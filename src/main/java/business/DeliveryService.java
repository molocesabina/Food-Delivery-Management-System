package business;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.FileWrite;



/**
 * DeliveryService structure of the app
 * @author Moloce Sabina
 * @invariant   isWellFormed()
 */

@SuppressWarnings("deprecation")
public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable{

	private static final long serialVersionUID = -6540241351904239288L;
	private Map<Order, List<MenuItem>> orders = new HashMap<Order, List<MenuItem>>();
	private List<MenuItem> menu = new ArrayList<>();
	private List<Account> users = new ArrayList<>();
	
	
	
	private int lastOrderId;

	public List<MenuItem> getMenu() {
		return menu;
	}

	/**
	 * Constructor
	 */
	public DeliveryService() {
		this.addAccount(new Account("admin","admin","admin"));
		this.addAccount(new Account("emp","emp","employee"));
	}
	
	/**
	 * method that adds an order
	 * @param o
	 * @param orderedItems
	 */
	private void addOrder(Order o, List<MenuItem> orderedItems) {
		Map.Entry<Order, List<MenuItem>> entry = new AbstractMap.SimpleEntry<Order, List<MenuItem>>(o, orderedItems);
		orders.put(o,orderedItems);
		setChanged();
		notifyObservers(entry);
	}
	
	/**
	 * @param mi the new product
	 * @invariant  isWellFormed()
	 */
	@Override
	public void addProduct(MenuItem mi) {
		assert mi!= null;
		int sizePre = menu.size();
		menu.add(mi);	
		assert menu.size() == sizePre +1 ;
		assert isWellFormed();
	}

	/**
	 * @param mi the product that we want to delete
	 * @invariant   isWellFormed()
	 */
	@Override
	public void deleteProduct(MenuItem mi) {
		assert mi!= null;
		assert menu.size()>0;
		int preSize = menu.size();
		menu.remove(mi);	
		assert menu.size() == preSize-1;
		assert isWellFormed();
	}
	
	/**
	 * @param the product that we want to modify has this name
	 * @param newMI the new fields of the product will be copied from this product
	 * @invariant  isWellFormed()
	 */
	@Override
	public void modifyProduct(String name, MenuItem newMI) {
		assert name!= null && newMI != null;
		int preSize = menu.size();
		for(MenuItem m: menu) {
			if(m.getName().equals(name)) {
				m.modifyProduct(m, newMI);
			}
		}	
		assert menu.size() == preSize;
		assert isWellFormed();
	}

	/**
	 * @param name the name of the menu
	 * @param l list of the products from the menu
	 * @invariant   isWellFormed()
	 */
	@Override
	public void createCompositeProduct(String name, List<MenuItem> l) {
		assert name!=null && l.size() > 0;
		int preSize = menu.size();
		CompositeProduct cp = new CompositeProduct(name, l);
		menu.add(cp);
		assert menu.size() == preSize + 1;
		assert isWellFormed();
	}
	
	/**
	 * @param o the order
	 * @param prod products that have been ordered
	 * @invariant   isWellFormed()
	 */
	@Override
	public void placeOrder(Order o, List<MenuItem> prod) {
		assert o!=null && prod.size() > 0;
		int preSize = orders.size();
		lastOrderId++;
	    int id = lastOrderId;
		o.setOrderID(id);
		addOrder(o,prod);
		FileWrite fw = new FileWrite(); 
		fw.makeBill(o, prod);
		assert orders.size() == preSize +1 ;
		assert isWellFormed();
	}

	/**
	 * method that uses lambda expression and streams
	 * @invariant   isWellFormed()
	 */
	@Override
	public void importBaseProducts() {
		assert menu.size() == 0;
		try {
			File f = new File("products.csv");
		    InputStream is = new FileInputStream(f);
		    BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
		    br.lines().skip(1)
		    	.map(line -> Arrays.asList(line.split(",")))
		    	.filter( distinctByKey(l -> l.get(0)) )
		    	.forEach(l -> menu.add(new BaseProduct(l.get(0),Float.parseFloat(l.get(1)),Integer.parseInt(l.get(2)),Integer.parseInt(l.get(3)), Integer.parseInt(l.get(4)),Integer.parseInt(l.get(5)),Integer.parseInt(l.get(6))))
		    	);
		    
		    br.close();
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert menu.size() != 0;
		assert isWellFormed();
	}
	
	private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
	    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	
	@Override
	/**
	 * method that uses lambda expression and streams 
	 */
	public List<MenuItem> searchProducts(String title, float rating, int calories, int proteins, int fats, int sodium, int price) {
		List<MenuItem> search = new ArrayList<MenuItem>();
		search = menu.stream()
					.filter( mi -> (title!=null ?  mi.getName().contains(title) : true) &&
							(rating!=-1  ?  mi.computeRating()==rating : true) &&
							(calories!=-1  ?  mi.computeCalories()==calories : true) &&
							(proteins!=-1  ?  mi.computeProteins()==proteins : true) &&
							(fats!=-1  ?  mi.computeFats()==fats : true) &&
							(sodium!=-1  ?  mi.computeSodium()==sodium : true) &&
							(price!=-1  ?  mi.computePrice()==price : true)
							)	
					.collect(Collectors.toList());
		
		return search;
	}

	/**
	 * method that uses lambda expression and streams
	 */
	@Override
	public List<Order> report1(String startHour, String endHour) {
		assert startHour!= null && endHour!= null;
		List<Order> result = orders.keySet().stream()
				.filter(o -> isBetween(o.getTime(),startHour,endHour))
				.collect(Collectors.toList());
		
		return result;
	}


	/**
	 * method that uses lambda expression and streams
	 */
	@Override
	public List<MenuItem> report2(int times) {
		assert times > 0;
		List<MenuItem> list = orders.values().stream()
		        .flatMap(l-> l.stream())
		        .collect(Collectors.toList());
		      
		List<MenuItem> result = list.stream()
				.filter(mi -> Collections.frequency(list, mi)==times)
				.distinct()
				.collect(Collectors.toList());

		return result;
	}
	
    /**
     * method that uses lambda expression and streams
     */
	@Override
	public List<Account> report3(int nbOrders, int totalPrice) {
		assert nbOrders > 0 && totalPrice > 0;
		List<Order> allOrdersTotalPrice = orders.keySet().stream()
				.filter(o -> o.getTotalAmount() > totalPrice)
				.collect(Collectors.toList()); 
		
		List<Account> allClientsNbOrders = allOrdersTotalPrice.stream()
				.filter(o -> howManyOrdersPerClient(o.getClientID(),allOrdersTotalPrice) > nbOrders)
				.map(o -> getAccountById(o.getClientID()))
				.distinct()
		        .collect(Collectors.toList());
		
		return allClientsNbOrders;
	}

	/**
	 * method that uses lambda expression and streams
	 */
	@Override
	public Map<MenuItem, Integer> report4(String date) {
		assert date!=null;
		Map<MenuItem, Integer> result = new HashMap<MenuItem, Integer>();
		List<MenuItem> allMenuItemsOrderedInDay = new ArrayList<>();
	  
	    orders.keySet().stream()
		        .filter(o -> o.getDate().equals(date))
		        .forEach(o -> allMenuItemsOrderedInDay.addAll(orders.get(o)));
	    
	    allMenuItemsOrderedInDay.stream()
	    	    .distinct()
	    	    .forEach(mi -> result.put(mi, Collections.frequency(allMenuItemsOrderedInDay, mi)));
	    
		return result;
	}
	
	/**
	 * invariant method should always be true 
	 * @return
	 */
	protected boolean isWellFormed()  {
		if(menu == null)
			return false;
		if(orders == null)
			return false;
		if(users == null)
			return false;
		if(lastOrderId < 0)
			return false;
		return true;
	}

	public void addAccount(Account a) {
		a.setId(getLastIDAccount());
		users.add(a);
		assert isWellFormed();
	}
	
	private int getLastIDAccount() {
		if(users.isEmpty()) {
			return 0;
		}
		return users.get(users.size()-1).getId()+1;
	}
	
	private boolean isBetween(String actualOrder, String startHour, String endHour) {
		Date timeStart = transformToDate(startHour);
		Date timeEnd = transformToDate(endHour);
		Date timeOrder = transformToDate(actualOrder);
		
		if(timeStart.compareTo(timeOrder) > 0)
			return false;
		
		if(timeEnd.compareTo(timeOrder) < 0)
			return false;
		
		return true;
	}
	
	private Date transformToDate(String time) {
	    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
	    Date d = null;
		try {
			d = dateFormat.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    return d;
	}
	
	public Account getAccount(String username) {
		for(Account a: users) {
			if(a.getUsername().equals(username)) {
				return a;
			}
		}
		return null;
	}
	
	public MenuItem getProduct(String name) {
		for(MenuItem m: menu) {
			if(m.getName().equals(name)) {
				return m;
			}
		}
		return null;
	}
	
	public Account getAccountById(int id) {
		for(Account a: users) {
			if(a.getId()==id)
				return a;
		}
		return null;
	}

	private int howManyOrdersPerClient(int id, List<Order> o) {
		int nb=0;
		for(Order or: o) {
			if(or.getClientID()==id)
				nb++;
		}
		return nb;
	}
}

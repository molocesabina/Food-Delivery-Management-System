package business;

import java.util.List;
import java.util.Map;

public interface IDeliveryServiceProcessing {
	/** 
	* import products form .cvs file
	* @pre menu.getSize() == 0
	* @post menu.getSize() != 0
	*/
	public void importBaseProducts();

	/**
	 * add a product to the menu
	 * @pre  mi!=null
	 * @post menu.getSize() == menu.getSize()@pre + 1
	 */
	public void addProduct(MenuItem mi);
	
	/**
	 * delete the product from menu
	 * @pre  mi!=null
	 * @pre menu.getSize() > 0
	 * @post menu.getSize() == menu.getSize()@pre - 1
	 */
	public void deleteProduct(MenuItem mi);
	
	/**
	 * modify the product from menu with the name
	 * @pre newMI != null && name != null
	 * @post menu.getSize()=menu.getSize()@pre
	 */
	public void modifyProduct(String name, MenuItem newMI);
	

	
	/**
	 * add in the menu list a new composite product
	 * @pre name != null && l.getSize() > 0
	 * @post menu.getSize() == menu.getSize()@pre + 1
	 */
	public void createCompositeProduct(String name,List<MenuItem> l);
	
	/**
	 * add a new order
	 * @pre o != null && prod.getSize() > 0
	 * @post orders.getSize() == order.getSize()@pre + 1
	 */
	public void placeOrder(Order o, List<MenuItem> prod);
	
	/**
	 * returns all product that fit the criteria
	 * @pre true
	 * @post @nochange
	 */
	public List<MenuItem> searchProducts(String title, float rating, int calories, int proteins, int fats, int sodium, int price);
	
	/**
	 * generate all orders that are in the interval
	 * @pre startHour != null && endHour != null 
	 * @pre startHour <= endHour
	 * @post @nochange
	 */
	public List<Order> report1(String startHour, String endHour);
	
	/**
	 * generate all products that have been ordered more than # times
	 * @pre time > 0
	 * @post @nochange
	 */
	public List<MenuItem> report2(int time);
	
	/**
	 * the clients that have ordered more than a specified number of times and the value of the order was higher than a specified amount.
	 * @pre nbOrders > 0 && totalPrice > 0
	 * @post @nochange
	 */
	public List<Account> report3(int nbOrders, int totalPrice);
	
	/**
	 * the products ordered within a specified day with the number of times they have been ordered
	 * @pre date != null
	 * @post @nochange
	 */
	public Map<MenuItem, Integer> report4(String date);
}

package business;

import java.io.Serializable;
import java.util.Date;
/**
* Order class 
* @author Moloce Sabina
*/
public class Order implements Serializable {
	
	private static final long serialVersionUID = -2880530629942692764L;
	private int orderID;
	private int clientID;
	private String orderDate;
	private int totalAmount;
	
	
	/**
	 * Constructor
	 * @param clientID
	 * @param orderDate
	 * @param totalAmount
	 */
	public Order(int clientID,String orderDate,int totalAmount) {
		this.clientID = clientID;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}
    
	
	
	public int getTotalAmount() {
		return totalAmount;
	}

	public int getOrderID() {
		return orderID;
	}

	public int getClientID() {
		return clientID;
	}

	public String getOrderDate() {
		return orderDate;
	}
	
	public String getTime() {
        String[] arrOfStr = orderDate.split(" ");
        return arrOfStr[1];
	}
	
	public String getDate() {
		String[] arrOfStr = orderDate.split(" ");
	    return arrOfStr[0];
	}

	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(o == null) 
			return false;
		if(this.getClass() != o.getClass()) 
			return false;
		Order order = (Order) o;
		return orderID != order.orderID && clientID !=order.clientID && (!orderDate.equals(order.orderDate));
	}
	
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (int) orderID;
		hash = 31 * hash + (int) clientID;
		hash = 31 * hash + orderDate.hashCode();
		return hash;	
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	
}

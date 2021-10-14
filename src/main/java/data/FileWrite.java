package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import business.*;

public class FileWrite {
	/**
	 * method that generates the bill when an order is placed
	 * @param o
	 * @param prod
	 */
	public static void makeBill(Order o, List<MenuItem> prod) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("Order.txt"));
			String s = "Order id: "+o.getOrderID()+'\n';
			s+= "Client id: "+o.getClientID()+'\n';
			s+="Date : "+o.getOrderDate()+'\n';
			s+="Ordered products:"+'\n';
			for(MenuItem mi: prod) {
				s+="  "+mi.getName()+'\n';
			}
			s+="Total order: "+o.getTotalAmount()+'\n';
		    out.write(s);
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}

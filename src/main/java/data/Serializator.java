package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import business.DeliveryService;

public class Serializator {
	/**
	 * method for serialization of the data from delivery service
	 * @param ds
	 */
	public static void serialize(DeliveryService ds) {
		FileOutputStream file;
		try {
			file = new FileOutputStream ("file.txt");
			ObjectOutputStream out = new ObjectOutputStream(file); 
			out.writeObject(ds); 
			out.close(); 
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	
	/**
	 * method that deserialization of data
	 * @return
	 */
	public static DeliveryService deserialize() {
		try {
			DeliveryService object = new DeliveryService(); 
			FileInputStream file = new FileInputStream("file.txt");
			ObjectInputStream in = new ObjectInputStream(file); 
			object = (DeliveryService)in.readObject(); 
			in.close(); 
			file.close();
			return object;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null; 
		
	}
	

}

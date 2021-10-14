package business;

import java.io.Serializable;

/**
* MenuItem class for products(base products and composite products)
* @author Moloce Sabina
*/
public class MenuItem implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5794785838417518412L;
	public int computePrice() {
		return 0;
	}
	
	public String getName() {
		return null;
	}
	
	public void modifyProduct(MenuItem mi, MenuItem newMI){
	}
	
	public float computeRating() {
		return 0;
	}
	public int computeCalories() {
		return 0;
	}
	public int computeProteins() {
		return 0;
	}
	public int computeFats() {
		return 0;
	}
	
	public int computeSodium() {
		return 0;
	}
}

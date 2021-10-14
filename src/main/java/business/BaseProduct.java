package business;

import java.util.List;

/**
* BaseProduct class for products from .cvs
* @author Moloce Sabina
*/
public class BaseProduct extends MenuItem {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1558537760773277949L;
	private String title;
	private float rating;
	private int calories;
	private int proteins;
	private int fats;
	private int sodium;
	private int price;
	
	/**
	 * Constructor
	 * @param title
	 * @param rating
	 * @param calories
	 * @param proteins
	 * @param fats
	 * @param sodium
	 * @param price
	 */
	public BaseProduct(String title, float rating, int calories, int proteins, int fats, int sodium, int price) {
		this.title = title;
		this.rating = rating;
		this.calories = calories;
		this.proteins = proteins;
		this.fats = fats;
		this.sodium = sodium;
		this.price = price;
		
	}
	
	
	
	/**
	 * @param mi old product
	 * @param newMI new product
	 */
	public void modifyProduct(MenuItem mi, MenuItem newMI) {
		BaseProduct bp = (BaseProduct)mi;
		BaseProduct newBP = (BaseProduct)newMI;
		bp.title = newBP.title;
		bp.rating = newBP.rating;
		bp.fats = newBP.fats;
		bp.proteins = newBP.proteins;
		bp.sodium = newBP.sodium;
		bp.price = newBP.price;
	}
	
	public String getName() {
		return title;
	}



	public int computePrice() {
		return price;
	}


	@Override
	public float computeRating() {
		return rating;
	}


	@Override
	public int computeCalories() {
		return calories;
	}


	@Override
	public int computeProteins() {
		return proteins;
	}


	@Override
	public int computeFats() {
		return fats;
	}


	@Override
	public int computeSodium() {
		return sodium;
	}
}

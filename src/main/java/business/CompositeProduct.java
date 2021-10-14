package business;

import java.util.List;

/**
* CompositeProduct class for composed products(menus)
* @author Moloce Sabina
*/
public class CompositeProduct extends MenuItem{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8017410863625522944L;
	private String name;
	private List<MenuItem> l;
	
	/**
	 * Constructor
	 * @param name
	 * @param l
	 */
	public CompositeProduct(String name, List<MenuItem> l) {
		this.name = name;
		this.l = l;
	}
	
	public String getName() {
		return name;
	}

	/**
	 * @return total price
	 */
	@Override
	public int computePrice() {
		int price = 0;
		for(MenuItem mi: l) {
			price+= mi.computePrice();
		}
		return price;
	}

	@Override
	public void modifyProduct(MenuItem mi, MenuItem newMI) {
		CompositeProduct cp = (CompositeProduct)mi;
		CompositeProduct newCP = (CompositeProduct)newMI;
		cp.name = newCP.name;		
	}

	/**
	 * @return general rating
	 */
	@Override
	public float computeRating() {
		float rating = 0;
		for(MenuItem mi: l) {
			rating+= mi.computeRating();
		}
		rating /= l.size();
		return rating;
	}

	/**
	 * @return total calories
	 */
	@Override
	public int computeCalories() {
		int calories = 0;
		for(MenuItem mi: l) {
			calories+= mi.computeCalories();
		}
		return calories;
	}

	/**
	 * @return total proteins
	 */
	@Override
	public int computeProteins() {
		int proteins = 0;
		for(MenuItem mi: l) {
			proteins+= mi.computeProteins();
		}
		return proteins;
	}

	/**
	 * @return total fats
	 */
	@Override
	public int computeFats() {
		int fats = 0;
		for(MenuItem mi: l) {
			fats+= mi.computeFats();
		}
		return fats;
	}

	/**
	 * @return total sodium
	 */
	@Override
	public int computeSodium() {
		int sodium = 0;
		for(MenuItem mi: l) {
			sodium+= mi.computeSodium();
		}
		return sodium;
	}

}

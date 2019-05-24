package items;

/**
 * Represents the base class for all items. Includes methods to get price and name. 
 * @author ctg31
 *
 */
public class Item {
	/**
	 * Name of the item.
	 */
	private String name;
	/**
	 * Cost of the item.
	 */
	private int cost;
	
	/**
	 * Constructor for a new item. Sets name and cost.
	 * @param name String - Name of the item.
	 * @param cost int - Cost of the item.
	 */
	public Item(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}
	
	/**
	 * Gets the name of the item.
	 * @return The name of the item
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the cost of the item.
	 * @return The name of the item.
	 */
	public int getCost() {
		return this.cost;
	}
	
	/**
	 * Override of the toString method to display only the name of the object in the inventory combo box
	 * on the day view.
	 * @return The name of the item.
	 */
	@Override
	public String toString() {
		return this.name;
	}
}

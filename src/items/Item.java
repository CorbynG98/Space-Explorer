package items;

public class Item {
	// Variables
	private String name;
	private int cost;
	
	// Constructor
	public Item(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}
	
	//Getters
	public String getName() {
		return this.name;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	// This is what gets shown when the object is in a combo box.
	// Namely the inventory list on the day screen.
	@Override
	public String toString() {
		return this.name;
	}
}

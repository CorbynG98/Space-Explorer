package InventoryItems;

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
}

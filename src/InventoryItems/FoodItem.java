package InventoryItems;

public class FoodItem extends Item {
	// Variables
	private int hungerValue;
	private int energyValue = 0;
	private int healthValue = 0;
	
	// Constructor/s
	public FoodItem(String name, int hungerValue, int cost) {
		super(name, cost);
		this.hungerValue = hungerValue;
	}
	
	public FoodItem(String name, int hungerValue, int cost, int bonusStat) {
		super(name, cost);
		this.hungerValue = hungerValue;
		if (name == "Milo") 
			this.healthValue = bonusStat;
		else
			this.energyValue = bonusStat;
	}
	
	// Getters
	public int getHungerValue() {
		return hungerValue;
	}
	
	public int getEnergyValue() {
		return energyValue;
	}
	
	public int getHealthValue() {
		return healthValue;
	}
}

package items;

import java.util.Random;
import java.util.*;

import items.*;

public class FoodItem extends Item {
	// Variables
	private int hungerValue;
	private int energyValue = 0;
	private int healthValue = 0;
	//private ArrayList<FoodItem> foodArray = new ArrayList<FoodItem>();
	
	private List<FoodItem> foodList = Arrays.asList(new ApplePie(), new BigMac(), new EnergyDrink(), new Fries(), new FroCo(), new Milo(), new MincePie(), new MincePieWithKetchup());
	
	
	
	// Constructor/s
	public FoodItem(String name, int hungerValue, int cost) {
		super(name, cost);
		this.hungerValue = hungerValue;
		this.foodList = null;
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
	
	public String toString() {
		return this.getName();
	}
	
//	public FoodItem selectRandomItem() {
//		Random foodSelect = new Random();
//		
//		foodArray.addAll(foodList);
//		int foodIndex = foodSelect.nextInt(foodArray.size() + 1);
//				
//		return foodArray.get(foodIndex);
//	}
}

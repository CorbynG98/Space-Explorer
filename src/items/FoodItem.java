package items;

import java.util.Random;
import java.util.*;

import items.*;

/**
 * Represents the food item class, extending the item class. provides basic stats for the food item
 * getting created.
 * @author ctg31
 *
 */
public class FoodItem extends Item {
	/**
	 * Hunger value the item restores.
	 */
	private int hungerValue;
	/**
	 * Energy value the item restores (Bonus stat).
	 */
	private int energyValue = 0;
	/**
	 * Health value the item restores (Bonus stat).
	 */
	private int healthValue = 0;
	
	/**
	 * Constructor to create a food item without any bonus stats.
	 * @param name String - Name of the item.
	 * @param hungerValue int - Amount of hunger the item restores.
	 * @param cost int - Cost of the item.
	 */
	public FoodItem(String name, int hungerValue, int cost) {
		super(name, cost);
		this.hungerValue = hungerValue;
	}

	/**
	 * Constructor to create a food item with a bonus stat if applicable to that type.
	 * @param name String - Name of the item.
	 * @param hungerValue int - Amount of hunger the item restores.
	 * @param cost int - Cost of the item.
	 * @param bonusStat int - Health or Energy the item restores is applicable.
	 */
	public FoodItem(String name, int hungerValue, int cost, int bonusStat) {
		super(name, cost);
		this.hungerValue = hungerValue;
		if (name == "Milo") 
			this.healthValue = bonusStat;
		else
			this.energyValue = bonusStat;
	}
	
	/**
	 * Gets the amount of hunger the item restores.
	 * @return amount of hunger restore.
	 */
	public int getHungerValue() {
		return hungerValue;
	}
	
	/**
	 * Gets the amount of energy the item restores.
	 * @return amount of energy restore.
	 */
	public int getEnergyValue() {
		return energyValue;
	}
	
	/**
	 * Gets the amount of health the item restores.
	 * @return amount of health restore.
	 */
	public int getHealthValue() {
		return healthValue;
	}
	
	/**
	 * Gets the name of item.
	 * @return the name of the item.
	 */
	public String toString() {
		return this.getName();
	}
}

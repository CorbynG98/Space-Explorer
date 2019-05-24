package items;

import java.util.*;
import java.lang.Math;

/**
 * Represents the medical item class, extending the item class. provides basic stats for the medical item
 * getting created.
 * @author ctg31
 *
 */
public class MedicalItem extends Item {
	/**
	 * Amount of health the item heals by.
	 */
	private int healthValue;
	/**
	 * If the item cures the plague or not.
	 */
	private boolean curesPlague = false;
	
	/**
	 * Constructor to set stats for basic medical item.
	 * @param name String - Name of the medical item.
	 * @param healthValue int - Value of health this item restores.
	 * @param cost int - How much this item costs to buy.
	 */
	public MedicalItem(String name, int healthValue, int cost) {
		super(name, cost);
		this.healthValue = healthValue;
	}
	
	/**
	 * Constructor for advanced medical item (SpacePlagueCure).
	 * @param name String - Name of the medical item.
	 * @param healthValue int - Value of health this item restores.
	 * @param cost int - How much this item costs to buy.
	 * @param cure Boolean - Whether or not this item cures the space plague.
	 */
	public MedicalItem(String name, int healthValue, int cost, boolean cure) {
		super(name, cost);
		this.healthValue = healthValue;
		this.curesPlague = cure;
	}
	
	/**
	 * Gets if this item is a cure to the plague or not.
	 * @return True if cure, false otherwise.
	 */
	public boolean isPlagueCure() {
		return curesPlague;
	}
	
	/**
	 * Gets amount of health this item restores on consumption.
	 * @return Amount of health this item restores.
	 */
	public int getHealthValue() {
		return healthValue;
	}
}

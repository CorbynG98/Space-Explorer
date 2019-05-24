package crew;

import java.util.ArrayList;

import items.*;

/**
 * Represents the Crew that have been selected by the player. Holds variables that can be accessed by crew members and the methods for adding and removing crew
 * members from the crew list.
 * @author mch221
 *
 */
public class Crew {
	
	/**
	 * ArrayList of CrewMember objects that holds the currently alive crew members.
	 */
	private ArrayList<CrewMember> crewList;
	/**
	 * ArrayList of MedicalItem objects that are currently in the crew inventory.
	 */
	private ArrayList<MedicalItem> medicalInventory;
	/**
	 * ArrayList of FoodItem objects that are currently in the crew inventory.
	 */
	private ArrayList<FoodItem> foodInventory;
	/**
	 * Holds the current number of credits owned by the Crew.
	 */
	private int money = 400;
	
	
	/**
	 * Creates new Crew objects. Initializes ArrayLists for the crew's inventories and for the crew list. 
	 */
	public Crew() {
		this.crewList = new ArrayList<CrewMember>();
		this.medicalInventory = new ArrayList<MedicalItem>();
		this.foodInventory = new ArrayList<FoodItem>();
	}
	
	
	/**
	 * Adds a CrewMember object to the crew list ArrayList.
	 * @param name takes a CrewMember object to be added to the crewList. 
	 */
	public void addCrewMember(CrewMember name) {
		if (crewList.size() >= 4) {
			return;
		}
		crewList.add(name);
	}
	
	/**
	 * Removes a CrewMember object from the crew list ArrayList.
	 * @param name takes a CrewMember to remove from the crew list.
	 */
	public void removeCrewMember(CrewMember name) {
		crewList.remove(name);
	}
	
	/**
	 * Gets the ArrayList of currently alive CrewMembers.
	 * @return an ArrayList of CrewMember objects
	 */
	public ArrayList<CrewMember> getCrewList() {
		return crewList;
	}
	
	/**
	 * Adds a given MedicalItem to the Crew's MedicalItem inventory.
	 * @param type takes the type of MedicalItem to add to the inventory.
	 */
	public void addMedicalItem(MedicalItem type) {
		medicalInventory.add(type);
	}
	
	/**
	 * Removes a given MedicalItem from the Crew's MedicalItem inventory.
	 * @param type takes the item to be removed from the inventory.
	 */
	public void removeMedicalItem(MedicalItem type) {
		medicalInventory.remove(type);
	}
	
	/**
	 * Gets the current MedicalItem inventory.
	 * @return an ArrayList of MedicalItems that exist in the Crew's inventory.
	 */
	public ArrayList<MedicalItem> getMedicalInventory() {
		return medicalInventory;
	}
	
	/**
	 * Adds a FoodItem to the Crew's FoodItem inventory.
	 * @param type takes the type of FoodItem to add to the inventory.
	 */
	public void addFoodItem(FoodItem type) {
		foodInventory.add(type);
	}
	
	/**
	 * Removes a given FoodItem from the Crew's FoodItem inventory.
	 * @param type takes the item to be removed from the inventory.
	 */
	public void removeFoodItem(FoodItem type) {
		foodInventory.remove(type);
	}
	
	/**
	 * Gets the current FoodItem inventory.
	 * @return an ArrayList of FoodItems that exist in the Crew's inventory.
	 */
	public ArrayList<FoodItem> getFoodInventory() {
		return foodInventory;
	}
	
	/**
	 * Gets both the food and medical item inventories. 
	 * @return an ArrayList of Items containing items that currently exist in the food and medical inventories.
	 */
	public ArrayList<Item> fullInventory() {
		ArrayList<Item> fullInv = new ArrayList<Item>();
		fullInv.addAll(foodInventory);
		fullInv.addAll(medicalInventory);
		return fullInv;
		
	}
	
	/**
	 * Gets the current amount of money in the Crew's bank.
	 * @return an Integer value representing the money currently in the Crew's bank.
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * Adds money to the Crew's bank.
	 * @param amount takes an Integer value to add to the Crew's bank.
	 */
	public void addMoney(int amount) {
		money += amount;
	}
	
	/**
	 * Removes money from the Crew's bank.
	 * @param amount takes an Integer value to remove from the Crew's bank.
	 */
	public void removeMoney(int amount) {
		money -= amount;
		if (money <= 0) {
			money = 0;
		}
	}
}

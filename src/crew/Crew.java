package crew;

import java.util.ArrayList;

import items.*;


public class Crew {
	
	private ArrayList<CrewMember> crewList;
	private ArrayList<MedicalItem> medicalInventory;
	private ArrayList<FoodItem> foodInventory;
	private int money = 400;
	
	
	/* Constructor for the Crew class */
	public Crew() {
		this.crewList = new ArrayList<CrewMember>();
		this.medicalInventory = new ArrayList<MedicalItem>();
		this.foodInventory = new ArrayList<FoodItem>();
	}
	
	
	/* Getter and setter methods for the Crew class */
	
	/* Crew list */
	
	public void addCrewMember(CrewMember name) {
		if (crewList.size() >= 4) {
			return;
		}
		crewList.add(name);
	}
	
	public void removeCrewMember(CrewMember name) {
		crewList.remove(name);
	}
	
	public ArrayList<CrewMember> getCrewList() {
		return crewList;
	}
	
	/* Medical item inventory */
	
	public void addMedicalItem(MedicalItem type) {
		medicalInventory.add(type);
	}
	
	public void removeMedicalItem(MedicalItem type) {
		medicalInventory.remove(type);
	}
	
	public ArrayList<MedicalItem> getMedicalInventory() {
		return medicalInventory;
	}
	
	/* Food item inventory */
	
	public void addFoodItem(FoodItem type) {
		foodInventory.add(type);
	}
	
	public void removeFoodItem(FoodItem type) {
		foodInventory.remove(type);
	}
	
	public ArrayList<FoodItem> getFoodInventory() {
		return foodInventory;
	}
	
	/* General inventory */
	public ArrayList<Item> fullInventory() {
		ArrayList<Item> fullInv = new ArrayList<Item>();
		fullInv.addAll(foodInventory);
		fullInv.addAll(medicalInventory);
		return fullInv;
		
	}
	
	/* Money */
	
	public int getMoney() {
		return money;
	}
	
	public void addMoney(int amount) {
		money += amount;
	}
	
	public void removeMoney(int amount) {
		money -= amount;
		if (money <= 0) {
			money = 0;
		}
	}
	

}

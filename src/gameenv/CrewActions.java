package gameenv;

import java.util.*;
import crew.*;
import spaceship.*;
import items.*;
import planet.*;



public class CrewActions {

	private List<FoodItem> foodList;
	private List<MedicalItem> medicalList;
	
	/*
	 * Constructor method for CrewActions instances.
	 */
	public CrewActions(List<FoodItem> foodList, List<MedicalItem> medicalList) {
		this.foodList = foodList;
		this.medicalList = medicalList;
	}
	
	public void viewInventory(Crew crewName) {
		crewName.getFoodInventory();
		crewName.getMedicalInventory();
		
	}
	
	public void pilotShip(CrewMember name, Ship shipName) {
		name.addActionPerformed();
		shipName.addPilot(name);
	}
	
	public void repairShip(CrewMember name, Ship shipName) {
		name.addActionPerformed();
		shipName.repairShip(name);
	}
	
	public Object searchPlanet(CrewMember name, Planet planetName, Crew currentCrew) { 
		name.addActionPerformed();
		Object foundItem = planetName.searchPlanet(name, foodList, medicalList, currentCrew);
		
		return foundItem;
		
	}
}

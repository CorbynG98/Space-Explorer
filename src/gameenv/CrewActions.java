package gameenv;

import java.util.*;
import crew.*;
import spaceship.*;
import items.*;
import planet.*;



public class CrewActions {

	private List<FoodItem> foodList;
	private List<MedicalItem> medicalList;
	
	public CrewActions(List<FoodItem> foodList, List<MedicalItem> medicalList) {
		this.foodList = foodList;
		this.medicalList = medicalList;
	}
	
	public void viewCrewStatus(CrewMember name) {
		double[] statusArray;
		statusArray = new double[3];
		
		statusArray = name.getCrewMemberStatus();
		
		/* TODO
		 * - Display with GUI
		 */
	}
	
	public void viewShipStatus(Ship shipName) {
		int shipHealth = shipName.getHealth();
		
		/* TODO
		 * - Display with GUI
		 */
	}
	
	
	public void viewInventory(Crew crewName) {
		crewName.getFoodInventory();
		crewName.getMedicalInventory();
		
		/* TODO
		 * - Display with GUI
		 */
	}
	
	public void pilotShip(CrewMember name, Ship shipName) {
		name.addActionPerformed();
		shipName.addPilot(name);
	}
	
	public void repairShip(CrewMember name, Ship shipName) {
		name.addActionPerformed();
		shipName.repairShip(name);
	}
	
	public Object searchPlanet(CrewMember name, Planet planetName) { 
		name.addActionPerformed();
		Object foundItem = planetName.searchPlanet(name, foodList, medicalList);
		
		return foundItem;
		
	}
}

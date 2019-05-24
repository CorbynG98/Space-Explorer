package gameenv;

import java.util.*;
import crew.*;
import spaceship.*;
import items.*;
import planet.*;

/**
 * Contains methods that implement CrewMember actions within the GameEnvironment, and calls the necessary methods for those actions.
 * @author mch221
 *
 */
public class CrewActions {

	/**
	 * Holds a List of every FoodItem type so that new items can be generated.
	 */
	private List<FoodItem> foodList;
	/**
	 * Holds a List of every MedicalItem type so that new items can be generated.
	 */
	private List<MedicalItem> medicalList;
	
	/**
	 * Creates a new CrewActions instance.
	 * @param foodList takes a List of FoodItems.
	 * @param medicalList takes a List of MedicalItems.
	 */
	public CrewActions(List<FoodItem> foodList, List<MedicalItem> medicalList) {
		this.foodList = foodList;
		this.medicalList = medicalList;
	}

	/**
	 * Add a CrewMember object to Ship's currentPilot list.
	 * @param name takes a CrewMember to add to the pilot list.
	 * @param shipName takes a Ship object for the CrewMember to be added to.
	 */
	public void pilotShip(CrewMember name, Ship shipName) {
		name.addActionPerformed();
		shipName.addPilot(name);
	}
	
	/**
	 * Allows CrewMember objects to repair a Ship's shields.
	 * @param name takes a CrewMember to perform the repairs.
	 * @param shipName takes a Ship to be repaired.
	 */
	public void repairShip(CrewMember name, Ship shipName) {
		name.addActionPerformed();
		shipName.repairShip(name);
	}
	
	/**
	 * Allows CrewMember objects to conduct searches on a Planet's surface.
	 * @param name takes a CrewMember to conduct the search.
	 * @param planetName takes a Planet to be searched.
	 * @param currentCrew takes a Crew so that any found items may be added to the inventory.
	 * @return the object, if any, that was found.
	 */
	public Object searchPlanet(CrewMember name, Planet planetName, Crew currentCrew) { 
		name.addActionPerformed();
		Object foundItem = planetName.searchPlanet(name, foodList, medicalList, currentCrew);
		
		return foundItem;
	}
}

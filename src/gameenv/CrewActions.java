package gameenv;

import java.util.ArrayList;
import crew.*;
import spaceship.*;

public class CrewActions extends GameEnvironment {

	
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
	
	public void repairShip(CrewMember name) {
		current.repairShip(name);
		
	}
	
	public void searchPlanet(CrewMember name) { 
		
		/* TODO
		 *  - Select random item */
	}
	
	
	/* TODO
	 *  - Visit and search planet
	 */
}

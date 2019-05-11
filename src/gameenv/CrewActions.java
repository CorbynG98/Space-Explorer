package gameenv;

import java.util.ArrayList;
import crew.*;
import spaceship.*;

public class CrewActions {
	
	
	
	public void viewCrewStatus(CrewMember name) {
		double[] statusArray;
		statusArray = new double[3];
		
		statusArray = name.getCrewMemberStatus();
		
		/* TODO
		 *  - Display with GUI
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
		 *  - Display with GUI
		 */
	}
	
	public void repairShip(CrewMember name) {
		shipName.repairShip(name);
		
	}
	
	public
	/* TODO
	 *  - View status of crew member
	 *  - View status of ship
	 *  - Use item
	 *  - Repair ship
	 *  - Visit space station
	 *  - Visit and search planet
	 */
}

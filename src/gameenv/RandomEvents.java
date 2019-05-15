package gameenv;

import java.util.Random;
import java.util.ArrayList;

import crew.*;
import spaceship.*;
import items.*;

public class RandomEvents {

	/* Logic for the space plague random event */
	
	/*TODO
	 * Create popup window for the crew members that contract the plague
	 */
	public static void spacePlague(ArrayList<CrewMember> crewList) {
		Random plagueChance = new Random();
		
		/* Determine if each crew member will contract the space plague */
		
		for (CrewMember crewMember: crewList) {
			int getsPlague = plagueChance.nextInt(10);
			
			if (getsPlague >= 7) {
				if (crewMember.getSpecialization() == "Medic") {
					continue;
				}
				else {
					crewMember.setDiseaseStatus(true);
					crewMember.setHealth(crewMember.getHealth() - 10);
				}
			}
		}
	}

	
	/* Logic for the alien pirates random event */
	
	/*TODO
	 * Create popup windows when the pirates steal an item or when a soldier protects the crew
	 */
	public static void alienPirates(Crew currentCrew) {
		Random pirateChances = new Random();
		
		boolean soldierInCrew = false;
		boolean soldierProtectsShip = false;
		
		
		for (CrewMember crewMember: currentCrew.getCrewList()) {
			if (crewMember.getSpecialization() == "Soldier") {
				soldierInCrew = true;
			}
		}
		
		if (soldierInCrew) {
			int soldierProtects = pirateChances.nextInt(2);
			if (soldierProtects == 1) {
				soldierProtectsShip = true;
			}
		}
		
		if (!soldierProtectsShip) {
			int itemTypeStolen = pirateChances.nextInt(2);
			
			if (itemTypeStolen == 1) {
				int sizeOfInventory = currentCrew.getFoodInventory().size();
				
				int itemStolen = pirateChances.nextInt(sizeOfInventory + 1);
				
				FoodItem foodStolen = currentCrew.getFoodInventory().get(itemStolen);
				currentCrew.getFoodInventory().remove(itemStolen);
			}
			else {
				int sizeOfInventory = currentCrew.getMedicalInventory().size();
				
				int itemStolen = pirateChances.nextInt(sizeOfInventory + 1);
				
				MedicalItem medicalStolen = currentCrew.getMedicalInventory().get(itemStolen);
				currentCrew.getMedicalInventory().remove(itemStolen);
			}
		}
	}
}


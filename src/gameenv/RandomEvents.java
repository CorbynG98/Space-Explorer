package gameenv;

import java.util.Random;
import java.util.ArrayList;

import spaceship.*;
import crew.*;
import items.*;
import views.*;
import gameenv.*;

public class RandomEvents {

	
	/* 
	 * Logic for the space plague random event 
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
		String spacePlague = "The crew was exposed to the space plague! Make sure to cure any survivors with a space plague cure.";
		RandomEventDialogs dialog = new RandomEventDialogs(spacePlague);
		dialog.setVisible(true);
	}

	
	/*
	 *  Logic for the alien pirates random event 
	 */
	public static void alienPirates(Crew currentCrew, Ship currentShip, GameEnvironment currentGame) {
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
				
				int itemStolen = pirateChances.nextInt(sizeOfInventory);
				
				FoodItem foodStolen = currentCrew.getFoodInventory().get(itemStolen);
				currentCrew.getFoodInventory().remove(itemStolen);
				
				
				String alienStoleItem = "Alien pirates boarded the ship and stole one " + foodStolen.toString() + "!";
				RandomEventDialogs dialog = new RandomEventDialogs(alienStoleItem);
				dialog.setVisible(true);
			}
			else {
				int sizeOfInventory = currentCrew.getMedicalInventory().size();
				
				int itemStolen = pirateChances.nextInt(sizeOfInventory);
				
				MedicalItem medicalStolen = currentCrew.getMedicalInventory().get(itemStolen);
				currentCrew.getMedicalInventory().remove(itemStolen);
				
				// Generate dialog with the results of the Alien pirate boarding
				String alienStoleItem = "Alien pirates boarded the ship and stole one " + medicalStolen.toString() + "!";
				RandomEventDialogs dialog = new RandomEventDialogs(alienStoleItem);
				dialog.setVisible(true);
			}
		}
		
		else {
			String soldierSavesShip = "The ship was protected from Alien pirates by our brave soldiers! However, the ship's shield took some damage in the fight.";
			
			currentShip.takeDamage(10, currentGame);
			RandomEventDialogs dialog = new RandomEventDialogs(soldierSavesShip);
			dialog.setVisible(true);
		}
		
	}
}


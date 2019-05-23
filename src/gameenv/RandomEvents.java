package gameenv;

import java.util.Random;
import java.util.ArrayList;

import spaceship.*;
import crew.*;
import planet.*;
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
		EventDialogs dialog = new EventDialogs(spacePlague);
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
			int soldierProtects = pirateChances.nextInt(3);
			if (soldierProtects == 1) {
				soldierProtectsShip = true;
			}
		}
		
		
		if (!soldierProtectsShip) {
			int itemTypeStolen = pirateChances.nextInt(2);
			
			if (itemTypeStolen == 1) {
				int sizeOfInventory = currentCrew.getFoodInventory().size();
				
				if (sizeOfInventory <= 0) {
					String alienStoleItem = "Alien pirates boarded the ship but there were no items to steal!";
					EventDialogs dialog = new EventDialogs(alienStoleItem);
					dialog.setVisible(true);
				} else {
					int itemStolen = pirateChances.nextInt(sizeOfInventory);
						
					FoodItem foodStolen = currentCrew.getFoodInventory().get(itemStolen);
					currentCrew.getFoodInventory().remove(itemStolen);
						
					String alienStoleItem = "Alien pirates boarded the ship and stole one " + foodStolen.toString() + "!";
					EventDialogs dialog = new EventDialogs(alienStoleItem);
					dialog.setVisible(true);
				}
			}
			
			else {
				int sizeOfInventory = currentCrew.getMedicalInventory().size();
				
				if (sizeOfInventory <= 0) {
					String alienStoleItem = "Alien pirates boarded the ship but there were no items to steal!";
					EventDialogs dialog = new EventDialogs(alienStoleItem);
					dialog.setVisible(true);
				} else {
					int itemStolen = pirateChances.nextInt(sizeOfInventory);
					
					MedicalItem medicalStolen = currentCrew.getMedicalInventory().get(itemStolen);
					currentCrew.getMedicalInventory().remove(itemStolen);
					
					String alienStoleItem = "Alien pirates boarded the ship and stole one " + medicalStolen.toString() + "!";
					EventDialogs dialog = new EventDialogs(alienStoleItem);
					dialog.setVisible(true);
				}
			}
		}
		else {
			String soldierSavesShip = "The ship was protected from Alien pirates by our brave soldiers! However, the ship's shield took some damage in the fight.";
			
			currentShip.takeDamage(10, currentGame);
			if (currentShip.getHealth() <= 0) {
				currentGame.gameOver(currentShip.getGameOverText());
			}
			
			EventDialogs dialog = new EventDialogs(soldierSavesShip);
			dialog.setVisible(true);
		}
		
	}
	
	/*
	 * Alien battle random event. A number between 1 and 20. If the number is greater than a given crew member's damage then that crew member sustains 
	 * damage equal to the generated number. If the crew member's damage is higher they sustain no damage. If no crew members sustain damage, the crew gains
	 * a new MedKit.
	 */
	public static void spaceBattle(Crew currentCrew, Ship currentShip, GameEnvironment currentGame) {
		Random battleChances = new Random();
		
		int damageToShip = 0;
		boolean crewMembersHurt = false;
		String battleResult;
		
		
		for (CrewMember crewMember: currentCrew.getCrewList()) {
			int alienDamage = battleChances.nextInt(20) + 1;
			
			if (alienDamage >= crewMember.getDamage()) {
				crewMember.takeDamage(alienDamage);
				crewMembersHurt = true;
			}
			
			else {
				damageToShip += 10;
			}
		}
		
		if (crewMembersHurt) {
			battleResult = "Aliens boarded the ship and attacked the crew! Some crew members were hurt in the battle. The ship took some damage.";
			
		}
		
		else {
			battleResult = "Aliens boarded the ship and attacked the crew! Our brave crew members fought and repelled them without sustaining damage. "
					+ "The aliens left an item behind in their hasty retreat. The ship took some damage."; 
			currentCrew.addMedicalItem(new MedKit());
		}
		
		currentShip.takeDamage(damageToShip, currentGame);
		if (currentShip.getHealth() <= 0) {
			currentGame.gameOver(currentShip.getGameOverText());
		}
		
		EventDialogs dialog = new EventDialogs(battleResult);
		dialog.setVisible(true);
	}
	
	/*
	 * A battle that may occur when a crew member searches a planet. A number is generate between 1 and 20. If the crew member's damage is greater than
	 * the generated number they will sustain damage equal to the generated number. If the crew member's damage is greater then they may find an extra 
	 * item on the planet (not a Transporter Part). If the crew member's damage is less than the generated number the crew member will sustain damage between
	 */
	public static String planetBattle(CrewMember crewSearcher, Crew currentCrew, Planet planet) {
		Random battleChances = new Random();
		
		String battleResult;
		
		int alienDamage = battleChances.nextInt(20) + 1;
		
		if (crewSearcher.getDamage() >= alienDamage) {
			battleResult = crewSearcher.getName() + " encountered an aggressive alien on the surface of " + planet.getName() + ". The were able to overcome "
					+ "it and found an extra item it was carrying.";
			currentCrew.addMedicalItem(new FirstAidKit());
			
			int damageTaken = battleChances.nextInt(20) + 21;
			crewSearcher.takeDamage(damageTaken);
		}
		
		else {
			battleResult = crewSearcher.getName() + " encountered an aggressive alien on the surface of " + planet.getName() + ". They were hurt badly in the battle.";
			crewSearcher.takeDamage(alienDamage);
		}
		
		if (crewSearcher.getHealth() <= 0) {
			String crewMemberDied = crewSearcher.getName() + " died after encountering an aggressive searching the planet. They died for a good cause.";
			battleResult = crewMemberDied;
		}
		return battleResult;
	}
}


package gameenv;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.Random;

import crew.*;
import items.*;
import spaceship.*;
import views.*;
import planet.*;

public class GameEnvironment {
	
	private int daysCompleted = 0;
	private Crew currentCrew;
	private Ship currentShip;
	private Planet currentPlanet;
	private FoodItem[] diffFoods = {new ApplePie(), new BigMac(), new EnergyDrink(), new Fries(), new FroCo(), new Milo(), new MincePie(), new MincePieWithKetchup()};
	private MedicalItem[] diffMeds = {new FirstAidKit(), new MedKit()};
	
	// Here just for testing dont keep for final
	private Ship testShip = new Enterprise();
	
	
	private boolean transporterPartFound = false;
	
	public GameEnvironment() {
		// Initialize ship
		currentShip = new Enterprise();
		
		// Call main menu view to kick off program
		mainMenu();
	}
	
	public void mainMenu() {
		MainMenuView mainView = new MainMenuView(currentShip);
		mainView.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainView.getFrame().dispose();
				visitShop();
			}
		});
	}
	
	public void setupScreen() {
		SetupView setupGame = new SetupView();
	}
	
	public void visitShop() {
		// Test ship
		testShip.addCrewMember(new Medic("Claire"));
		testShip.addCrewMember(new Engineer("John"));
		testShip.addCrewMember(new Pilot("Gordon"));
		testShip.addCrewMember(new Soldier("Alara"));
		
		// List of shop items
		ArrayList<Item> shopItems = new ArrayList<Item>();
		
		// Fill shop list with random items
		while(shopItems.size() < 6) {
			Random rand = new Random();
			int randomNum = rand.nextInt(20) + 1;
			if (randomNum < 15) {
				FoodItem newItem = diffFoods[rand.nextInt(diffFoods.length)];
				if (newItem instanceof MincePieWithKetchup) {
					randomNum = rand.nextInt(100);
					if (randomNum < 95) continue;
				}
				if (shopItems.contains(newItem)) continue;
				shopItems.add(newItem);
			}
			else {
				MedicalItem newItem = diffMeds[rand.nextInt(diffMeds.length)];
				if (newItem instanceof MedKit) {
					randomNum = rand.nextInt(50);
					if (randomNum < 45) continue;
				}
				if (shopItems.contains(newItem)) continue;
				shopItems.add(newItem);
			}
		}
		
		SpaceStationView stationView = new SpaceStationView(testShip, shopItems);
		
		stationView.getLeaveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stationView.getFrame().dispose();
			}
		});
	}
	
	public void goToNextDay() {
		daysCompleted += 1;
		
		/* TODO */
		/* Reset actions for crew */
		/* Chance of random events */
		/* New planet */
		/* New Space Station/refresh shop */
		
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
	}
	
	
}

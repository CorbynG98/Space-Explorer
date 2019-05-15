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
	private int numDays;
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
		
		// Initialize crew
		currentCrew = new Crew();
		
		// Initialize first planet
		currentPlanet = new Planet();
		
		// Call main menu view to kick off program
		mainMenu();
	}
	
	public void mainMenu() {
		MainMenuView mainView = new MainMenuView(currentShip);
		mainView.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainView.getFrame().dispose();
				setupScreen();
			}
		});
	}
	
	public void setupScreen() {
		InitialSetupView initialSetup = new InitialSetupView();
		
		initialSetup.getConfirm().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (initialSetup.getShipName().getText().length() < 3) {
					initialSetup.getError().setText("Please enter a valid name!");
					return;
				}
				currentShip.setName(initialSetup.getShipName().getText());
				numDays = Integer.parseInt((String)initialSetup.getDays().getSelectedItem());
				initialSetup.getFrame().dispose();
				SetupView setupGame = new SetupView(currentShip);
				setupGame.getStartGame().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (currentShip.getCrew().getCrewList().size() < 2) {
							setupGame.getError().setText("You need more than 2 crew member");
							return;
						}
						setupGame.getFrame().dispose();
						newDay();
					}
				});
			}
		});
	}
	
	public void visitShop() {
		// Test ship
		testShip.getCrew().addCrewMember(new Medic("Claire"));
		testShip.getCrew().addCrewMember(new Engineer("John"));
		testShip.getCrew().addCrewMember(new Pilot("Gordon"));
		testShip.getCrew().addCrewMember(new Soldier("Alara"));
		
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
	
	public void newDay() {
		DayView day = new DayView();
	}
	
	public void goToNextDay() {
		daysCompleted += 1;
		
		for (CrewMember crewMember: currentCrew.getCrewList()) {
			crewMember.resetActionsPerformed();
		}
	
		currentPlanet = new Planet();
		
		/* Determine if a random event occurs */
		Random eventChance = new Random();
		int eventType = eventChance.nextInt(10);
		
		if (eventType == 5) {
			/* TODO 
			 *  Pass crewList to spacePlague function (currentCrew is a local private variable)
			 */
			RandomEvents.spacePlague(currentCrew);
		}
		
		/* TODO */
		/* New Space Station/refresh shop */
		
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
	}
	
	
}

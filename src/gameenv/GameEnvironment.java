package gameenv;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JFrame;

import crew.*;
import items.*;
import spaceship.*;
import views.*;
import planet.*;

public class GameEnvironment {
	
	private int daysCompleted = 0;
	private int numDays;
	private Ship currentShip;
	private Planet currentPlanet;
	private int totalParts;
	private int partsFound = 0;
	private JFrame dayView;
	private DayView day;
	
	private FoodItem[] diffFoods = {new ApplePie(), new BigMac(), new EnergyDrink(), new Fries(), new FroCo(), new Milo(), new MincePie(), new MincePieWithKetchup()};
	private MedicalItem[] diffMeds = {new FirstAidKit(), new MedKit()};
	
	private ArrayList<CrewMember> currentPilots = new ArrayList<CrewMember>();
	
	private boolean transporterPartFound = false;
	
	
	
	/* Initializes the main game objects */
	
	public GameEnvironment() {
		// Initialize ship
		currentShip = new Enterprise();
		
		// Initialize first planet
		currentPlanet = new Planet();
		
		// Call main menu view to kick off program
		mainMenu();
	}
	
	
	/* Initializes the title screen when the game is run */ 
	
	public void mainMenu() {
		MainMenuView mainView = new MainMenuView(currentShip);
		mainView.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainView.getFrame().dispose();
				setupScreen();
			}
		});
	}
	
	
	/* Initializes the window to begin creating a ship and crew */
	
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
				totalParts = numDays * (2/3);
				
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
	
	
	/* Actions when a player enters the shop with a crew member */
	
	public void visitShop() {		
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
		
		SpaceStationView stationView = new SpaceStationView(currentShip, shopItems);
		
		stationView.getLeaveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day.setInventoryList();
				stationView.getFrame().dispose();
				day.getFrame().setVisible(true);
			}
		});
	}
	
	public void newDay() {
		day = new DayView(currentShip, daysCompleted);
		day.getStationButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day.getFrame().setVisible(false);
				visitShop();
			}
		});
		day.getNextDay().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToNextDay();
				day.setCurrentDay(daysCompleted);
				day.updateGUI();
			}
		});
	}
	
	public void goToNextDay() {
		// Goes to the next day on the same planet.
		daysCompleted += 1;
		
		for (CrewMember crewMember: currentShip.getCrew().getCrewList()) {
			crewMember.resetActionsPerformed();
			
			if (crewMember.getSleepStatus()) {
				crewMember.setSleepStatus(false);
				crewMember.setTiredness(0);
			}
			
			if (crewMember.getDiseaseStatus()) {
				crewMember.setHealth(crewMember.getHealth() - 25);
			}
		}
	
		currentPlanet = new Planet();	
	}
	
	// Goes to a new planet, consumes 1 day.
	public void goToNewPlanet() {
		
		daysCompleted += 1;
		
		for (CrewMember crewMember: currentShip.getCrew().getCrewList()) {
			crewMember.resetActionsPerformed();
			
			if (crewMember.getSleepStatus()) {
				crewMember.setSleepStatus(false);
				crewMember.setTiredness(0);
			}
			
			if (crewMember.getDiseaseStatus()) {
				crewMember.setHealth(crewMember.getHealth() - 25);
			}
		}
	
		currentPlanet = new Planet();
		
		/* Determine if a random event occurs */
		Random eventChance = new Random();
		int eventType = eventChance.nextInt(10);
		
		/* Space plague occurs */
		if (eventType == 5) {
				
			RandomEvents.spacePlague(currentShip.getCrew().getCrewList());
		}
		
		/* Asteroid belt occurs */
		else if (eventType == 6) {
			boolean shipAlive = currentShip.AsteroidField();
			
			if (!shipAlive) {
				gameOver();
			}
		}
		
		/* Alien pirates occurs */
		else if (eventType == 7) { 
			RandomEvents.alienPirates(currentShip.getCrew());
		}
	}
	
	
	/* Game over method, creates game over screen and resets variables */
	
	public void gameOver() {
		
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
	}
	
	
}

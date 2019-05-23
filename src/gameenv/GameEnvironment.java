package gameenv;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

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
	private int hungerDecrease = 15;
	private int energyDecrease = 15;
	private int transporterPartsFound = 0;
	
	private List<FoodItem> foodItems = Arrays.asList(new ApplePie(), new BigMac(), new EnergyDrink(), new Fries(), new FroCo(), new Milo(), new MincePie(), new MincePieWithKetchup());
	private List<MedicalItem> medicalItems = Arrays.asList(new FirstAidKit(), new MedKit());
	

	
	
	
	
	
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
						for (CrewMember person : currentShip.getCrew().getCrewList()) {
							if (person instanceof Medic) {
								currentShip.getCrew().addMedicalItem(new MedKit());
							}
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
				FoodItem newItem = foodItems.get(rand.nextInt(foodItems.size()));
				if (newItem instanceof MincePieWithKetchup) {
					randomNum = rand.nextInt(100);
					if (randomNum < 95) continue;
				}
				if (shopItems.contains(newItem)) continue;
				shopItems.add(newItem);
			}
			
			else {
				MedicalItem newItem = medicalItems.get(rand.nextInt(medicalItems.size()));
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
		day.getState().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day.getFrame().setVisible(false);
				viewShipState();
			}
		});
		day.getSearchButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchPlanet();
			}
		});
		day.getRepairButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrewMember selected = day.getSelectedCrewMember();
				if (selected == null) return;
				if (selected.getActionsPerformed() >= 2) return;
				currentShip.repairShip(selected);
				day.updateGUI();
			}
		});
	}
	
	public void viewShipState() {
		ShipStatusView shipState = new ShipStatusView(currentShip);
		
		shipState.getLeave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day.getFrame().setVisible(true);
				shipState.getFrame().dispose();
			}
		});
	}
	
	public void repairShip() {
		
	}
	
	public void searchPlanet() {
		CrewMember activeCrewMember = day.getSelectedCrewMember();
		activeCrewMember.addActionPerformed();
		
		Object foundItem = currentPlanet.searchPlanet(activeCrewMember, foodItems, medicalItems);
		if (foundItem != null) {
			if (foundItem instanceof FoodItem) {
				currentShip.getCrew().addFoodItem((FoodItem) foundItem);
			}
			else if (foundItem instanceof MedicalItem) {
				currentShip.getCrew().addMedicalItem((MedicalItem) foundItem);
			}
			else if (foundItem instanceof TransporterPart) {
				transporterPartsFound += 1;
			}
		}
		else {
			
		}
		
		day.updateGUI();
	}
	
	public void goToNextDay() {
		// Goes to the next day on the same planet.
		daysCompleted += 1;
		
		if (daysCompleted >= numDays) {
			// Game is over, end
		}
		
		// Calculate new values, not resetting here, only when going to a new planet.
		for (CrewMember crewMember: currentShip.getCrew().getCrewList()) {
			crewMember.resetActionsPerformed();
			
			crewMember.setHunger((int)(crewMember.getHunger() - (hungerDecrease * crewMember.getHungerDegradation())));
			crewMember.setTiredness((int)(crewMember.getTiredness() - (hungerDecrease * crewMember.getTirednessDegradation())));
		}
		
		/* Random events will go here */
		
	}
	
	// Goes to a new planet, consumes 1 day.
	public void goToNewPlanet() {
		
		daysCompleted += 1;
		
		for (CrewMember crewMember: currentShip.getCrew().getCrewList()) {
			crewMember.resetActionsPerformed();
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
			RandomEvents.alienPirates(currentShip.getCrew(), currentShip);
		}
	}
	
	
	/* Game over method, creates game over screen and resets variables */
	
	public void gameOver() {
		
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
	}
	
	
}

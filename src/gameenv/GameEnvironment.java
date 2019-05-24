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
	private int numberOfGameDays;
	private Ship currentShip;
	private Planet currentPlanet;
	private JFrame dayView;
	private DayView day;
	private int hungerDecrease = 15;
	private int tirednessDecrease = 15;
	private int partsRequired;
	private int transporterPartsFound = 0;
	
	private List<FoodItem> foodItems = Arrays.asList(new ApplePie(), new BigMac(), new EnergyDrink(), new Fries(), new FroCo(), new Milo(), new MincePie(), new MincePieWithKetchup());
	private List<MedicalItem> medicalItems = Arrays.asList(new FirstAidKit(), new MedKit());
	

	
	
	
	
	
	/*
	 *  Initializes the main game objects 
	 */
	public GameEnvironment() {
		currentShip = new Enterprise();
		currentPlanet = new Planet();
	}
	
	public void newGame() {
		mainMenu();
	}
	
	/* 
	 * Initializes the title screen when the game is run erefull
	 */ 
	public void mainMenu() {
		MainMenuView mainView = new MainMenuView(currentShip);
		mainView.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainView.getFrame().dispose();
				setupScreen();
			}
		});
	}
	
	
	/* 
	 * Creates the crew selection window, which displays the attributes for different crew member classes. Also allows the naming of the crew members. 
	 */
	public void setupScreen() {
		InitialSetupView initialSetup = new InitialSetupView();
		
		initialSetup.getConfirm().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (initialSetup.getShipName().getText().length() < 3) {
					initialSetup.getError().setText("Please enter a valid name!");
					return;
				}
				
				currentShip.setName(initialSetup.getShipName().getText());
				numberOfGameDays = Integer.parseInt((String)initialSetup.getDays().getSelectedItem());
				partsRequired = (int)(numberOfGameDays * (2.0/3.0));
				
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
	
	
	/*
	 *  Actions when a player enters the shop with a crew member. Also Generates the items that will be available for purchase in the shop.
	 */
	public void visitShop() {		
		// List of shop items
		ArrayList<Item> shopItems = new ArrayList<Item>();
		
		// Generate random items for the space station shop
		while(shopItems.size() < 6) {
			Random selectShopItems = new Random();
			int itemType = selectShopItems.nextInt(20) + 1;
			
			if (itemType < 15) {
				FoodItem newItem = foodItems.get(selectShopItems.nextInt(foodItems.size()));
				if (newItem instanceof MincePieWithKetchup) {
					int chanceOfRareItem = selectShopItems.nextInt(100);
					if (chanceOfRareItem < 95) continue;
				}
				if (shopItems.contains(newItem)) continue;
				shopItems.add(newItem);
			}
			
			else {
				MedicalItem newItem = medicalItems.get(selectShopItems.nextInt(medicalItems.size()));
				if (newItem instanceof MedKit) {
					int chanceOfRareItem = selectShopItems.nextInt(50);
					if (chanceOfRareItem < 45) continue;
				}
				if (shopItems.contains(newItem)) continue;
				shopItems.add(newItem);
			}
		}
		
		SpaceStationView stationView = new SpaceStationView(currentShip, shopItems);
		
		// Button to leave the shop window
		stationView.getLeaveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day.setInventoryList();
				stationView.getFrame().dispose();
				day.getFrame().setVisible(true);
			}
		});
	}	
	
	
	/*
	 * Action events for the buttons on the main crew view screen
	 */
	public void newDay() {
		day = new DayView(currentShip, daysCompleted);
		
		// Go to space station shop
		day.getStationButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day.getFrame().setVisible(false);
				visitShop();
			}
		});
		
		// Go to next day
		day.getNextDay().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToNextDay(false);
				day.setCurrentDay(daysCompleted);
				day.updateGUI();
			}
		});
		
		// View the ship status
		day.getState().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day.getFrame().setVisible(false);
				viewShipState();
			}
		});
		
		// Search the current planet
		day.getSearchButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchPlanet();
			}
		});
		
		// Repair the ship
		day.getRepairButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrewMember selectedMember = day.getSelectedCrewMember();
				if (selectedMember == null) return;
				currentShip.repairShip(selectedMember);
				day.updateGUI();
			}
		});
		
		// Add the currently selected crew member as a pilot
		day.getPilotButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CrewMember selectedCrewMember = day.getSelectedCrewMember();
				if (selectedCrewMember.getActionsPerformed() >= 2) {
					return;
				}
				else {
					if (currentShip.getPilots().size() < 2 && !currentShip.getPilots().contains(selectedCrewMember)) {
						currentShip.getPilots().add(selectedCrewMember);
						selectedCrewMember.addActionPerformed();
						day.updateGUI();
					}
				}
				
			}
		});
		
		day.getFlyButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (currentShip.getPilots().size() == 2) {
					goToNewPlanet();
					day.updateGUI();
				}
			}
		});
	
	}
	
	/*
	 * Creates the Ship Status view window
	 */
	public void viewShipState() {
		ShipStatusView shipState = new ShipStatusView(currentShip);
		
		shipState.getLeave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day.getFrame().setVisible(true);
				shipState.getFrame().dispose();
			}
		});
	}
	
	/*
	 * Passes the currently selected crew member to the repairShip method and creates necessary dialogs
	 */
	public void repairShip() {
		CrewMember activeCrewMember = day.getSelectedCrewMember();
		
		// Confirm that a crew member is selected
		if (day.getSelectedCrewMember() == null) {
			return;
		}
		
		// Check that the crew member has actions left
		if (activeCrewMember.getActionsPerformed() >= 2) {
			EventDialogs noActionsLeft = new EventDialogs("This crew member has no actions left today.");
			noActionsLeft.setVisible(true);
			return;
		}
		
		int amountRepaired = currentShip.repairShip(activeCrewMember);
		String shipRepairText = activeCrewMember.getName() + " has repaired the ship and added " + Integer.toString(amountRepaired) + " points to the shields.";
		EventDialogs shipRepair = new EventDialogs(shipRepairText);
		shipRepair.setVisible(true);
	}
	
	/*
	 * Passes the currently selected crew member to the searchPlanet method and creates dialogs for any found items.
	 */
	public void searchPlanet() {
		CrewMember activeCrewMember = day.getSelectedCrewMember();
		
		// Confirm that a crew member is selected
		if (day.getSelectedCrewMember() == null) {
			return;
		}
		
		// Check that the crew member has actions left
		if (activeCrewMember.getActionsPerformed() >= 2) {
			EventDialogs noActionsLeft = new EventDialogs("This crew member has no actions left today.");
			noActionsLeft.setVisible(true);
			return;
		}
		
		activeCrewMember.addActionPerformed();
		
		Object foundItem = currentPlanet.searchPlanet(activeCrewMember, foodItems, medicalItems, currentShip.getCrew());
		
		// Analyze the type of item found and increment the associated variable(s). 
		if (foundItem != null) {
			
			if (foundItem instanceof FoodItem) {
				currentShip.getCrew().addFoodItem((FoodItem) foundItem);
			}
			
			else if (foundItem instanceof MedicalItem) {
				currentShip.getCrew().addMedicalItem((MedicalItem) foundItem);
			}
			
			else if (foundItem instanceof Integer) {
				currentShip.getCrew().addMoney((int) foundItem);
			}
			
			else if (foundItem instanceof TransporterPart) {
				transporterPartsFound += 1;
				day.updatePartsFound(transporterPartsFound);
			}
		}
		
		day.updateGUI();
	}
	
	/*
	 * Advances the game by a day, which resets crew actions and iterates their health, tiredness, and hunger levels. Can trigger certain random events.
	 */
	public void goToNextDay(boolean flyingToNewPlanet) {
		// Goes to the next day on the same planet.
		daysCompleted += 1;
		day.setDay(daysCompleted);
		day.updateGUI();
		
		currentShip.getPilots().clear();
		
		boolean atLeastTwoCrewAlive = false;
		
		if (daysCompleted > numberOfGameDays || transporterPartsFound == partsRequired) {
			if (transporterPartsFound == partsRequired) {
				gameWon();
			} else {
				gameOver("Got to last day without finding all the parts!");
			}
		}
		
		// Increment CrewMember variables, such as damage from space plague, and hunger and tiredness degradation. 
		for (CrewMember crewMember: currentShip.getCrew().getCrewList()) {
			crewMember.resetActionsPerformed();
			
			crewMember.setHunger((int)(crewMember.getHunger() - (hungerDecrease * crewMember.getHungerDegradation())));
			crewMember.setTiredness((int)(crewMember.getTiredness() - (tirednessDecrease * crewMember.getTirednessDegradation())));
			
			if (crewMember.getDiseaseStatus()) {
				Random spacePlagueDamage = new Random();
				int plagueDamage = spacePlagueDamage.nextInt(6) + 10;
				crewMember.takeDamage(plagueDamage);
			}
			
		}
		// Loop through and remove crew member if they are dead.
		for (int i = 0; i < currentShip.getCrew().getCrewList().size(); i++) {
			if (currentShip.getCrew().getCrewList().get(i).isDead()) {
				currentShip.getCrew().removeCrewMember(currentShip.getCrew().getCrewList().get(i));
			}
		}
		

		Random eventChance = new Random();
		int eventType = eventChance.nextInt(9);
		
		if (eventType == 5) {
			RandomEvents.spacePlague(currentShip.getCrew().getCrewList());
		}
		
		else if (eventType == 6) {
			RandomEvents.alienPirates(currentShip.getCrew(), currentShip, this);
		}
		
		else if (eventType == 7) {
			RandomEvents.spaceBattle(currentShip.getCrew(), currentShip, this);
		}

		else if (eventType == 8 && flyingToNewPlanet) {
			boolean shipAlive = currentShip.AsteroidField();
			
			if (!shipAlive) {
				gameOver(currentShip.getGameOverText());
			}
		}
		
		
		for (int i = 0; i < currentShip.getCrew().getCrewList().size(); i++) {
			if (currentShip.getCrew().getCrewList().get(i).isDead()) {
				EventDialogs crewMemberDied = new EventDialogs(currentShip.getCrew().getCrewList().get(i).getName() + " has died. You must continue the mission without them.");
				crewMemberDied.setVisible(true);
				currentShip.getCrew().removeCrewMember(currentShip.getCrew().getCrewList().get(i));
			}
		}
		
		if (currentShip.getCrew().getCrewList().size() >= 2) {
			atLeastTwoCrewAlive = true;
		}
		
		if (!atLeastTwoCrewAlive) {
			gameOver("There are not enough crew members to continue the mission. You have failed.");
		}
		
		day.updateGUI();
	}
	
	/*
	 * Advances the game by a day and creates a new planet. May trigger a random event. 
	 */
	public void goToNewPlanet() {
		currentPlanet = new Planet();
		day.resetPlanetPartsFound();
		goToNextDay(true);
	}
	
	
	/* 
	 * Game over method, creates game over screen and resets variables 
	 */
	public void gameOver(String gameOverText) {
		GameOverView gameOverWindow = new GameOverView(gameOverText, day);
	}
	
	public void gameWon() {
		GameWonView gameWonWindow = new GameWonView(day);
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.newGame();
	}
	
	
}

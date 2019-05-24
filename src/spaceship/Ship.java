package spaceship;

import java.util.ArrayList;
import crew.*;
import views.*;
import gameenv.*;

/**
 * Represents the Ship class. Ships allow Crew to fly to new planets. Ships have a shield variable that will decrease as the ship takes value
 * during events throughout the game, and will increase when a CrewMember conducts repairs on the ship. If the ship's health variable falls to 0 during a game
 * then the game is over as the ship has been destroyed.
 * @author ctg31
 * @author mch221
 *
 */
public class Ship {
	
	/**
	 * The name of the ship
	 */
	private String name;
	/**
	 * The current health of the ship
	 */
	private int health = 100;
	/**
	 * The maximum health of the ship
	 */
	private int maxHealth = 100;
	/**
	 * The ships crew
	 */
	private Crew crew = new Crew();
	/**
	 * The current pilots of the ship.
	 */
	private ArrayList<CrewMember> currentPilots = new ArrayList<CrewMember>();
	/**
	 * Game over text if the ships shields get to zero
	 */
	private String shipGameOverText = "The ship's shields have fallen to critical levels and the crew has been exposed to lethal doses of radiation. The"
			+ " mission has failed.";
	
	/**
	 * Constructor to set the name of the ship
	 * @param name String - The name of the ship
	 */
	public Ship(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * Constructor to set the name and custom health value of the ship.
	 * @param name String - The name of the ship
	 * @param health integer - The custom health value for the ship
	 */
	public Ship(String name, int health) {
		super();
		this.name = name;
		this.health = health;
		this.maxHealth = health;
	}
	
	/**
	 * Sets the name of the ship
	 * @param newName String - The new name of the ship
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * Removes some health from the ship
	 * @param damageTaken integer - Amount of damage taken.
	 * @param currentGame GameEnvironment - The game environment so the game can end on ship death.
	 */
	public void takeDamage(int damageTaken, GameEnvironment currentGame) {
		this.health -= damageTaken;
		if (health <= 0) {
			currentGame.gameOver(shipGameOverText);
		}
	}
	
	/**
	 * Get the name of the ship
	 * @return The ships name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the health of the ship
	 * @return The health of the ship
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Gets the crew object of the ship
	 * @return The crew object
	 */
	public Crew getCrew() {
		return this.crew;
	}
	
	/**
	 * Gets the currently selected pilots of the ship.
	 * @return ArrayList of the current pilots.
	 */
	public ArrayList<CrewMember> getPilots() {
		return currentPilots;
	}
	
	/**
	 * Get the ships game over text.
	 * @return The text to display when the ship dies.
	 */
	public String getGameOverText() {
		return shipGameOverText;
	}

	/**
	 * Repairs the ship but 10, with some bonus if the selected crew member is an engineer.
	 * @param person CrewMember - The crew member attempting the repair.
	 * @return The amount the person repaired the ship by.
	 */
	public int repairShip(CrewMember crewMember) {
		int repairAmount = 10;
		
		if (crewMember.getSpecialization() == "Engineer") {
			repairAmount *= 1.5;
		}
		
		this.health += repairAmount;
		
		if (health >= maxHealth) this.health=maxHealth;
		
		crewMember.addActionPerformed();
		
		String shipRepairText = crewMember.getName() + " has repaired the ship and added " + Integer.toString(repairAmount) + " points to the ship's shield.";
		EventDialogs shipRepair = new EventDialogs(shipRepairText);
		shipRepair.setVisible(true);
		
		return repairAmount;
	}
	
	/**
	 * Sends the ship through an asteroid field, applying some damage to it.
	 * @return True if the ship doesn't get destroyed. False otherwise.
	 */
	public boolean AsteroidField() {
		int damageAmount = 30;
		
		damageAmount += (this.health / 4);
		
		boolean pilotInCockpit = false;
		
		// Ship will take less damage if being piloted by a Pilot crew member
		for (CrewMember crewMember: currentPilots) {
			if (crewMember instanceof Pilot) {
				pilotInCockpit = true;
			}
		}
		
		if (pilotInCockpit) {
			damageAmount = damageAmount / 2;
		}
		this.health -= damageAmount;
		
		if (this.health <= 0) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Adds a new pilot the the list of current pilots
	 * @param newPilot CrewMember - The new pilot attempting to get added.
	 * @return True if there was room to add the pilot, false otherwise.
	 */
	public boolean addPilot(CrewMember newPilot) {
		// Check if there are two pilots
		if (currentPilots.size() == 2) {
			return false;
		}
		
		else {
			currentPilots.add(newPilot);
			return true;
		}
	}
}

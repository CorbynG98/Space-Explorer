package spaceship;

import java.util.ArrayList;
import crew.*;
import gameenv.*;

public class Ship {
	
	// Variables
	private String name;
	private int health = 100;
	private int maxHealth = 100;
	private Crew crew = new Crew();
	private ArrayList<CrewMember> currentPilots = new ArrayList<CrewMember>();
	private String shipGameOverText = "The ship's shields have fallen to critical levels and the crew has been exposed to lethal doses of radiation. The"
			+ " mission has failed.";
	
	// Constructor/s
	public Ship(String name) {
		super();
		this.name = name;
	}
	
	public Ship(String name, int health) {
		super();
		this.name = name;
		this.health = health;
		this.maxHealth = health;
	}
	
	// Setter/s
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void takeDamage(int damageTaken, GameEnvironment currentGame) {
		this.health -= damageTaken;
		if (health <= 0) {
			currentGame.gameOver(shipGameOverText);
		}
	}
	
	// Getter/s
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public Crew getCrew() {
		return this.crew;
	}
	
	public ArrayList<CrewMember> getPilots() {
		return currentPilots;
	}
	
	public String getGameOverText() {
		return shipGameOverText;
	}

	public int repairShip(CrewMember person) {
		int repairAmount = 10;
		
		if (person.getSpecialization() == "Engineer") {
			repairAmount *= 1.5;
		}
		
		this.health += repairAmount;
		if (health >= maxHealth) this.health=maxHealth;
		person.addActionPerformed();
		
		return repairAmount;
	}
	
	public void ShipToShipFight(int damageAmount, GameEnvironment currentGame) {
		this.health -= damageAmount;
		
		if (health <= 0) {
			currentGame.gameOver(shipGameOverText);
		}
	}
	
	public boolean AsteroidField() {
		int damageAmount = 30;
		
		damageAmount += (this.health / 4);
		
		// Ship will take less damage if being piloted by a Pilot crew member
		for (CrewMember crewMember: currentPilots) {
			if (crewMember instanceof Pilot) {
				damageAmount += (this.health / 5);
			}
		}
		 
		this.health -= damageAmount;
		
		if (this.health <= 0) {
			return false;
		}
		
		return true;
	}
	
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

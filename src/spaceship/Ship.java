package spaceship;

import java.util.ArrayList;
import crew.*;


public class Ship {
	
	// Variables
	private String name;
	private int health = 100;
	private int maxHealth = 100;
	private Crew crew = new Crew();
	
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
	
	
	// Action/s
	public void repairShip(CrewMember person) {
		int repairAmount = 10;
		if (person.getSpecialization() == "Engineer") {
			repairAmount *= 1.2;
		}
		this.health += repairAmount;
		if (health >= maxHealth) this.health=maxHealth;
	}
	
	public void ShipToShipFight(int damageAmount) {
		this.health -= damageAmount;
		
		if (health <= 0) {
			// Game over do game over stuff here
		}
	}
	
	public void AsteroidField(CrewMember person, int damageAmount) {
		if (person.getSpecialization() == "Pilot") {
			damageAmount *= 0.8;
		}
		
		this.health -= damageAmount;
		
		if (health <= 0) {
			// Game over do game over stuff here
		}
	}
}

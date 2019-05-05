package SpaceShip;

public class Ship {
	// Variables
	private String name;
	private int health = 100;
	private int maxHealth = 100;
	
	// Constructor/s
	public Ship(String name) {
			this.name = name;
	}
	
	public Ship(String name, int health) {
		this.name = name;
		this.health = health;
		this.maxHealth = health;
	}
	
	// Getter/s
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	// Action/s
	public void repairShip(CrewMember person) {
		int repairAmount = 10;
		if (person.specialization == "Engineer") {
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
		if (person.specialization == "Pilot") {
			damageAmount *= 0.8;
		}
		
		this.health -= damageAmount;
		
		if (health <= 0) {
			// Game over do game over stuff here
		}
	}
}

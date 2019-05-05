package crew;
import InventoryItems.*;

public class CrewMember {
	
	private String name;
	private String specialization;
	private double health = 100;
	private int hunger = 0;
	private int tiredness = 0;
	private int damage = 0;
	private double healthDegradation = 1;
	private double hungerDegradation = 1;
	private double tirednessDegradation = 1;
	private boolean isAsleep = false;
	private boolean isDiseased = false;
	
	
	/* Constructor method for the CrewMember class */
	
	
	public CrewMember(String name, String type, int damage, double healthDegradation, double hungerDegradation, double tirednessDegradation) {
		this.name = name;
		this.specialization = type;
		this.damage = damage;
		this.healthDegradation = healthDegradation;
		this.hungerDegradation = hungerDegradation;
		this.tirednessDegradation = tirednessDegradation;
	}

	
	
	/* Getter methods for the CrewMember variables */
	



	public String getName() {
		return name;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	
	public double getHealth() {
		return health;
	}
	
	public int getHunger() {
		return hunger;
	}
	
	public int getTiredness() {
		return tiredness;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public double getHealthDegradation() {
		return healthDegradation;
	}
	
	public double getHungerDegradation() {
		return hungerDegradation;
	}
	
	public double getTirednessDegradation() {
		return tirednessDegradation;
	}
	
	public boolean checkSleepStatus() {
		return isAsleep;
	}
	
	public boolean checkDiseaseStatus() {
		return isDiseased;
	}
	

	
	/* Setter methods for relevant CrewMember variables */
	
	
	public void setHealth(double health) {
		this.health = health;
	}
	
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}
	
	public void setSleepStatus(boolean isAsleep) {
		this.isAsleep = isAsleep;
	}
	
	
	
	/* CrewMember action methods */
	
	
	public void useItem(FoodItem name) {
		this.health += name.getHealthValue();
		this.tiredness -= name.getEnergyValue();
		this.hunger -= name.getHungerValue();
		
		if (this.health > 100) {
			this.health = 100;
		}
		
		if (this.tiredness < 0) {
			this.tiredness = 0;
		}
		
		if (this.hunger < 0) {
			this.hunger = 0;
		}
		
	}
	
	public void useItem(MedicalItem name) {
		this.health += name.getHealthValue();
		
		if (name.isPlagueCure()) {
			this.isDiseased = false;
		}
		
		if (this.health > 100) {
			this.health = 100;
		}
	}
	
	public void sleep() {
		this.isAsleep = true;
		this.tiredness = 0;
	}
}

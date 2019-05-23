package crew;

import items.*;

public class CrewMember {
	
	private String name;
	private String specialization;
	private double health = 100;
	private int hunger = 100;
	private int tiredness = 100;
	private int damage = 0;
	private double healthDegradation = 1;
	private double hungerDegradation = 1;
	private double tirednessDegradation = 1;
	private boolean isAsleep = false;
	private boolean isDiseased = false;
	private boolean isDead = false;
	private int actionsPerformed = 0;
	
	
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
	
	public boolean getDiseaseStatus() {
		return isDiseased;
	}
	
	public int getActionsPerformed() {
		return actionsPerformed;
	}

	
	public double[] getCrewMemberStatus() {
		double statusArray[];
		statusArray = new double[3];
		
		statusArray[0] = health;
		statusArray[1] = hunger;
		statusArray[2] = tiredness;
		
		return statusArray;
	}
	

	
	/* Setter methods for relevant CrewMember variables */
	
	
	public void setHealth(double health) {
		this.health = health;
	}
	
	public void setHunger(int hunger) {
		if (hunger <= 0) {
			hunger = 0;
			// He dead run code to kill
			// ( remove from crew list / eject )
			this.isDead = true;
		}
		this.hunger = hunger;
	}
	
	public void setTiredness(int tiredness) {
		if (tiredness <= 0) { 
			tiredness = 25;
			this.actionsPerformed = 2;
		}
		this.tiredness = tiredness;
	}
	
	public void setDiseaseStatus(boolean isDiseased) {
		this.isDiseased = isDiseased;
	}
	
	public void addActionPerformed() {
		actionsPerformed += 1;
	}
	
	public void resetActionsPerformed() {
		if (isDead == true) {
			//Don't reset the actions of a dead guy/gal
		}
		actionsPerformed = 0;
	}
	
	
	/* CrewMember action methods */
	
	
	public void useItem(FoodItem name) {
		this.health += name.getHealthValue();
		this.tiredness += name.getEnergyValue();
		this.hunger += name.getHungerValue();
		
		if (this.health > 100) {
			this.health = 100;
		}
		
		if (this.tiredness < 0) {
			this.tiredness = 0;
		}
		
		if (this.hunger < 0) {
			this.hunger = 0;
		}
		
		actionsPerformed += 1;
		
	}
	
	public void useItem(MedicalItem name) {
		this.health += name.getHealthValue();
		
		if (name.isPlagueCure()) {
			this.isDiseased = false;
		}
		
		if (this.health > 100) {
			this.health = 100;
		}
		
		actionsPerformed += 1;
	}
	
	public void sleep() {
		this.actionsPerformed = 2;
		this.tiredness = 100;
	}
}

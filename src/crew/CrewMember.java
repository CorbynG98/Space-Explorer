package crew;

import items.*;

public class CrewMember {
	
	//Name variable for the CrewMember class
	private String name;
	private String specialization;
	private double health = 100;
	private int hunger = 100;
	private int tiredness = 100;
	private int damage = 0;
	private double healthDegradation = 1;
	private double hungerDegradation = 1;
	private double tirednessDegradation = 1;
	private String classString;
	private boolean isDiseased = false;
	private boolean isDead = false;
	private int actionsPerformed = 0;
	private String imagePath;
	
	
	
	/* Constructor method for the CrewMember class */
	
	
	public CrewMember(String name, String type, int damage, double healthDegradation, double hungerDegradation, double tirednessDegradation, String classString, String imagePath) {
		this.name = name;
		this.specialization = type;
		this.damage = damage;
		this.healthDegradation = healthDegradation;
		this.hungerDegradation = hungerDegradation;
		this.tirednessDegradation = tirednessDegradation;
		this.classString = classString;
		this.imagePath = imagePath;
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
	
	public boolean isDead() {
		return isDead;
	}
	
	public int getActionsPerformed() {
		return actionsPerformed;
	}
	
	public String getClassString() {
		return classString;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	

	
	/* 
	 * Setter methods for relevant CrewMember variables 
	 */
	
	
	/*
	 * Setter method for health variable of a CrewMember instance. If the crew member has 0 health the will die and be removed from the crew.
	 */
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
	
	/*
	 * Setter for the tiredness variable of a CrewMember instance. If the crew member has 0 tiredness they will lose their actions for the day.
	 */
	public void setTiredness(int tiredness) {
		if (tiredness <= 0) { 
			tiredness = 25;
			this.actionsPerformed = 2;
		}
		this.tiredness = tiredness;
	}
	
	/*
	 * Setter for the disease status variable of a CrewMember instance.
	 */
	public void setDiseaseStatus(boolean isDiseased) {
		this.isDiseased = isDiseased;
	}
	
	/*
	 * Method to decrease the crew member's health given by the passed integer value.
	 */
	public void takeDamage(int damageTaken) {
		this.health -= damageTaken;
	}
	
	/*
	 * Method to increment a crew member's actionsPerformed variable.
	 */
	public void addActionPerformed() {
		if (actionsPerformed < 2) {
			actionsPerformed += 1;
		}
	}
	
	/*
	 * Method to reset the actions of a crew member at the end of each day.
	 */
	public void resetActionsPerformed() {
		if (isDead == true) {
			//Don't reset the actions of a dead guy/gal
			return;
		}
		
		actionsPerformed = 0;
	}
	
	
	
	/* 
	 * CrewMember action methods 
	 */
	
	/*
	 * Method to use a food item on a crew member.
	 * @param name: takes a FoodItem to be used on the crew member.
	 */
	public void useItem(FoodItem name) {
		this.health += name.getHealthValue();
		this.tiredness += name.getEnergyValue();
		this.hunger += name.getHungerValue();
		
		if (this.health > 100) {
			this.health = 100;
		}
		
		if (this.tiredness > 100) {
			this.tiredness = 100;
		}
		
		if (this.hunger > 100) {
			this.hunger = 100;
		}
		
		actionsPerformed += 1;
		
	}
	
	/*
	 * Method to use a medical item on a crew member.
	 * @param name: takes a MedicalItem to be used on the crew member.
	 */
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
	
	/*
	 * Method to put a crew member to sleep. Resets the actions performed for the given crew member.
	 */
	public void sleep() {
		this.actionsPerformed = 2;
		this.tiredness = 100;
	}
}

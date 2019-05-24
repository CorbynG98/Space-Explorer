package crew;

import items.*;

/**
 * Represents a CrewMember object. These are the characters that are used to play the game and perform actions within the game. Each CrewMember has various
 * attributes based on their class.
 * @author mch221
 *
 */
public class CrewMember {
	
	/**
	 * Holds the name String variable for a CrewMember object.
	 */
	private String name;
	/**
	 * Holds the class of a CrewMember object as a String.
	 */
	private String specialization;
	/**
	 * Holds the current health value of a CrewMember object.
	 */
	private double health = 100;
	/**
	 * Holds the current hunger value of a CrewMember object.
	 */
	private int hunger = 100;
	/**
	 * Holds the current tiredness value of a CrewMember object.
	 */
	private int tiredness = 100;
	/**
	 * Holds the damage output value of a CrewMember object.
	 */
	private int damage = 0;
	/**
	 * Holds the health degradation multiplier for a CrewMember object.
	 */
	private double healthDegradation = 1;
	/**
	 * Holds the hunger degradation multiplier for a CrewMember object.
	 */
	private double hungerDegradation = 1;
	/**
	 * Holds the tiredness degradation multiplier for a CrewMember object.
	 */
	private double tirednessDegradation = 1;
	/**
	 * Holds the class string for a CrewMember object, giving a description of the classes' strengths and weaknesses.
	 */
	private String classString;
	/**
	 * Holds the current disease status of a CrewMember object, depending on whether or not they currently have Space Plague.
	 */
	private boolean isDiseased = false;
	/**
	 * Holds the alive status of a CrewMember object, depending on whether the crew member has been killed by an event in the game.
	 * If true, the CrewMember will be removed from the Crew at the end of the day.
	 */
	private boolean isDead = false;
	/**
	 * Holds the number of actions performed during a day for a CrewMember object.
	 */
	private int actionsPerformed = 0;
	/**
	 * Holds the image path string to the image for a CrewMember class.
	 */
	private String imagePath;

	/**
	 * Creates new CrewMember objects.
	 * @param name takes a String representing the name string given by the player.
	 * @param type takes a String representing the class of a CrewMember object.
	 * @param damage takes an Integer for the damage output value. 
	 * @param healthDegradation takes a double with the health degradation multiplier.
	 * @param hungerDegradation takes a double with the hunger degradation multiplier.
	 * @param tirednessDegradation takes a double with the tiredness degradation multiplier.
	 * @param classString takes a String containing a description of the CrewMember class.
	 * @param imagePath takes a String containing a path to the class image.
	 */
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
	
	/**
	 * Gets the name of a CrewMember object.
	 * @return a String containing the name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the class type of a CrewMember object.
	 * @return a String containing the class.
	 */
	public String getSpecialization() {
		return specialization;
	}
	
	/**
	 * Gets a double value with the health of a CrewMember object.
	 * @return a double with the current health value.
	 */
	public double getHealth() {
		return health;
	}
	
	/**
	 * Gets an Integer value with the hunger of a CrewMember object.
	 * @return an integer with the current hunger value.
	 */
	public int getHunger() {
		return hunger;
	}
	
	/**
	 * Gets an Integer value with the tiredness of a CrewMember object.
	 * @return an integer with the current tiredness value.
	 */
	public int getTiredness() {
		return tiredness;
	}
	
	/**
	 * Gets an Integer value with the damage output of a CrewMember object.
	 * @return an integer with the damage value.
	 */
	public int getDamage() {
		return damage;
	}
	
	/**
	 * Gets the health degradation multiplier of a CrewMember object.	
	 * @return a double with the health degradation multiplier.
	 */
	public double getHealthDegradation() {
		return healthDegradation;
	}
	
	/**
	 * Gets the hunger degradation multiplier of a CrewMember object.
	 * @return a double with the hunger degradation multiplier.
	 */
	public double getHungerDegradation() {
		return hungerDegradation;
	}
	
	/**
	 * Gets the tiredness degradation multiplier of a CrewMember object.
	 * @return a double with the tiredness degradation multiplier.
	 */
	public double getTirednessDegradation() {
		return tirednessDegradation;
	}
	
	/**
	 * Gets the current disease status of a CrewMember object.
	 * @return a boolean value with the current disease status.
	 */
	public boolean getDiseaseStatus() {
		return isDiseased;
	}
	
	/**
	 * Gets the current death status of a CrewMember object.
	 * @return a boolean value representing whether the CrewMember is alive currently (false if they are alive).
	 */
	public boolean isDead() {
		return isDead;
	}
	
	/**
	 * Gets the number of actions performed by a CrewMember during the current day.
	 * @return an integer with the current number of actions performed.
	 */
	public int getActionsPerformed() {
		return actionsPerformed;
	}
	
	/**
	 * Gets the class string of a CrewMember object.
	 * @return a String with the class string.
	 */
	public String getClassString() {
		return classString;
	}
	
	/**
	 * Gets the images path of a CrewMember object.
	 * @return a String with the image path.
	 */
	public String getImagePath() {
		return imagePath;
	}
	
	
	/**
	 * Sets the health variable of a CrewMember object. If the crew member has 0 health be removed from the crew at the end of the day.
	 * @param health takes a double with the new health value.
	 */
	public void setHealth(double health) {
		this.health = health;
	}
	
	/**
	 * Sets the hunger value of a CrewMember object.
	 * @param hunger takes an integer with a CrewMembers new hunger value. 
	 */
	public void setHunger(int hunger) {
		if (hunger <= 0) {
			hunger = 0;
			// crew member has died
			this.isDead = true;
		}
		this.hunger = hunger;
	}
	
	/**
	 * Sets the tiredness variable of a CrewMember object. If the crew member has 0 tiredness they will lose their actions for the day.
	 * @param tiredness takes an integer with the new tiredness value.
	 */
	public void setTiredness(int tiredness) {
		if (tiredness <= 0) { 
			tiredness = 25;
			this.actionsPerformed = 2;
		}
		this.tiredness = tiredness;
	}
	
	/**
	 * Sets the disease status variable of a CrewMember object.
	 * @param isDiseased takes a boolean value with the new disease status.
	 */
	public void setDiseaseStatus(boolean isDiseased) {
		this.isDiseased = isDiseased;
	}
	
	/**
	 * Inflicts damage on a CrewMember object.
	 * @param damageTaken takes an integer with the damage amount.
	 */
	public void takeDamage(int damageTaken) {
		this.health -= damageTaken;
	}
	
	/**
	 * Increments the CrewMember's actionsPerformed variable by one.
	 */
	public void addActionPerformed() {
		if (actionsPerformed < 2) {
			actionsPerformed += 1;
		}
	}
	
	/*
	 * Resets the actionsPerformed variable if a crew member is still alive.
	 */
	public void resetActionsPerformed() {
		if (isDead == true) {
			//Don't reset the actions of a dead crew member.
			return;
		}
		
		actionsPerformed = 0;
	}

	/**
	 * Uses an a food item on a CrewMember object.
	 * @param name takes a FoodItem to be used on the crew member.
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
	
	/**
	 * Uses a medical item on a CrewMember object.
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
	
	/**
	 * Performs the sleep action for a CrewMember. Resets the tiredness variable, but removes the actions from that crew member for the current day.
	 */
	public void sleep() {
		this.actionsPerformed = 2;
		this.tiredness = 100;
	}
}

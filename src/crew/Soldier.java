package crew;

/**
 * Represents the Soldier crew member class. Extends the CrewMember class.
 * @author mch221
 *
 */
public class Soldier extends CrewMember {
	
	/**
	 * Holds the class string for the Soldier class.
	 */
	private static String classString= "Soldiers inflict more damage to alien forces and are able to protect the ship from invaders";
	/**
	 * Holds the image path string for the Soldier class.
	 */
	private static String imagePath = "/images/soldier.jpg";
	
	/**
	 * Creates a new Soldier object by passing the appropriate variable values in the super constructor.
	 * @param name takes a String to set as the name.
	 */
	public Soldier(String name) {
		super(name, "Soldier", 20, 0.5, 1.5, 1.5, classString, imagePath);
	}
}

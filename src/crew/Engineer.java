package crew;

/**
 * Represents the Engineer crew member class. Extends the CrewMember class.
 * @author mch221
 *
 */
public class Engineer extends CrewMember {
	
	/**
	 * Holds the class string for the Engineer class.
	 */
	private static String classString = "Repairs to the ship will be far more efficent with engineers in the crew. They can also work with very little sleep.";
	/**
	 * Holds the image path string for the Engineer class.
	 */
	private static String imagePath = "/images/engineer.jpg";
	
	/**
	 * Creates a new Engineer object by passing the appropriate variable values in the super constructor.
	 * @param name takes a String to set as the name.
	 */
	public Engineer(String name) {
		super(name, "Engineer", 10, 1.0, 0.5, 1.5, classString, imagePath);
	}

}

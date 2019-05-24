package crew;

/**
 * Represents the Scientist crew member class. Extends the CrewMember class.
 * @author mch221
 *
 */
public class Scientist extends CrewMember {
	
	/**
	 * Holds the class string for the Scientist class.
	 */
	private static String classString = "The scientist has specialized planet search equipment making him much more effective at searching for parts.";
	/**
	 * Holds the image path string for the Scientist class.
	 */
	private static String imagePath = "/images/scientist.jpg";
	
	/**
	 * Creates a new Scientist object by passing the appropriate variable values in the super constructor.
	 * @param name takes a String to set as the name.
	 */
	public Scientist(String name) {
		super(name, "Scientist", 10, 1, 1, 1, classString, imagePath);
	}

}

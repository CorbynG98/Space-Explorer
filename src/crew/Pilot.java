package crew;

/** 
 * Represents the Pilot crew member class. Extends the CrewMember class.
 * @author mch221
 *
 */
public class Pilot extends CrewMember{
	
	/**
	 * Holds the class string for the Pilot class.
	 */
	private static String classString = "The pilot has undertaken enhanced flight training, taking less damage in asteroid fields.";
	/**
	 * Holds the image path string for the Pilot class.
	 */
	private static String imagePath = "/images/pilot.jpg";
	
	/**
	 * Creates a new Pilot object by passing the appropriate variable values in the super constructor.
	 * @param name takes a String to set as the name.
	 */
	public Pilot(String name) {
		super(name, "Pilot", 10, 1.0, 1.0, 0.5, classString, imagePath);
	}
}

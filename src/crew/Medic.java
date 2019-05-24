package crew;

/**
 * Represents the Medic crew member class. Extends the CrewMember class.
 * @author mch221
 *
 */
public class Medic extends CrewMember {
	
	/**
	 * Holds the class string for the Medic class.
	 */
	private static String classString = "Medics know how to get the crew back on their feet. They'll bring their tools and experience to the crew.";
	/**
	 * Holds the image path string for the Medic class.
	 */
	private static String imagePath = "/images/medic.jpg";
	
	/**
	 * Creates a new Medic object by passing the appropriate variable values in the super constructor.
	 * @param name takes a String to set as the name.
	 */
	public Medic(String name) {
		super(name, "Medic", 10, 0.5, 1.5, 1.5, classString, imagePath);
	}
}


package crew;

/**
 * Represents the Merchant crew member class. Extends the CrewMember class.
 * @author mch221
 *
 */
public class Merchant extends CrewMember {
	
	/**
	 * Holds the class string for the Merchant class.
	 */
	private static String classString = "Merchants have smooth bartering skills which will get better deals at space station shops.";
	/**
	 * Holds the image path string for the Merchant class.
	 */
	private static String imagePath = "/images/merchant.jpg";
	
	/**
	 * Creates a new Merchant object by passing the appropriate variable values in the super constructor.
	 * @param name takes a String to set as the name.
	 */
	public Merchant(String name) {
		super(name, "Merchant", 10, 1.5, 1.5, 1.5, classString, imagePath);
	}
}

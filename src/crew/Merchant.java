package crew;

public class Merchant extends CrewMember {
	
	private static String classString = "Merchants have smooth bartering skills which will get better deals at space station shops.";
	private static String imagePath = "/images/merchant.jpg";
	
	public Merchant(String name) {
		super(name, "Merchant", 10, 1.5, 1.5, 1.5, classString, imagePath);
	}
}

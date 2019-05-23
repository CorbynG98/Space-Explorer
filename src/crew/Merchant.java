package crew;

public class Merchant extends CrewMember {
	
	private static String classString = "The Merchant has superior bartering skills making all shop items cheaper for all crew members.";
	
	public Merchant(String name) {
		super(name, "Merchant", 10, 1.5, 1.5, 1.5, classString);
	}
}

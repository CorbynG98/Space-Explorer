package crew;

public class Engineer extends CrewMember {
	
	private static String classString = "Repairs to the ship will be far more efficent with engineers in the crew. They can also work with very little sleep.";
	private static String imagePath = "/images/engineer.jpg";
	
	public Engineer(String name) {
		super(name, "Engineer", 10, 1.0, 0.5, 1.5, classString, imagePath);
	}

}

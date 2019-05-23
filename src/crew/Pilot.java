package crew;

public class Pilot extends CrewMember{
	
	private static String classString = "The pilot has undertaken enhanced flight training, taking less damage in asteroid fields.";
	private static String imagePath = "/images/pilot.jpg";
	
	public Pilot(String name) {
		super(name, "Pilot", 10, 1.0, 1.0, 0.5, classString, imagePath);
	}
}

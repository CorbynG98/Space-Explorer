package crew;

public class Scientist extends CrewMember {
	
	private static String classString = "The scientist has specialized planet search equipment making him much more effective at searching for parts.";
	
	public Scientist(String name) {
		super(name, "Scientist", 10, 1, 1, 1, classString);
	}

}

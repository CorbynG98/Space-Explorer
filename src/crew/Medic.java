package crew;

public class Medic extends CrewMember {
	
	private static String classString = "Medics know how to get the crew back on their feet. They'll bring their tools and experience to the crew.";
	public Medic(String name) {
		super(name, "Medic", 10, 0.5, 1.5, 1.5, classString);
	}
}


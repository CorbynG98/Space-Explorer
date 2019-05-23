package crew;

public class Soldier extends CrewMember {
	
	private static String classString= "Soldiers inflict more damage to alien forces and are able to protect the ship from invaders";
	private static String imagePath = "/images/soldier.jpg";
	
	public Soldier(String name) {
		super(name, "Soldier", 20, 0.5, 1.5, 1.5, classString, imagePath);
	}
}

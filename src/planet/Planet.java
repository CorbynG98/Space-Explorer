package planet;

import java.util.Random;
import crew.*;

public class Planet {
	
	
	private String name;
	private String[] planetNames = {"Tatooine", "Yavin IV", "Charon", "Pluto II", "Wotan", "Alpha-B32", "Terra", "Talara", "Athena", "Jupiter", "Beshan", "Calypso", "Nibiru", "Omicron Delta", "Risa", "Andoria", "Alderaan",
			"Yavin", "Kashyyyk", "Vendikar", "TRAPPIST-1", "Dagobah", "Hoth", "Janus IV", "Dakara", "Celestis"};
	
	
	public Planet() {
		
		Random r = new Random();
		String planetName = planetNames[r.nextInt(26) + 1];
		name = planetName;
		
	}
	
	public Object searchPlanet(CrewMember crewSearcher) {
		
	}

}

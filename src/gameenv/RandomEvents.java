package gameenv;

import java.util.Random;

import crew.*;
import spaceship.*;

public class RandomEvents {

	
	
	public void spacePlague(Crew crew) {
		Random plagueChance = new Random();
		
		
		
		for (CrewMember crewMember: crew.getCrewList()) {
			int getsPlague = plagueChance.nextInt(10);
			if (getsPlague >= 7) {
				if (crewMember.getSpecialization() == "Medic") {
					continue;
				}
				else {
					crewMember.setDiseaseStatus(true);
					crewMember.setHealth(crewMember.getHealth() - 5);
				}
			}
		}
	}
	
	public void asteroidField() {
		
	}
	
	public void alienPirates() {
		
	}
	
	public void spaceBattle() {
		
	}
	
}


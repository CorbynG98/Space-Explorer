package gameenv;

import crew.*;
import spaceship.*;
import planet.*;

public class GameEnvironment {
	
	private int daysCompleted = 0;
	private Crew currentCrew;
	private Ship currentShip;
	private Planet currentPlanet;
	
	
	private boolean transporterPartFound = false;
	
	public GameEnvironment() {
		currentCrew = new Crew();
		currentShip = new Ship();
		
	}
	
	public void goToNextDay() {
		daysCompleted += 1;
		
		/* TODO */
		/* Reset actions for crew */
		/* Chance of random events */
		/* New planet */
		/* New Space Station/refresh shop */
		
	}
	
	
}

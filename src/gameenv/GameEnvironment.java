package gameenv;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import crew.*;
import spaceship.*;
import views.*;
import planet.*;

public class GameEnvironment {
	
	private int daysCompleted = 0;
	private Crew currentCrew;
	private Ship currentShip;
	private Planet currentPlanet;
	
	
	private boolean transporterPartFound = false;
	
	public GameEnvironment() {
		// Initialize ship
		currentShip = new Enterprise();
		
		// Call main menu view to kick off program
		mainMenu();
	}
	
	public void mainMenu() {
		MainMenuView mainView = new MainMenuView(currentShip);
		
		mainView.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainView.getFrame().dispose();
				
			}
		});
	}
	
	public void setupScreen() {
		SetupView setupGame = new SetupView();
	}
	
	public void goToNextDay() {
		daysCompleted += 1;
		
		/* TODO */
		/* Reset actions for crew */
		/* Chance of random events */
		/* New planet */
		/* New Space Station/refresh shop */
		
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
	}
	
	
}

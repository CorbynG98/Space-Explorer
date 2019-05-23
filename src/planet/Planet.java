package planet;

import java.util.*;
import crew.*;
import items.*;
import views.*;

public class Planet {
	
	private String name;
	private String[] planetNames = {"Tatooine", "Yavin IV", "Charon", "Pluto II", "Wotan", "Alpha-B32", "Terra", "Talara", "Athena", "Jupiter", "Beshan", "Calypso", "Nibiru", "Omicron Delta", "Risa", "Andoria", "Alderaan",
			"Yavin", "Kashyyyk", "Vendikar", "TRAPPIST-1", "Dagobah", "Hoth", "Janus IV", "Dakara", "Celestis"};
	
	private boolean transporterPartFound = false;
	
	
	public Planet() {
		Random name = new Random();
		String planetName = planetNames[name.nextInt(26)];
		this.name = planetName;
	}
	
	public String getName() {
		return name;
	}
	
	public Object searchPlanet(CrewMember crewSearcher, List<FoodItem> foodItems, List<MedicalItem> medicalItems) {
		Random searchSelect = new Random();
		int itemType;
		
		Object foundItem = null;
		
		// Check if a transporter part has already been found on this planet
		if (!transporterPartFound) {
			itemType = searchSelect.nextInt(1);
		}
		else {
			itemType = searchSelect.nextInt(3);
		}

		// Select the found item
		if (itemType == 0) {
			
			// Search bonus for Scientist crew members
			if (crewSearcher.getSpecialization() == "Scientist") {
				int getPieWithKetchup = searchSelect.nextInt(4);
				if (getPieWithKetchup == 3) {
					foundItem = new MincePieWithKetchup();
				}
				
				else {
					foundItem = foodItems.get(searchSelect.nextInt(foodItems.size()));
				}
			}
			
			else {
				foundItem = foodItems.get(searchSelect.nextInt(foodItems.size()));
			}
		}
		
		else if (itemType == 1) {
			foundItem = medicalItems.get(searchSelect.nextInt(medicalItems.size()));
		}
		
		else if (itemType == 2) {
			return foundItem;
		}
	
		else if (itemType == 3) {
			foundItem = new TransporterPart();
			transporterPartFound = true;
		}
		
		if (foundItem != null) {
			String foundItemText = crewSearcher.getName() + " found one " + foundItem.toString() + " while searching " + this.name + ". It has been added to the ship's inventory.";
			RandomEventDialogs dialog = new RandomEventDialogs(foundItemText);
			dialog.setVisible(true);
		}
		else {
			String foundNothing = crewSearcher.getName() + " searched " + this.name + " but found nothing.";
			RandomEventDialogs dialog = new RandomEventDialogs(foundNothing);
			dialog.setVisible(true);
		}
		
		return foundItem;
	}

}

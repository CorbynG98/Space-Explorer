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
			
			// Search bonus if scientist in the crew
			if (crewSearcher instanceof Scientist) {
				int searchBonus = searchSelect.nextInt(8);
				
				if (searchBonus >= 4) {
					itemType = 4;
				}
				
				else {
					itemType = searchBonus;
				}
			}
			else {
				itemType = searchSelect.nextInt(5);
			}
		}
		else {
			itemType = searchSelect.nextInt(4);
		}

		// Food found
		if (itemType == 0) {
			
			foundItem = foodItems.get(searchSelect.nextInt(foodItems.size()));
			
		}
		
		// Medical item found
		else if (itemType == 1) {
			foundItem = medicalItems.get(searchSelect.nextInt(medicalItems.size()));
		}
		
		// Money found
		else if (itemType == 2) {
			foundItem = searchSelect.nextInt(500);
		}
		
		// Nothing found
		else if (itemType == 3) {
			
		}
		
		// Transporter part found
		else if (itemType == 4) {
			foundItem = new TransporterPart();
			transporterPartFound = true;
		}
		
		
		// Dialogs for the object found
		if (foundItem != null) {
			
			// Crew member found money on planet
			if (foundItem instanceof Integer) {
				
				String foundItemText = crewSearcher.getName() + " found " + Integer.toString((Integer) foundItem) + " credits while searching " + this.name + ". It has been added to the crew's bank.";
				EventDialogs dialog = new EventDialogs(foundItemText);
				dialog.setVisible(true);
			}
			
			// Crew member found item on planet
			else {
			
				String foundItemText = crewSearcher.getName() + " found one " + foundItem.toString() + " while searching " + this.name + ". It has been added to the ship's inventory.";
				EventDialogs dialog = new EventDialogs(foundItemText);
				dialog.setVisible(true);
			}
		}
		
		else {
			// Crew member found nothing on planet
			String foundNothing = crewSearcher.getName() + " searched " + this.name + " but found nothing.";
			EventDialogs dialog = new EventDialogs(foundNothing);
			dialog.setVisible(true);
		}
		
		return foundItem;
	}

}

package planet;

import java.util.*;

import crew.*;
import items.*;
import views.*;
import gameenv.RandomEvents;

/*
 * Represents planets that may exist in a GameEnvironment instance. The name is chosen from an array of name Strings. One Transporter
 * part may be found per planet.
 */
public class Planet {
	
	/*
	 * The name of a Planet object
	 */
	private String name;
	/*
	 * An array of possible names for Planet objects. When a new Planet object is created it's name is selected from the array.
	 */
	private String[] planetNames = {"Tatooine", "Yavin IV", "Charon", "Pluto II", "Wotan", "Alpha-B32", "Terra", "Talara", "Athena", "Jupiter", "Beshan", "Calypso", "Nibiru", "Omicron Delta", "Risa", "Andoria", "Alderaan",
			"Yavin", "Kashyyyk", "Vendikar", "TRAPPIST-1", "Dagobah", "Hoth", "Janus IV", "Dakara", "Celestis"};
	/*
	 * Boolean value for whether a transporter part has been found on a given Planet yet. If true no more parts can be found.
	 */
	private boolean transporterPartFound = false;
	
	/*
	 * Creates Planet objects. The name variable is randomly chosen from the planetNames array.
	 */
	public Planet() {
		Random name = new Random();
		String planetName = planetNames[name.nextInt(26)];
		this.name = planetName;
	}
	
	/*
	 * Gets the name of a Planet object.
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Allows crew members to search a planet. There is an equal chance of finding a FoodItem, MedicalItem, money, nothing, or, if no transporter part has yet been found
	 * on the current Planet, a transporter part. Scientist class crew members have a higher chance of finding transporter parts.
	 * @param crewSearcher takes a CrewMember object to conduct the search.
	 * @param foodItems takes a List of FoodItem objects that may be found on the planet.
	 * @param medicalItems takes a List of MedicalItem objects that may be found on the planet.
	 * @param currentCrew takes the current instance of Crew to allow found items to be added to the inventory.
	 * @return the object found, if any, while searching the planet.
	 * 
	 */
	public Object searchPlanet(CrewMember crewSearcher, List<FoodItem> foodItems, List<MedicalItem> medicalItems, Crew currentCrew) {
		Random searchSelect = new Random();
		int itemType;
		
		Object foundItem = null;
		String planetBattleString = "";
		// Chance of alien encounter on the planet
		int alienAppears = searchSelect.nextInt(6);
		if (alienAppears == 5) {
			planetBattleString = RandomEvents.planetBattle(crewSearcher, currentCrew, this);
		}
		
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
			foundItem = searchSelect.nextInt(300);
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
				
				String foundItemText = crewSearcher.getName() + " found " + Integer.toString((Integer) foundItem) + " credits while searching " + this.name + ". It has been added "
						+ "to the crew's bank. " + planetBattleString;
				EventDialogs dialog = new EventDialogs(foundItemText);
				dialog.setVisible(true);
			}
			
			// Crew member found item on planet
			else {
			
				String foundItemText = crewSearcher.getName() + " found one " + foundItem.toString() + " while searching " + this.name + ". It has been added to the ship's inventory. "
						+ planetBattleString;
				EventDialogs dialog = new EventDialogs(foundItemText);
				dialog.setVisible(true);
			}
		}
		
		else {
			// Crew member found nothing on planet
			String foundNothing = crewSearcher.getName() + " searched " + this.name + " but found nothing. " + planetBattleString;
			EventDialogs dialog = new EventDialogs(foundNothing);
			dialog.setVisible(true);
		}
		
		return foundItem;
	}

}

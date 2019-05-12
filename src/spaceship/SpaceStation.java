package spaceship;

import java.util.ArrayList;

import crew.*;
import items.*;
import views.*;

@SuppressWarnings("unused")
public class SpaceStation {
	private ArrayList<Item> shopItems = new ArrayList<Item>();
	
	public SpaceStation(Ship spaceShip) {	
		// Testing
		this.shopItems.add(new FroCo());
		this.shopItems.add(new Fries());
		this.shopItems.add(new ApplePie());
		this.shopItems.add(new MedKit());
		this.shopItems.add(new Milo());
		this.shopItems.add(new FirstAidKit());
		
		SpaceStationView stationView = new SpaceStationView(spaceShip, shopItems);
	}
	
	public static void main(String[] args) {
		Ship testShip = new Enterprise();
		testShip.addCrewMember(new Medic("Claire"));
		testShip.addCrewMember(new Engineer("John"));
		testShip.addCrewMember(new Pilot("Gordon"));
		testShip.addCrewMember(new Soldier("Alara"));
		SpaceStation station = new SpaceStation(testShip);
	}
}

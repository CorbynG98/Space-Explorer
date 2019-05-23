package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import crew.*;
import items.*;

class CrewTests {
	private static Crew crewList;
	private static Engineer testPerson;
	private static FroCo froCo;
	private static MedKit medKit;
	
	@BeforeAll
	static void beforeAll() {
		testPerson = new Engineer("Corbyn");
		medKit = new MedKit();
		froCo = new FroCo();
	}
	
	@BeforeEach
	public void init() {
		crewList = new Crew();
	}

	@Test
	void testAddCrewMember() {
		crewList.addCrewMember(testPerson);
		assertEquals(1, crewList.getCrewList().size());
	}
	
	@Test
	void testRemoveCrewMember() {
		crewList.addCrewMember(testPerson);
		crewList.removeCrewMember(testPerson);
		assertEquals(0, crewList.getCrewList().size());
	}
	
	@Test
	void testCrewMaxFour() {
		crewList.addCrewMember(new Engineer("person1"));
		crewList.addCrewMember(new Engineer("person2"));
		crewList.addCrewMember(new Engineer("person3"));
		crewList.addCrewMember(new Engineer("person4"));
		crewList.addCrewMember(new Engineer("person5"));
		assertEquals(4, crewList.getCrewList().size());
	}
	
	@Test
	void testAddMedicalItem() {
		crewList.addMedicalItem(medKit);
		assertEquals(1, crewList.getMedicalInventory().size());
	}
	
	@Test
	void testRemoveMedicalItem() {
		crewList.addMedicalItem(medKit);
		crewList.removeMedicalItem(medKit);
		assertEquals(0, crewList.getMedicalInventory().size());
	}
	
	@Test
	void testAddFoodItem() {
		crewList.addFoodItem(froCo);
		assertEquals(1, crewList.getFoodInventory().size());
	}
	
	@Test
	void testRemoveFoodItem() {
		crewList.addFoodItem(froCo);
		crewList.removeFoodItem(froCo);
		assertEquals(0, crewList.getFoodInventory().size());
	}
	
	@Test
	void testGetFullInventory() {
		crewList.addFoodItem(froCo);
		crewList.addMedicalItem(medKit);
		assertEquals(2, crewList.fullInventory().size());
	}
	
	@Test
	void testAddMoney() {
		int initMoney = crewList.getMoney();
		crewList.addMoney(100);
		assertEquals(initMoney+100, crewList.getMoney());
	}
	
	@Test
	void testRemoveMoney() {
		int initMoney = crewList.getMoney();
		crewList.removeMoney(100);
		assertEquals(initMoney-100, crewList.getMoney());
	}
	
	@Test
	void testMoneyNotBelowZero() {
		crewList.removeMoney(10000);
		assertEquals(0, crewList.getMoney());
	}

}

package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import crew.*;
import items.*;

class CrewMemberTest {
	private CrewMember testEngineer;
	
	@BeforeEach
	public void init() {
		testEngineer = new Engineer("Person1");
	}
	
	boolean testUseMedItem(CrewMember person, MedicalItem item, double expected) {
		person.setHealth(50);
		person.useItem(item);
		assertEquals(expected, person.getHealth());
		return true;
	}
	
	boolean testUseFoodItem(CrewMember person, FoodItem item, double expected) {
		person.setHunger(50);
		person.useItem(item);
		assertEquals(expected, person.getHunger());
		return true;
	}
	
	@Test
	void testUseMedKit() {
		assertTrue(testUseMedItem(testEngineer, new MedKit(), 100));
	}
	
	@Test
	void testUseFirstAidKit() {
		assertTrue(testUseMedItem(testEngineer, new FirstAidKit(), 75));
	}
	
	@Test
	void testPlagueCure() {
		testEngineer.setDiseaseStatus(true);
		testEngineer.useItem(new SpacePlagueCure());
		assertFalse(testEngineer.getDiseaseStatus());
	}
	
	@Test
	void testUseApplePie() {
		assertTrue(testUseFoodItem(testEngineer, new ApplePie(), 60));
	}
	
	@Test
	void testUseBigMac() {
		assertTrue(testUseFoodItem(testEngineer, new BigMac(), 100));
	}
	
	@Test
	void testUseMicePieWithKetchup() {
		assertTrue(testUseFoodItem(testEngineer, new MincePieWithKetchup(), 100));
	}
	
	@Test
	void testKillCrewMember() {
		testEngineer.setHunger(0);
		assertTrue(testEngineer.isDead());
	}
	
	@Test
	void testTakeDamage() {
		testEngineer.setHealth(100);
		testEngineer.takeDamage(20);
		assertEquals(80, testEngineer.getHealth());
	}
	
	@Test
	void testAddActionPerformed() {
		testEngineer.addActionPerformed();
		assertEquals(1, testEngineer.getActionsPerformed());
	}
	
	@Test
	void testResetActionsPerformed() {
		testEngineer.addActionPerformed();
		testEngineer.addActionPerformed();
		testEngineer.resetActionsPerformed();
		assertEquals(0, testEngineer.getActionsPerformed());
	}
	
	@Test
	void testActionsPerformedMax2() {
		testEngineer.addActionPerformed();
		testEngineer.addActionPerformed();
		testEngineer.addActionPerformed();
		testEngineer.addActionPerformed();
		testEngineer.addActionPerformed();
		assertEquals(2, testEngineer.getActionsPerformed());
	}
	
	@Test
	void testSleepUses2Actions() {
		testEngineer.addActionPerformed();
		testEngineer.addActionPerformed();
		testEngineer.sleep();
		assertEquals(2, testEngineer.getActionsPerformed());
	}
	
	@Test
	void testAutoSleepNotFullReset() {
		testEngineer.setTiredness(0);
		assertEquals(25, testEngineer.getTiredness());
	}
	
	@Test
	void testAutoSleepResetActions() {
		testEngineer.setTiredness(0);
		assertEquals(2, testEngineer.getActionsPerformed());
	}
	
	@Test
	void testUseItemTakesAction() {
		testEngineer.useItem(new MedKit());
		assertEquals(1, testEngineer.getActionsPerformed());
	}

}

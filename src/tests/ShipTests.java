package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import crew.*;
import gameenv.GameEnvironment;
import spaceship.*;

class ShipTests {
	private static Ship testShip;
	private static CrewMember pilot;
	private static CrewMember engineer;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		pilot = new Pilot("Pilot");
		engineer = new Engineer("Engineer");
	}
	
	@BeforeEach
	public void init() {
		testShip = new Ship("My Test Ship");
	}

	@Test
	void testTakeDamage() {
		testShip.takeDamage(50, new GameEnvironment());
		assertEquals(50, testShip.getHealth());
	}
	
	@Test
	void testRepairShipNormal() {
		testShip.takeDamage(50, new GameEnvironment());
		testShip.repairShip(pilot);
		assertEquals(60, testShip.getHealth());
	}
	
	@Test
	void testRepairShipEngineer() {
		testShip.takeDamage(50, new GameEnvironment());
		testShip.repairShip(engineer);
		assertEquals(65, testShip.getHealth());
	}

	@Test
	void testMaxTwoPilots() {
		testShip.addPilot(pilot);
		testShip.addPilot(engineer);
		testShip.addPilot(new Pilot("Pilot2"));
		assertEquals(2, testShip.getPilots().size());
	}
	
	@Test
	void testAsteroidFieldNormal() {
		testShip.addPilot(engineer);
		testShip.addPilot(new Engineer("Engineer2"));
		testShip.AsteroidField();
		assertEquals(45, testShip.getHealth());
	}
	
	@Test
	void testAsteroidFieldPilot() {
		testShip.addPilot(engineer);
		testShip.addPilot(pilot);
		testShip.AsteroidField();
		assertEquals(73, testShip.getHealth());
	}
	
	@Test
	void testAsteroidDestroyShip() {
		testShip.takeDamage(80, new GameEnvironment());
		testShip.addPilot(engineer);
		testShip.addPilot(new Engineer("Engineer2"));
		assertFalse(testShip.AsteroidField());
	}
}

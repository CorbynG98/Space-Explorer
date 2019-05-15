package items;

import java.util.*;
import java.lang.Math;

public class MedicalItem extends Item {
	// Variables
	private int healthValue;
	private boolean curesPlague = false;
	
	private MedicalItem[] medicalList = {new FirstAidKit(), new MedKit()};
	
	// Constructor/s
	public MedicalItem(String name, int healthValue, int cost) {
		super(name, cost);
		this.healthValue = healthValue;
	}
	
	public MedicalItem(String name, int healthValue, int cost, boolean cure) {
		super(name, cost);
		this.healthValue = healthValue;
		this.curesPlague = cure;
	}
	
	// Getters
	public boolean isPlagueCure() {
		return curesPlague;
	}
		
	public int getHealthValue() {
		return healthValue;
	}
	
	public MedicalItem selectRandomItem() {
		double medicalIndex = Math.random();
		
		if (medicalIndex >= 0.9) {
			return medicalList[1];
		}
		else {
			return medicalList[0];
		}
	}
}

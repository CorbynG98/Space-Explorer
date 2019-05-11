package InventoryItems;

public class MedicalItem extends Item {
	// Variables
	private int healthValue;
	private boolean curesPlague = false;
	
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
}

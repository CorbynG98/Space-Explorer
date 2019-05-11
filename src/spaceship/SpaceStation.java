package spaceship;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import crew.*;
import items.*;

public class SpaceStation extends JFrame implements ActionListener {
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private int playersFunds;
	
	public SpaceStation(int funds) {
		this.playersFunds = funds;
		
		// Intialize the shop frame
		JFrame shopFrame = new JFrame("Vendor");
		shopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shopFrame.setSize(750, 750);
		shopFrame.setVisible(true);
		
		// Create the panel for the items that will go on the screen
		JPanel panel = new JPanel();
		panel.setVisible(true);
		
		// Vendor label
		JLabel vendor = new JLabel("Welcome to the shop!");
		
		// Buy button
		// JButton button = new JButton("Purchase");
		// button.setSize(300, 300);
		// button.addActionListener(this);
		
		// Available funds label
		JLabel availMoney = new JLabel(Integer.toString(this.playersFunds));
		
		
		createItemButtons(new Fries(), 100, 100, panel);
		
		shopFrame.add(panel);
	}
	
	public void createItemButtons(Item item, int x, int y, JPanel panel) {
		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		itemPanel.setSize((panel.getWidth() / 3) - 10, (panel.getHeight() / 3) - 10);
		itemPanel.setBounds(x, y, (panel.getWidth() / 1) - 10, (panel.getHeight() / 1) - 10);
		itemPanel.setVisible(true);
		
		JButton button = new JButton("Buy");
		
		itemPanel.add(button);
		
		panel.add(itemPanel);		
	}
	
	public void updateTotal() {
		
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}
	
	public static void main(String[] args) {
		SpaceStation test = new SpaceStation(200);
	}
}

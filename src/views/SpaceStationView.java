package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;

import spaceship.Ship;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import items.*;
import crew.*;

/**
 * Represents the space station view. Used to create the frame and all components
 * of the space station so the user can interact with the view. Returns certain components so the 
 * events can be handled in the game env class.
 * @author ctg31
 *
 */
public class SpaceStationView {

	/**
	 * The main frame
	 */
	private JFrame frame;
	/**
	 * Name of the selected item
	 */
	private JLabel lblInfoName;
	/**
	 * Price of the selected item
	 */
	private JLabel lblInfoPrice;
	/**
	 * Error message if required (no money, no selected item, etc.)
	 */
	private JLabel lblErrorMessage;
	/**
	 * Display of players remaining money
	 */
	private JLabel lblMoney;
	/**
	 * Button to leave the shop
	 */
	JButton btnLeaveShop;
	/**
	 * List of items the shop displays
	 */
	private ArrayList<Item> itemList;
	/**
	 * The item the player has selected
	 */
	private Item selectedItem = null;
	/**
	 * If there is a merchant in the crew, to apply discounts
	 */
	private boolean merchantInCrew = false;
	/**
	 * Current ship instance
	 */
	private Ship ship;
	/**
	 * Integer value of the players funds, used for calculations
	 */
	private int playerFunds;
	/**
	 * Health/Hunger gain the item provides
	 */
	private JLabel lblHealthHungerGain;
	/**
	 * Energy gain the item provides if applicable
	 */
	private JLabel lblEnergyGain;
	/**
	 * Text of Health or Hunger depending if a medical item or food item is chosen respectively.
	 */
	private JLabel lblHealthHunger;
	
	/**
	 * Constructor when the class is created to create the GUI.
	 * @param ship Ship - The ship current in use in the game.
	 * @param itemList ArrayList<Item> - The items that the shop displays.
	 */
	public SpaceStationView(Ship ship, ArrayList<Item> itemList) {
		this.itemList = itemList;
		this.ship = ship;
		this.playerFunds = ship.getCrew().getMoney();
		
		for (CrewMember crewMember: ship.getCrew().getCrewList()) {
			if (crewMember instanceof Merchant) {
				merchantInCrew = true;
			}
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 726, 408);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the store!");
		lblWelcomeToThe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setBounds(12, 12, 702, 27);
		panel.add(lblWelcomeToThe);
		
		JButton btnItem1 = new JButton(this.itemList.get(0).getName());
		btnItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblErrorMessage.setText("");
				selectedItem = itemList.get(0);
				if(playerFunds < selectedItem.getCost()) {
					lblErrorMessage.setText("NOT ENOUGH FUNDS");
				}
				updateInformation();
			}
		});
		btnItem1.setBounds(12, 70, 149, 66);
		panel.add(btnItem1);
		
		JButton btnItem2 = new JButton(this.itemList.get(1).getName());
		btnItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblErrorMessage.setText("");
				selectedItem = itemList.get(1);
				if(playerFunds < selectedItem.getCost()) {
					lblErrorMessage.setText("NOT ENOUGH FUNDS");
				}
				updateInformation();
			}
		});
		btnItem2.setBounds(173, 70, 149, 66);
		panel.add(btnItem2);
		
		JButton btnItem3 = new JButton(this.itemList.get(2).getName());
		btnItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblErrorMessage.setText("");
				selectedItem = itemList.get(2);
				if(playerFunds < selectedItem.getCost()) {
					lblErrorMessage.setText("NOT ENOUGH FUNDS");
				}
				updateInformation();
			}
		});
		btnItem3.setBounds(12, 148, 149, 66);
		panel.add(btnItem3);
		
		JButton btnItem4 = new JButton(this.itemList.get(3).getName());
		btnItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblErrorMessage.setText("");
				selectedItem = itemList.get(3);
				if(playerFunds < selectedItem.getCost()) {
					lblErrorMessage.setText("NOT ENOUGH FUNDS");
				}
				updateInformation();
			}
		});
		btnItem4.setBounds(173, 148, 149, 66);
		panel.add(btnItem4);
		
		JButton btnItem5 = new JButton(this.itemList.get(4).getName());
		btnItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblErrorMessage.setText("");
				selectedItem = itemList.get(4);
				if(playerFunds < selectedItem.getCost()) {
					lblErrorMessage.setText("NOT ENOUGH FUNDS");
				}
				updateInformation();
			}
		});
		btnItem5.setBounds(12, 226, 149, 66);
		panel.add(btnItem5);
		
		JButton btnItem6 = new JButton(this.itemList.get(5).getName());
		btnItem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblErrorMessage.setText("");
				selectedItem = itemList.get(5);
				if(playerFunds < selectedItem.getCost()) {
					lblErrorMessage.setText("NOT ENOUGH FUNDS");
				}
				updateInformation();
			}
		});
		btnItem6.setBounds(173, 226, 149, 66);
		panel.add(btnItem6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(334, 72, 380, 220);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblItemInformation = new JLabel("Item Information");
		lblItemInformation.setFont(new Font("Dialog", Font.BOLD, 14));
		lblItemInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemInformation.setBounds(0, 0, 380, 34);
		panel_1.add(lblItemInformation);
		
		lblInfoName = new JLabel("");
		lblInfoName.setBounds(105, 46, 275, 28);
		panel_1.add(lblInfoName);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(10, 46, 83, 28);
		panel_1.add(lblName);
		
		lblInfoPrice = new JLabel("");
		lblInfoPrice.setBounds(105, 86, 275, 28);
		panel_1.add(lblInfoPrice);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrice.setBounds(10, 86, 83, 28);
		panel_1.add(lblPrice);
		
		lblHealthHunger = new JLabel("Health:");
		lblHealthHunger.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHealthHunger.setBounds(10, 126, 83, 28);
		panel_1.add(lblHealthHunger);
		
		JLabel lblEnergy = new JLabel("Energy: ");
		lblEnergy.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnergy.setBounds(10, 166, 83, 28);
		panel_1.add(lblEnergy);
		
		lblHealthHungerGain = new JLabel("");
		lblHealthHungerGain.setBounds(105, 126, 275, 28);
		panel_1.add(lblHealthHungerGain);
		
		lblEnergyGain = new JLabel("");
		lblEnergyGain.setBounds(105, 166, 275, 28);
		panel_1.add(lblEnergyGain);
		
		JButton btnBuy = new JButton("Purchase");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Code to attempt to purchase the item
				if (selectedItem == null) {
					lblErrorMessage.setText("Please select an item");
					return;
				}
				if(playerFunds < selectedItem.getCost()) {
					lblErrorMessage.setText("NOT ENOUGH FUNDS");
					return;
				}
				if (selectedItem instanceof FoodItem) {
					ship.getCrew().addFoodItem((FoodItem)selectedItem);
				}
				if (selectedItem instanceof MedicalItem) {
					lblErrorMessage.setText("Medical Item");
					ship.getCrew().addMedicalItem((MedicalItem)selectedItem);
				}
			
				ship.getCrew().removeMoney(merchantInCrew ? (int)(selectedItem.getCost() * 0.7) : (int)(selectedItem.getCost()));
				playerFunds = ship.getCrew().getMoney();
				
				lblMoney.setText(Integer.toString(playerFunds));
			}
		});
		btnBuy.setBounds(538, 337, 176, 59);
		panel.add(btnBuy);
		
		btnLeaveShop = new JButton("Leave Shop");
		btnLeaveShop.setBounds(12, 337, 176, 59);
		panel.add(btnLeaveShop);
		
		JLabel lblRemainingMoney = new JLabel("Remaining Money:");
		lblRemainingMoney.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRemainingMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRemainingMoney.setBounds(206, 337, 185, 27);
		panel.add(lblRemainingMoney);
		
		lblMoney = new JLabel(Integer.toString(this.playerFunds));
		lblMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoney.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMoney.setBounds(403, 337, 135, 27);
		panel.add(lblMoney);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Dialog", Font.BOLD, 14));
		lblErrorMessage.setBounds(206, 369, 314, 27);
		panel.add(lblErrorMessage);
		
		frame.setVisible(true);
	}
	
	/**
	 * Gets the button to leave the shop, so the event can be triggered in the game env class
	 * @return the button to leave the shop
	 */
	public JButton getLeaveButton() {
		return btnLeaveShop;
	}
	
	/**
	 * Gets the frame for the view so the view can be disposed when the next screens
	 * needs to be displayed.
	 * @return the main frame of the game
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Updates the GUI to display information about the selected item in the info box.
	 */
	public void updateInformation() {
		lblInfoName.setText(selectedItem.getName());
		
		if (selectedItem instanceof MedicalItem) {
			MedicalItem item = (MedicalItem)selectedItem;
			lblHealthHunger.setText("Health: ");
			lblHealthHungerGain.setText(Integer.toString(item.getHealthValue()));
			lblEnergyGain.setText("None");
		}
		else {
			FoodItem item = (FoodItem)selectedItem;
			lblHealthHunger.setText("Hunger: ");
			lblHealthHungerGain.setText(Integer.toString(item.getHungerValue()));
			lblEnergyGain.setText(item.getEnergyValue() != 0 ? Integer.toString(item.getEnergyValue()) : "None");
		}
		
		// Give 30 percent discount if there is a merchant in the crew
		if (merchantInCrew) {
			lblInfoPrice.setText(Double.toString(selectedItem.getCost() * 0.7));
		}
		else {
			lblInfoPrice.setText(Integer.toString(selectedItem.getCost()));
		}
	}
}

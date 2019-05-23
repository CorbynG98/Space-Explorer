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

public class SpaceStationView {

	private JFrame frame;
	private JLabel lblInfoName, lblInfoPrice, lblErrorMessage, lblMoney;
	JButton btnLeaveShop;
	private ArrayList<Item> itemList;
	private Item selectedItem = null;
	private boolean merchantInCrew = false;
	private Ship ship;
	private int playerFunds;
	private JLabel lblHealthGain, lblHungerGain, lblHealthHunger;
	
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
		
		
		/*
		 *  Create shop item buttons
		 */
		
		
		JButton btnItem1 = new JButton(this.itemList.get(0).getName());
		btnItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblErrorMessage.setText("");
				selectedItem = itemList.get(0);
				if(playerFunds < selectedItem.getCost()) {
					lblErrorMessage.setText("NOT ENOUGH FUNDS");
				}
				updateInformation(selectedItem);
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
				updateInformation(selectedItem);
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
				updateInformation(selectedItem);
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
				updateInformation(selectedItem);
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
				updateInformation(selectedItem);
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
				updateInformation(selectedItem);
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
		
		lblHealthGain = new JLabel("");
		lblHealthGain.setBounds(105, 126, 275, 28);
		panel_1.add(lblHealthGain);
		
		lblHungerGain = new JLabel("");
		lblHungerGain.setBounds(105, 166, 275, 28);
		panel_1.add(lblHungerGain);
		
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
	
	public JButton getLeaveButton() {
		return btnLeaveShop;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void updateInformation(Item SelectedItem) {
		lblInfoName.setText(selectedItem.getName());
		
		if (selectedItem instanceof MedicalItem) {
			MedicalItem item = (MedicalItem)selectedItem;
			lblHealthHunger.setText("Health: ");
			lblHealthGain.setText(Integer.toString(item.getHealthValue()));
			lblHungerGain.setText("None");
		}
		else {
			FoodItem item = (FoodItem)selectedItem;
			lblHealthHunger.setText("Hunger: ");
			lblHealthGain.setText(Integer.toString(item.getHungerValue()));
			lblHungerGain.setText(item.getEnergyValue() != 0 ? Integer.toString(item.getEnergyValue()) : "None");
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

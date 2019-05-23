package views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import crew.*;
import items.*;
import spaceship.*;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JPanel;

public class DayView {

	private JFrame frame;
	private Ship ship;
	private int currentDay;
	private JButton btnSpaceStation, btnNextDay;
	private CrewMember selectedPerson;
	private JLabel lblSelectedImage, lblSpecialty, lblCrewMemberName, lblDayCount, lblAliveCount;
	private JComboBox comboInventoryItems;
	private JButton btnViewShipStatus;
	private JButton btnSearchPlanet;
	private JButton btnPersonSleep;
	private JButton btnRepairShip;
	private JButton btnAddCrewAsPilot;
	private JButton btnFly;
	private JLabel lblHunger;
	private JLabel lblEnergy;
	private JLabel lblHealth;
	private JProgressBar personHealth1, personHealth2, personHealth3, personHealth4;
	private JProgressBar personEnergy1, personEnergy2, personEnergy3, personEnergy4;
	private JProgressBar personHunger1, personHunger2, personHunger3, personHunger4;
	private JLabel lblPersonImage1, lblPersonImage2, lblPersonImage3,lblPersonImage4;
	private JLabel lblPersonName1, lblPersonName2, lblPersonName3,lblPersonName4;
	private JLabel lblPersonType1, lblPersonType2, lblPersonType3,lblPersonType4;
	private JLabel lblActions;
	private JLabel lblAction1;
	private JLabel lblActions2;
	private JLabel lblActions3;
	private JLabel lblActions4;
	private JLabel lblPersonActions1;
	private JLabel lblPersonActions2;
	private JLabel lblPersonActions3;
	private JLabel lblPersonActions4;
	private JLabel lblPilots;
	private JLabel lblPartOnPlanetFound;
	private JLabel lblParts;
	private JLabel lblTotalPartsFound;
	private JLabel lblDiseased1, lblDiseased2, lblDiseased3, lblDiseased4;
	private JPanel panelPerson1, panelPerson2, panelPerson3, panelPerson4;
	/**
	 * Create the application.
	 */
	public DayView(Ship ship, int currentDay) {
		this.ship = ship;
		this.currentDay = currentDay;
		this.selectedPerson = ship.getCrew().getCrewList().get(0);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblCurrentDay = new JLabel("Current Day:");
		lblCurrentDay.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCurrentDay.setBounds(12, 12, 130, 15);
		frame.getContentPane().add(lblCurrentDay);
		
		lblDayCount = new JLabel(Integer.toString(currentDay));
		lblDayCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDayCount.setBounds(141, 13, 66, 15);
		frame.getContentPane().add(lblDayCount);
		
		JLabel lblCrewAlive = new JLabel("Crew Alive:");
		lblCrewAlive.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCrewAlive.setBounds(640, 12, 114, 15);
		frame.getContentPane().add(lblCrewAlive);
		
		lblAliveCount = new JLabel(Integer.toString(ship.getCrew().getCrewList().size()));
		lblAliveCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAliveCount.setBounds(755, 12, 33, 15);
		frame.getContentPane().add(lblAliveCount);
		
		lblCrewMemberName = new JLabel("Crew Member Name");
		lblCrewMemberName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewMemberName.setBounds(322, 13, 163, 15);
		frame.getContentPane().add(lblCrewMemberName);
		
		lblSpecialty = new JLabel("Specialty");
		lblSpecialty.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecialty.setBounds(322, 30, 163, 15);
		frame.getContentPane().add(lblSpecialty);
		
		lblSelectedImage = new JLabel("Person Image");
		lblSelectedImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedImage.setBounds(332, 45, 153, 131);
		frame.getContentPane().add(lblSelectedImage);
		
		btnSpaceStation = new JButton("Space Station");
		btnSpaceStation.setBounds(12, 39, 163, 25);
		frame.getContentPane().add(btnSpaceStation);
		
		btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.setBounds(625, 39, 163, 25);
		frame.getContentPane().add(btnSearchPlanet);
		
		btnNextDay = new JButton("Next Day");
		btnNextDay.setBounds(12, 76, 163, 25);
		frame.getContentPane().add(btnNextDay);
		
		btnFly = new JButton("Fly");
		btnFly.setBounds(625, 79, 163, 25);
		frame.getContentPane().add(btnFly);
		
		btnRepairShip = new JButton("Repair Ship");
		btnRepairShip.setBounds(12, 113, 163, 25);
		frame.getContentPane().add(btnRepairShip);
		
		comboInventoryItems = new JComboBox();
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel(ship.getCrew().fullInventory().toArray(new Item[ship.getCrew().fullInventory().size()]));
		comboInventoryItems.setModel(comboModel);
		comboInventoryItems.setBounds(625, 154, 163, 24);
		frame.getContentPane().add(comboInventoryItems);
		
		JButton btnConsumeItem = new JButton("Consume Item");
		btnConsumeItem.setBounds(625, 117, 163, 25);
		frame.getContentPane().add(btnConsumeItem);
		
		btnViewShipStatus = new JButton("Ship Status");
		btnViewShipStatus.setBounds(12, 150, 163, 25);
		frame.getContentPane().add(btnViewShipStatus);
		
		btnAddCrewAsPilot = new JButton("Enter Cockpit");
		btnAddCrewAsPilot.setBounds(12, 187, 163, 25);
		frame.getContentPane().add(btnAddCrewAsPilot);
		
		
		btnPersonSleep = new JButton("Sleep");
		btnPersonSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedPerson.sleep();
				updateGUI();
			}
		});
		btnPersonSleep.setBounds(625, 190, 163, 25);
		
		frame.getContentPane().add(btnPersonSleep);
		
		lblHunger = new JLabel("Hunger");
		lblHunger.setHorizontalAlignment(SwingConstants.CENTER);
		lblHunger.setBounds(361, 524, 66, 15);
		frame.getContentPane().add(lblHunger);
		
		lblEnergy = new JLabel("Energy");
		lblEnergy.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnergy.setBounds(361, 541, 66, 15);
		frame.getContentPane().add(lblEnergy);
		
		lblHealth = new JLabel("Health");
		lblHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth.setBounds(361, 507, 66, 15);
		frame.getContentPane().add(lblHealth);
		
		lblPilots = new JLabel("0/2");
		lblPilots.setHorizontalAlignment(SwingConstants.CENTER);
		lblPilots.setBounds(580, 80, 49, 24);
		frame.getContentPane().add(lblPilots);
		
		lblPartOnPlanetFound = new JLabel("0/1");
		lblPartOnPlanetFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartOnPlanetFound.setBounds(580, 38, 49, 24);
		frame.getContentPane().add(lblPartOnPlanetFound);
		
		lblParts = new JLabel("Parts:");
		lblParts.setHorizontalAlignment(SwingConstants.CENTER);
		lblParts.setBounds(545, 38, 49, 24);
		frame.getContentPane().add(lblParts);
		
		lblTotalPartsFound = new JLabel("Parts Found: ");
		lblTotalPartsFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPartsFound.setBounds(181, 188, 448, 15);
		frame.getContentPane().add(lblTotalPartsFound);
		
		if (ship.getCrew().getCrewList().size() >= 1) {
			panelPerson1 = new JPanel();
			panelPerson1.setBounds(12, 231, 183, 324);
			frame.getContentPane().add(panelPerson1);
			panelPerson1.setLayout(null);
			
			lblPersonImage1 = new JLabel("");
			lblPersonImage1.setBounds(12, 62, 159, 161);
			panelPerson1.add(lblPersonImage1);
			lblPersonImage1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonImage1.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource(ship.getCrew().getCrewList().get(0).getImagePath())).getImage().getScaledInstance(155, 135, Image.SCALE_DEFAULT)));
			
			JButton btnSelectPerson1 = new JButton("Select");
			btnSelectPerson1.setBounds(5, 17, 163, 25);
			panelPerson1.add(btnSelectPerson1);
			
			lblAction1 = new JLabel("Actions: ");
			lblAction1.setBounds(7, 2, 75, 15);
			panelPerson1.add(lblAction1);
			lblAction1.setHorizontalAlignment(SwingConstants.LEFT);
			
			lblPersonActions1 = new JLabel("2");
			lblPersonActions1.setBounds(85, 2, 76, 15);
			panelPerson1.add(lblPersonActions1);
			lblPersonActions1.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblPersonName1 = new JLabel(ship.getCrew().getCrewList().get(0).getName());
			lblPersonName1.setBounds(0, 239, 183, 15);
			panelPerson1.add(lblPersonName1);
			lblPersonName1.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblPersonType1 = new JLabel(ship.getCrew().getCrewList().get(0).getSpecialization());
			lblPersonType1.setBounds(0, 254, 183, 15);
			panelPerson1.add(lblPersonType1);
			lblPersonType1.setHorizontalAlignment(SwingConstants.CENTER);
			
			personHealth1 = new JProgressBar();
			personHealth1.setBounds(12, 273, 153, 14);
			panelPerson1.add(personHealth1);
			personHealth1.setValue((int)ship.getCrew().getCrewList().get(0).getHealth());
			personHealth1.setBackground(Color.RED);
			personHealth1.setForeground(Color.GREEN);
			
			personHunger1 = new JProgressBar();
			personHunger1.setBounds(12, 290, 153, 14);
			panelPerson1.add(personHunger1);
			personHunger1.setValue((int)ship.getCrew().getCrewList().get(0).getHunger());
			personHunger1.setBackground(Color.RED);
			personHunger1.setForeground(Color.GREEN);
			
			personEnergy1 = new JProgressBar();
			personEnergy1.setBounds(12, 307, 153, 14);
			panelPerson1.add(personEnergy1);
			personEnergy1.setValue((int)ship.getCrew().getCrewList().get(0).getTiredness());
			personEnergy1.setBackground(Color.RED);
			personEnergy1.setForeground(Color.GREEN);
			
			lblDiseased1 = new JLabel("you gay");
			lblDiseased1.setHorizontalAlignment(SwingConstants.CENTER);
			lblDiseased1.setBounds(12, 42, 159, 15);
			panelPerson1.add(lblDiseased1);
			btnSelectPerson1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedPerson = ship.getCrew().getCrewList().get(0);
					updateSelectedDetails();
				}
			});
		}
		
		if (ship.getCrew().getCrewList().size() >= 2) {
			panelPerson2 = new JPanel();
			panelPerson2.setBounds(187, 231, 183, 324);
			frame.getContentPane().add(panelPerson2);
			panelPerson2.setLayout(null);
			
			lblPersonImage2 = new JLabel("");
			lblPersonImage2.setBounds(12, 62, 159, 161);
			panelPerson2.add(lblPersonImage2);
			lblPersonImage2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonImage2.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource(ship.getCrew().getCrewList().get(1).getImagePath())).getImage().getScaledInstance(155, 135, Image.SCALE_DEFAULT)));
			
			JButton btnSelectPerson2 = new JButton("Select");
			btnSelectPerson2.setBounds(7, 17, 162, 25);
			panelPerson2.add(btnSelectPerson2);
			
			lblPersonActions2 = new JLabel("Actions: ");
			lblPersonActions2.setBounds(7, 2, 75, 15);
			panelPerson2.add(lblPersonActions2);
			lblPersonActions2.setHorizontalAlignment(SwingConstants.LEFT);
			
			lblPersonActions2 = new JLabel("2");
			lblPersonActions2.setBounds(85, 2, 76, 15);
			panelPerson2.add(lblPersonActions2);
			lblPersonActions2.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblPersonName2 = new JLabel(ship.getCrew().getCrewList().get(1).getName());
			lblPersonName2.setBounds(0, 239, 183, 15);
			panelPerson2.add(lblPersonName2);
			lblPersonName2.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblPersonType2 = new JLabel(ship.getCrew().getCrewList().get(1).getSpecialization());
			lblPersonType2.setBounds(0, 254, 183, 15);
			panelPerson2.add(lblPersonType2);
			lblPersonType2.setHorizontalAlignment(SwingConstants.CENTER);
			
			personHealth2 = new JProgressBar();
			personHealth2.setBounds(12, 273, 153, 14);
			panelPerson2.add(personHealth2);
			personHealth2.setValue((int)ship.getCrew().getCrewList().get(1).getHealth());
			personHealth2.setBackground(Color.RED);
			personHealth2.setForeground(Color.GREEN);
			
			personHunger2 = new JProgressBar();
			personHunger2.setBounds(12, 290, 153, 14);
			panelPerson2.add(personHunger2);
			personHunger2.setValue((int)ship.getCrew().getCrewList().get(1).getHunger());
			personHunger2.setBackground(Color.RED);
			personHunger2.setForeground(Color.GREEN);
			
			personEnergy2 = new JProgressBar();
			personEnergy2.setBounds(12, 307, 153, 14);
			panelPerson2.add(personEnergy2);
			personEnergy2.setValue((int)ship.getCrew().getCrewList().get(1).getTiredness());
			personEnergy2.setBackground(Color.RED);
			personEnergy2.setForeground(Color.GREEN);
			
			lblDiseased2 = new JLabel("you gay");
			lblDiseased2.setHorizontalAlignment(SwingConstants.CENTER);
			lblDiseased2.setBounds(12, 42, 159, 15);
			panelPerson2.add(lblDiseased2);
			btnSelectPerson2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedPerson = ship.getCrew().getCrewList().get(1);
					updateSelectedDetails();
				}
			});
		}
			
		if (ship.getCrew().getCrewList().size() >= 3) {
			panelPerson3 = new JPanel();
			panelPerson3.setBounds(450, 231, 183, 324);
			frame.getContentPane().add(panelPerson3);
			panelPerson3.setLayout(null);
			
			lblPersonImage3 = new JLabel("");
			lblPersonImage3.setBounds(12, 62, 159, 161);
			panelPerson3.add(lblPersonImage3);
			lblPersonImage3.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonImage3.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource(ship.getCrew().getCrewList().get(2).getImagePath())).getImage().getScaledInstance(155, 135, Image.SCALE_DEFAULT)));
			
			JButton btnSelectPerson3 = new JButton("Select");
			btnSelectPerson3.setBounds(5, 17, 163, 25);
			panelPerson3.add(btnSelectPerson3);
			
			lblPersonActions3 = new JLabel("Actions: ");
			lblPersonActions3.setBounds(7, 2, 75, 15);
			panelPerson3.add(lblPersonActions3);
			lblPersonActions3.setHorizontalAlignment(SwingConstants.LEFT);
			
			lblPersonActions3 = new JLabel("2");
			lblPersonActions3.setBounds(85, 2, 76, 15);
			panelPerson3.add(lblPersonActions3);
			lblPersonActions3.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblPersonName3 = new JLabel(ship.getCrew().getCrewList().get(2).getName());
			lblPersonName3.setBounds(0, 239, 183, 15);
			panelPerson3.add(lblPersonName3);
			lblPersonName3.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblPersonType3 = new JLabel(ship.getCrew().getCrewList().get(2).getSpecialization());
			lblPersonType3.setBounds(0, 254, 183, 15);
			panelPerson3.add(lblPersonType3);
			lblPersonType3.setHorizontalAlignment(SwingConstants.CENTER);
			
			personHealth3 = new JProgressBar();
			personHealth3.setBounds(12, 273, 153, 14);
			panelPerson3.add(personHealth3);
			personHealth3.setValue((int)ship.getCrew().getCrewList().get(2).getHealth());
			personHealth3.setBackground(Color.RED);
			personHealth3.setForeground(Color.GREEN);
			
			personHunger3 = new JProgressBar();
			personHunger3.setBounds(12, 290, 153, 14);
			panelPerson3.add(personHunger3);
			personHunger3.setValue((int)ship.getCrew().getCrewList().get(2).getHunger());
			personHunger3.setBackground(Color.RED);
			personHunger3.setForeground(Color.GREEN);
			
			personEnergy3 = new JProgressBar();
			personEnergy3.setBounds(12, 307, 153, 14);
			panelPerson3.add(personEnergy3);
			personEnergy3.setValue((int)ship.getCrew().getCrewList().get(2).getTiredness());
			personEnergy3.setBackground(Color.RED);
			personEnergy3.setForeground(Color.GREEN);
			
			lblDiseased3 = new JLabel("you gay");
			lblDiseased3.setHorizontalAlignment(SwingConstants.CENTER);
			lblDiseased3.setBounds(12, 42, 159, 15);
			panelPerson3.add(lblDiseased3);
			btnSelectPerson3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedPerson = ship.getCrew().getCrewList().get(2);
					updateSelectedDetails();
				}
			});
		}
		
		if (ship.getCrew().getCrewList().size() >= 4) {
			panelPerson4 = new JPanel();
			panelPerson4.setBounds(625, 231, 183, 324);
			frame.getContentPane().add(panelPerson4);
			panelPerson4.setLayout(null);
			
			lblPersonImage4 = new JLabel("");
			lblPersonImage4.setBounds(12, 62, 159, 161);
			panelPerson4.add(lblPersonImage4);
			lblPersonImage4.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonImage4.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource(ship.getCrew().getCrewList().get(3).getImagePath())).getImage().getScaledInstance(155, 135, Image.SCALE_DEFAULT)));
			
			JButton btnSelectPerson4 = new JButton("Select");
			btnSelectPerson4.setBounds(7, 17, 162, 25);
			panelPerson4.add(btnSelectPerson4);
			
			lblPersonActions4 = new JLabel("Actions: ");
			lblPersonActions4.setBounds(7, 2, 75, 15);
			panelPerson4.add(lblPersonActions4);
			lblPersonActions4.setHorizontalAlignment(SwingConstants.LEFT);
			
			lblPersonActions4 = new JLabel("2");
			lblPersonActions4.setBounds(85, 2, 76, 15);
			panelPerson4.add(lblPersonActions4);
			lblPersonActions4.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblPersonName4 = new JLabel(ship.getCrew().getCrewList().get(3).getName());
			lblPersonName4.setBounds(0, 239, 183, 15);
			panelPerson4.add(lblPersonName4);
			lblPersonName4.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblPersonType4 = new JLabel(ship.getCrew().getCrewList().get(3).getSpecialization());
			lblPersonType4.setBounds(0, 254, 183, 15);
			panelPerson4.add(lblPersonType4);
			lblPersonType4.setHorizontalAlignment(SwingConstants.CENTER);
			
			personHealth4 = new JProgressBar();
			personHealth4.setBounds(12, 273, 153, 14);
			panelPerson4.add(personHealth4);
			personHealth4.setValue((int)ship.getCrew().getCrewList().get(3).getHealth());
			personHealth4.setBackground(Color.RED);
			personHealth4.setForeground(Color.GREEN);
			
			personHunger4 = new JProgressBar();
			personHunger4.setBounds(12, 290, 153, 14);
			panelPerson4.add(personHunger4);
			personHunger4.setValue((int)ship.getCrew().getCrewList().get(3).getHunger());
			personHunger4.setBackground(Color.RED);
			personHunger4.setForeground(Color.GREEN);
			
			personEnergy4 = new JProgressBar();
			personEnergy4.setBounds(12, 307, 153, 14);
			panelPerson4.add(personEnergy4);
			personEnergy4.setValue((int)ship.getCrew().getCrewList().get(3).getTiredness());
			personEnergy4.setBackground(Color.RED);
			personEnergy4.setForeground(Color.GREEN);
			
			lblDiseased4 = new JLabel("you gay");
			lblDiseased4.setHorizontalAlignment(SwingConstants.CENTER);
			lblDiseased4.setBounds(12, 42, 159, 15);
			panelPerson4.add(lblDiseased4);
			btnSelectPerson4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedPerson = ship.getCrew().getCrewList().get(3);
					updateSelectedDetails();
				}
			});
		}
		btnConsumeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectedPerson == null) return;
				if (comboInventoryItems.getSelectedItem() == null) return;
				if (selectedPerson.getActionsPerformed() == 2) return;
				if (comboInventoryItems.getSelectedItem() instanceof FoodItem) {
					selectedPerson.useItem((FoodItem)comboInventoryItems.getSelectedItem());
					ship.getCrew().removeFoodItem((FoodItem)comboInventoryItems.getSelectedItem());
				}
				else {
					selectedPerson.useItem((MedicalItem)comboInventoryItems.getSelectedItem());
					ship.getCrew().removeMedicalItem((MedicalItem)comboInventoryItems.getSelectedItem());
				}
				DefaultComboBoxModel comboModel = new DefaultComboBoxModel(ship.getCrew().fullInventory().toArray(new Item[ship.getCrew().fullInventory().size()]));
				comboInventoryItems.setModel(comboModel);
				updateGUI();
			}
		});
	}
	
	// private JLabel lblSelectedImage, lblSpecialty, lblCrewMemberName;
	
	public void updateSelectedDetails() {
		lblSpecialty.setText(selectedPerson.getSpecialization());
		lblCrewMemberName.setText(selectedPerson.getName());
		lblSelectedImage.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource(selectedPerson.getImagePath())).getImage().getScaledInstance(155, 135, Image.SCALE_DEFAULT)));
		lblSelectedImage.setText("");
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public JButton getState() {
		return btnViewShipStatus;
	}
	
	public JButton getStationButton() {
		return btnSpaceStation;
	}
	
	public void setInventoryList() {
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel(ship.getCrew().fullInventory().toArray(new Item[ship.getCrew().fullInventory().size()]));
		comboInventoryItems.setModel(comboModel);
	}
	
	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}
	
	public JButton getNextDay() {
		return btnNextDay;
	}
	
	public JButton getSleep() {
		return btnPersonSleep;
	}
	
	public JButton getSearchButton() {
		return btnSearchPlanet;
	}
	
	public JButton getRepairButton() {
		return btnRepairShip;
	}
	
	public JButton getPilotButton() {
		return btnAddCrewAsPilot;
	}
	
	public JButton getFlyButton() {
		return btnFly;
	}

	public CrewMember getSelectedCrewMember() {
		return selectedPerson;
	}
	
	public void updateGUI() {
		if (ship.getCrew().getCrewList().size() >= 1) {
			personHealth1.setValue((int)(ship.getCrew().getCrewList().get(0).getHealth()));
			personHunger1.setValue((int)(ship.getCrew().getCrewList().get(0).getHunger()));
			personEnergy1.setValue((int)(ship.getCrew().getCrewList().get(0).getTiredness()));
			
			lblPersonImage1.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource(ship.getCrew().getCrewList().get(0).getImagePath())).getImage().getScaledInstance(155, 135, Image.SCALE_DEFAULT)));
			lblPersonName1.setText(ship.getCrew().getCrewList().get(0).getName());
			lblPersonType1.setText(ship.getCrew().getCrewList().get(0).getSpecialization());
			
			lblPersonActions1.setText(Integer.toString(2 - ship.getCrew().getCrewList().get(0).getActionsPerformed()));
		} else {
			panelPerson1.setVisible(false);
		}
		if (ship.getCrew().getCrewList().size() >= 2) {
			personHealth2.setValue((int)(ship.getCrew().getCrewList().get(1).getHealth()));
			personHunger2.setValue((int)(ship.getCrew().getCrewList().get(1).getHunger()));
			personEnergy2.setValue((int)(ship.getCrew().getCrewList().get(1).getTiredness()));
			
			lblPersonImage2.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource(ship.getCrew().getCrewList().get(1).getImagePath())).getImage().getScaledInstance(155, 135, Image.SCALE_DEFAULT)));
			lblPersonName2.setText(ship.getCrew().getCrewList().get(1).getName());
			lblPersonType2.setText(ship.getCrew().getCrewList().get(1).getSpecialization());
			
			lblPersonActions2.setText(Integer.toString(2 - ship.getCrew().getCrewList().get(1).getActionsPerformed()));
		} else {
			panelPerson2.setVisible(false);
		}
		if (ship.getCrew().getCrewList().size() >= 3) {
			personHealth3.setValue((int)(ship.getCrew().getCrewList().get(2).getHealth()));
			personHunger3.setValue((int)(ship.getCrew().getCrewList().get(2).getHunger()));
			personEnergy3.setValue((int)(ship.getCrew().getCrewList().get(2).getTiredness()));
			
			lblPersonImage3.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource(ship.getCrew().getCrewList().get(2).getImagePath())).getImage().getScaledInstance(155, 135, Image.SCALE_DEFAULT)));
			lblPersonName3.setText(ship.getCrew().getCrewList().get(2).getName());
			lblPersonType3.setText(ship.getCrew().getCrewList().get(2).getSpecialization());
			
			lblPersonActions3.setText(Integer.toString(2 - ship.getCrew().getCrewList().get(2).getActionsPerformed()));
		} else {
			panelPerson3.setVisible(false);
		}
		if (ship.getCrew().getCrewList().size() >= 4) {
			personHealth4.setValue((int)(ship.getCrew().getCrewList().get(3).getHealth()));
			personHunger4.setValue((int)(ship.getCrew().getCrewList().get(3).getHunger()));
			personEnergy4.setValue((int)(ship.getCrew().getCrewList().get(3).getTiredness()));
			
			lblPersonImage4.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource(ship.getCrew().getCrewList().get(3).getImagePath())).getImage().getScaledInstance(155, 135, Image.SCALE_DEFAULT)));
			lblPersonName4.setText(ship.getCrew().getCrewList().get(3).getName());
			lblPersonType4.setText(ship.getCrew().getCrewList().get(3).getSpecialization());
			
			lblPersonActions4.setText(Integer.toString(2 - ship.getCrew().getCrewList().get(3).getActionsPerformed()));
		} else {
			panelPerson4.setVisible(false);
		}
		lblAliveCount.setText(Integer.toString(ship.getCrew().getCrewList().size()));
		lblDayCount.setText(Integer.toString(currentDay));
		setInventoryList();
		lblPilots.setText(ship.getPilots().size() + "/2");
	}
	
	public void updatePartsFound(int partsFound) {
		lblPartOnPlanetFound.setText("1/1");
		lblTotalPartsFound.setText("Parts Found: " + Integer.toString(partsFound));
	}
	
	public void resetPlanetPartsFound() {
		lblPartOnPlanetFound.setText("0/1");
	}
}

package views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import crew.*;
import items.*;
import spaceship.*;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;

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
	private JLabel lblHunger;
	private JLabel lblEnergy;
	private JLabel lblHealth;
	private JProgressBar personHealth1, personHealth2, personHealth3, personHealth4;
	private JProgressBar personEnergy1, personEnergy2, personEnergy3, personEnergy4;
	private JProgressBar personHunger1, personHunger2, personHunger3, personHunger4;
	private JLabel lblActions;
	private JLabel lblAction1;
	private JLabel lblActions2;
	private JLabel lblActions3;
	private JLabel lblActions4;
	private JLabel lblPersonActions1;
	private JLabel lblPersonActions2;
	private JLabel lblPersonActions3;
	private JLabel lblPersonActions4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ship testShip = new Enterprise();
					testShip.getCrew().addCrewMember(new Medic("Claire"));
					testShip.getCrew().addCrewMember(new Engineer("John"));
					testShip.getCrew().addCrewMember(new Pilot("Gordon"));
					testShip.getCrew().addCrewMember(new Soldier("Alara"));
					DayView window = new DayView(testShip, 5);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DayView(Ship ship, int currentDay) {
		this.ship = ship;
		this.currentDay = currentDay;
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
		
		lblSelectedImage = new JLabel("Image of person");
		lblSelectedImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedImage.setBounds(332, 40, 153, 131);
		frame.getContentPane().add(lblSelectedImage);
		
		if (ship.getCrew().getCrewList().size() >= 1) {
			JLabel lblPersonImage1 = new JLabel("Image of person");
			lblPersonImage1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonImage1.setBounds(12, 278, 163, 179);
			frame.getContentPane().add(lblPersonImage1);
			
			JLabel lblPersonName1 = new JLabel(ship.getCrew().getCrewList().get(0).getName());
			lblPersonName1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonName1.setBounds(12, 469, 163, 15);
			frame.getContentPane().add(lblPersonName1);
			
			JLabel lblPersonType1 = new JLabel(ship.getCrew().getCrewList().get(0).getSpecialization());
			lblPersonType1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonType1.setBounds(12, 485, 163, 15);
			frame.getContentPane().add(lblPersonType1);
			
			personHealth1 = new JProgressBar();
			personHealth1.setValue((int)ship.getCrew().getCrewList().get(0).getHealth());
			personHealth1.setBounds(22, 507, 153, 14);
			personHealth1.setBackground(Color.RED);
			personHealth1.setForeground(Color.GREEN);
			frame.getContentPane().add(personHealth1);
			
			personHunger1 = new JProgressBar();
			personHunger1.setValue((int)ship.getCrew().getCrewList().get(0).getHunger());
			personHunger1.setBounds(22, 524, 153, 14);
			personHunger1.setBackground(Color.RED);
			personHunger1.setForeground(Color.GREEN);
			frame.getContentPane().add(personHunger1);
			
			personEnergy1 = new JProgressBar();
			personEnergy1.setValue((int)ship.getCrew().getCrewList().get(0).getTiredness());
			personEnergy1.setBounds(22, 541, 153, 14);
			personEnergy1.setBackground(Color.RED);
			personEnergy1.setForeground(Color.GREEN);
			frame.getContentPane().add(personEnergy1);
			
			lblAction1 = new JLabel("Actions: ");
			lblAction1.setHorizontalAlignment(SwingConstants.LEFT);
			lblAction1.setBounds(12, 234, 75, 15);
			frame.getContentPane().add(lblAction1);
			
			lblPersonActions1 = new JLabel("2");
			lblPersonActions1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonActions1.setBounds(99, 234, 76, 15);
			frame.getContentPane().add(lblPersonActions1);
			
			JButton btnSelectPerson1 = new JButton("Select");
			btnSelectPerson1.setBounds(12, 250, 163, 25);
			frame.getContentPane().add(btnSelectPerson1);
			btnSelectPerson1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedPerson = ship.getCrew().getCrewList().get(0);
					updateSelectedDetails();
				}
			});
		}
		
		if (ship.getCrew().getCrewList().size() >= 2) {
			JButton btnSelectPerson2 = new JButton("Select");
			btnSelectPerson2.setBounds(187, 250, 163, 25);
			frame.getContentPane().add(btnSelectPerson2);
			btnSelectPerson2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedPerson = ship.getCrew().getCrewList().get(1);
					updateSelectedDetails();
				}
			});
			
			JLabel lblPersonImage2 = new JLabel("Image of person");
			lblPersonImage2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonImage2.setBounds(187, 278, 163, 179);
			frame.getContentPane().add(lblPersonImage2);
			
			JLabel lblPersonName2 = new JLabel(ship.getCrew().getCrewList().get(1).getName());
			lblPersonName2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonName2.setBounds(187, 469, 163, 15);
			frame.getContentPane().add(lblPersonName2);
			
			JLabel lblPersonType2 = new JLabel(ship.getCrew().getCrewList().get(1).getSpecialization());
			lblPersonType2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonType2.setBounds(187, 485, 163, 15);
			frame.getContentPane().add(lblPersonType2);
			
			personHealth2 = new JProgressBar();
			personHealth2.setValue((int)ship.getCrew().getCrewList().get(1).getHealth());
			personHealth2.setBounds(187, 507, 153, 14);
			personHealth2.setBackground(Color.RED);
			personHealth2.setForeground(Color.GREEN);
			frame.getContentPane().add(personHealth2);
			
			personHunger2 = new JProgressBar();
			personHunger2.setValue((int)ship.getCrew().getCrewList().get(1).getHunger());
			personHunger2.setBounds(187, 524, 153, 14);
			personHunger2.setBackground(Color.RED);
			personHunger2.setForeground(Color.GREEN);
			frame.getContentPane().add(personHunger2);
			
			personEnergy2 = new JProgressBar();
			personEnergy2.setValue((int)ship.getCrew().getCrewList().get(1).getTiredness());
			personEnergy2.setBounds(187, 541, 153, 14);
			personEnergy2.setBackground(Color.RED);
			personEnergy2.setForeground(Color.GREEN);
			frame.getContentPane().add(personEnergy2);
			
			lblActions2 = new JLabel("Actions: ");
			lblActions2.setHorizontalAlignment(SwingConstants.LEFT);
			lblActions2.setBounds(187, 234, 75, 15);
			frame.getContentPane().add(lblActions2);
			
			lblPersonActions2 = new JLabel(Integer.toString(2 - ship.getCrew().getCrewList().get(1).getActionsPerformed()));
			lblPersonActions2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonActions2.setBounds(274, 234, 76, 15);
			frame.getContentPane().add(lblPersonActions2);
		}
		
		if (ship.getCrew().getCrewList().size() >= 4) {
			JButton btnSelectPerson4 = new JButton("Select");
			btnSelectPerson4.setBounds(625, 250, 163, 25);
			frame.getContentPane().add(btnSelectPerson4);
			btnSelectPerson4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedPerson = ship.getCrew().getCrewList().get(3);
					updateSelectedDetails();
				}
			});
			
			JLabel lblPersonImage4 = new JLabel("Image of person");
			lblPersonImage4.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonImage4.setBounds(625, 278, 163, 179);
			frame.getContentPane().add(lblPersonImage4);
			
			JLabel lblPersonName4 = new JLabel(ship.getCrew().getCrewList().get(3).getName());
			lblPersonName4.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonName4.setBounds(625, 469, 163, 15);
			frame.getContentPane().add(lblPersonName4);
			
			JLabel lblPersonType4 = new JLabel(ship.getCrew().getCrewList().get(3).getSpecialization());
			lblPersonType4.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonType4.setBounds(625, 485, 163, 15);
			frame.getContentPane().add(lblPersonType4);
			
			personEnergy4 = new JProgressBar();
			personEnergy4.setValue((int)ship.getCrew().getCrewList().get(3).getTiredness());
			personEnergy4.setBounds(625, 541, 153, 14);
			frame.getContentPane().add(personEnergy2);
			
			personHealth4 = new JProgressBar();
			personHealth4.setValue((int)ship.getCrew().getCrewList().get(3).getHealth());
			personHealth4.setBounds(635, 507, 153, 14);
			personHealth4.setBackground(Color.RED);
			personHealth4.setForeground(Color.GREEN);
			frame.getContentPane().add(personHealth4);
			
			personHunger4 = new JProgressBar();
			personHunger4.setValue((int)ship.getCrew().getCrewList().get(3).getHunger());
			personHunger4.setBounds(635, 524, 153, 14);
			personHunger4.setBackground(Color.RED);
			personHunger4.setForeground(Color.GREEN);
			frame.getContentPane().add(personHunger4);
			
			personEnergy4 = new JProgressBar();
			personEnergy4.setValue((int)ship.getCrew().getCrewList().get(3).getTiredness());
			personEnergy4.setBounds(635, 541, 153, 14);
			personEnergy4.setBackground(Color.RED);
			personEnergy4.setForeground(Color.GREEN);
			frame.getContentPane().add(personEnergy4);
			
			lblActions3 = new JLabel("Actions: ");
			lblActions3.setHorizontalAlignment(SwingConstants.LEFT);
			lblActions3.setBounds(450, 234, 75, 15);
			frame.getContentPane().add(lblActions3);
			
			lblPersonActions4 = new JLabel(Integer.toString(2 - ship.getCrew().getCrewList().get(3).getActionsPerformed()));
			lblPersonActions4.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonActions4.setBounds(712, 234, 76, 15);
			frame.getContentPane().add(lblPersonActions4);
			
			lblActions4 = new JLabel("Actions: ");
			lblActions4.setHorizontalAlignment(SwingConstants.LEFT);
			lblActions4.setBounds(625, 234, 75, 15);
			frame.getContentPane().add(lblActions4);
		}
		
		if (ship.getCrew().getCrewList().size() >= 3) {
			JButton btnSelectPerson3 = new JButton("Select");
			btnSelectPerson3.setBounds(450, 250, 163, 25);
			frame.getContentPane().add(btnSelectPerson3);
			btnSelectPerson3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedPerson = ship.getCrew().getCrewList().get(2);
					updateSelectedDetails();
				}
			});
			
			JLabel lblPersonImage3 = new JLabel("Image of person");
			lblPersonImage3.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonImage3.setBounds(450, 278, 163, 179);
			frame.getContentPane().add(lblPersonImage3);
			
			JLabel lblPersonName3 = new JLabel(ship.getCrew().getCrewList().get(2).getName());
			lblPersonName3.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonName3.setBounds(450, 469, 163, 15);
			frame.getContentPane().add(lblPersonName3);
			
			JLabel lblPersonType3 = new JLabel(ship.getCrew().getCrewList().get(2).getSpecialization());
			lblPersonType3.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonType3.setBounds(450, 485, 163, 15);
			frame.getContentPane().add(lblPersonType3);
			
			personHealth3 = new JProgressBar();
			personHealth3.setBounds(460, 507, 153, 14);
			personHealth3.setValue((int)ship.getCrew().getCrewList().get(2).getHealth());
			personHealth3.setBackground(Color.RED);
			personHealth3.setForeground(Color.GREEN);
			frame.getContentPane().add(personHealth3);
			
			personHunger3 = new JProgressBar();
			personHunger3.setBounds(460, 524, 153, 14);
			personHunger3.setValue((int)ship.getCrew().getCrewList().get(2).getHunger());
			personHunger3.setBackground(Color.RED);
			personHunger3.setForeground(Color.GREEN);
			frame.getContentPane().add(personHunger3);
			
			personEnergy3 = new JProgressBar();
			personEnergy3.setBounds(460, 541, 153, 14);
			personEnergy3.setValue((int)ship.getCrew().getCrewList().get(2).getTiredness());
			personEnergy3.setBackground(Color.RED);
			personEnergy3.setForeground(Color.GREEN);
			frame.getContentPane().add(personEnergy3);
			
			lblActions = new JLabel("Actions: ");
			lblActions.setHorizontalAlignment(SwingConstants.LEFT);
			lblActions.setBounds(450, 234, 75, 15);
			frame.getContentPane().add(lblActions);
			
			lblPersonActions3 = new JLabel(Integer.toString(2 - ship.getCrew().getCrewList().get(2).getActionsPerformed()));
			lblPersonActions3.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonActions3.setBounds(537, 234, 76, 15);
			frame.getContentPane().add(lblPersonActions3);
		}
		
		btnSpaceStation = new JButton("Space Station");
		btnSpaceStation.setBounds(12, 39, 163, 25);
		frame.getContentPane().add(btnSpaceStation);
		
		btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.setBounds(625, 39, 163, 25);
		frame.getContentPane().add(btnSearchPlanet);
		
		btnNextDay = new JButton("Next Day");
		btnNextDay.setBounds(12, 76, 163, 25);
		frame.getContentPane().add(btnNextDay);
		
		JButton btnFly = new JButton("Fly");
		btnFly.setBounds(625, 79, 163, 25);
		frame.getContentPane().add(btnFly);
		
		JButton btnRepairShip = new JButton("Repair Ship");
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
	
	public CrewMember getSelectedCrewMember() {
		return selectedPerson;
	}
	
//	private JLabel lblPersonHealth1,lblPersonHealth2,lblPersonHealth3,lblPersonHealth4;
//	private JLabel lblPersonHunger1,lblPersonHunger2,lblPersonHunger3,lblPersonHunger4;
//	private JLabel lblPersonEnergy1,lblPersonEnergy2,lblPersonEnergy3,lblPersonEnergy4;
//	private JLabel lblPersonActions1,lblPersonActions2,lblPersonActions3,lblPersonActions4;
	
	public void updateGUI() {
		if (ship.getCrew().getCrewList().size() >= 1) {
			personHealth1.setValue((int)(ship.getCrew().getCrewList().get(0).getHealth()));
			personHunger1.setValue((int)(ship.getCrew().getCrewList().get(0).getHunger()));
			personEnergy1.setValue((int)(ship.getCrew().getCrewList().get(0).getTiredness()));
			lblPersonActions1.setText(Integer.toString(2 - ship.getCrew().getCrewList().get(0).getActionsPerformed()));
		}
		if (ship.getCrew().getCrewList().size() >= 2) {
			personHealth2.setValue((int)(ship.getCrew().getCrewList().get(1).getHealth()));
			personHunger2.setValue((int)(ship.getCrew().getCrewList().get(1).getHunger()));
			personEnergy2.setValue((int)(ship.getCrew().getCrewList().get(1).getTiredness()));
			lblPersonActions2.setText(Integer.toString(2 - ship.getCrew().getCrewList().get(1).getActionsPerformed()));
		}
		if (ship.getCrew().getCrewList().size() >= 3) {
			personHealth3.setValue((int)(ship.getCrew().getCrewList().get(2).getHealth()));
			personHunger3.setValue((int)(ship.getCrew().getCrewList().get(2).getHunger()));
			personEnergy3.setValue((int)(ship.getCrew().getCrewList().get(2).getTiredness()));
			lblPersonActions3.setText(Integer.toString(2 - ship.getCrew().getCrewList().get(2).getActionsPerformed()));
		}
		if (ship.getCrew().getCrewList().size() >= 4) {
			personHealth4.setValue((int)(ship.getCrew().getCrewList().get(3).getHealth()));
			personHunger4.setValue((int)(ship.getCrew().getCrewList().get(3).getHunger()));
			personEnergy4.setValue((int)(ship.getCrew().getCrewList().get(3).getTiredness()));
			lblPersonActions4.setText(Integer.toString(2 - ship.getCrew().getCrewList().get(3).getActionsPerformed()));
		}
		lblAliveCount.setText(Integer.toString(ship.getCrew().getCrewList().size()));
		lblDayCount.setText(Integer.toString(currentDay));
	}
}

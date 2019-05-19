package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import crew.*;
import spaceship.*;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DayView {

	private JFrame frame;
	private Ship ship;
	private int currentDay;
	private JButton btnSpaceStation;
	private CrewMember selectedPerson;
	private JLabel lblSelectedImage, lblSpecialty, lblCrewMemberName;
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
		
		JLabel lblDayCount = new JLabel(Integer.toString(currentDay));
		lblDayCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDayCount.setBounds(141, 13, 66, 15);
		frame.getContentPane().add(lblDayCount);
		
		JLabel lblCrewAlive = new JLabel("Crew Alive:");
		lblCrewAlive.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCrewAlive.setBounds(640, 12, 114, 15);
		frame.getContentPane().add(lblCrewAlive);
		
		JLabel lblAliveCount = new JLabel(Integer.toString(ship.getCrew().getCrewList().size()));
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
		lblSelectedImage.setBounds(332, 40, 153, 102);
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
			
			JLabel lblPersonHealth1 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(0).getHealth()));
			lblPersonHealth1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonHealth1.setBounds(12, 506, 163, 15);
			frame.getContentPane().add(lblPersonHealth1);
			
			JLabel lblPersonEnergy1 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(0).getTiredness()));
			lblPersonEnergy1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonEnergy1.setBounds(12, 521, 163, 15);
			frame.getContentPane().add(lblPersonEnergy1);
			
			JLabel lblPersonHunger1 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(0).getHunger()));
			lblPersonHunger1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonHunger1.setBounds(12, 535, 163, 15);
			frame.getContentPane().add(lblPersonHunger1);
			
			JButton btnSelectPerson1 = new JButton("Select");
			btnSelectPerson1.setBounds(12, 250, 163, 25);
			frame.getContentPane().add(btnSelectPerson1);
			btnSelectPerson1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedPerson = ship.getCrew().getCrewList().get(0);
					updateSelectedDetails();
				}
			});
			
			JLabel lblPersonActions1 = new JLabel(Integer.toString(2 - ship.getCrew().getCrewList().get(0).getActionsPerformed()));
			lblPersonActions1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonActions1.setBounds(12, 550, 163, 15);
			frame.getContentPane().add(lblPersonActions1);
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
			
			JLabel lblPersonHealth2 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(1).getHealth()));
			lblPersonHealth2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonHealth2.setBounds(187, 506, 163, 15);
			frame.getContentPane().add(lblPersonHealth2);
			
			JLabel lblPersonHunger2 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(1).getHunger()));
			lblPersonHunger2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonHunger2.setBounds(187, 535, 163, 15);
			frame.getContentPane().add(lblPersonHunger2);
			
			JLabel lblPersonEnergy2 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(1).getTiredness()));
			lblPersonEnergy2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonEnergy2.setBounds(187, 521, 163, 15);
			frame.getContentPane().add(lblPersonEnergy2);
			
			JLabel lblPersonActions2 = new JLabel(Integer.toString(2 - ship.getCrew().getCrewList().get(1).getActionsPerformed()));
			lblPersonActions2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonActions2.setBounds(187, 550, 163, 15);
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
			
			JLabel lblPersonHealth4 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(3).getHealth()));
			lblPersonHealth4.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonHealth4.setBounds(625, 506, 163, 15);
			frame.getContentPane().add(lblPersonHealth4);
			
			JLabel lblPersonHunger4 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(3).getHunger()));
			lblPersonHunger4.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonHunger4.setBounds(625, 535, 163, 15);
			frame.getContentPane().add(lblPersonHunger4);
			
			JLabel lblPersonEnergy4 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(3).getTiredness()));
			lblPersonEnergy4.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonEnergy4.setBounds(625, 521, 163, 15);
			frame.getContentPane().add(lblPersonEnergy4);
			
			JLabel lblPersonActions4 = new JLabel(Integer.toString(2 - ship.getCrew().getCrewList().get(3).getActionsPerformed()));
			lblPersonActions4.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonActions4.setBounds(625, 550, 163, 15);
			frame.getContentPane().add(lblPersonActions4);
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
			
			JLabel lblPersonHealth3 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(2).getHealth()));
			lblPersonHealth3.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonHealth3.setBounds(450, 506, 163, 15);
			frame.getContentPane().add(lblPersonHealth3);
			
			JLabel lblPersonHunger3 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(2).getHunger()));
			lblPersonHunger3.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonHunger3.setBounds(450, 535, 163, 15);
			frame.getContentPane().add(lblPersonHunger3);
			
			JLabel lblPersonEnergy3 = new JLabel(Double.toString(ship.getCrew().getCrewList().get(2).getTiredness()));
			lblPersonEnergy3.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonEnergy3.setBounds(450, 521, 163, 15);
			frame.getContentPane().add(lblPersonEnergy3);
			
			JLabel lblPersonActions3 = new JLabel(Integer.toString(2 - ship.getCrew().getCrewList().get(2).getActionsPerformed()));
			lblPersonActions3.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonActions3.setBounds(450, 550, 163, 15);
			frame.getContentPane().add(lblPersonActions3);
		}
		
		btnSpaceStation = new JButton("Space Station");
		btnSpaceStation.setBounds(12, 39, 163, 25);
		frame.getContentPane().add(btnSpaceStation);
		
		JButton btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.setBounds(625, 39, 163, 25);
		frame.getContentPane().add(btnSearchPlanet);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.setBounds(12, 76, 163, 25);
		frame.getContentPane().add(btnNextDay);
		
		JButton btnFly = new JButton("Fly");
		btnFly.setBounds(625, 79, 163, 25);
		frame.getContentPane().add(btnFly);
		
		JButton btnRepairShip = new JButton("Repair Ship");
		btnRepairShip.setBounds(12, 113, 163, 25);
		frame.getContentPane().add(btnRepairShip);
		
		JButton btnConsumeItem = new JButton("Consume Item");
		btnConsumeItem.setBounds(625, 117, 163, 25);
		frame.getContentPane().add(btnConsumeItem);
	}
	
	// private JLabel lblSelectedImage, lblSpecialty, lblCrewMemberName;
	
	public void updateSelectedDetails() {
		lblSpecialty.setText(selectedPerson.getSpecialization());
		lblCrewMemberName.setText(selectedPerson.getName());
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public JButton getStationButton() {
		return btnSpaceStation;
	}
}

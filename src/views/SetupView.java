package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import crew.*;
import spaceship.*;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextPane;

public class SetupView {

	private JFrame frame;
	private JTextField SoldierName, EngineerName, MedicName,  MerchantName, PilotName, ScientistName;
	private JButton btnEnterTheVerse;
	private JTextPane lblError;
	private Ship currentShip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupView window = new SetupView(new Enterprise());
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
	public SetupView(Ship currentShip) {
		this.currentShip = currentShip;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		DefaultListModel CrewListModel = new DefaultListModel();
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(12, 12, 745, 750);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		lblError = new JTextPane();
		lblError.setForeground(Color.RED);
		lblError.setBackground(new Color(255, 255, 255, 0));
		lblError.setBounds(496, 127, 220, 87);
		mainPanel.add(lblError);
		
		JPanel panelCrew = new JPanel();
		panelCrew.setBounds(12, 23, 230, 191);
		mainPanel.add(panelCrew);
		panelCrew.setLayout(null);
		
		JList crewList = new JList(CrewListModel);
		crewList.setBounds(2, 12, 218, 167);
		panelCrew.add(crewList);
		
		JPanel panelStats = new JPanel();
		panelStats.setBounds(254, 23, 230, 191);
		mainPanel.add(panelStats);
		panelStats.setLayout(null);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setBounds(12, 12, 104, 15);
		panelStats.add(lblHealth);
		
		JLabel lblPersonHealth = new JLabel("");
		lblPersonHealth.setBounds(114, 12, 104, 15);
		panelStats.add(lblPersonHealth);
		
		JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setBounds(12, 39, 104, 15);
		panelStats.add(lblStrength);
		
		JLabel lblPersonStrength = new JLabel("");
		lblPersonStrength.setBounds(114, 39, 104, 15);
		panelStats.add(lblPersonStrength);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setBounds(12, 66, 104, 15);
		panelStats.add(lblClass);
		
		JLabel lblPersonClass = new JLabel("");
		lblPersonClass.setBounds(114, 66, 104, 15);
		panelStats.add(lblPersonClass);
		
		JTextPane txtpnPersonInfo = new JTextPane();
		txtpnPersonInfo.setText("Information about the person's speciality");
		txtpnPersonInfo.setEditable(false);
		txtpnPersonInfo.setBounds(12, 93, 195, 86);
		panelStats.add(txtpnPersonInfo);
		
		JLabel label = new JLabel("Create your crew");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 743, 23);
		mainPanel.add(label);
		
		JPanel SoldierPanel = new JPanel();
		SoldierPanel.setBounds(12, 226, 230, 251);
		mainPanel.add(SoldierPanel);
		SoldierPanel.setLayout(null);
		
		SoldierName = new JTextField();
		SoldierName.setText("Name");
		SoldierName.setBounds(0, 10, 220, 26);
		SoldierPanel.add(SoldierName);
		SoldierName.setColumns(10);
		
		JButton btnAddSoldierToCrew = new JButton("Add To Crew");
		btnAddSoldierToCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (limitReached()) {
					lblError.setText("You have reached the crew limit!");
					return;
				}
				if (SoldierName.getText() == "") {
					lblError.setText("Please enter a name!");
					return;
				}
				Soldier newCrewMember = new Soldier(SoldierName.getText());
				currentShip.getCrew().addCrewMember(newCrewMember);
				CrewListModel.add(currentShip.getCrew().getCrewList().size() - 1, newCrewMember.getName() + " | " + newCrewMember.getSpecialization());
			}
		});
		btnAddSoldierToCrew.setBounds(0, 220, 220, 25);
		SoldierPanel.add(btnAddSoldierToCrew);
		
		JButton btnSoldierStats = new JButton("Soldier Stats");
		btnSoldierStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Soldier crewMember = new Soldier(SoldierName.getText());
				lblPersonHealth.setText(Double.toString(crewMember.getHealth()));
				lblPersonStrength.setText(Double.toString(crewMember.getDamage()));
				lblPersonClass.setText(crewMember.getSpecialization());
				txtpnPersonInfo.setText(crewMember.getClassString());
			}
		});
		btnSoldierStats.setBounds(0, 189, 220, 25);
		SoldierPanel.add(btnSoldierStats);
		
		JLabel lblSoldierImage = new JLabel("");
		lblSoldierImage.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource("/images/soldier.jpg")).getImage().getScaledInstance(230, 251, Image.SCALE_DEFAULT)));
		lblSoldierImage.setBounds(-10, 0, 240, 265);
		SoldierPanel.add(lblSoldierImage);
		
		JPanel EngineerPanel = new JPanel();
		EngineerPanel.setLayout(null);
		EngineerPanel.setBounds(254, 226, 230, 251);
		mainPanel.add(EngineerPanel);
		
		EngineerName = new JTextField();
		EngineerName.setText("Name");
		EngineerName.setColumns(10);
		EngineerName.setBounds(0, 10, 220, 26);
		EngineerPanel.add(EngineerName);
		
		JButton btnAddEngineerToCrew = new JButton("Add To Crew");
		btnAddEngineerToCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (limitReached()) {
					lblError.setText("You have reached the crew limit!");
					return;
				}
				if (EngineerName.getText() == "") {
					lblError.setText("Please enter a name!");
					return;
				}
				Engineer newCrewMember = new Engineer(EngineerName.getText());
				currentShip.getCrew().addCrewMember(newCrewMember);
				CrewListModel.add(currentShip.getCrew().getCrewList().size() - 1, newCrewMember.getName() + " | " + newCrewMember.getSpecialization());
			}
		});
		btnAddEngineerToCrew.setBounds(0, 220, 220, 25);
		EngineerPanel.add(btnAddEngineerToCrew);
		
		JButton btnEngineerStats = new JButton("Engineer Stats");
		btnEngineerStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Engineer crewMember = new Engineer(EngineerName.getText());
				lblPersonHealth.setText(Double.toString(crewMember.getHealth()));
				lblPersonStrength.setText(Double.toString(crewMember.getDamage()));
				lblPersonClass.setText(crewMember.getSpecialization());
				txtpnPersonInfo.setText(crewMember.getClassString());
			}
		});
		btnEngineerStats.setBounds(0, 189, 220, 25);
		EngineerPanel.add(btnEngineerStats);
		
		JLabel lblEngineerImage = new JLabel("");
		lblEngineerImage.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource("/images/engineer.jpg")).getImage().getScaledInstance(230, 251, Image.SCALE_DEFAULT)));
		lblEngineerImage.setBounds(-10, 0, 240, 265);
		EngineerPanel.add(lblEngineerImage);
		
		JPanel MedicPanel = new JPanel();
		MedicPanel.setLayout(null);
		MedicPanel.setBounds(496, 226, 230, 251);
		mainPanel.add(MedicPanel);
		
		MedicName = new JTextField();
		MedicName.setText("Name");
		MedicName.setColumns(10);
		MedicName.setBounds(0, 10, 220, 26);
		MedicPanel.add(MedicName);
		
		JButton btnAddMedicToCrew = new JButton("Add To Crew");
		btnAddMedicToCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (limitReached()) {
					lblError.setText("You have reached the crew limit!");
					return;
				}
				if (MedicName.getText() == "") {
					lblError.setText("Please enter a name!");
					return;
				}
				Medic newCrewMember = new Medic(MedicName.getText());
				currentShip.getCrew().addCrewMember(newCrewMember);
				CrewListModel.add(currentShip.getCrew().getCrewList().size() - 1, newCrewMember.getName() + " | " + newCrewMember.getSpecialization());
			}
		});
		btnAddMedicToCrew.setBounds(0, 220, 220, 25);
		MedicPanel.add(btnAddMedicToCrew);
		
		JButton btnMedicStats = new JButton("Medic Stats");
		btnMedicStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Medic crewMember = new Medic(MedicName.getText());
				lblPersonHealth.setText(Double.toString(crewMember.getHealth()));
				lblPersonStrength.setText(Double.toString(crewMember.getDamage()));
				lblPersonClass.setText(crewMember.getSpecialization());
				txtpnPersonInfo.setText(crewMember.getClassString());
			}
		});
		btnMedicStats.setBounds(0, 189, 220, 25);
		MedicPanel.add(btnMedicStats);
		
		JLabel lblMedicImage = new JLabel("");
		lblMedicImage.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource("/images/medic.jpg")).getImage().getScaledInstance(230, 251, Image.SCALE_DEFAULT)));
		lblMedicImage.setBounds(-10, 0, 240, 265);
		MedicPanel.add(lblMedicImage);
		
		JPanel MerchantPanel = new JPanel();
		MerchantPanel.setLayout(null);
		MerchantPanel.setBounds(254, 488, 230, 251);
		mainPanel.add(MerchantPanel);
		
		MerchantName = new JTextField();
		MerchantName.setText("Name");
		MerchantName.setColumns(10);
		MerchantName.setBounds(0, 10, 220, 26);
		MerchantPanel.add(MerchantName);
		
		JButton btnAddMerchantToCrew = new JButton("Add To Crew");
		btnAddMerchantToCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (limitReached()) {
					lblError.setText("You have reached the crew limit!");
					return;
				}
				if (MerchantName.getText() == "") {
					lblError.setText("Please enter a name!");
					return;
				}
				Merchant newCrewMember = new Merchant(MerchantName.getText());
				currentShip.getCrew().addCrewMember(newCrewMember);
				CrewListModel.add(currentShip.getCrew().getCrewList().size() - 1, newCrewMember.getName() + " | " + newCrewMember.getSpecialization());
			}
		});
		btnAddMerchantToCrew.setBounds(0, 220, 220, 25);
		MerchantPanel.add(btnAddMerchantToCrew);
		
		JButton btnMerchantStats = new JButton("Merchant Stats");
		btnMerchantStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Merchant crewMember = new Merchant(MerchantName.getText());
				lblPersonHealth.setText(Double.toString(crewMember.getHealth()));
				lblPersonStrength.setText(Double.toString(crewMember.getDamage()));
				lblPersonClass.setText(crewMember.getSpecialization());
				txtpnPersonInfo.setText(crewMember.getClassString());
			}
		});
		btnMerchantStats.setBounds(0, 189, 220, 25);
		MerchantPanel.add(btnMerchantStats);
		
		JLabel lblMerchantImage = new JLabel("");
		lblMerchantImage.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource("/images/merchant.jpg")).getImage().getScaledInstance(230, 251, Image.SCALE_DEFAULT)));
		lblMerchantImage.setBounds(-10, 0, 240, 265);
		MerchantPanel.add(lblMerchantImage);
		
		JPanel PilotPanel = new JPanel();
		PilotPanel.setLayout(null);
		PilotPanel.setBounds(12, 489, 230, 251);
		mainPanel.add(PilotPanel);
		
		PilotName = new JTextField();
		PilotName.setText("Name");
		PilotName.setColumns(10);
		PilotName.setBounds(0, 10, 220, 26);
		PilotPanel.add(PilotName);
		
		JButton btnAddPilotToCrew = new JButton("Add To Crew");
		btnAddPilotToCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (limitReached()) {
					lblError.setText("You have reached the crew limit!");
					return;
				}
				if (PilotName.getText() == "") {
					lblError.setText("Please enter a name!");
					return;
				}
				Pilot newCrewMember = new Pilot(PilotName.getText());
				currentShip.getCrew().addCrewMember(newCrewMember);
				CrewListModel.add(currentShip.getCrew().getCrewList().size() - 1, newCrewMember.getName() + " | " + newCrewMember.getSpecialization());
			}
		});
		btnAddPilotToCrew.setBounds(0, 220, 220, 25);
		PilotPanel.add(btnAddPilotToCrew);
		
		JButton btnPilotStats = new JButton("Pilot Stats");
		btnPilotStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pilot crewMember = new Pilot(PilotName.getText());
				lblPersonHealth.setText(Double.toString(crewMember.getHealth()));
				lblPersonStrength.setText(Double.toString(crewMember.getDamage()));
				lblPersonClass.setText(crewMember.getSpecialization());
				txtpnPersonInfo.setText(crewMember.getClassString());
			}
		});
		btnPilotStats.setBounds(0, 189, 220, 25);
		PilotPanel.add(btnPilotStats);
		
		JLabel lblPilotImage = new JLabel("");
		lblPilotImage.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource("/images/pilot.jpg")).getImage().getScaledInstance(230, 251, Image.SCALE_DEFAULT)));
		lblPilotImage.setBounds(-10, 0, 240, 265);
		PilotPanel.add(lblPilotImage);
		
		JPanel ScientistPanel = new JPanel();
		ScientistPanel.setLayout(null);
		ScientistPanel.setBounds(496, 488, 230, 251);
		mainPanel.add(ScientistPanel);
		
		ScientistName = new JTextField();
		ScientistName.setText("Name");
		ScientistName.setColumns(10);
		ScientistName.setBounds(0, 10, 220, 26);
		ScientistPanel.add(ScientistName);
		
		JButton btnAddScientistToCrew = new JButton("Add To Crew");
		btnAddScientistToCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (limitReached()) {
					lblError.setText("You have reached the crew limit!");
					return;
				}
				if (ScientistName.getText() == "") {
					lblError.setText("Please enter a name!");
					return;
				}
				Scientist newCrewMember = new Scientist(ScientistName.getText());
				currentShip.getCrew().addCrewMember(newCrewMember);
				CrewListModel.add(currentShip.getCrew().getCrewList().size() - 1, newCrewMember.getName() + " | " + newCrewMember.getSpecialization());
			}
		});
		btnAddScientistToCrew.setBounds(0, 220, 220, 25);
		ScientistPanel.add(btnAddScientistToCrew);
		
		JButton btnScientistStats = new JButton("Scientist Stats");
		btnScientistStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Scientist crewMember = new Scientist(ScientistName.getText());
				lblPersonHealth.setText(Double.toString(crewMember.getHealth()));
				lblPersonStrength.setText(Double.toString(crewMember.getDamage()));
				lblPersonClass.setText(crewMember.getSpecialization());
				txtpnPersonInfo.setText(crewMember.getClassString());
			}
		});
		btnScientistStats.setBounds(0, 189, 220, 25);
		ScientistPanel.add(btnScientistStats);
		
		JLabel lblScientistImage = new JLabel("");
		lblScientistImage.setIcon(new ImageIcon(new ImageIcon(SetupView.class.getResource("/images/scientist.jpg")).getImage().getScaledInstance(230, 251, Image.SCALE_DEFAULT)));
		lblScientistImage.setBounds(-10, 0, 240, 265);
		ScientistPanel.add(lblScientistImage);
		
		btnEnterTheVerse = new JButton("Enter the verse");
		btnEnterTheVerse.setBounds(496, 90, 220, 25);
		mainPanel.add(btnEnterTheVerse);
	}
	
	public JButton getStartGame() {
		return btnEnterTheVerse;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JTextPane getError() {
		return lblError;
	}
	
	private boolean limitReached() {
		if (currentShip.getCrew().getCrewList().size() == 4) return true;
		return false;
	}
}

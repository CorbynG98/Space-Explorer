package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InitialSetupView {

	private JFrame frame;
	private JTextField textField;
	private JButton btnConfirm;
	private JLabel lblError;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialSetupView window = new InitialSetupView();
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
	public InitialSetupView() {
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
		frame.setVisible(true);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the universe!");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWelcomeToThe.setBounds(12, 178, 726, 33);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 726, 155);
		frame.getContentPane().add(panel);
		
		JLabel lblEnterShipName = new JLabel("Enter Ship Name: ");
		lblEnterShipName.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEnterShipName.setBounds(59, 223, 272, 33);
		frame.getContentPane().add(lblEnterShipName);
		
		JLabel lblHowManyDays = new JLabel("How many days will you play?");
		lblHowManyDays.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblHowManyDays.setBounds(59, 268, 272, 33);
		frame.getContentPane().add(lblHowManyDays);
		
		textField = new JTextField();
		textField.setBounds(373, 227, 220, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(373, 272, 220, 25);
		frame.getContentPane().add(comboBox);
		
		btnConfirm = new JButton("Continue");
		btnConfirm.setBounds(300, 378, 150, 40);
		frame.getContentPane().add(btnConfirm);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblError.setBounds(12, 333, 726, 33);
		frame.getContentPane().add(lblError);
	}
	
	public JButton getConfirm() {
		return btnConfirm;
	}
	
	public JTextField getShipName() {
		return textField;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JLabel getError() {
		return lblError;
	}
	
	public JComboBox getDays() {
		return comboBox;
	}
}

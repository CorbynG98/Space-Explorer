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

/**
 * Represents the initialSetup class. Creates and builds the components required for the initial setup of the game.
 * Returns the components so the information can be collected and events handled in the game env class
 * @author ctg31
 *
 */
public class InitialSetupView {

	/**
	 * Main frame of the view.
	 */
	private JFrame frame;
	/**
	 * Name of the ship.
	 */
	private JTextField textField;
	/**
	 * Button to confirm entered data.
	 */
	private JButton btnConfirm;
	/**
	 * Error label in case any information is invalid.
	 */
	private JLabel lblError;
	/**
	 * Combo box for the number of days being played.
	 */
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
	
	/**
	 * Get button to confirm ship name and selected days
	 * @return The button to confirm selected options
	 */
	public JButton getConfirm() {
		return btnConfirm;
	}
	
	/**
	 * Gets the text field of the ships name
	 * @return the TextField containing the ships name
	 */
	public JTextField getShipName() {
		return textField;
	}
	
	/**
	 * Gets the main frame for this view
	 * @return The main frame of the view
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Gets the label to display errors
	 * @return The JLabel to show the player error messages
	 */
	public JLabel getError() {
		return lblError;
	}
	
	/**
	 * Gets the combo box with the selected number of days
	 * @return JComboBox with players chosen amount of days
	 */
	public JComboBox getDays() {
		return comboBox;
	}
}

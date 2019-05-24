package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import spaceship.Ship;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Represents the MainMenuView GUI. Creates and builds the GUI components so the user can interact with them.
 * Returns certain components so the events can be handled in the game env class.
 * @author ctg31
 *
 */
public class MainMenuView {

	/**
	 * Main frame for this view
	 */
	private JFrame frame;
	/**
	 * Button to begin the setup process
	 */
	private JButton btnStart = new JButton("Enter the void");
	
	/**
	 * Create the application.
	 * @param currentShip Ship - The current games ship object so actions can be performed
	 */
	public MainMenuView(Ship currentShip) {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 726, 408);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Space Explorer");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-12, 109, 726, 27);
		panel.add(lblNewLabel);
		
		btnStart.setBounds(261, 148, 180, 57);
		panel.add(btnStart);
	}
	
	/**
	 * Get the start button so the event listener can be triggered in game env
	 * @return The button to begin the setup process
	 */
	public JButton getStartButton() {
		return btnStart;
	}
	
	/**
	 * Gets the frame for the view so the view can be disposed when the next screens
	 * needs to be displayed.
	 * @return The main frame of the game
	 */
	public JFrame getFrame() {
		return frame;
	}
}

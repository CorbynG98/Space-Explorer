package views;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

import spaceship.*;

import java.awt.Color;
import javax.swing.JButton;

/**
 * Represents the ShipStatusView. Used to create the frame and components for the ship status
 * view so the player can interact with the view. Returns certain components to handle event sin game environment.
 * @author ctg31
 *
 */
public class ShipStatusView {

	private JFrame frame;
	private JButton btnLeave;
	private Ship currentShip;

	/**
	 * Constructor that creates the GUI when the class is initialized
	 * @param ship Ship - The current games ship object.
	 */
	public ShipStatusView(Ship ship) {
		this.currentShip = ship;
		initialize();
	}

	/**
	 * Initialize and build the frame components.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(currentShip.getHealth());
		progressBar.setBackground(Color.RED);
		progressBar.setForeground(Color.CYAN);
		progressBar.setBounds(12, 375, 714, 45);
		frame.getContentPane().add(progressBar);
		
		btnLeave = new JButton("Leave");
		btnLeave.setBounds(12, 12, 114, 25);
		frame.getContentPane().add(btnLeave);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(ShipStatusView.class.getResource("/images/Star-Trek-3-USS-Enterprise.jpg")).getImage().getScaledInstance(750, 460, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(0, -26, 750, 458);
		
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	
	/**
	 * The button to leave the ship status screen. So the event can be triggered from gameenv.
	 * @return the button to leave the status screen
	 */
	public JButton getLeave() {
		return btnLeave;
	}
	
	/**
	 * Gets the frame for the view so the view can be disposed when the next screens
	 * needs to be displayed.
	 * @return the main frame of the game
	 */
	public JFrame getFrame() {
		return frame;
	}
}

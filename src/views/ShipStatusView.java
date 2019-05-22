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

public class ShipStatusView {

	private JFrame frame;
	private JButton btnLeave;
	private Ship currentShip;

	/**
	 * Create the application.
	 */
	public ShipStatusView(Ship ship) {
		this.currentShip = ship;
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
	
	public JButton getLeave() {
		return btnLeave;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}

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

public class ShipStatusView {

	private JFrame frame;
	private Ship currentShip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipStatusView window = new ShipStatusView(new Enterprise());
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
		progressBar.setBackground(Color.RED);
		progressBar.setValue(currentShip.getHealth());
		progressBar.setForeground(Color.CYAN);
		progressBar.setBounds(12, 375, 714, 45);
		frame.getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(ShipStatusView.class.getResource("/images/Star-Trek-3-USS-Enterprise.jpg")).getImage().getScaledInstance(750, 460, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(0, -26, 750, 458);
		
		frame.getContentPane().add(lblNewLabel);
	}
}

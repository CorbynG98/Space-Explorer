package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.*;
import gameenv.*;

public class GameWonView {

	private JFrame frame;



	
	/**
	 * Create the application.
	 */
	public GameWonView(DayView currentDayView) {
		currentDayView.getFrame().dispose();
		String gameWonText = "Congratulations, enough transporter parts were found, and the crew can now return home!";
		initialize(gameWonText);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String gameWonText) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(12, 235, 114, 25);
		frame.getContentPane().add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(324, 235, 114, 25);
		frame.getContentPane().add(btnNewGame);
		
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameEnvironment newGame = new GameEnvironment();
				newGame.newGame();
				frame.dispose();
			}
		});
		JTextPane textPane = new JTextPane();
		textPane.setText(gameWonText);
		textPane.setEditable(false);
		textPane.setBounds(73, 49, 289, 161);
		frame.getContentPane().add(textPane);
		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setBounds(175, 12, 158, 25);
		frame.getContentPane().add(lblGameOver);
	}
}

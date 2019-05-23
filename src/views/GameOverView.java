package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.*;
import gameenv.*;

public class GameOverView {

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public GameOverView(String gameOverText, DayView currentDayView) {
		currentDayView.getFrame().dispose();
		initialize(gameOverText);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String gameOverText) {
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
		textPane.setText(gameOverText);
		textPane.setEditable(false);
		textPane.setBounds(73, 49, 289, 161);
		frame.getContentPane().add(textPane);
		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setBounds(175, 12, 158, 25);
		frame.getContentPane().add(lblGameOver);
	}
}

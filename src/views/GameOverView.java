package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.*;
import gameenv.*;

/**
 * Contains the GameOverView class which creates Game Over window frame. The text in the window describes the event or conditions that were met
 * to cause the game to end.
 * @author ctg31
 * @author mch221
 *
 */
public class GameOverView {

	/**
	 * Main frame for the view
	 */
	private JFrame frame;

	/**
	 * Create the application.
	 * @param gameOverText String - The string that is shown on the game over screen
	 * @param currentDayView DayView - The current day view so the day can be disposed.
	 */
	public GameOverView(String gameOverText, DayView currentDayView) {
		currentDayView.getFrame().dispose();
		initialize(gameOverText);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param gameOverText String - The string that is shown on the game over screen
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
		
		frame.addWindowFocusListener(new WindowFocusListener() {
			
			public void windowGainedFocus(WindowEvent e) {
				//do nothing
			}
			
			public void windowLostFocus(WindowEvent e) {
				frame.dispose();
			}
		});
		
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

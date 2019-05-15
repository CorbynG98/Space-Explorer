package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupView {

	private JFrame frame;
	private JTextField txtCrewMemberName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupView window = new SetupView();
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
	public SetupView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 745, 750);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Create your crew");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 743, 23);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 226, 230, 251);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtCrewMemberName = new JTextField();
		txtCrewMemberName.setText("Name");
		txtCrewMemberName.setBounds(0, 10, 220, 26);
		panel_1.add(txtCrewMemberName);
		txtCrewMemberName.setColumns(10);
		
		JButton btnAddToCrew = new JButton("Add To Crew");
		btnAddToCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddToCrew.setBounds(0, 220, 220, 25);
		panel_1.add(btnAddToCrew);
		
		JButton btnStats = new JButton("Stats");
		btnStats.setBounds(0, 189, 220, 25);
		panel_1.add(btnStats);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(254, 226, 230, 251);
		panel.add(panel_2);
		
		textField = new JTextField();
		textField.setText("Name");
		textField.setColumns(10);
		textField.setBounds(0, 10, 220, 26);
		panel_2.add(textField);
		
		JButton button = new JButton("Add To Crew");
		button.setBounds(0, 220, 220, 25);
		panel_2.add(button);
		
		JButton button_1 = new JButton("Stats");
		button_1.setBounds(0, 189, 220, 25);
		panel_2.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(496, 226, 230, 251);
		panel.add(panel_3);
		
		textField_1 = new JTextField();
		textField_1.setText("Name");
		textField_1.setColumns(10);
		textField_1.setBounds(0, 10, 220, 26);
		panel_3.add(textField_1);
		
		JButton button_2 = new JButton("Add To Crew");
		button_2.setBounds(0, 220, 220, 25);
		panel_3.add(button_2);
		
		JButton button_3 = new JButton("Stats");
		button_3.setBounds(0, 189, 220, 25);
		panel_3.add(button_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(254, 488, 230, 251);
		panel.add(panel_4);
		
		textField_2 = new JTextField();
		textField_2.setText("Name");
		textField_2.setColumns(10);
		textField_2.setBounds(0, 10, 220, 26);
		panel_4.add(textField_2);
		
		JButton button_4 = new JButton("Add To Crew");
		button_4.setBounds(0, 220, 220, 25);
		panel_4.add(button_4);
		
		JButton button_5 = new JButton("Stats");
		button_5.setBounds(0, 189, 220, 25);
		panel_4.add(button_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(12, 489, 230, 251);
		panel.add(panel_5);
		
		textField_3 = new JTextField();
		textField_3.setText("Name");
		textField_3.setColumns(10);
		textField_3.setBounds(0, 10, 220, 26);
		panel_5.add(textField_3);
		
		JButton button_6 = new JButton("Add To Crew");
		button_6.setBounds(0, 220, 220, 25);
		panel_5.add(button_6);
		
		JButton button_7 = new JButton("Stats");
		button_7.setBounds(0, 189, 220, 25);
		panel_5.add(button_7);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(496, 488, 230, 251);
		panel.add(panel_6);
		
		textField_4 = new JTextField();
		textField_4.setText("Name");
		textField_4.setColumns(10);
		textField_4.setBounds(0, 10, 220, 26);
		panel_6.add(textField_4);
		
		JButton button_8 = new JButton("Add To Crew");
		button_8.setBounds(0, 220, 220, 25);
		panel_6.add(button_8);
		
		JButton button_9 = new JButton("Stats");
		button_9.setBounds(0, 189, 220, 25);
		panel_6.add(button_9);
	}
}

package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import InventoryItems.*;

public class SpaceStaiton {

	private JFrame frame;
	private JLabel lblInfoName, lblInfoPrice;
	private ArrayList<Item> itemList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceStaiton window = new SpaceStaiton();
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
	public SpaceStaiton(ArrayList<Item> itemList) {
		this.itemList = itemList;
		initialize();
	}
	
	public SpaceStaiton() {
		this.itemList = new ArrayList<Item>();
		this.itemList.add(new FroCo());
		this.itemList.add(new Fries());
		this.itemList.add(new ApplePie());
		this.itemList.add(new MedKit());
		this.itemList.add(new Milo());
		this.itemList.add(new FirstAidKit());
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
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 726, 408);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the store!");
		lblWelcomeToThe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setBounds(12, 12, 702, 27);
		panel.add(lblWelcomeToThe);
		
		JButton btnItem1 = new JButton(this.itemList.get(0).getName());
		btnItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Item item = itemList.get(0);
				updateInformation(item.getName(), item.getCost());
			}
		});
		btnItem1.setBounds(12, 70, 149, 66);
		panel.add(btnItem1);
		
		JButton btnItem2 = new JButton(this.itemList.get(1).getName());
		btnItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Item item = itemList.get(1);
				updateInformation(item.getName(), item.getCost());
			}
		});
		btnItem2.setBounds(173, 70, 149, 66);
		panel.add(btnItem2);
		
		JButton btnItem3 = new JButton(this.itemList.get(2).getName());
		btnItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Item item = itemList.get(2);
				updateInformation(item.getName(), item.getCost());
			}
		});
		btnItem3.setBounds(12, 148, 149, 66);
		panel.add(btnItem3);
		
		JButton btnItem4 = new JButton(this.itemList.get(3).getName());
		btnItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Item item = itemList.get(3);
				updateInformation(item.getName(), item.getCost());
			}
		});
		btnItem4.setBounds(173, 148, 149, 66);
		panel.add(btnItem4);
		
		JButton btnItem5 = new JButton(this.itemList.get(4).getName());
		btnItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Item item = itemList.get(4);
				updateInformation(item.getName(), item.getCost());
			}
		});
		btnItem5.setBounds(12, 226, 149, 66);
		panel.add(btnItem5);
		
		JButton btnItem6 = new JButton(this.itemList.get(5).getName());
		btnItem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Item item = itemList.get(5);
				updateInformation(item.getName(), item.getCost());
			}
		});
		btnItem6.setBounds(173, 226, 149, 66);
		panel.add(btnItem6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(334, 72, 380, 220);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblItemInformation = new JLabel("Item Information");
		lblItemInformation.setFont(new Font("Dialog", Font.BOLD, 14));
		lblItemInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemInformation.setBounds(0, 0, 380, 34);
		panel_1.add(lblItemInformation);
		
		lblInfoName = new JLabel("");
		lblInfoName.setBounds(78, 46, 302, 28);
		panel_1.add(lblInfoName);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(10, 46, 56, 28);
		panel_1.add(lblName);
		
		lblInfoPrice = new JLabel("");
		lblInfoPrice.setBounds(78, 86, 302, 28);
		panel_1.add(lblInfoPrice);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrice.setBounds(10, 86, 56, 28);
		panel_1.add(lblPrice);
		
		JButton btnNewButton = new JButton("Purchase");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(538, 337, 176, 59);
		panel.add(btnNewButton);
		
		JButton btnLeaveShop = new JButton("Leave Shop");
		btnLeaveShop.setBounds(12, 337, 176, 59);
		panel.add(btnLeaveShop);
	}
	
	public void updateInformation(String name, int price) {
		lblInfoName.setText(name);
		lblInfoPrice.setText(Integer.toString(price));
	}

}

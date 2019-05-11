package SpaceShip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import InventoryItems.*;

public class SpaceStation extends JFrame implements ActionListener {
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	public SpaceStation() {
		JFrame frame = new JFrame("Vendor!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(300,300);
	    JButton button = new JButton("Press");
	    frame.getContentPane().add(button); // Adds Button to content pane of frame
	    button.addActionListener(this);
	    frame.setVisible(true);
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) {
		SpaceStation test = new SpaceStation();
	}
}

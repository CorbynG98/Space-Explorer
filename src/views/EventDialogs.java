package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class EventDialogs extends JDialog {
	/**
	 * Main content panel for each dialog created.
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 * @param eventResults String - The string that displays to show what happened in the event and what event it was.
	 */
	public EventDialogs(String eventResults) {
		setBounds(100, 100, 325, 198);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Hide dialog box if focus is lost on the dialog box (i.e. the user clicks away or another dialog box is created).
		this.addWindowFocusListener(new WindowFocusListener() {
			
			public void windowGainedFocus(WindowEvent e) {
				//do nothing
			}
			
			public void windowLostFocus(WindowEvent e) {
				dispose();
			}
		});
		
		JTextPane textPane = new JTextPane();
		textPane.setText(eventResults);
		textPane.setEditable(false);
		textPane.setBounds(12, 12, 284, 111);
		contentPanel.add(textPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}

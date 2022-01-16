package videoco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SuperAdminGUI {
	
	public static JButton addEmployeeButton;
	public static JButton removeEmployeeButton;
	public static JButton signOutButton;
	
	public SuperAdminGUI() {
		final JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	
    	//Setup the frame
    	frame.setSize(400,200);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(panel);
    	frame.setTitle("Super Admin");
    	
    	panel.setLayout(null);
    	
    	//Super Admin Add Button
    	addEmployeeButton = new JButton("Add Employee");
    	addEmployeeButton.setBounds(10,20,160,25);
    	addEmployeeButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			new AddEmployeeGUI();
    			frame.setVisible(false);
    		}
    	});
    	panel.add(addEmployeeButton);
    	
    	//Super Admin Remove Button
    	removeEmployeeButton = new JButton("Remove Employee");
    	removeEmployeeButton.setBounds(10,50,160,25);
    	removeEmployeeButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			new DeleteEmployeeGUI();
    			frame.setVisible(false);
    			
    			
    		}
    	});
    	panel.add(removeEmployeeButton);
    	
    	//Super Admin Sign Out Button
    	signOutButton = new JButton("Sign Out");
    	signOutButton.setBounds(10,80,160,25);
    	signOutButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			new GUI();
    			frame.setVisible(false);
    		}
    	});
    	panel.add(signOutButton);
    	
    	frame.setVisible(true);
	}

}

package videoco;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Never call directly. Must be only accessed after user login
public class SystemAdminHome {
	
	public static JLabel welcomeLabel = new JLabel();
	public static JLabel loyaltyPointsLabel = new JLabel();
	
	public static JButton searchButton;
	public static JButton inventoryButton;
	public static JButton signOutButton;
	public static JButton addMovieButton;
	
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	
	public SystemAdminHome() {
		//Setup the frame
    	frame.setSize(400,290);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.getContentPane().add(panel);
    	frame.setTitle("VideoCo Home");
    	
    	panel.setLayout(null);
    	
    	VideoCompany video_company = VideoCompany.getInstance();
    	String username = video_company.employee_database_list.get(GUI.system_admin_login_index).username;
    	
    	//Welcome label
    	welcomeLabel.setText(username + ", welcome to the VideoCo System Administration");
    	welcomeLabel.setBounds(10,20,800,25);
    	panel.add(welcomeLabel);
    	
    	//Search Button
    	searchButton = new JButton("Search Customer");
    	searchButton.setBounds(10,80,200,25);
    	searchButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new SearchCustomer();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(searchButton);
    	
    	//Inventory Button
    	inventoryButton = new JButton("Manage Inventory");
    	inventoryButton.setBounds(10,110,200,25);
    	inventoryButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new InventoryGUI();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(inventoryButton);
    	
    	//Sign Out Button
    	addMovieButton = new JButton("Add Movie");
    	addMovieButton.setBounds(10,140,200,25);
    	addMovieButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new AddMovieGUI();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(addMovieButton);
    	
    	//Sign Out Button
    	signOutButton = new JButton("Sign Out");
    	signOutButton.setBounds(10,170,200,25);
    	signOutButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new GUI();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(signOutButton);
    	
    	frame.setVisible(true);
	}
	
	//Should never be called directly
	 public static void main(String[] args) {
	    	new Home();
	    }
}

package videoco;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Never call directly. Must be only accessed after user login
public class Home {
	
	public static JLabel welcomeLabel = new JLabel();
	public static JLabel loyaltyPointsLabel = new JLabel();
	
	public static JButton searchButton;
	public static JButton cartButton;
	public static JButton profileButton;
	public static JButton signOutButton;
	
	public static JLabel success;
	
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	
	public Home() {
		//Setup the frame
    	frame.setSize(400,400);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.getContentPane().add(panel);
    	frame.setTitle("VideoCo Home");
    	
    	panel.setLayout(null);
    	
    	CustomerDatabase customer_database = CustomerDatabase.getInstance();
    	String username;
    	if (GUI.login_index >= 0) {
    		username = customer_database.customer_database_list.get(GUI.login_index).username;
    	}
    	else {
    		username = SearchCustomer.selected_customer_username;
    	}
   
    	
    	//Welcome label
    	welcomeLabel.setText(username + ", welcome to the VideoCo System!");
    	welcomeLabel.setBounds(10,20,800,25);
    	panel.add(welcomeLabel);
    	
    	//Loyalty Points label
    	loyaltyPointsLabel.setText("You have collected " + Customer.getLoyaltyPoints(username) + " Loyalty Points!");
    	loyaltyPointsLabel.setBounds(10,50,800,25);
    	panel.add(loyaltyPointsLabel);
    	
    	//Search Button
    	searchButton = new JButton("Search Movies");
    	searchButton.setBounds(10,80,120,25);
    	searchButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new Search();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(searchButton);
    	
    	//Cart Button
    	cartButton = new JButton("View Cart");
    	cartButton.setBounds(10,110,120,25);
    	cartButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new ViewCartGUI();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(cartButton);
    	
    	//View Past Orders Button
    	profileButton = new JButton("Past Orders");
    	profileButton.setBounds(10,140,120,25);
    	profileButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new PastOrdersGUI();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(profileButton);
    	
    	//Profile Button
    	profileButton = new JButton("Manage Profile");
    	profileButton.setBounds(10,170,120,25);
    	profileButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new ProfileGUI();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(profileButton);
    	
    	//Sign Out Button
    	signOutButton = new JButton("Sign Out");
    	signOutButton.setBounds(10,200,120,25);
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

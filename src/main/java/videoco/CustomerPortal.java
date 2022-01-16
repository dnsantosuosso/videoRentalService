package videoco;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Never call directly. Must be only accessed after user login
public class CustomerPortal {
	
	public static JLabel welcomeLabel = new JLabel();
	public static JLabel loyaltyPointsLabel = new JLabel();
	
	public static JButton searchButton;
	public static JButton cartButton;
	public static JButton profileButton;
	public static JButton signOutButton;
	public static JButton deleteCust;
	
	public static JLabel success = new JLabel();
	
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	Customer selected_customer;
	
	public CustomerPortal() {
		
		//Setup the frame
    	frame.setSize(400,400);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.getContentPane().add(panel);
    	frame.setTitle("Customer Portal");
    	
    	panel.setLayout(null);
    	
    	String username = SearchCustomer.selected_customer_username;
    	final String user__ = SearchCustomer.selected_customer_username;
    	
    	//Welcome label
    	welcomeLabel.setText("You are using " + username + "'s VideoCo Portal");
    	welcomeLabel.setBounds(10,20,800,25);
    	panel.add(welcomeLabel);
    	
    	//Loyalty Points label
    	loyaltyPointsLabel.setText(username + " has collected " + Customer.getLoyaltyPoints(username) + " Loyalty Points!");
    	loyaltyPointsLabel.setBounds(10,50,800,25);
    	panel.add(loyaltyPointsLabel);
    	
    	//Search Button
    	searchButton = new JButton("Search Movies");
    	searchButton.setBounds(10,80,140,25);
    	searchButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new Search();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(searchButton);
    	
    	//Cart Button
    	cartButton = new JButton("Customer Cart");
    	cartButton.setBounds(10,110,140,25);
    	cartButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new ViewCartGUI();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(cartButton);
    	
    	//View Past Orders Button
    	profileButton = new JButton("Past Orders");
    	profileButton.setBounds(10,140,140,25);
    	profileButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new PastOrdersGUI();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(profileButton);
    	
    	//Profile Button
    	profileButton = new JButton("Manage Profile");
    	profileButton.setBounds(10,170,140,25);
    	profileButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new ProfileGUI();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(profileButton);
    	
    	//Delete Customer Button
    	deleteCust = new JButton("Delete Customer");
    	deleteCust.setBounds(10,200,140,25);
    	deleteCust.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			
    			CustomerDatabase cust_database = CustomerDatabase.getInstance();
    			for (int i = 0; i < cust_database.customer_database_list.size(); i++) {
    				if (cust_database.customer_database_list.get(i).username.equals(user__)) {
    					selected_customer = cust_database.customer_database_list.get(i);
    				}
    			}
    			cust_database.removeCustomer(selected_customer);
    			new CustDeleted();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(deleteCust);
    	
    	//Sign Out Button
    	signOutButton = new JButton("Sign Out");
    	signOutButton.setBounds(10,230,140,25);
    	signOutButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    	        frame.setVisible(false);
    		}
    	});
    	
    	//Success label
    	success.setBounds(10,260,500,25);
    	panel.add(success);
    	int loyalty_ = Customer.getLoyaltyPoints(username);
    	
    	if (loyalty_ < 0) {
    		success.setText("Customer was deleted. You cannot operate on this customer.");
    	}
    	else {
    		success.setText("Customer is active. You can operate on this customer.");
    	}
    	
    	panel.add(signOutButton);
    	
    	frame.setVisible(true);
	}
	
	//Should never be called directly
	 public static void main(String[] args) {
	    	new CustomerPortal();
	    }
}

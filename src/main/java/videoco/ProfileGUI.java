package videoco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ProfileGUI {
	
	public static JLabel userLabel;
	public static JTextField userText;
	public static JLabel passwordLabel;;
	public static JPasswordField passwordText;
	
	public static JLabel nameLabel;
	public static JTextField nameText;
	
	public static JLabel emailLabel;
	public static JTextField emailText;
	
	public static JLabel addressLabel;
	public static JTextField addressText;
	
	public static JLabel provinceLabel;
	public static JTextField provinceText;
	
	public static JLabel creditCardLabel;
	public static JTextField creditCardText;
	
	public static JButton registerButton;
	public static JButton homeButton;
	public static JLabel success;
	
	public ProfileGUI() {
		final JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		//Setup the frame
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setTitle("VideoCo Profile");
		
		panel.setLayout(null);
		
		//Username label
    	userLabel = new JLabel("Change Username");
    	userLabel.setBounds(10,20,120,25);
    	panel.add(userLabel);
    	
    	//Username textbox
    	userText = new JTextField();
    	userText.setBounds(160,20,165,25);
    	panel.add(userText);
    	
    	//Password label
    	passwordLabel = new JLabel("Change Password");
    	passwordLabel.setBounds(10,50,120,25);
    	panel.add(passwordLabel);
    	
    	//Password textbox
    	passwordText = new JPasswordField();
    	passwordText.setBounds(160,50,165,25);
    	panel.add(passwordText);
    	
    	//Name label
    	nameLabel = new JLabel("Change Name");
    	nameLabel.setBounds(10,80,120,25);
    	panel.add(nameLabel);
    	
    	//Name textbox
    	nameText = new JTextField();
    	nameText.setBounds(160,80,165,25);
    	panel.add(nameText);
    	
    	//Email label
    	emailLabel = new JLabel("Change Email");
    	emailLabel.setBounds(10,110,120,25);
    	panel.add(emailLabel);
    	
    	//Email textbox
    	emailText = new JTextField();
    	emailText.setBounds(160,110,165,25);
    	panel.add(emailText);

    	//Email label
    	addressLabel = new JLabel("Change Address");
    	addressLabel.setBounds(10,140,120,25);
    	panel.add(addressLabel);
    	
    	//Email textbox
    	addressText = new JTextField();
    	addressText.setBounds(160,140,165,25);
    	panel.add(addressText);
    	
    	//Province label
    	provinceLabel = new JLabel("Change Province");
    	provinceLabel.setBounds(10,170,120,25);
    	panel.add(provinceLabel);
    	
    	//Province textbox
    	provinceText = new JTextField();
    	provinceText.setBounds(160,170,165,25);
    	panel.add(provinceText);
    	
    	//CreditCard label
    	creditCardLabel = new JLabel("Change Credit Card");
    	creditCardLabel.setBounds(10,200,140,25);
    	panel.add(creditCardLabel);
    	
    	//CreditCard textbox
    	creditCardText = new JTextField();
    	creditCardText.setBounds(160,200,165,25);
    	panel.add(creditCardText);
    	
    	//Success label
    	success = new JLabel("");
    	success.setBounds(10,235,500,25);
    	panel.add(success);
    	
    	//Register Button
    	registerButton = new JButton("Apply Changes");
    	registerButton.setBounds(80,265,160,25);
    	
    	registerButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String username = userText.getText();
    			String password = passwordText.getText();
    			String name = nameText.getText();
    			String email = emailText.getText();
    			String creditCardNo = creditCardText.getText();
    			String address = addressText.getText();
    			String province = provinceText.getText();
    			
    			CustomerDatabase customer_database = CustomerDatabase.getInstance();
    			
    			Customer cust = customer_database.customer_database_list.get(GUI.login_index);
    			
    			if (!username.equals("") || !password.equals("") || !name.equals("") || !email.equals("") || !address.equals("") || !province.equals("") || !creditCardNo.equals("")) {
    				if (!username.equals("")) {
        				cust.setUsername(username);
        				success.setText("Profile updated");
        			}
        			
        			if (!password.equals("")) {
        				cust.setPassword(password);
        				success.setText("Profile updated");
        			}
        			
        			if (!name.equals("")) {
        				cust.setName(name);
        				success.setText("Profile updated");
        			}
        			
        			if (!email.equals("")) {
        				cust.setEmail(email);
        				success.setText("Profile updated");
        			}
        			
        			if (!creditCardNo.equals("")) {
        				cust.setCreditCard(creditCardNo);
        				success.setText("Profile updated");
        			}
        			
        			if (!address.equals("")) {
        				cust.setAddress(address);
        				success.setText("Profile updated");
        			}
        			
        			if (!province.equals("")) {
        				cust.setProvince(province);
        				success.setText("Profile updated");
        			}
    				
    			}
    			
    			else {
    				success.setText("Nothing has been changed.");
    			}
    			
    			
    		}
    	});
    	
    	panel.add(registerButton);
    	
    	//Home Button
    	homeButton = new JButton("Return to Home");
    	homeButton.setBounds(80,295,160,25);
    	
    	homeButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			new Home();
    			frame.setVisible(false);
    			userText.setText("");
    			passwordText.setText("");
    			nameText.setText("");
    			emailText.setText("");
    			addressText.setText("");
    			provinceText.setText("");
    			creditCardText.setText("");
    			success.setText("");
    		}
    	});
    	
    	panel.add(homeButton);
    	
    	
    	
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
    	new ProfileGUI();
    }

}

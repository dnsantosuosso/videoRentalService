 package videoco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// REQ-1 : USER IS ABLE TO LOG IN
public class GUI implements ActionListener{
	
	public static JLabel userLabel;
	public static JTextField userText;
	public static JLabel passwordLabel;;
	public static JPasswordField passwordText; 
	public static JButton loginButton;
	public static JButton loginSystemAdmin;
	public static JButton registerButton;
	public static JButton superAdminButton;
	
	public static JLabel success;
	
	public static int login_index;
	public static int system_admin_login_index;
	
	public GUI() {
		final JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	
    	//Setup the frame
    	frame.setSize(400,230);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(panel);
    	frame.setTitle("VideoCo Login");
    	
    	panel.setLayout(null);
    
    	//Username label
    	userLabel = new JLabel("Username");
    	userLabel.setBounds(10,20,80,25);
    	panel.add(userLabel);
    	
    	//Username textbox
    	userText = new JTextField();
    	userText.setBounds(100,20,165,25);
    	panel.add(userText);
    	
    	//Password label
    	passwordLabel = new JLabel("Password");
    	passwordLabel.setBounds(10,50,80,25);
    	panel.add(passwordLabel);
    	
    	//Password textbox
    	passwordText = new JPasswordField();
    	passwordText.setBounds(100,50,165,25);
    	panel.add(passwordText);
    	
    	//Success label
    	success = new JLabel("");
    	success.setBounds(10,170,500,25);
    	panel.add(success);
    	
    	
    	//Login Button
    	loginButton = new JButton("Login");
    	loginButton.setBounds(10,80,80,25);
    	loginButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String username = userText.getText();
    			String password = passwordText.getText();
    			
    			boolean bool = false;
    			
    			//search in database
//    			bool = Customer.login(username, password);
    			CustomerDatabase cust_datab = CustomerDatabase.getInstance();
    			int len = cust_datab.customer_database_list.size();
    			
    			for (int i = 0; i < len; i = i + 1) {
    				if (username.equals(cust_datab.customer_database_list.get(i).username) && password.equals(cust_datab.customer_database_list.get(i).password)) {
    					bool = true;
    					login_index = i;
    				}
    			}
    			
    			if (bool) {
    				new Home();
        	        frame.setVisible(false);
    			}
    			
    			else {
    				success.setText("LOGIN FAILED: Your username and password do not match");
    			}
    			
    		}
    	});
    	panel.add(loginButton);
    	
    	//System Admin Login Button
    	loginButton = new JButton("System Admin Login");
    	loginButton.setBounds(10,110,160,25);
    	loginButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String usern = userText.getText();
    			String psswd = passwordText.getText();
    			
    			boolean bool = false;
    			
    			//search in database
//    			bool = Customer.login(username, password);
    			
    			VideoCompany video_company = VideoCompany.getInstance();
    			int len = video_company.employee_database_list.size();
//    			System.out.println(len);
//    			System.out.println(video_company.employee_database_list.get(0).username);
//    			System.out.println(video_company.employee_database_list.get(0).password);

    			for (int i = 0; i < len; i = i + 1) {
    				if (usern.equals(video_company.employee_database_list.get(i).username) && psswd.equals(video_company.employee_database_list.get(i).password)) {
    					bool = true;
    					system_admin_login_index = i;
    					break;
    				}
    			}
    			
    			if (bool) {
    				new SystemAdminHome();
        	        frame.setVisible(false);
    			}
    			
    			else {
    				success.setText("LOGIN FAILED: Your username and password do not match");
    			}
    			
    		}
    	});
    	panel.add(loginButton);
    	
    	//Super Admin Login Button
    	superAdminButton = new JButton("Super Admin Login");
    	superAdminButton.setBounds(10,140,160,25);
    	superAdminButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String usern = userText.getText();
    			String psswd = passwordText.getText();
    			
    			if (usern.equals("superadmin") && psswd.equals("superadmin123")) {
    				new SuperAdminGUI();
    				frame.setVisible(false);
    			}
    			else {
    				success.setText("LOGIN FAILED: Your username and password do not match");
    			}
    			
    		}
    	});
    	panel.add(superAdminButton);
    	
    	
    	//Register Button
    	registerButton = new JButton("Register");
    	registerButton.setBounds(80,80,80,25);
    	registerButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new RegisterGUI();
    	        frame.setVisible(false);
    		}
    	});
    	
    	panel.add(registerButton);
    	

    	frame.setVisible(true);
		
	}

    public static void main(String[] args) {
    	new GUI();
    }


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    	
}


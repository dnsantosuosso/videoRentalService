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

//REQ-2 : USER IS ABLE TO REGISTER
public class RegisterGUI implements ActionListener{
	
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
	public static JButton loginButton;
	public static JLabel success;
	
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	
	public RegisterGUI() {
		//Setup the frame
    	frame.setSize(400,400);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(panel);
    	frame.setTitle("VideoCo Register");
    	
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
    	
    	//Name label
    	nameLabel = new JLabel("Full Name");
    	nameLabel.setBounds(10,80,80,25);
    	panel.add(nameLabel);
    	
    	//Name textbox
    	nameText = new JTextField();
    	nameText.setBounds(100,80,165,25);
    	panel.add(nameText);
    	
    	//Email label
    	emailLabel = new JLabel("Email");
    	emailLabel.setBounds(10,110,80,25);
    	panel.add(emailLabel);
    	
    	//Email textbox
    	emailText = new JTextField();
    	emailText.setBounds(100,110,165,25);
    	panel.add(emailText);

    	//Email label
    	addressLabel = new JLabel("Address");
    	addressLabel.setBounds(10,140,80,25);
    	panel.add(addressLabel);
    	
    	//Email textbox
    	addressText = new JTextField();
    	addressText.setBounds(100,140,165,25);
    	panel.add(addressText);
    	
    	//Province label
    	provinceLabel = new JLabel("Province");
    	provinceLabel.setBounds(10,170,80,25);
    	panel.add(provinceLabel);
    	
    	//Province textbox
    	provinceText = new JTextField();
    	provinceText.setBounds(100,170,165,25);
    	panel.add(provinceText);
    	
    	//CreditCard label
    	creditCardLabel = new JLabel("Credit Card");
    	creditCardLabel.setBounds(10,200,80,25);
    	panel.add(creditCardLabel);
    	
    	//CreditCard textbox
    	creditCardText = new JTextField();
    	creditCardText.setBounds(100,200,165,25);
    	panel.add(creditCardText);
    	
    	//Success label
    	success = new JLabel("");
    	success.setBounds(10,265,500,25);
    	panel.add(success);
    	
    	//Register Button
    	registerButton = new JButton("Register");
    	registerButton.setBounds(10,235,80,25);
    	
    	registerButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String username = userText.getText();
    			String password = passwordText.getText();
    			String name = nameText.getText();
    			String email = emailText.getText();
    			String creditCardNo = creditCardText.getText();
    			String address = addressText.getText();
    			String province = provinceText.getText();
    			
    			if (!username.equals("") && !password.equals("") && !name.equals("") && !email.equals("") && !address.equals("") && !province.equals("") && !creditCardNo.equals("")) {
    				Customer customer = new Customer(name, username, password, email, address, creditCardNo, province);
    				customer.register();
    				success.setText("User registered successfully!");
    				
    			}
    			
    			else {
    				success.setText("Please fill all required fields");
    			}
    		}
    	});
    	
    	panel.add(registerButton);
    	
    	//Login Button
    	loginButton = new JButton("Back to Login");
    	loginButton.setBounds(122,295,120,25);
    	loginButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			frame.repaint();
    			frame.revalidate();
    			frame.pack();
    			frame.dispose();
    			new GUI();
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
    	
    	panel.add(loginButton);


    	frame.setVisible(true);
	}
	

    public static void main(String[] args) {
    	new RegisterGUI();
    }


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    	
}

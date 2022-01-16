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
public class DeleteEmployeeGUI implements ActionListener{
	
	public static JLabel userLabel;
	public static JTextField userText;
	public static JLabel passwordLabel;;
	public static JPasswordField passwordText;
	
	public static JButton registerButton;
	public static JButton loginButton;
	public static JLabel success;
	
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	
	Employee selected_employee;
	
	public DeleteEmployeeGUI() {
		//Setup the frame
    	frame.setSize(400,200);
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
    	
    	//Success label
    	success = new JLabel("");
    	success.setBounds(10,110,500,25);
    	panel.add(success);
    	
    	//Register Button
    	registerButton = new JButton("Delete");
    	registerButton.setBounds(10,80,80,25);
    	registerButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String user__ = userText.getText();
    			String psswd__ = passwordText.getText();
    			
    			if (!user__.equals("") && !psswd__.equals("") ) {
    				
    				VideoCompany videoco = VideoCompany.getInstance();
    				int len = videoco.employee_database_list.size();
    				for (int i = 0; i < len; i++) {
    					if (videoco.employee_database_list.get(i).username.equals(user__)) {
    						selected_employee = videoco.employee_database_list.get(i);
    					}
    				}
    				
    				if (selected_employee != null) {
    					if (user__.equals(selected_employee.username) && psswd__.equals(selected_employee.password)) {
    						videoco.removeEmployee(selected_employee);
    	    				success.setText("Employee deleted successfully!");
    					}
    					else {
    						success.setText("Username and password do not match");
    					}
    				}
    				else {
    					success.setText("No employee matches our records");
    				}
    				
    			}
    			
    			else {
    				success.setText("Please fill all required fields");
    			}
    		}
    	});
    	
    	panel.add(registerButton);
    	
    	//Back Button
    	loginButton = new JButton("Back");
    	loginButton.setBounds(122,140,120,25);
    	loginButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			frame.repaint();
    			frame.revalidate();
    			frame.pack();
    			frame.dispose();
    			new SuperAdminGUI();
    			frame.setVisible(false);
    			userText.setText("");
    			passwordText.setText("");
    			success.setText("");
    		}
    	});
    	
    	panel.add(loginButton);


    	frame.setVisible(true);
	}
	

    public static void main(String[] args) {
    	new DeleteEmployeeGUI();
    }


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    	
}

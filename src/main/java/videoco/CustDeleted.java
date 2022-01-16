package videoco;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustDeleted {
	public static JLabel label;
	public static JLabel label2;
	public static JButton okButton;
	
	public CustDeleted() {
		final JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	
    	//Setup the frame
    	frame.setSize(230,130);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(panel);
    	frame.setTitle("Alert");
    	
    	panel.setLayout(null);
    	
    	//Label
    	label = new JLabel("CUSTOMER DELETED");
    	label.setBounds(10,20,280,25);
    	panel.add(label);
    	
    	//Ok Button
    	okButton = new JButton("Ok");
    	okButton.setBounds(10,50,80,25);
    	okButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    	        frame.setVisible(false);
    		}
    	});
    	
    	panel.add(okButton);
    	
    	
    	
    	frame.setVisible(true);
	}
	
	public static void main(String[] args) {
    	new CustDeleted();
    }


}

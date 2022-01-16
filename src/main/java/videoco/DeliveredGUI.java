package videoco;

import java.awt.event.ActionListener;
import java.time.Clock;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeliveredGUI {
	public static JLabel label;
	public static JLabel label2;
	public static JLabel label3;
	public static JButton okButton;
	
	public DeliveredGUI() {
		final JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	
    	//Setup the frame
    	frame.setSize(260,170);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(panel);
    	frame.setTitle("VideoCo Login");
    	
    	panel.setLayout(null);
    	
    	//Label
    	label = new JLabel("ALERT: Order has been delivered!");
    	label.setBounds(15,20,280,25);
    	panel.add(label);
    	
    	
    	
    	//Label
    	label = new JLabel("Must be returned within two weeks.");
    	label.setBounds(15,40,280,25);
    	panel.add(label);
    	
    	Warehouse warehouse = Warehouse.getInstance();
    	
    	
    	//Label
    	label3 = new JLabel("Due: " + warehouse.selected_order.getDueDate());
    	label3.setBounds(15,70,280,25);
    	panel.add(label3);
    	
    	//Ok Button
    	okButton = new JButton("Ok");
    	okButton.setBounds(80,100,80,25);
    	okButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    	        frame.setVisible(false);
    		}
    	});
    	
    	panel.add(okButton);
    	
    	
    	
    	frame.setVisible(true);
	}
	
	public static void main(String[] args) {
    	new DeliveredGUI();
    }
	
	public Date addHoursToJavaUtilDate(Date date, int hours) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    return calendar.getTime();
	}


}

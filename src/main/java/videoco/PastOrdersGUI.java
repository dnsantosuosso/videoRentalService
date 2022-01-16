package videoco;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PastOrdersGUI extends JFrame implements Observer{
	
	public static JTable jt = new JTable();
	Container jcontent = new Container();
	JFrame frame2 = new JFrame();
	Order selected_order;
	public static JButton cancelButton;
	public static JButton returnButton;
	public static JButton updateButton;
	public static JButton homeButton;
	public static JLabel success;
	
	public PastOrdersGUI() {
		
		final JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	
    	//Setup the frame
    	frame.setSize(720,400);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(panel);
    	frame.setTitle("Past Orders");
    	
    	panel.setLayout(null);
		
		CustomerDatabase customer_database = CustomerDatabase.getInstance();
		
		final Customer cust = customer_database.customer_database_list.get(GUI.login_index);
		
		String[] columns = {"ID", "Movies", "Price", "Status"};
		
		int len = cust.pastOrders.size();
		
		//Create Table
		String[][] data = new String[len][4];
		int j = 0;
		
		for (int i = 0; i < len; i++) {
			data[i][j] = String.valueOf(cust.pastOrders.get(i).orderID);
			data[i][j+1] = cust.pastOrders.get(i).getMovies();
			data[i][j+2] = String.valueOf(Math.round(cust.pastOrders.get(i).getOrderPrice() * 100.0)/100.0);
			data[i][j+3] = cust.pastOrders.get(i).getStatus();
			
		}
		
		jt = new JTable(data, columns) {
			public boolean isCellEditable(int data, int columns) 
			{
				return false;
			}
		};
		jt.setPreferredScrollableViewportSize(new Dimension(500,150));
		jt.setBounds(100,200,400,100);
		jt.getColumnModel().getColumn(0).setPreferredWidth(15);
		jt.getColumnModel().getColumn(1).setPreferredWidth(200);
		jt.getColumnModel().getColumn(2).setPreferredWidth(180);
		jt.getColumnModel().getColumn(3).setPreferredWidth(90);
		jt.setFillsViewportHeight(true);	//setVisible(true)
		
    	
		jt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String order = jt.getValueAt(jt.getSelectedRow(), 0).toString();
				for (Order o : cust.pastOrders) {
					if (o.getID() == Integer.valueOf(order)) {
						selected_order = o;
					}
				}
			}
		});
		
		//Scroll Panel added to Frame 3
		JScrollPane sp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		frame2.add(sp);
		
		jcontent = frame2.getContentPane();
		jcontent.setBounds(10,60,680,200);
		panel.add(jcontent);
		
		//Cancel Button
    	cancelButton = new JButton("Cancel Order");
    	cancelButton.setBounds(10,20,160,25);
    	cancelButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			Warehouse warehouse = Warehouse.getInstance();
    			if (selected_order != null) {
    				if (warehouse.cancel(selected_order)) {
        				success.setText("Order Cancelled");
        			}
        			else {
        				success.setText("Order cannot be cancelled. Contact System Administrator");
        			}
    			}
    			else {
    				success.setText("Please select an order.");
    			}
    		}
    	});
    	panel.add(cancelButton);
    	
    	//Return Button
    	returnButton = new JButton("Return Order");
    	returnButton.setBounds(180,20,160,25);
    	returnButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			
    			Date date1 = Calendar.getInstance().getTime();
    		    Date date2 = selected_order.getDueDate();
    		    double diff = date2.getTime() - date1.getTime();
    			
    			Warehouse warehouse = Warehouse.getInstance();
    			if (selected_order != null) {
    				if (warehouse.returnOrder(selected_order)) {
    					cust.returnOrder(selected_order);
    					if (diff >= 0) {
    						success.setText("Order Returned. Thank you!");
    					}
    					else {
    						
    						double diff_ = Math.abs(diff);
    						double diff__ = Math.floor(diff_);
    						int siz = selected_order.orderList.size();
    						
    						//charge $1 per movie per late day
    						cust.charges(diff__ * siz);
    						success.setText("You have been charged $" + ( diff__ * siz ) + " for returning movie late");
    						
    					}
        			}
        			else {
        				success.setText("Order cannot be returned. Contact System Administrator");
        			}
    			}
    			else {
    				success.setText("Please select an order.");
    			}
    		}
    	});
    	panel.add(returnButton);
    	
    	//Update Button
    	updateButton = new JButton("Update");
    	updateButton.setBounds(350,20,160,25);
    	updateButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			update(frame);
    		}
    	});
    	panel.add(updateButton);
    	
    	//Home Button
    	homeButton = new JButton("Return to Home");
    	homeButton.setBounds(520,20,160,25);
    	homeButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			frame.setVisible(false);
    			new Home();
    		}
    	});
    	panel.add(homeButton);
    	
    	//Success label
    	success = new JLabel("");
    	success.setBounds(10,260,400,25);
    	panel.add(success);
    	
    	
		
		frame.setVisible(true);
	}
	
	public void update(JFrame frame) {
		frame.setVisible(false);
		frame.repaint();
		frame.revalidate();
		frame.pack();
		new PastOrdersGUI();
		}
}

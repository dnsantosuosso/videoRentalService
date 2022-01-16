// m.getTitle().contains(text) || m.getCategories().contains(text) || String.valueOf(m.getID()).contains(text)|| text.equals("")

package videoco;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SearchCustomer extends JFrame{
	
	/**
	 * 
	 */
	public static JTable jt = new JTable();
	public static JLabel welcomeLabel;
	
	public static JLabel addMovieToCart;
	public static JTextField movieTitleText;	//for searching
	public static JButton searchByTitleButton;
	public static JLabel success;
	
	public static JTextField movieTitle;	//for adding to cart
	public static JButton addToCartButton;
	public static JButton viewCartButton;
	public static JLabel success2;
	
	public static JButton returnHomeButton;
	public static JButton movieDisplayButton;
	public static JButton deleteCustButton;
	
	public static JPanel panel = new JPanel();
	
	public static JFrame frame = new JFrame();
	public static JFrame frame2 = new JFrame();
	
	public static JFrame frame4 = new JFrame();
	
	static String selected_customer_username;
	
	int counter = 0;
	
	//MOVIE DISPLAY
	public static String movie_title;
	public Movie selected_movie;
	public static JLabel title;
	public static JLabel description;
	public static JLabel release_date;
	public static JLabel actors;
	public static JLabel directors;
	public static JLabel category;
	public static JLabel price;

	Container jcontent = new Container();
	Container jcontent2 = new Container();
	
	
	public SearchCustomer() {
		
		//Frame 1 Setup
		frame.setLayout(new FlowLayout());
		frame.setSize(600,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Frame 2 Setup
		frame2.setSize(785,400);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.add(panel);
		frame2.setTitle("VideoCo Search");
		
		panel.setLayout(null);
		
		
		//Search by Category Label
		welcomeLabel = new JLabel("Search by Name");
    	welcomeLabel.setBounds(10,20,165,25);
    	panel.add(welcomeLabel);

    	//Movie Title Textbox 1
    	movieTitleText = new JTextField();
    	movieTitleText.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {
    			
    		}
    	});
    	
    	movieTitleText.setBounds(140,20,165,25);
    	panel.add(movieTitleText);
    	
    	//Table 1: Complete Table added to Frame 1
    	// ********************** TABLE 1 START ***************************
    	String[] columns = {"Name", "Username"};
		
		final CustomerDatabase customer_database = CustomerDatabase.getInstance();
		
		int len = customer_database.customer_database_list.size();
		
		String[][] data = new String[len][2];
		int j = 0;
		
		for (int i = 0; i < len; i++) {
			data[i][j] = customer_database.customer_database_list.get(i).name;
			data[i][j+1] = customer_database.customer_database_list.get(i).username;
		}
		
		jt = new JTable(data, columns) {
			public boolean isCellEditable(int data, int columns) 
			{
				return false;
			}
			
			//set lines gray and light gray
//			public Component prepareRenderer(TableCellRenderer r, int data, int columns) 
//			{
//				Component c = super.prepareRenderer(r, data, columns);
//				
//				if (data % 2 == 0) {
//					c.setBackground(Color.LIGHT_GRAY);
//					
//				}
//				else {
//					c.setBackground(Color.GRAY);
//				}
//				return c;
//			}
		};
		jt.setPreferredScrollableViewportSize(new Dimension(500,150));
		jt.setBounds(100,200,400,100);
		jt.getColumnModel().getColumn(0).setPreferredWidth(240);
		jt.getColumnModel().getColumn(1).setPreferredWidth(240);
		jt.setFillsViewportHeight(true);	//setVisible(true)
		
		jt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				movieTitle.setText(jt.getValueAt(jt.getSelectedRow(), 1).toString());
			}
		});
		
		JScrollPane sp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Add table 1 to frame1
		frame.add(sp);
		
		//JContent1 contains Frame1
		jcontent = frame.getContentPane();
		jcontent.setBounds(10,60,600,200);
		panel.add(jcontent);
		
		// ********************** TABLE 1 FINISH ***************************
    	
    	//Success label: Gives result of movies searched
    	success = new JLabel("");
    	success.setBounds(280,50,165,25);
    	panel.add(success);
    	
    	//Success 2 label: Gives result of addToCart Button
    	success2 = new JLabel("");
    	success2.setBounds(10,320,500,25);
    	panel.add(success2);

    	//Search Button
    	searchByTitleButton = new JButton("Search");
    	searchByTitleButton.setBounds(310,20,165,25);
    	searchByTitleButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) 
    		{
    			
    			panel.remove(jcontent);
    			frame.setVisible(false);
    			
    			//Frame 3: Table 2 will be added to this frame
    			JFrame frame3 = new JFrame();
    			frame3.setLayout(new FlowLayout());
    			frame3.setSize(600,200);
    			frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			
    			if (counter >= 1) {
    				for (int i = 0; i < counter*10; i++) {
    					panel.remove(jcontent);
        				panel.remove(jcontent2);
        			}
    			}
    			
    			
    			String text = movieTitleText.getText();
    			String builder = "";
    			
    			ArrayList<Customer> matches = new ArrayList<Customer>();
    			
    			
    			for (Customer m : customer_database.customer_database_list) {
    				if (m.username.contains(text) || text.equals("")) {
    					matches.add(m);
    					builder = builder + m.username + ", ";
    					
    				}
    			}
    			
    			if (builder.length() >= 2) {
    				String builder_2 = builder.substring(0, builder.length()-2);
        			success.setText(builder_2);
    			}
    			else {
    				success.setText("No customers matched your search. Try again.");
    			}
    			
    			int len = matches.size();
    			
    			// ********************** TABLE 2 START ***************************
    			
    			String[] columns_ = {"Name", "Username"};
    			
    			CustomerDatabase customer_database = CustomerDatabase.getInstance();
    			
    			int len_ = customer_database.customer_database_list.size();
    			
    			String[][] data_ = new String[len_][2];
    			int j = 0;
    			
    			for (int i = 0; i < len_; i++) {
    				data_[i][j] = customer_database.customer_database_list.get(i).name;
    				data_[i][j+1] = customer_database.customer_database_list.get(i).username;
    			}
    			
    			
    			jt = new JTable(data_, columns_) {
    				public boolean isCellEditable(int data, int columns) 
    				{
    					return false;
    				}
    			};
    			jt.setPreferredScrollableViewportSize(new Dimension(500,150));
    			jt.setBounds(100,200,400,100);
    			jt.getColumnModel().getColumn(0).setPreferredWidth(240);
    			jt.getColumnModel().getColumn(1).setPreferredWidth(240);

    			jt.setFillsViewportHeight(true);	//setVisible(true)
    			
    			jt.addMouseListener(new MouseAdapter() {
    				@Override
    				public void mouseClicked(MouseEvent e) {
    					movieTitle.setText(jt.getValueAt(jt.getSelectedRow(), 1).toString());
    				}
    			});
    			
    			//Scroll Panel added to Frame 3
    			JScrollPane sp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    			
    			frame3.add(sp);
    			
    			jcontent2 = frame3.getContentPane();
    			jcontent2.setBounds(10,60,600,200);
    			panel.add(jcontent2);
    			
    			counter ++;

    			
    			// ********************** TABLE 2 FINISH ***************************
    			
    		}
    	});
    	panel.add(searchByTitleButton);
		
    	
    	//Type Cust Username Label
    	addMovieToCart = new JLabel("Type Customer Username");
    	addMovieToCart.setBounds(10,290,260,25);
    	panel.add(addMovieToCart);
    	
//    	//Cust Username textbox
    	movieTitle = new JTextField();
    	movieTitle.setBounds(205,290,200,25);
    	panel.add(movieTitle);
    	
    	//Success label
    	success = new JLabel("");
    	success.setBounds(10,260,600,25);
    	panel.add(success);
   
    	
    	//Customer Portal Button
    	addToCartButton = new JButton("Customer Portal");
    	addToCartButton.setBounds(400,290,160,25);
    	addToCartButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) 
    		{
    			selected_customer_username = movieTitle.getText();
    			new CustomerPortal();
    		}
    	});
    	panel.add(addToCartButton);
 
    	
    	//Home Button
    	returnHomeButton = new JButton("Return to Home");
    	returnHomeButton.setBounds(200,320,200,25);
    	returnHomeButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) 
    		{
    			new SystemAdminHome();
    	        frame2.setVisible(false);
    		}
    	});
    	panel.add(returnHomeButton);
    	
    	title = new JLabel();
    	description = new JLabel();
    	release_date = new JLabel();
    	actors = new JLabel();
    	directors = new JLabel();
    	category = new JLabel();
    	price = new JLabel();
    	

 
		frame2.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
//    	SearchByAll gui = new SearchByAll();
//		
//    	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	gui.setSize(600,100);
//    	gui.setVisible(true);
//    	gui.setTitle("JTable");
//    	
//    	gui.add(panel);
		new SearchCustomer();
    }

}


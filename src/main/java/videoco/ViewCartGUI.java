package videoco;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewCartGUI extends JFrame implements ActionListener{
	
	public static JLabel cartLabel = new JLabel();
	public static JLabel lateFee = new JLabel();
	public static JLabel cartPriceLabel = new JLabel();
	public static JButton deleteButton;
	public static JButton addButton;
	public static JButton placeOrder;
	public static JButton homeButton;
	public static JTextField deleteText;
	public static JLabel success = new JLabel();
	public static JComboBox comboBox;
	
	Movie selected_movie;
	
	String item = "";
	
	
	Container jcontent = new Container();
	
	
	public ViewCartGUI() {
		final JFrame frame = new JFrame();
		JFrame frame2 = new JFrame();
    	JPanel panel = new JPanel();
    	
		//Setup the frame
    	frame.setSize(600,400);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(panel);
    	frame.setTitle("Your Cart");
    	
    	//Frame 2 Setup
    	frame2.setLayout(new FlowLayout());
    	frame2.setSize(600,200);
    	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	panel.setLayout(null);
    	
    	CustomerDatabase customer_database = CustomerDatabase.getInstance();
		
		final Customer cust = customer_database.customer_database_list.get(GUI.login_index);
    	
    	//Your Cart label
    	cartLabel = new JLabel();
    	cartLabel.setText("Your Cart: " + cust.viewCart());
    	cartLabel.setBounds(10,20,800,25);
    	panel.add(cartLabel);
    	
    	//Your Cart Price label
    	cartPriceLabel.setBounds(10,50,400,25);
    	cartPriceLabel.setText("Total: $" + Math.round(cust.getCartPrice() * 100.0)/100.0);
    	panel.add(cartPriceLabel);
    	
    	//Late Fee Price label
    	lateFee.setBounds(110,50,400,25);
    	if (cust.customerHasLateFee()) {
    		lateFee.setText("You are being charged a late fee.");
    	}
    	else {
    		lateFee.setText("You are not being charged a late fee");
    	}
    	panel.add(lateFee);
    	
    	
    	
    	//Success label
    	success.setBounds(10,150,800,25);
    	panel.add(success);
    	
    	//Combo Box
    	ArrayList<Movie> movies_in_cart = cust.cartList();
    	int len = movies_in_cart.size();
    	
    	String[] movies_in_cart_array = new String[len];
    	
    	for (int i = 0; i < len; i ++) {
    		movies_in_cart_array[i] = movies_in_cart.get(i).getTitle();
    	}
    	
    	comboBox = new JComboBox(movies_in_cart_array);
    	comboBox.addActionListener(this);
    	
    	comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==comboBox) {
					item = comboBox.getSelectedItem().toString();
				}
			}
    	});
    	
    	frame2.add(comboBox);
    	jcontent = frame2.getContentPane();
		jcontent.setBounds(10,70,200,200);
		
		panel.add(jcontent);
    	
    	//Delete Movie Button
    	deleteButton = new JButton("Delete Movie");
    	deleteButton.setBounds(220,77,160,25);
    	deleteButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			Inventory movie_database = Inventory.getInstance();
				for (int i = 0; i < movie_database.movie_database.size(); i++) {
		    		if (movie_database.movie_database.get(i).title.equals(item)) {
		    			selected_movie = movie_database.movie_database.get(i);
		    		}
		    	}
    			if (selected_movie != null) {
    				cust.deleteFromCart(selected_movie);
    				success.setText(selected_movie.getTitle() + " was successfully removed from your cart");
    				cartLabel.setText("Your Cart: " + cust.viewCart());
    				cartPriceLabel.setText("Total: $" + cust.getCartPrice());
    			}
    			else {
    				success.setText("Failed: Movie is no longer in your cart");
    			}
    		}
    	});
    	panel.add(deleteButton);
    	
    	//Add Movie Button
    	addButton = new JButton("Add Movie");
    	addButton.setBounds(380,77,160,25);
    	addButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			Inventory movie_database = Inventory.getInstance();
				for (int i = 0; i < movie_database.movie_database.size(); i++) {
		    		if (movie_database.movie_database.get(i).title.equals(item)) {
		    			selected_movie = movie_database.movie_database.get(i);
		    		}
		    	}
    			if (selected_movie != null && !cust.cart.contains(selected_movie)) {
    				cust.addToCart(selected_movie);
    				success.setText(selected_movie.getTitle() + " was successfully added to your cart");
    				cartLabel.setText("Your Cart: " + cust.viewCart());
    				cartPriceLabel.setText("Total: $" + cust.getCartPrice());
    			}
    			else {
    				success.setText("Failed: Movie is already in your cart");
    			}
    		}
    	});
    	panel.add(addButton);
    	
    	//Place Order Button
    	placeOrder = new JButton("Place Order");
    	placeOrder.setBounds(220,120,160,25);
    	placeOrder.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			cust.placeOrder();
				success.setText("Your order has been placed! You have been awarded one loyalty point.");
    		}
    	});
    	panel.add(placeOrder);
    	
    	//Home Order Button
    	homeButton = new JButton("Return to Home");
    	homeButton.setBounds(380,120,160,25);
    	homeButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			success.setText("");
    			new Home();
    			frame.setVisible(false);
    		}
    	});
    	panel.add(homeButton);
    	
    	
    	frame.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
//	public static void main(String[] args) {
//    	Customer cust = new Customer("Diego", "nicodemo", "2000", "nicodemo@my.yorku.ca", "299 Davos Road", "123456789", "ON" );
//    	Inventory inventory = Inventory.getInstance();
//    	cust.addToCart(inventory.movie_database.get(0));
//    	cust.addToCart(inventory.movie_database.get(1));
//    	cust.addToCart(inventory.movie_database.get(2));
//    	cust.addToCart(inventory.movie_database.get(3));
//    	
//    	System.out.println(cust.viewCart());
//    	
//    	cust.deleteFromCart(inventory.movie_database.get(3));
//    	
//    	System.out.println(cust.viewCart());
//    	
//
//    }
	

}

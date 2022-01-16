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

public class SearchByCategory extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public static JPanel panel = new JPanel();
	
	public static JFrame frame = new JFrame();
	public static JFrame frame2 = new JFrame();
	
	public static JFrame frame4 = new JFrame();
	
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
	
	
	public SearchByCategory() {
		
		//Frame 1 Setup
		frame.setLayout(new FlowLayout());
		frame.setSize(600,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Frame 2 Setup
		frame2.setSize(685,800);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.add(panel);
		frame2.setTitle("VideoCo Search");
		
		panel.setLayout(null);
		
		
		//Search by Category Label
		welcomeLabel = new JLabel("Search by Category");
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
    	String[] columns = {"ID", "Name", "Category", "Price"};
		
		Inventory inventory = Inventory.getInstance();
		
		int len = inventory.movie_database.size();
		
		String[][] data = new String[len][4];
		int j = 0;
		
		for (int i = 0; i < len; i++) {
			data[i][j] = String.valueOf(inventory.movie_database.get(i).getID());
			data[i][j+1] = inventory.movie_database.get(i).getTitle();
			data[i][j+2] = inventory.movie_database.get(i).getCategories();
			data[i][j+3] = "$" + String.valueOf(inventory.movie_database.get(i).getPrice());
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
		jt.getColumnModel().getColumn(0).setPreferredWidth(15);
		jt.getColumnModel().getColumn(1).setPreferredWidth(200);
		jt.getColumnModel().getColumn(2).setPreferredWidth(180);
		jt.getColumnModel().getColumn(3).setPreferredWidth(90);
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
    			
    			ArrayList<Movie> matches = new ArrayList<Movie>();
    			
    			Inventory inventory = Inventory.getInstance();
    			
    			
    			for (Movie m : inventory.movie_database) {
    				if (m.getCategories().contains(text) || text.equals("")) {
    					matches.add(m);
    					builder = builder + m.getTitle() + ", ";
    					
    				}
    			}
    			
    			if (builder.length() >= 2) {
    				String builder_2 = builder.substring(0, builder.length()-2);
        			success.setText(builder_2);
    			}
    			else {
    				success.setText("No movies matched your search. Try again.");
    			}
    			
    			int len = matches.size();
    			
    			// ********************** TABLE 2 START ***************************
    			
    			String[] columns = {"ID", "Name", "Category", "Price"};
    			
    			String[][] data = new String[len][4];
    			int j = 0;
    			
    			for (int i = 0; i < len; i++) {
    				int id = matches.get(i).getID();
    				data[i][j] = String.valueOf(id);
    				data[i][j+1] = matches.get(i).getTitle();
    				data[i][j+2] = matches.get(i).getCategories();
    				data[i][j+3] = "$" + matches.get(i).getPrice();
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
		
    	
    	//Add Movie to Cart label
    	addMovieToCart = new JLabel("Type Movie Title");
    	addMovieToCart.setBounds(10,290,165,25);
    	panel.add(addMovieToCart);
    	
//    	//Movie ID textbox
    	movieTitle = new JTextField();
    	movieTitle.setBounds(115,290,165,25);
    	panel.add(movieTitle);
    	
    	//Success label
    	success = new JLabel("");
    	success.setBounds(10,260,600,25);
    	panel.add(success);
   
    	
    	//AddToCart Button
    	addToCartButton = new JButton("Add To Cart");
    	addToCartButton.setBounds(280,290,120,25);
    	addToCartButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) 
    		{
    			String title = movieTitle.getText();
    			
    			if (movieIsAvailable(title)) {
    				CustomerDatabase customer_database = CustomerDatabase.getInstance();
        			
            		Customer cust = customer_database.customer_database_list.get(GUI.login_index);
            		cust.addToCart(getMovieByTitle(title));
            		success2.setText(getMovieByTitle(title).title + " was successfully added to your cart!");
    			}
    			else {
    				success2.setText("Please enter a valid Movie Title");
    			}
    		}
    	});
    	panel.add(addToCartButton);
    	

    	
    	//ViewCart Button
    	viewCartButton = new JButton("View Cart");
    	viewCartButton.setBounds(530,290,120,25);
    	viewCartButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) 
    		{
    			new ViewCartGUI();
    	        frame2.setVisible(false);
    		}
    	});
    	panel.add(viewCartButton);
    	
    	//Home Button
    	returnHomeButton = new JButton("Return to Home");
    	returnHomeButton.setBounds(200,610,200,25);
    	returnHomeButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) 
    		{
    			new Home();
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
    	
    	//View Movie Button
    	movieDisplayButton = new JButton("Movie Details");
    	movieDisplayButton.setBounds(405,290,120,25);
    	movieDisplayButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) 
    		{
    			movie_title = movieTitle.getText();
    			if (movie_title.equals("")) {
    				success2.setText("Please enter a valid Movie Title");
    			}
    			else{

    				Inventory movie_database = Inventory.getInstance();
    				for (int i = 0; i < movie_database.movie_database.size(); i++) {
    		    		if (movie_database.movie_database.get(i).title.equals(movie_title)) {
    		    			selected_movie = movie_database.movie_database.get(i);
    		    		}
    		    	}
    				
    				frame2.revalidate();
    				frame2.repaint();
    				
    				
    				//Title
    		    	title.setText(selected_movie.getTitle());
    		    	title.setBounds(10,340,800,25);
    		    	panel.add(title);
    		    	
    		    	//Description
    		    	description.setText(selected_movie.getDescription());
    		    	description.setBounds(10,370,800,50);
    		    	panel.add(description);
    		    	
    		    	//Release Date
    		    	release_date.setText("Release Date: " + selected_movie.getReleaseDate());
    		    	release_date.setBounds(10,430,800,25);
    		    	panel.add(release_date);
    		    	
    		    	//Actors
    		    	actors.setText("Cast: " + selected_movie.getActors());
    		    	actors.setBounds(10,460,800,25);
    		    	panel.add(actors);
    		    	
    		    	//Directors
    		    	directors.setText("Directors: " + selected_movie.getDirectors());
    		    	directors.setBounds(10,490,800,25);
    		    	panel.add(directors);
    		    	
    		    	//Directors
    		    	category.setText("Categories: " + selected_movie.getCategories());
    		    	category.setBounds(10,520,800,25);
    		    	panel.add(category);
    		    	
    		    	//Price
    		    	price.setText("Price: $" + selected_movie.getPrice());
    		    	price.setBounds(10,550,800,25);
    		    	panel.add(price);
    		 
    			}
    		}
    	});
    	panel.add(movieDisplayButton);
 
		frame2.setVisible(true);
		
	}
	
	public Movie getMovieByTitle(String title) {
		Movie movie0 = new Movie();
		
		Inventory inventory = Inventory.getInstance();
		
		for (Movie m : inventory.movie_database) {
			if (title.equals(m.getTitle())) {
				return m;
			}
		}
		
		//should never return
		return movie0;
	}
	
	public Movie getMovieByCategory(String categ) {
		Movie movie0 = new Movie();
		
		Inventory inventory = Inventory.getInstance();
		
		for (Movie m : inventory.movie_database) {
			if (m.getCategories().contains(categ)) {
				return m;
			}
		}
		
		//should never return
		return movie0;
	}
	
	public boolean inBounds(int id) {
		
		boolean bool = false;
		
		Inventory inventory = Inventory.getInstance();
		
		int len = inventory.movie_database.size();
		
		if (id >0 && id<= 50) {
			bool = true;
		}
		
		return bool;
	}
	
	public Movie getMovieByID(int id) {
		int index = id - 1;
		
		Inventory inventory = Inventory.getInstance();
		
		
		return inventory.movie_database.get(index);
	}
	
	public boolean movieIsAvailable(String title) {
		
		boolean bool = false;
		
		Inventory inventory = Inventory.getInstance();
		
		for (Movie m : inventory.movie_database) {
			if (title.equals(m.getTitle())) {
				bool = true;
			}
		}
		
		
		return bool;
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
		new SearchByCategory();
    }

}


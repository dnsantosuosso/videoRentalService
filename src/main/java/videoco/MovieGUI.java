package videoco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MovieGUI {
	
	public static JLabel titleLabel;
	public static JTextField titleText;
	public static JLabel actorsLabel;;
	public static JTextField actorsText;
	
	public static JLabel directorLabel;
	public static JTextField directorText;
	
	public static JLabel releaseDateLabel;
	public static JTextField releaseDateText;
	
	public static JLabel priceLabel;
	public static JTextField priceText;
	
	public static JLabel categoryLabel;
	public static JTextField categoryText;
	
	public static JButton deleteButton;
	public static JButton registerButton;
	public static JButton homeButton;
	public static JLabel success;
	
	Movie selected_movie;
	
	String item = "";
	
	boolean wasDeleted = false;
	
	public MovieGUI() {
		
		Inventory movie_database = Inventory.getInstance();
		
		if (!InventoryGUI.selected_title.equals("")) {
			item = InventoryGUI.selected_title;
		}
		for (int i = 0; i < movie_database.movie_database.size(); i++) {
    		if (movie_database.movie_database.get(i).title.equals(item)) {
    			selected_movie = movie_database.movie_database.get(i);
    		}
    	}
		
		final JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		//Setup the frame
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setTitle(selected_movie.title);
		
		panel.setLayout(null);
		
		//Title label
    	titleLabel = new JLabel("Change Title");
    	titleLabel.setBounds(10,20,120,25);
    	panel.add(titleLabel);
    	
    	//Title textbox
    	titleText = new JTextField();
    	titleText.setBounds(160,20,165,25);
    	panel.add(titleText);
    	
    	//Actors label
    	actorsLabel = new JLabel("Change Actors");
    	actorsLabel.setBounds(10,50,120,25);
    	panel.add(actorsLabel);
    	
    	//Actors textbox
    	actorsText = new JTextField();
    	actorsText.setBounds(160,50,165,25);
    	panel.add(actorsText);
    	
    	//Director label
    	directorLabel = new JLabel("Change Directors");
    	directorLabel.setBounds(10,80,120,25);
    	panel.add(directorLabel);
    	
    	//Director textbox
    	directorText = new JTextField();
    	directorText.setBounds(160,80,165,25);
    	panel.add(directorText);
    	
    	//Date label
    	releaseDateLabel = new JLabel("Change Date");
    	releaseDateLabel.setBounds(10,110,120,25);
    	panel.add(releaseDateLabel);
    	
    	//Date textbox
    	releaseDateText = new JTextField();
    	releaseDateText.setBounds(160,110,165,25);
    	panel.add(releaseDateText);

    	//Price label
    	priceLabel = new JLabel("Change Price");
    	priceLabel.setBounds(10,140,120,25);
    	panel.add(priceLabel);
    	
    	//Price textbox
    	priceText = new JTextField();
    	priceText.setBounds(160,140,165,25);
    	panel.add(priceText);
    	
    	//Category label
    	categoryLabel = new JLabel("Change Category");
    	categoryLabel.setBounds(10,170,120,25);
    	panel.add(categoryLabel);
    	
    	//Category textbox
    	categoryText = new JTextField();
    	categoryText.setBounds(160,170,165,25);
    	panel.add(categoryText);
    	
    	//Register Button
    	deleteButton = new JButton("Delete Movie");
    	deleteButton.setBounds(80,235,160,25);
    	deleteButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			Inventory movie_database = Inventory.getInstance();
    			
    			if (!InventoryGUI.selected_title.equals("")) {
    				item = InventoryGUI.selected_title;
    			}
    			for (int i = 0; i < movie_database.movie_database.size(); i++) {
		    		if (movie_database.movie_database.get(i).title.equals(item)) {
		    			selected_movie = movie_database.movie_database.get(i);
		    		}
		    	}
    			
    			movie_database.removeMovie(selected_movie);
    			success.setText(selected_movie.title + " successfully deleted.");
    			wasDeleted = true;
    		}
    	});
    	panel.add(deleteButton);
    	
    	//Success label
    	success = new JLabel("");
    	success.setBounds(10,205,500,25);
    	panel.add(success);
    	
    	//Register Button
    	registerButton = new JButton("Apply Changes");
    	registerButton.setBounds(80,265,160,25);
    	
    	registerButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String title = titleText.getText();
    			String actors = actorsText.getText();
    			String director = directorText.getText();
    			String releaseDate = releaseDateText.getText();
    			String price = priceText.getText();
    			String category = categoryText.getText();
    			
    			Inventory movie_database = Inventory.getInstance();
    			
    			if (!InventoryGUI.selected_title.equals("")) {
    				item = InventoryGUI.selected_title;
    			}
    			for (int i = 0; i < movie_database.movie_database.size(); i++) {
		    		if (movie_database.movie_database.get(i).title.equals(item)) {
		    			selected_movie = movie_database.movie_database.get(i);
		    		}
		    	}
    			
    			if (wasDeleted == false) {
    				if (!title.equals("") || !actors.equals("") || !director.equals("") || !releaseDate.equals("") || !price.equals("") || !category.equals("")) {
        				if (!title.equals("")) {
            				selected_movie.setTitle(title);
            				success.setText("Title updated");
            			}
            			
            			if (!actors.equals("")) {
            				selected_movie.setActorsString(actors);
            				success.setText("Actors updated");
            			}
            			
            			if (!director.equals("")) {
            				selected_movie.setDirectorsString(director);
            				success.setText("Directors updated");
            			}
            			
            			if (!releaseDate.equals("")) {
            				selected_movie.setReleaseDateString(releaseDate);
            				success.setText("Date updated");
            			}
            			
            			if (!price.equals("")) {
            				selected_movie.setPriceString(price);
            				success.setText("Price updated");
            			}
            			
            			if (!category.equals("")) {
            				selected_movie.setCategoryString(category);
            				success.setText("Categories updated");
            			}
        			}
        			
        			else {
        				success.setText("Nothing has been changed.");
        			}
    			}
    			else {
    				success.setText("Movie was deleted.");
    			}
    			
    			
    		}
    	});
    	
    	panel.add(registerButton);
    	
    	//Home Button
    	homeButton = new JButton("Return to Home");
    	homeButton.setBounds(80,295,160,25);
    	
    	homeButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			new SystemAdminHome();
    			frame.setVisible(false);
    			titleText.setText("");
    			actorsText.setText("");
    			directorText.setText("");
    			releaseDateText.setText("");
    			priceText.setText("");
    			categoryText.setText("");
    			success.setText("");
    		}
    	});
    	
    	panel.add(homeButton);
    	
    	
    	
		frame.setVisible(true);
	}

}

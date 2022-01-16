package videoco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddMovieGUI {
	
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
	
	public static JLabel idLabel;
	public static JTextField idText;
	
	public static JButton deleteButton;
	public static JButton registerButton;
	public static JButton homeButton;
	public static JLabel success;
	
	
	String item = "";
	
	boolean wasDeleted = false;
	
	public AddMovieGUI() {
		
		Inventory movie_database = Inventory.getInstance();
		
		final JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		//Setup the frame
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setTitle("Add Movie");
		
		panel.setLayout(null);
		
		//Title label
    	titleLabel = new JLabel("Add Title");
    	titleLabel.setBounds(10,20,120,25);
    	panel.add(titleLabel);
    	
    	//Title textbox
    	titleText = new JTextField();
    	titleText.setBounds(160,20,165,25);
    	panel.add(titleText);
    	
    	//Actors label
    	actorsLabel = new JLabel("Add Actors");
    	actorsLabel.setBounds(10,50,120,25);
    	panel.add(actorsLabel);
    	
    	//Actors textbox
    	actorsText = new JTextField();
    	actorsText.setBounds(160,50,165,25);
    	panel.add(actorsText);
    	
    	//Director label
    	directorLabel = new JLabel("Add Directors");
    	directorLabel.setBounds(10,80,120,25);
    	panel.add(directorLabel);
    	
    	//Director textbox
    	directorText = new JTextField();
    	directorText.setBounds(160,80,165,25);
    	panel.add(directorText);
    	
    	//Date label
    	releaseDateLabel = new JLabel("Add Date");
    	releaseDateLabel.setBounds(10,110,120,25);
    	panel.add(releaseDateLabel);
    	
    	//Date textbox
    	releaseDateText = new JTextField();
    	releaseDateText.setBounds(160,110,165,25);
    	panel.add(releaseDateText);

    	//Price label
    	priceLabel = new JLabel("Add Price");
    	priceLabel.setBounds(10,140,120,25);
    	panel.add(priceLabel);
    	
    	//Price textbox
    	priceText = new JTextField();
    	priceText.setBounds(160,140,165,25);
    	panel.add(priceText);
    	
    	//Category label
    	categoryLabel = new JLabel("Add Category");
    	categoryLabel.setBounds(10,170,120,25);
    	panel.add(categoryLabel);
    	
    	//Category textbox
    	categoryText = new JTextField();
    	categoryText.setBounds(160,170,165,25);
    	panel.add(categoryText);
    	
    	//ID label
    	idLabel = new JLabel("Add Movie ID");
    	idLabel.setBounds(10,200,120,25);
    	panel.add(idLabel);
    	
    	//ID textbox
    	idText = new JTextField();
    	idText.setBounds(160,200,165,25);
    	panel.add(idText);
    	
    	
    	
    	//Register Button
    	deleteButton = new JButton("Add Movie");
    	deleteButton.setBounds(80,265,160,25);
    	deleteButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			Inventory movie_database = Inventory.getInstance();
    			
    			if (!titleText.getText().isBlank() && !actorsText.getText().isBlank() && !directorText.getText().isBlank() && !releaseDateText.getText().isBlank() && !priceText.getText().isBlank() && !categoryText.getText().isBlank() && !idText.getText().isBlank()) {
    				String title = titleText.getText();
        			ArrayList<String> actors = getArrayFromString(actorsText.getText());
        			ArrayList<String> directors = getArrayFromString(directorText.getText());
        			int date = Integer.parseInt(releaseDateText.getText());
        			double price = Double.parseDouble(priceText.getText());
        			ArrayList<String> category = getArrayFromString(categoryText.getText());
        			int id = Integer.parseInt(idText.getText());
        			
    				Movie movie1 = new Movie(title, actors, directors, date, price, category, id);
    				movie_database.addMovie(movie1);
    				success.setText("Movie successfully added.");
    			}
    			else {
        			success.setText("Please fill all required fields.");
    			}

    		}
    	});
    	panel.add(deleteButton);
    	
    	//Success label
    	success = new JLabel("");
    	success.setBounds(10,235,500,25);
    	panel.add(success);
    	
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
	
	public ArrayList<String> getArrayFromString(String str){
		String[] elements = str.split(",");
		List<String> fixedLenghtList = Arrays.asList(elements);
		ArrayList<String> listOfString = new ArrayList<String>(fixedLenghtList);
		return listOfString;
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
		new AddMovieGUI();
    }

}

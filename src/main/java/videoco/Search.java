package videoco;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Search {
	
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	
	public static JLabel welcomeLabel;
	
	public static JButton byTitleButton;
	public static JButton byCategoryButton;
	public static JButton byAllButton;
	public static JButton homeButton;
	
	public Search() {
		//Setup the frame
		frame.setSize(350,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setTitle("VideoCo Search");
		
		panel.setLayout(null);
		
		//Welcome label
    	welcomeLabel = new JLabel("Select how you would like to search your movie");
    	welcomeLabel.setBounds(10,20,800,25);
    	panel.add(welcomeLabel);
    	
    	//By Title Button
    	byTitleButton = new JButton("Search by Title");
    	byTitleButton.setBounds(10,50,150,25);
    	byTitleButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new SearchByTitle();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(byTitleButton);
    	
    	//By Category Button
    	byCategoryButton = new JButton("Search by Category");
    	byCategoryButton.setBounds(10,80,150,25);
    	byCategoryButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new SearchByCategory();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(byCategoryButton);
    	
    	//By All Button
    	byAllButton = new JButton("Search by All");
    	byAllButton.setBounds(10,110,150,25);
    	byAllButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new SearchByAll();
    	        frame.setVisible(false);
    		}
    	});
    	panel.add(byAllButton);
    	
    	//Home Button
    	homeButton = new JButton("Return to Home");
    	homeButton.setBounds(10,160,150,25);
    	homeButton.addActionListener(new ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			new Home();
    			frame.setVisible(false);
    		}
    	});
    	panel.add(homeButton);
    	
    	frame.setVisible(true);
	}
	
	public static void main(String[] args) {
    	new Search();
    }

}

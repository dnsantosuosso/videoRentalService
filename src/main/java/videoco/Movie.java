package videoco;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Movie {
	public String title;
	public ArrayList<String> actors;
	public ArrayList<String> directors;
	public int releaseDate;
	public double price;
	public String description;
	public ArrayList<String> category;	//list of genres
	public int id;;	//no two movies should have the same id
	
	public Movie(String title, ArrayList<String> actors, ArrayList<String> directors, int releaseDate, double price, ArrayList<String> category, int id) {
		this.title = title;
		this.actors = actors;
		this.directors = directors;
		this.releaseDate = releaseDate;
		this.price = price;
		this.category = category;
		this.id = id;
	}

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public double setPrice(double new_price) {
		this.price = new_price;
		return this.price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String setDescription(String new_description) {
		this.description = new_description;
		return this.description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String changeTitle(String new_title) {
		this.title = new_title;
		return this.title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getActors() {
		StringBuilder sb = new StringBuilder();
		for (String s : actors)
		{
		    sb.append(s);
		    sb.append(", ");
		}
		
		return sb.toString().substring(0, sb.toString().length()-2);
	}
	
	public String getDirectors() {
		StringBuilder sb = new StringBuilder();
		for (String s : directors)
		{
		    sb.append(s);
		    sb.append(", ");
		}
		
		return sb.toString().substring(0, sb.toString().length()-2);
	}
	
	public String getCategories() {
		
		StringBuilder sb = new StringBuilder();
		for (String s : category)
		{
		    sb.append(s);
		    sb.append(", ");
		}
		
		return sb.toString().substring(0, sb.toString().length()-2);
	}
	
	public int getReleaseDate() {
		return this.releaseDate;
	}
	
	public String setTitle(String new_title) {
		title = new_title;
		return title;
	}
	
	public ArrayList<String> setActorsString(String new_actors) {
		String[] elements = new_actors.split(",");
		List<String> fixedLenghtList = Arrays.asList(elements);
		ArrayList<String> listOfString = new ArrayList<String>(fixedLenghtList);
		this.actors = listOfString;
		return this.actors;
	}
	
	public ArrayList<String> setDirectorsString(String new_directors) {
		String[] elements = new_directors.split(",");
		List<String> fixedLenghtList = Arrays.asList(elements);
		ArrayList<String> listOfString = new ArrayList<String>(fixedLenghtList);
		this.directors = listOfString;
		return this.directors;
	}
	
	public ArrayList<String> setCategoryString(String new_category) {
		String[] elements = new_category.split(",");
		List<String> fixedLenghtList = Arrays.asList(elements);
		ArrayList<String> listOfString = new ArrayList<String>(fixedLenghtList);
		this.category = listOfString;
		return this.category;
	}
	
	//Pre-condition: input must be only numbers
	public int setReleaseDateString(String new_date) {
		int dat = Integer.parseInt(new_date);
		this.releaseDate = dat;
		return this.releaseDate;
	}
	
	public double setPriceString(String new_price) {
		double pric = Double.parseDouble(new_price);
		this.price = pric;
		return this.price;
	}
	
	public int setReleaseDate(int new_date) {
		this.releaseDate = new_date;
		return this.releaseDate;
	}
	
	public String setActors(ArrayList<String> new_actors) {
		this.actors = new_actors;
		return this.getActors();
	}
	
	public String setDirectors(ArrayList<String> new_directors) {
		this.directors = new_directors;
		return this.getDirectors();
	}
	
	public String setCategory(ArrayList<String> new_category) {
		this.category = new_category;
		return this.getCategories();
	}
	
	
	

}

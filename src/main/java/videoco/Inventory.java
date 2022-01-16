package videoco;

import java.util.ArrayList;

public class Inventory {
	
	private static Inventory inventory;
	public ArrayList<Movie> movie_database = new ArrayList<Movie>();
	public ArrayList<Movie> movie_outOfStock = new ArrayList<Movie>();
	
	private Inventory() {
		//Constructor sets up Movie Database...
		
		//MOVIE 1: The Invisible Guest
		ArrayList<String> movie1_actors = new ArrayList<String>();
		movie1_actors.add("Mario Casas");
		movie1_actors.add("Barbara Lennie");
		movie1_actors.add("Jose Coronado");
		movie1_actors.add("Tomas Garrido");
		
		ArrayList<String> movie1_directors = new ArrayList<String>();
		movie1_directors.add("Oriol Paulo");
		movie1_directors.add("Diego Santosuosso");
		
		ArrayList<String> movie1_category = new ArrayList<String>();
		movie1_category.add("Suspense");
		movie1_category.add("Drama");
		movie1_category.add("Family");
		
		Movie movie1 = new Movie("The Invisible Guest", movie1_actors, movie1_directors, 2018, 3.99, movie1_category, 1);
		movie1.setDescription("<html>A successful businessman accused of murder<br>must come up with an impecable defense <br>in order to save his reputation.</html>");
		
		//MOVIE 2: Toy Story 3
		ArrayList<String> movie2_actors = new ArrayList<String>();
		movie2_actors.add("Woody");
		movie2_actors.add("Andy");
		movie2_actors.add("Buzz Light Year");
		
		ArrayList<String> movie2_directors = new ArrayList<String>();
		movie2_directors.add("Disney Pixar");
		
		ArrayList<String> movie2_category = new ArrayList<String>();
		movie2_category.add("Family");
		movie2_category.add("Comedy");
		
		Movie movie2 = new Movie("Toy Story 3", movie2_actors, movie2_directors, 2010, 2.99, movie2_category, 2);
		movie2.setDescription("<html>A movie that takes place in a world where toys come <br>to life. It shows the relationship between cowboy <br>Woody and astronaut Buzz Light Year.</html>");
		
		
		//MOVIE 3: Money Heist
		ArrayList<String> movie3_actors = new ArrayList<String>();
		movie3_actors.add("Ursula Corbero");
		movie3_actors.add("Alvaro Morte");
		movie3_actors.add("Itziar Ituno");
		movie3_actors.add("Miguel Hernan");
		movie3_actors.add("Pedro Alonso");
		
		ArrayList<String> movie3_directors = new ArrayList<String>();
		movie3_directors.add("Alex Pina");
		movie3_directors.add("Jesus Colmenar");
		
		ArrayList<String> movie3_category = new ArrayList<String>();
		movie3_category.add("Suspense");
		movie3_category.add("Drama");
		
		Movie movie3 = new Movie("Money Heist", movie3_actors, movie3_directors, 2021, 6.99, movie3_category, 3);
		movie3.setDescription("<html>Eight thieves take hostages and lock themselves in the Royal Mint of Spain <br>as a criminal mastermind manipulates the police to carry out his plan. <br>This riveting crime series won Best Drama at the International Emmy Awards.</html>");
		
		
		//MOVIE 4: Harry Potter
		ArrayList<String> movie4_actors = new ArrayList<String>();
		movie4_actors.add("Daniel Radcliffe");
		movie4_actors.add("Emma Watson");
		movie4_actors.add("Rupert Grint");
		
		ArrayList<String> movie4_directors = new ArrayList<String>();
		movie4_directors.add("Chris Columbus");
		movie4_directors.add("J.K. Rowling");
		
		ArrayList<String> movie4_category = new ArrayList<String>();
		movie4_category.add("Family");
		movie4_category.add("Drama");
		
		Movie movie4 = new Movie("Harry Potter 1", movie4_actors, movie4_directors, 2001, 2.99, movie4_category, 4);
		movie4.setDescription("<html>In a world of wizards, Harry Potter and his friends (Hermione Granger and Ron Weasley) <br>come together to defeat Voldemort and the dark force. <br>This is the first movie of the sequel of Harry Potter films.</html>");
		
		
		//MOVIE 5: Squid Game
		ArrayList<String> movie5_actors = new ArrayList<String>();
		movie5_actors.add("Hoyeon Jung");
		movie5_actors.add("Lee Jung Jae");
		movie5_actors.add("Gong Yoo");
		
		ArrayList<String> movie5_directors = new ArrayList<String>();
		movie5_directors.add("Hwang Doyk Hyuk");
		
		ArrayList<String> movie5_category = new ArrayList<String>();
		movie5_category.add("Family");
		movie5_category.add("Suspense");
		movie5_category.add("Drama");
		
		Movie movie5 = new Movie("Squid Game", movie5_actors, movie5_directors, 2020, 5.99, movie5_category, 5);
		movie5.setDescription("<html>Squid Game focuses on a desperate group of people in South Korea. They're tricked  <br>into a deadly tournament of children's games, but then many of them volunteer to return, <br>realizing the games may be their only chance to win the money they need to survive. </html>");
		
		
		//MOVIE 6: Two and Half Men
		ArrayList<String> movie6_actors = new ArrayList<String>();
		movie6_actors.add("Charlie Sheen");
		movie6_actors.add("Jon Cryer");
		movie6_actors.add("Angus Jones");
		movie6_actors.add("Ashton Kutcher");
		
		ArrayList<String> movie6_directors = new ArrayList<String>();
		movie6_directors.add("Chuck Lorre");
		movie6_directors.add("Ashton Kutcher");
		movie6_directors.add("Charlie Sheen");
		
		ArrayList<String> movie6_category = new ArrayList<String>();
		movie6_category.add("Comedy");
		
		Movie movie6 = new Movie("Two and a Half Men", movie6_actors, movie6_directors, 2005, 2.99, movie6_category, 6);
		
		//MOVIE 7: Jumanji
		ArrayList<String> movie7_actors = new ArrayList<String>();
		movie7_actors.add("Dwayne Johnson");
		movie7_actors.add("Kevin Hart");
		
		ArrayList<String> movie7_directors = new ArrayList<String>();
		movie7_directors.add("Gyula Pados");
		
		ArrayList<String> movie7_category = new ArrayList<String>();
		movie7_category.add("Family");
		
		Movie movie7 = new Movie("Jumanji", movie7_actors, movie7_directors, 2017, 3.99, movie7_category, 7);
		
		//MOVIE 8: Star Wars
		ArrayList<String> movie8_actors = new ArrayList<String>();
		movie8_actors.add("Natalie Portman");
		movie8_actors.add("Liam Neeson");
		movie8_actors.add("Jake Lloyd");
		movie8_actors.add("Kira Nightley");
		movie8_actors.add("Hayden Christensen");
		movie8_actors.add("Samuel Jackson");
		
		ArrayList<String> movie8_directors = new ArrayList<String>();
		movie8_directors.add("George Lucas");
		
		ArrayList<String> movie8_category = new ArrayList<String>();
		movie8_category.add("Family");
		movie8_category.add("Drama");
		
		Movie movie8 = new Movie("Star Wars", movie8_actors, movie8_directors, 2017, 3.99, movie8_category, 8);
		
		//MOVIE 9: The Warning
		ArrayList<String> movie9_actors = new ArrayList<String>();
		movie9_actors.add("Aura Garrido");
		movie9_actors.add("Belen Cuesta");
		movie9_actors.add("Raul Arevalo");
		
		ArrayList<String> movie9_directors = new ArrayList<String>();
		movie9_directors.add("Daniel Calparsoro");
		
		ArrayList<String> movie9_category = new ArrayList<String>();
		movie9_category.add("Suspense");
		movie9_category.add("Drama");
		
		Movie movie9 = new Movie("The Warning", movie9_actors, movie9_directors, 2018, 3.99, movie9_category, 9);
		
		//MOVIE 10: The Purge
		ArrayList<String> movie10_actors = new ArrayList<String>();
		movie10_actors.add("Ethan Hawke");
		movie10_actors.add("Lena Headey");
		movie10_actors.add("Adelaide Kane");
		
		ArrayList<String> movie10_directors = new ArrayList<String>();
		movie10_directors.add("James De Monaco");
		
		ArrayList<String> movie10_category = new ArrayList<String>();
		movie10_category.add("Suspense");
		movie10_category.add("Drama");
		
		Movie movie10 = new Movie("The Purge", movie10_actors, movie10_directors, 2018, 3.99, movie10_category, 10);
		
		ArrayList<String> movie11_actors = new ArrayList<String>();
		movie11_actors.add("Gianluigi Santosuosso");
		movie11_actors.add("Alberto Vergara");
		movie11_actors.add("Diego Santosuosso");
		
		ArrayList<String> movie11_directors = new ArrayList<String>();
		movie11_directors.add("Default Director");
		
		ArrayList<String> movie11_category = new ArrayList<String>();
		movie11_category.add("Drama");
		
		Movie movie11 = new Movie("Good Will Hunting", movie11_actors, movie11_directors, 2018, 2.99, movie11_category, 11);
		Movie movie12 = new Movie("Pulp Fiction", movie11_actors, movie11_directors, 2018, 3.99, movie9_category, 12);
		Movie movie13 = new Movie("Rocky", movie11_actors, movie11_directors, 2018, 2.99, movie6_category, 13);
		Movie movie14 = new Movie("Hitchcock's Psycho", movie11_actors, movie11_directors, 2018, 1.99, movie5_category, 14);
		Movie movie15 = new Movie("The Magnificent Seven", movie11_actors, movie11_directors, 2018, 6.99, movie7_category, 15);
		Movie movie16 = new Movie("Eternal Sunshine", movie11_actors, movie11_directors, 2018, 5.99, movie4_category, 16);
		Movie movie17 = new Movie("3 Meters Above the Sky", movie11_actors, movie11_directors, 2018, 0.99, movie8_category, 17);
		Movie movie18 = new Movie("The Breakfast Club", movie11_actors, movie11_directors, 2018, 1.99, movie4_category, 18);
		Movie movie19 = new Movie("La Dolce Vita", movie11_actors, movie11_directors, 2018, 2.99, movie2_category, 19);
		Movie movie20 = new Movie("Shawshank Redemption", movie11_actors, movie11_directors, 2018, 3.99, movie1_category, 20);
		
		Movie movie21 = new Movie("The Godfather", movie11_actors, movie11_directors, 2018, 2.99, movie5_category, 21);
		Movie movie22 = new Movie("Spiderman", movie11_actors, movie11_directors, 2018, 3.99, movie3_category, 22);
		Movie movie23 = new Movie("The Avengers", movie11_actors, movie11_directors, 2018, 4.99, movie2_category, 23);
		Movie movie24 = new Movie("ET", movie11_actors, movie11_directors, 2018, 1.99, movie1_category, 24);
		Movie movie25 = new Movie("Back To The Future", movie11_actors, movie11_directors, 2018, 6.99, movie2_category, 25);
		Movie movie26 = new Movie("Rocky", movie11_actors, movie11_directors, 2018, 1.99, movie10_category, 26);
		Movie movie27 = new Movie("Karate Kid", movie11_actors, movie11_directors, 2018, 2.99, movie11_category, 27);
		Movie movie28 = new Movie("The Silence Of The Lambs", movie11_actors, movie11_directors, 2018, 3.99, movie2_category, 28);
		Movie movie29 = new Movie("Forrest Gump", movie11_actors, movie11_directors, 2018, 4.99, movie11_category, 29);
		Movie movie30 = new Movie("Black Mirror", movie11_actors, movie11_directors, 2018, 6.99, movie1_category, 30);
		
		Movie movie31 = new Movie("Twilight", movie11_actors, movie11_directors, 2018, 0.99, movie10_category, 31);
		Movie movie32 = new Movie("Paranormal Activity", movie11_actors, movie11_directors, 2018, 1.99, movie9_category, 32);
		Movie movie33 = new Movie("Galaxy Guardians", movie11_actors, movie11_directors, 2018, 4.99, movie8_category, 33);
		Movie movie34 = new Movie("Iron Man", movie11_actors, movie11_directors, 2018, 3.99, movie6_category, 34);
		Movie movie35 = new Movie("BatMan", movie11_actors, movie11_directors, 2018, 2.99, movie11_category, 35);
		Movie movie36 = new Movie("Wonder Woman", movie11_actors, movie11_directors, 2018, 2.99, movie5_category, 36);
		Movie movie37 = new Movie("Superman", movie11_actors, movie11_directors, 2018, 1.99, movie4_category, 37);
		Movie movie38 = new Movie("Thor", movie11_actors, movie11_directors, 2018, 2.99, movie3_category, 38);
		Movie movie39 = new Movie("Captain America", movie11_actors, movie11_directors, 2018, 0.99, movie2_category, 39);
		Movie movie40 = new Movie("1000 Ways to Die", movie11_actors, movie11_directors, 2018, 1.99, movie1_category, 40);
		
		Movie movie41 = new Movie("Hangover", movie11_actors, movie11_directors, 2018, 5.99, movie3_category, 41);
		Movie movie42 = new Movie("Hunger Games", movie11_actors, movie11_directors, 2018, 2.99, movie1_category, 42);
		Movie movie43 = new Movie("Shark", movie11_actors, movie11_directors, 2018, 3.99, movie4_category, 43);
		Movie movie44 = new Movie("A Night in the Museum", movie11_actors, movie11_directors, 2018, 1.99, movie2_category, 44);
		Movie movie45 = new Movie("Harry Sally", movie11_actors, movie11_directors, 2018, 4.99, movie5_category, 45);
		Movie movie46 = new Movie("Run", movie11_actors, movie11_directors, 2018,2.99, movie6_category, 46);
		Movie movie47 = new Movie("Scream", movie11_actors, movie11_directors, 2018, 2.99, movie9_category, 47);
		Movie movie48 = new Movie("Willy Wonka", movie11_actors, movie11_directors, 2018, 3.99, movie10_category, 48);
		Movie movie49 = new Movie("Alice in Wonderland", movie11_actors, movie11_directors, 2018, 2.99, movie11_category, 49);
		Movie movie50 = new Movie("Frankenstein", movie11_actors, movie11_directors, 2018, 1.99, movie1_category, 50);
		
		//Add descriptions
		movie6.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie7.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie8.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie9.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie10.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie11.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie12.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie13.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie14.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie15.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie16.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie17.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie18.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie19.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie20.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie21.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie22.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie23.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie24.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie25.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie26.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie27.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie28.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie29.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie30.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie31.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie32.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie33.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie34.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie35.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie36.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie37.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie38.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie39.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie40.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie41.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie42.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie43.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie44.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie45.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie46.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie47.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie48.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie49.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		movie50.setDescription("<html>This is the default description for this movie. It is about a desperate indebted <br>group of people who come together to defeat the dark forces that were left <br>behind them, and the future forces that will be ahead.</html>");
		
		
		
		this.movie_database.add(movie1);
		this.movie_database.add(movie2);
		this.movie_database.add(movie3);
		this.movie_database.add(movie4);
		this.movie_database.add(movie5);
		this.movie_database.add(movie6);
		this.movie_database.add(movie7);
		this.movie_database.add(movie8);
		this.movie_database.add(movie9);
		this.movie_database.add(movie10);
		this.movie_database.add(movie11);
		this.movie_database.add(movie12);
		this.movie_database.add(movie13);
		this.movie_database.add(movie14);
		this.movie_database.add(movie15);
		this.movie_database.add(movie16);
		this.movie_database.add(movie17);
		this.movie_database.add(movie18);
		this.movie_database.add(movie19);
		this.movie_database.add(movie20);
		this.movie_database.add(movie21);
		this.movie_database.add(movie22);
		this.movie_database.add(movie23);
		this.movie_database.add(movie24);
		this.movie_database.add(movie25);
		this.movie_database.add(movie26);
		this.movie_database.add(movie27);
		this.movie_database.add(movie28);
		this.movie_database.add(movie29);
		this.movie_database.add(movie30);
		this.movie_database.add(movie31);
		this.movie_database.add(movie32);
		this.movie_database.add(movie33);
		this.movie_database.add(movie34);
		this.movie_database.add(movie35);
		this.movie_database.add(movie36);
		this.movie_database.add(movie37);
		this.movie_database.add(movie38);
		this.movie_database.add(movie39);
		this.movie_database.add(movie40);
		this.movie_database.add(movie41);
		this.movie_database.add(movie42);
		this.movie_database.add(movie43);
		this.movie_database.add(movie44);
		this.movie_database.add(movie45);
		this.movie_database.add(movie46);
		this.movie_database.add(movie47);
		this.movie_database.add(movie48);
		this.movie_database.add(movie49);
		this.movie_database.add(movie50);
	}
	
	public void addMovie(Movie movie){
		this.movie_database.add(movie);
	}
	
	public void removeMovie(Movie movie){
		this.movie_database.remove(movie);
		this.movie_outOfStock.add(movie);
	}
	
	public void returnMovie(Movie movie) {
		this.movie_outOfStock.remove(movie);
		this.movie_database.add(movie);
	}
	
	public static Inventory getInstance() {
		if (inventory == null) {
			inventory = new Inventory();
		}
		
		return inventory;
	}

}

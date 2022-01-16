package videoco;

import java.util.ArrayList;

public class MovieDatabase {
	public ArrayList<Movie> movie_database = new ArrayList<Movie>();
	
	public MovieDatabase() {
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
		
		Movie movie1 = new Movie("The Invisible Guest", movie1_actors, movie1_directors, 2018, 3.99, movie1_category);
		
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
		
		Movie movie2 = new Movie("Toy Story 3", movie2_actors, movie2_directors, 2010, 2.99, movie2_category);
		
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
		
		Movie movie3 = new Movie("Money Hesit", movie3_actors, movie3_directors, 2021, 6.99, movie3_category);
		
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
		
		Movie movie4 = new Movie("Harry Potter 1", movie4_actors, movie4_directors, 2001, 2.99, movie4_category);
		
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
		
		Movie movie5 = new Movie("Squid Game", movie5_actors, movie5_directors, 2020, 5.99, movie5_category);
		
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
		
		Movie movie6 = new Movie("Two and a Half Men", movie6_actors, movie6_directors, 2005, 2.99, movie6_category);
		
		//MOVIE 7: Jumanji
		ArrayList<String> movie7_actors = new ArrayList<String>();
		movie7_actors.add("Dwayne Johnson");
		movie7_actors.add("Kevin Hart");
		
		ArrayList<String> movie7_directors = new ArrayList<String>();
		movie7_directors.add("Gyula Pados");
		
		ArrayList<String> movie7_category = new ArrayList<String>();
		movie7_category.add("Family");
		
		Movie movie7 = new Movie("Jumanji", movie7_actors, movie7_directors, 2017, 3.99, movie7_category);
		
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
		
		Movie movie8 = new Movie("Jumanji", movie8_actors, movie8_directors, 2017, 3.99, movie8_category);
		
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
		
		Movie movie9 = new Movie("The Warning", movie9_actors, movie9_directors, 2018, 3.99, movie9_category);
		
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
		
		Movie movie10 = new Movie("The Purge", movie10_actors, movie10_directors, 2018, 3.99, movie10_category);
		
		
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
	}
	
	public  void addMovie(Movie movie){
		this.movie_database.add(movie);
	}

}

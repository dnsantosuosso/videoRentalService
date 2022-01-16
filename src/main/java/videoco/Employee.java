package videoco;

import java.util.ArrayList;

public class Employee {
	public String name;
	public String username;
	public String password;
	public String email;
	public String address;
	public String province;
	
	Employee(String name, String username, String password, String email, String address, String province){
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.province = province;
	}
	
	public static boolean login(String usern, String pswd) {
		VideoCompany video_company = VideoCompany.getInstance();
		
		int len = video_company.employee_database_list.size();
		boolean bool = false;
		
		for (int i = 0; i < len; i = i + 1) {
			if (usern.equals(video_company.employee_database_list.get(i).username) && pswd.equals(video_company.employee_database_list.get(i).password)) {
				bool = true;
			}
		}
		return bool;
	}
	
	public boolean placeCustOrder(Customer cust) {
		return cust.placeOrder();
	}
	
	public String orderStatus(Order order, Customer cust) {
		String status = "";
		for (Order o : cust.pastOrders) {
			if (o.equals(order)) {
				status = o.getStatus();
			}
		}
		return status;
	}
	
	public void addMovie(Movie movie) {
		Inventory inventory = Inventory.getInstance();
		inventory.addMovie(movie);
	}
	
	public void removeMovie(Movie movie) {
		Inventory inventory = Inventory.getInstance();
		inventory.removeMovie(movie);
	}
	
	public void changeMovieTitle(Movie movie, String new_title) {
		movie.setTitle(new_title);
	}
	
	public void changeMovieActors(Movie movie, String new_actors) {
		movie.setActorsString(new_actors);
	}
	
	public void changeMovieDirectors(Movie movie, String new_directors) {
		movie.setDirectorsString(new_directors);
	}
	
	public void changeMovieDate(Movie movie, String new_) {
		movie.setReleaseDateString(new_);
	}
	
	public void changeMovieDescription(Movie movie, String new_) {
		movie.setDescription(new_);
	}
	
	public String getCustName(Customer cust) {
		return cust.name;
	}
	
	public String getCustEmail(Customer cust) {
		return cust.email;
	}
	
	public String getCustPassword(Customer cust) {
		return cust.password;
	}
	
	public String getCustUsername(Customer cust) {
		return cust.username;
	}
	
	public ArrayList<Order> getCustOrder(Customer cust) {
		return cust.pastOrders;
	}
	
	public void removeCustomer(Customer cust) {
		CustomerDatabase cust_data = CustomerDatabase.getInstance();
		cust_data.removeCustomer(cust);
	}
}

package videoco;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class SystemAdminTest {
	
	Customer cust1 = new Customer("Diego", "nicodemo", "2000", "nicodemo@my.yorku.ca", "299 Davos Road", "123456789", "ON" );
	Customer cust2 = new Customer("David", "davids", "1111", "david@my.yorku.ca", "40 Yonge Road", "123456789", "AB");
	Customer cust3 = new Customer("Daniel", "daniel32", "daniel", "daniel32@my.yorku.ca", "60 John Road", "123456789", "BC");
	Customer cust4 = new Customer("Derek", "derek", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
	
	Employee employee1 = new Employee("Song", "song", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
	

	//REQ-1
	@Test
	public void systemAdminLogin() {
		VideoCompany video_company = VideoCompany.getInstance();
		video_company.employee_database_list.add(employee1);
		boolean bool = Employee.login("song", "song123");
		
		Assert.assertEquals(true, bool);
	}
	
	//REQ-10, REQ-12
	@Test
	public void systemAdminPlaceOrder1() {
		//Customer calls and System Admin places order for customer
		//Customer walks in store and System admin places order for customer
		Inventory inventory = Inventory.getInstance();
		
		Movie movie1 = inventory.movie_database.get(0);
		cust1.addToCart(movie1);
		
		boolean bool = employee1.placeCustOrder(cust1);
		
		Assert.assertEquals(bool, true);
		
	}
	
	//REQ-10, REQ-12
	@Test
	public void systemAdminPlaceOrder2() {
		//Customer calls and System Admin places order for customer, OR
		//Customer walks in store and System admin places order for customer
		Inventory inventory = Inventory.getInstance();
		
		Movie movie1 = inventory.movie_database.get(0);
		Movie movie2 = inventory.movie_database.get(1);
		Movie movie3 = inventory.movie_database.get(2);
		Movie movie4 = inventory.movie_database.get(3);
		
		cust1.addToCart(movie1);
		cust1.addToCart(movie2);
		cust1.addToCart(movie3);
		cust1.addToCart(movie4);
		
		boolean bool = employee1.placeCustOrder(cust1);
		
		int loyalty = cust1.loyaltyPoints;
		Assert.assertEquals(1, loyalty);
	}
	
	//REQ-11
	@Test
	public void checkOrderStatus1() {
		//Customer calls and System Admin checks order status
		Inventory inventory = Inventory.getInstance();
		
		Movie movie1 = inventory.movie_database.get(0);
		Movie movie2 = inventory.movie_database.get(1);
		Movie movie3 = inventory.movie_database.get(2);
		Movie movie4 = inventory.movie_database.get(3);
		
		cust1.addToCart(movie1);
		cust1.addToCart(movie2);
		cust1.addToCart(movie3);
		cust1.addToCart(movie4);
		
		//system admin places cust order
		boolean bool = employee1.placeCustOrder(cust1);
		int i = cust1.pastOrders.size();
		Order order = cust1.pastOrders.get(i-1);
		
		String stat = employee1.orderStatus(order, cust1);

		Assert.assertEquals("Not delivered", stat);
	}
	
	//REQ-11
	@Test
	public void checkOrderStatus2() {
		//Customer calls and System Admin checks order status
		Inventory inventory = Inventory.getInstance();
		
		Movie movie1 = inventory.movie_database.get(0);

		
		cust1.addToCart(movie1);
		
		//customer places own order
		cust1.placeOrder();
		int i = cust1.pastOrders.size();
		Order order = cust1.pastOrders.get(i-1);
		
		String stat = employee1.orderStatus(order, cust1);

		Assert.assertEquals("Not delivered", stat);
	}
	
	//REQ-13
	@Test
	public void cancelOrder1() {
		//Order can be cancelled because it hasn't been delivered
		Inventory inventory = Inventory.getInstance();
		
		Movie movie1 = inventory.movie_database.get(0);
		Movie movie2 = inventory.movie_database.get(1);
		Movie movie3 = inventory.movie_database.get(2);
		Movie movie4 = inventory.movie_database.get(3);
		
		cust1.addToCart(movie1);
		cust1.addToCart(movie2);
		cust1.addToCart(movie3);
		cust1.addToCart(movie4);
		
		//system admin places cust order
		boolean bool = employee1.placeCustOrder(cust1);
		int i = cust1.pastOrders.size();
		Order order = cust1.pastOrders.get(i-1);
		
		Warehouse warehouse = Warehouse.getInstance();
		boolean cancelled = warehouse.cancel(order);
		
		//order can be cancelled because it hasn't been delivered
		Assert.assertEquals(cancelled, true);
	}
	
	//REQ-13
	@Test
	public void cancelOrder2() {
		//Order can be cancelled because it hasn't been delivered
		Inventory inventory = Inventory.getInstance();
		
		Movie movie1 = inventory.movie_database.get(0);

		
		cust1.addToCart(movie1);
		
		//customer places own order
		cust1.placeOrder();
		int i = cust1.pastOrders.size();
		Order order = cust1.pastOrders.get(i-1);
		
		Warehouse warehouse = Warehouse.getInstance();
		boolean cancelled = warehouse.cancel(order);
		
		//order can be cancelled because it hasn't been delivered
		Assert.assertEquals(cancelled, true);
	}
	
	//REQ-16
	@Test
	public void addMovie() {
		//System Admin add movie
		
		ArrayList<String> movie1_actors = new ArrayList<String>();
		movie1_actors.add("Test Actor");

		
		ArrayList<String> movie1_directors = new ArrayList<String>();
		movie1_directors.add("Oriol Paulo");
		movie1_directors.add("Diego Santosuosso");
		
		ArrayList<String> movie1_category = new ArrayList<String>();
		movie1_category.add("Suspense");
		movie1_category.add("Drama");
		
		Movie movie11 = new Movie("Movie", movie1_actors, movie1_directors, 2018, 2.99, movie1_category, 11);
		
		employee1.addMovie(movie11);
		
		Inventory inventory = Inventory.getInstance();
		boolean bool = inventory.movie_database.contains(movie11);
		Assert.assertEquals(bool, true);
	}
	
	//REQ-16
	@Test
	public void removeMovie() {
		//System Admin add movie
		
		ArrayList<String> movie1_actors = new ArrayList<String>();
		movie1_actors.add("Test Actor");

		
		ArrayList<String> movie1_directors = new ArrayList<String>();
		movie1_directors.add("Oriol Paulo");
		movie1_directors.add("Diego Santosuosso");
		
		ArrayList<String> movie1_category = new ArrayList<String>();
		movie1_category.add("Suspense");
		movie1_category.add("Drama");
		
		Movie movie11 = new Movie("Movie", movie1_actors, movie1_directors, 2018, 2.99, movie1_category, 11);
		
		employee1.addMovie(movie11);
		
		Inventory inventory = Inventory.getInstance();
		
		employee1.removeMovie(movie11);
		
		boolean bool = inventory.movie_database.contains(movie11);
		Assert.assertEquals(bool, false);
	}
	
	//REQ-17
	@Test
	public void changeMovieTitle() {
		ArrayList<String> movie1_actors = new ArrayList<String>();
		movie1_actors.add("Test Actor");

		
		ArrayList<String> movie1_directors = new ArrayList<String>();
		movie1_directors.add("Oriol Paulo");
		movie1_directors.add("Diego Santosuosso");
		
		ArrayList<String> movie1_category = new ArrayList<String>();
		movie1_category.add("Suspense");
		movie1_category.add("Drama");
		
		Movie movie11 = new Movie("Movie", movie1_actors, movie1_directors, 2018, 2.99, movie1_category, 11);
		
		employee1.addMovie(movie11);
		
		employee1.changeMovieTitle(movie11, "NEW TITLE");
		Assert.assertEquals(movie11.getTitle(), "NEW TITLE");
		
	}
	
	//REQ-17
	@Test
	public void changeMovieReleaseDate() {
		ArrayList<String> movie1_actors = new ArrayList<String>();
		movie1_actors.add("Test Actor");

		
		ArrayList<String> movie1_directors = new ArrayList<String>();
		movie1_directors.add("Oriol Paulo");
		movie1_directors.add("Diego Santosuosso");
		
		ArrayList<String> movie1_category = new ArrayList<String>();
		movie1_category.add("Suspense");
		movie1_category.add("Drama");
		
		Movie movie11 = new Movie("Movie", movie1_actors, movie1_directors, 2018, 2.99, movie1_category, 11);
		
		employee1.addMovie(movie11);
		
		employee1.changeMovieDate(movie11, "2016");
		Assert.assertEquals(movie11.getReleaseDate(), 2016);
		
	}
	
	//REQ-18
	@Test
	public void getCustEmail() {
		String email_ = employee1.getCustEmail(cust1);
		Assert.assertEquals(email_, cust1.email);
		
	}
	
	//REQ-18
	@Test
	public void getCustUser() {
		String user_ = employee1.getCustUsername(cust1);
		Assert.assertEquals(user_, cust1.username);
		
	}
	
	//REQ-18
	@Test
	public void getCustName() {
		String name_ = employee1.getCustName(cust1);
		Assert.assertEquals(name_, cust1.name);
		
	}
	
	//REQ-19
	@Test
	public void removeCustomer() {
		CustomerDatabase cust_data = CustomerDatabase.getInstance();
		cust_data.addCustomer(cust1);
		int len = cust_data.customer_database_list.size();
		employee1.removeCustomer(cust1);
		int new_len = cust_data.customer_database_list.size();
		Assert.assertEquals(len-1, new_len);
	}
	
	//REQ-19
	@Test
	public void removeCustomer2() {
		CustomerDatabase cust_data = CustomerDatabase.getInstance();
		cust_data.addCustomer(cust2);
		cust_data.addCustomer(cust3);
		cust_data.addCustomer(cust4);
		int len = cust_data.customer_database_list.size();
		employee1.removeCustomer(cust2);
		employee1.removeCustomer(cust3);
		employee1.removeCustomer(cust4);
		int new_len = cust_data.customer_database_list.size();
		Assert.assertEquals(len-3, new_len);
	}
	
	//REQ-20
	@Test
	public void addAdminAccount1() {
		VideoCompany videoco = VideoCompany.getInstance();
		int len = videoco.employee_database_list.size();
		Employee employee2 = new Employee("Song_", "song_", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
		videoco.addEmployee(employee2);
		int new_len = videoco.employee_database_list.size();
		Assert.assertEquals(len+1, new_len);
	}
	
	//REQ-20
	@Test
	public void addAdminAccount2() {
		VideoCompany videoco = VideoCompany.getInstance();
		int len = videoco.employee_database_list.size();
		Employee employee2 = new Employee("Song", "song_", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
		Employee employee3 = new Employee("Song", "song__", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
		Employee employee4 = new Employee("Song", "song___", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
		Employee employee5 = new Employee("Song", "song____", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
		
		videoco.addEmployee(employee2);
		videoco.addEmployee(employee3);
		videoco.addEmployee(employee4);
		videoco.addEmployee(employee5);
		
		int new_len = videoco.employee_database_list.size();
		Assert.assertEquals(len+4, new_len);
	}
	
	//REQ-21
	@Test
	public void removeAdminAccounts() {
		VideoCompany videoco = VideoCompany.getInstance();
		int len = videoco.employee_database_list.size();
		Employee employee2 = new Employee("Song_", "song_", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
		videoco.addEmployee(employee2);
		int new_len = videoco.employee_database_list.size();
		Assert.assertEquals(len+1, new_len);
		
		videoco.removeEmployee(employee2);
		int new_len2 = videoco.employee_database_list.size();
		
		Assert.assertEquals(len, new_len2);
	}
	
	//REQ-21
	@Test
	public void removeAdminAccounts2() {
		VideoCompany videoco = VideoCompany.getInstance();
		int len = videoco.employee_database_list.size();
		Employee employee2 = new Employee("Song", "song_", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
		Employee employee3 = new Employee("Song", "song__", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
		Employee employee4 = new Employee("Song", "song___", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
		Employee employee5 = new Employee("Song", "song____", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
		
		videoco.addEmployee(employee2);
		videoco.addEmployee(employee3);
		videoco.addEmployee(employee4);
		videoco.addEmployee(employee5);
		
		int new_len = videoco.employee_database_list.size();
		Assert.assertEquals(len+4, new_len);
		
		videoco.removeEmployee(employee2);
		videoco.removeEmployee(employee3);
		videoco.removeEmployee(employee4);
		videoco.removeEmployee(employee5);
	
		int new_len2 = videoco.employee_database_list.size();
		
		Assert.assertEquals(len, new_len2);
	}
	
	//REQ-22
	@Test
	public void updateStatus() {
		Inventory inventory = Inventory.getInstance();
		
		Movie movie1 = inventory.movie_database.get(0);
		Movie movie2 = inventory.movie_database.get(1);
		Movie movie3 = inventory.movie_database.get(2);
		Movie movie4 = inventory.movie_database.get(3);
		
		cust1.addToCart(movie1);
		cust1.addToCart(movie2);
		cust1.addToCart(movie3);
		cust1.addToCart(movie4);
		
		//system admin places cust order
		boolean bool = employee1.placeCustOrder(cust1);
		int i = cust1.pastOrders.size();
		Order order = cust1.pastOrders.get(i-1);
		
		//System Automatically sets status
		String stat = employee1.orderStatus(order, cust1);

		Assert.assertEquals("Not delivered", stat);
	}
	
	//REQ-22
	@Test
	public void updateStatus2() {
		Inventory inventory = Inventory.getInstance();
		
		Movie movie1 = inventory.movie_database.get(0);
		Movie movie2 = inventory.movie_database.get(1);
		
		cust2.addToCart(movie1);
		cust2.addToCart(movie2);
		
		//system admin places cust order
		boolean bool = employee1.placeCustOrder(cust2);
		int i = cust2.pastOrders.size();
		Order order = cust2.pastOrders.get(i-1);
		
		//System Automatically sets status
		String stat = employee1.orderStatus(order, cust2);

		Assert.assertEquals("Not delivered", stat);
	}
	
	//REQ-25
	@Test
	public void ordersSentToWarehouse() {
		Inventory inventory = Inventory.getInstance();
		
		Warehouse warehouse = Warehouse.getInstance();
		int init_siz = warehouse.warehouse_database.size();
		
		Movie movie1 = inventory.movie_database.get(0);
		Movie movie2 = inventory.movie_database.get(1);
		
		cust2.addToCart(movie1);
		cust2.addToCart(movie2);
		
		//system admin places cust order
		boolean bool = employee1.placeCustOrder(cust2);
		
		int new_siz = warehouse.warehouse_database.size();

		Assert.assertEquals(init_siz + 1, new_siz);
	}
	
	//REQ-25
	@Test
	public void ordersSentToWarehouse2() {
		Inventory inventory = Inventory.getInstance();
		
		Warehouse warehouse = Warehouse.getInstance();
		int init_siz = warehouse.warehouse_database.size();
		
		Movie movie1 = inventory.movie_database.get(0);
		Movie movie2 = inventory.movie_database.get(1);
		
		Movie movie3 = inventory.movie_database.get(2);
		Movie movie4 = inventory.movie_database.get(3);
		
		cust2.addToCart(movie1);
		cust2.addToCart(movie2);
		
		cust1.addToCart(movie3);
		cust1.addToCart(movie4);
		
		//system admin places cust order
		employee1.placeCustOrder(cust2);
		employee1.placeCustOrder(cust1);
		
		int new_siz = warehouse.warehouse_database.size();

		Assert.assertEquals(init_siz + 2, new_siz);
	}
	
	//REQ-24
	@SuppressWarnings("deprecation")
	@Test
	public void chargeExtraDollar() {
		Inventory inventory = Inventory.getInstance();
		
		Movie movie1 = inventory.movie_database.get(0);
		Movie movie2 = inventory.movie_database.get(1);
		
		cust2.addToCart(movie1);
		cust2.addToCart(movie2);
		
		
		//system admin places cust order
		employee1.placeCustOrder(cust2);
		
		int i = cust2.pastOrders.size();
		Order order = cust2.pastOrders.get(i-1);
		
		//Extra dollar not charged because it was returned on time
		int bal = cust2.owes;
		boolean bool = cust2.returnOrder(order);
		int bal2 = cust2.owes;

		//Balance is the same because customer was not charged
		Assert.assertEquals(bool, true);
		Assert.assertEquals(bal, bal2);
	}
	
	//REQ-24
	@Test
	public void chargeExtraDollar2() {
		Inventory inventory = Inventory.getInstance();
		
		Movie movie1 = inventory.movie_database.get(10);
		Movie movie2 = inventory.movie_database.get(11);
		
		cust1.addToCart(movie1);
		cust1.addToCart(movie2);
		
		
		//system admin places cust order
		employee1.placeCustOrder(cust1);
		
		int i = cust1.pastOrders.size();
		Order order = cust1.pastOrders.get(i-1);
		
		//Extra dollar not charged because it was returned on time
		int bal = cust1.owes;
		boolean bool = cust1.returnOrder(order);
		int bal2 = cust1.owes;

		//Balance is the same because customer was not charged
		Assert.assertEquals(bool, true);
		Assert.assertEquals(bal, bal2);
	}
	
	//REQ-26
	@Test
	public void sentToSubWarehouse() {
		Inventory inventory = Inventory.getInstance();
		
		Warehouse warehouse = Warehouse.getInstance();
		
		WarehouseOne warehouse1 = WarehouseOne.getInstance();
		
		WarehouseTwo warehouse2 = WarehouseTwo.getInstance();
		
		Movie movie1 = inventory.movie_database.get(10);
		Movie movie2 = inventory.movie_database.get(11);
		
		cust1.addToCart(movie1);
		cust1.addToCart(movie2);
		
		
		//system admin places cust order
		employee1.placeCustOrder(cust1);
		int len = cust1.pastOrders.size();
		Order order = cust1.pastOrders.get(len-1);
		
		
		int i = cust1.getClosestWarehouse();
		System.out.println(i);

		
		warehouse.deliver(order);
		
		String builder = "";
		
		builder = builder + warehouse1.warehouse_database.size();
		builder = builder + warehouse2.warehouse_database.size();
		
		
		boolean bool = false;
		if (builder.equals("01") || builder.equals("10")) {
			bool = true;
		}
		Assert.assertEquals(bool, true);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

package videoco;

import java.util.ArrayList;

public class Customer {
	public String name;
	public String username;
	public String password;
	public String email;
	public String address;	//Select ON if in Ontario
	public String province;
	public String creditCardNo;
	public int loyaltyPoints;
	public int numberOfOrders = 0;
	public int owes = 0;
	public ArrayList<Movie> cart = new ArrayList<Movie>();
	public ArrayList<Order> pastOrders = new ArrayList<Order>();
	public int closestWarehouse;
	
	Customer(String name, String username, String password, String email, String address, String creditCardNo, String province){
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.creditCardNo = creditCardNo;
		this.province = province;
		
		int min = 1;
		int max = 2;
		
		int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		this.closestWarehouse = random_int;
	}
	
	public boolean register(){
		LoginDatabase.addUser(username, password);
		
		CustomerDatabase customer_database = CustomerDatabase.getInstance();
		customer_database.addCustomer(this);
		return true;
	}
	
	public static boolean login(String usern, String pswd) {
		CustomerDatabase customer_database = CustomerDatabase.getInstance();
		
		int len = LoginDatabase.database.size();
		boolean bool = false;
		
		for (int i = 0; i < len; i = i + 2) {
			if (usern.equals(LoginDatabase.database.get(i)) && pswd.equals(LoginDatabase.database.get(i+1))) {
				bool = true;
			}
		}
		return bool;
	}
	
	public static int getLoyaltyPoints(String username) {
		
		CustomerDatabase customer_database = CustomerDatabase.getInstance();
		
		int len = customer_database.customer_database_list.size();
		
		//iterate through each customer in the database
		for (int i = 0; i < len; i++) {
			if ((customer_database.customer_database_list.get(i).username).equals(username)) {
				return customer_database.customer_database_list.get(i).loyaltyPoints;
			}
		}
		return -1;
	}
	
	public static String getAddress(String username) {
		CustomerDatabase customer_database = CustomerDatabase.getInstance();
		
		int len = customer_database.customer_database_list.size();
		
		//iterate through each customer in the database
		for (int i = 0; i < len; i++) {
			if ((customer_database.customer_database_list.get(i).username).equals(username)) {
				return customer_database.customer_database_list.get(i).address;
			}
		}
		return "";
	}
	
	public static String getCreditCardNo(String username) {
		CustomerDatabase customer_database = CustomerDatabase.getInstance();
		int len = customer_database.customer_database_list.size();
		
		//iterate through each customer in the database
		for (int i = 0; i < len; i++) {
			if ((customer_database.customer_database_list.get(i).username).equals(username)) {
				return customer_database.customer_database_list.get(i).creditCardNo;
			}
		}
		return "";
	}
	
	public static String getEmail(String username) {
		CustomerDatabase customer_database = CustomerDatabase.getInstance();
		
		int len = customer_database.customer_database_list.size();
		
		//iterate through each customer in the database
		for (int i = 0; i < len; i++) {
			if ((customer_database.customer_database_list.get(i).username).equals(username)) {
				return customer_database.customer_database_list.get(i).email;
			}
		}
		return "";
	}
	
	public String viewCart() {
		if (this.cart.size() >= 1) {
			StringBuilder sb = new StringBuilder();
			for (Movie m : this.cart)
			{
			    sb.append(m.title);
			    sb.append(", ");
			}
			
			return sb.toString().substring(0, sb.toString().length()-2);
		}
		return "";
	}
	
	public ArrayList<Movie> cartList(){
		ArrayList<Movie> cart_ = new ArrayList<Movie>();
		
		for (Movie m : this.cart)
		{
		    cart_.add(m);
		}
		return cart_;
	}
	
	public double getCartPrice() {
		double balance = 0;
		for (Movie m : this.cart){
			balance = balance + m.getPrice();
		}
		
		//if customer has enough loyalty points - ensures balance is always positive
		if (this.hasEnoughLoyaltyPoints()) {
			double numerator = 0.0;
			int counter = 0;
			if (this.cart.size() > 0) {
				for (Movie m : this.cart)
				{
				    numerator = numerator + m.getPrice();
				    counter++;
				}
			}
			//remove price of movie (avg price of all movies in cart)
			double avg = numerator/counter;
			balance = balance - avg;
		}
		
		//if customer is not from Ontario
		if (customerHasLateFee()){
			//extra $9.99 delivery
			balance = balance + 9.99;
		}
		
		return balance;
	}
	
	public boolean customerHasLateFee() {
		
		boolean bool = false;
		if (!this.province.equals("ON")){
			//extra $9.99 delivery
			bool = true;
		}
		return bool;
		
	}
	
	public Movie addToCart(Movie movie) {
		cart.add(movie);
		return movie;
	}
	
	public Movie deleteFromCart(Movie movie) {
		cart.remove(movie);
		return movie;
	}
	
	// MAIN OPERATIONS:
	// (1) Charge Customer: Credit Card or Loyalty Points
	// (2) Create Order and Send to Warehouse and Set Status
	// (3) Clear Cart
	// (4) Increase Number of Orders
	// (5) Add Order to Past Orders
	// (6) Increase loyalty points by 1
	// (7) Update Inventory
	
	public boolean placeOrder() {
		boolean bool = false;

		
		//if cart is not empty: perform main operations
		if (!this.cart.isEmpty()) {
			//Set bool to true
			bool = true;
			
			// (2.1) Create Order
			Order order = new Order(this);
			for (Movie m : this.cart)
			{
			    order.addMovie(m);
			}
			
			// (1.1) Charge customer (Loyalty Points)
			if (this.hasEnoughLoyaltyPoints()) {
				this.loyaltyPoints = this.loyaltyPoints - 10;
				order.paidUsingLoyalty = true;
			}		
			// (1.2) Charge customer (Credit Card)
			else {
				order.paidUsingLoyalty = false;
				this.charges(order.getOrderPrice());
			}
			
			// (3) Remove all items from cart
			this.cart.removeAll(cart);
			
			
			// (2.2) Send Order to Warehouse - will deliver in 5 seconds
			order.send();
			order.status = "Not delivered";
			
			// (4) Increase Number of Orders
			this.numberOfOrders++;
			
			// (5) Add order to previous orders
			this.pastOrders.add(order);
			
			// (6) Increase loyalty points
			this.loyaltyPoints++;
			
			// (7) Update Inventory
			Inventory inventory = Inventory.getInstance();
			for (Order o : this.pastOrders) {
				for (Movie m : o.orderList) {
					inventory.removeMovie(m);
				}
			}
		}
		
		return bool;
	}
	
	public void charges(double price) {
		// TODO Auto-generated method stub
		this.owes += price;
	}

	public boolean returnOrder(Order order) {
		boolean bool = false;
		Inventory inventory = Inventory.getInstance();
		
		int original_len = inventory.movie_database.size();
		
		int counter = 0;
		for (Movie m : order.orderList) {
			inventory.returnMovie(m);
			counter++;
		}
		
		if (inventory.movie_database.size() == original_len + counter) {
			bool = true;
		}
		
		return bool;
	}
	
	//if customer has 10 Loyalty Points
	public boolean hasEnoughLoyaltyPoints() {
		boolean bool = false;
		
		if (this.loyaltyPoints >= 10) {
			bool = true;
		}
		
		return bool;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setUsername(String username) {
		int len = LoginDatabase.database.size();
		for (int i = 0; i < len; i = i + 2) {
			if (this.username.equals(LoginDatabase.database.get(i))) {
				LoginDatabase.database.set(i, username);
			}
		}
		this.username = username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		int len = LoginDatabase.database.size();
		for (int i = 0; i < len; i = i + 2) {
			if (this.password.equals(LoginDatabase.database.get(i+1))) {
				LoginDatabase.database.set(i+1, password);
			}
		}
		this.password = password;
	}
	
	public void setAddress(String address_) {
		this.address = address_;
	}
	
	public void setCreditCard(String credit) {
		this.creditCardNo = credit;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public int getClosestWarehouse() {
		return this.closestWarehouse;
	}
	
	
	

}

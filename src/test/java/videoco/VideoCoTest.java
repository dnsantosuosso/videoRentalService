package videoco;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

//TESTING FILE FOR CUSTOMER INTERFACE
public class VideoCoTest {
	
	Customer cust1 = new Customer("Diego", "nicodemo", "2000", "nicodemo@my.yorku.ca", "299 Davos Road", "123456789", "ON" );
	Customer cust2 = new Customer("David", "davids", "1111", "david@my.yorku.ca", "40 Yonge Road", "123456789", "AB");
	Customer cust3 = new Customer("Daniel", "daniel32", "daniel", "daniel32@my.yorku.ca", "60 John Road", "123456789", "BC");
	Customer cust4 = new Customer("Derek", "derek", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");

	
	//REQ-2
	@Test
	public void test_register() {
		Assert.assertEquals(true, cust1.register());
	}
	
	@Test
	public void test_map() {
		Map<String, Double> myMap = new HashMap<String, Double>();
		myMap.put("Hello", 2.2);
		myMap.put("Hi", 3.2);
		System.out.println(myMap.keySet().toArray()[0]);
		System.out.println(myMap.get(myMap.keySet().toArray()[1]));
	}
	
	
	
	//REQ-2
	@Test
	public void test_register2() {
		//Login Database is double the size
		int len = LoginDatabase.database.size();
		Assert.assertEquals(2, len);
	}
	
	//REQ-2
	@Test
	public void test_register3() {
		boolean bool1 = cust2.register();
		boolean bool2 = cust3.register();
		boolean bool3 = cust4.register();
		
		Assert.assertEquals(bool1, bool2);
		Assert.assertEquals(bool2, bool3);
		Assert.assertEquals(bool1, true);
	}
	
	//REQ-2
	@Test
	public void test_register4() {
		//Login Database is double the size
		int len = LoginDatabase.database.size();
		Assert.assertEquals(8, len);
	}
	
	//REQ-1
	@Test
	public void login1() {
		boolean bool = false;
		//Correct password
		bool = Customer.login("nicodemo", "2000");
		Assert.assertEquals(true, bool);
	}
	
	//REQ-1
	@Test
	public void login2() {
		boolean bool = false;
		//Wrong password
		bool = !Customer.login("nicodemo", "2001");
		Assert.assertEquals(true, bool);
	}
	
	//REQ-1
	@Test
	public void login3() {
		boolean bool = false;
		//Wrong username
		bool = !Customer.login("nicodemos", "2000");
		Assert.assertEquals(true, bool);
	}
	
	//REQ-1
	@Test
	public void login4() {
		boolean bool = false;
		//Wrong username and password
		bool = !Customer.login("derek40", "Password");
		Assert.assertEquals(true, bool);
	}
	
	//REQ-1
	@Test
	public void login5() {
		boolean bool = false;
		//User 4
		bool = !Customer.login("derek", "3000");
		Assert.assertEquals(true, bool);
	}
	
	//REQ-1
	@Test
	public void login6() {
		boolean bool = false;
		//User 3
		bool = !Customer.login("daniel32", "daniel");
		Assert.assertEquals(true, bool);
	}
	
	//REQ-1
	@Test
	public void login7() {
		boolean bool = false;
		//User 2
		bool = !Customer.login("davids", "1111");
		Assert.assertEquals(true, bool);
	}
	
	//REQ-3
	@Test
	public void search1() {
		SearchByAll search = new SearchByAll();
		String found = search.searchByAllMethod("A Night");
		//comma and space (", ") is removed in GUI
		Assert.assertEquals("A Night in the Museum, ", found);
	}
	
	//REQ-3
	@Test
	public void search2() {
		SearchByAll search = new SearchByAll();
		String found = search.searchByAllMethod("Come");
		String expected = "The Avengers, Back To The Future, The Silence Of The Lambs, Iron Man, Captain America, A Night in the Museum, Run, Two and a Half Men, ";
		//comma and space (", ") is removed in GUI
		Assert.assertEquals(expected, found);
	}
	
	//REQ-4
	@Test
	public void addToCart() {
		Inventory inventory = Inventory.getInstance();
		Movie movie0 = inventory.movie_database.get(0);
		
		Movie expected_movie = cust1.addToCart(movie0);
		
		Assert.assertEquals(expected_movie, movie0);
	}
	
	//REQ-4
	@Test
	public void addToCart2() {
		Inventory inventory = Inventory.getInstance();
		Movie movie1 = inventory.movie_database.get(20);
		
		Movie expected_movie = cust1.addToCart(movie1);
		
		Assert.assertEquals(expected_movie, movie1);
		
		String got = cust1.viewCart();
		String expected = "Superman";
		
		Assert.assertEquals(got, expected);
	}
	
	//REQ-5
	@Test
	public void viewCart() {
		Inventory inventory = Inventory.getInstance();
		
		Movie movie0 = inventory.movie_database.get(30);
		cust1.addToCart(movie0);
		
		Movie movie1 = inventory.movie_database.get(31);
		cust1.addToCart(movie1);	
		
		Movie movie2 = inventory.movie_database.get(32);
		cust1.addToCart(movie2);
		
		String got = cust1.viewCart();
		String expected = "Scream, Willy Wonka, Alice in Wonderland";
		
		Assert.assertEquals(got, expected);
	}
	
	//REQ-5
	@Test
	public void viewCart2() {
		Inventory inventory = Inventory.getInstance();
		
		Movie movie0 = inventory.movie_database.get(12);
		cust1.addToCart(movie0);
		
		Movie movie1 = inventory.movie_database.get(13);
		cust1.addToCart(movie1);	
		
		Movie movie2 = inventory.movie_database.get(14);
		cust1.addToCart(movie2);
		
		String got = cust1.viewCart();
		String expected = "Rocky, Hitchcock's Psycho, The Magnificent Seven";
		
		Assert.assertEquals(got, expected);
	}
	
	//REQ-5
	@Test
	public void deleteFromCart() {
		Inventory inventory = Inventory.getInstance();
		
		Movie movie0 = inventory.movie_database.get(12);
		cust1.addToCart(movie0);
		
		Movie movie1 = inventory.movie_database.get(13);
		cust1.addToCart(movie1);	
		
		Movie movie2 = inventory.movie_database.get(14);
		cust1.addToCart(movie2);
		
		Assert.assertEquals(cust1.cartList().size(), 3);
		cust1.deleteFromCart(movie2);
		Assert.assertEquals(cust1.cartList().size(), 2);
	}
	
	
	
	@Test
	public void getID() {
		Inventory inventory = Inventory.getInstance();
		Movie movie29 = inventory.movie_database.get(28);
		
		Movie movie30 = inventory.movie_database.get(29);
		
		int id = movie29.getID();
		int id2 = movie30.getID();
		
		Assert.assertEquals(id, 41);
		Assert.assertEquals(id2, 42);
	}
	
	//REQ-6, REQ-7
	@Test
	public void placeOrder() {
		//Place 10 orders
		Inventory inventory = Inventory.getInstance();
		int enough_points = 10;
		int i = 0;
		while (i < enough_points) {
			Movie movie1 = inventory.movie_database.get(i);
			cust1.addToCart(movie1);
			cust1.placeOrder();
			i++;
		}
		int loyalty = cust1.loyaltyPoints;
		Assert.assertEquals(enough_points, loyalty);
	}
	
	//REQ-6, REQ-7
	@Test
	public void placeOrder2() {
		//Empty order
		Inventory inventory = Inventory.getInstance();
		boolean bool = cust1.placeOrder();
		Assert.assertEquals(false, bool);
	}
	
	
	@Test
	public void hasEnoughLoyaltyPoints() {
		Inventory inventory = Inventory.getInstance();
		cust1.loyaltyPoints = 10;
		boolean bool = cust1.hasEnoughLoyaltyPoints();
		
		Assert.assertEquals(true, bool);
	}
	
	@Test
	public void hasEnoughLoyaltyPoints_2() {
		Inventory inventory = Inventory.getInstance();
		cust1.loyaltyPoints = 0;
		boolean bool = cust1.hasEnoughLoyaltyPoints();
		
		Assert.assertEquals(false, bool);
	}
	
	@Test
	public void hasEnoughLoyaltyPoints_3() {
		Inventory inventory = Inventory.getInstance();
		cust1.loyaltyPoints = 9;
		boolean bool = cust1.hasEnoughLoyaltyPoints();
		
		Assert.assertEquals(false, bool);
	}
	
	@Test
	public void hasEnoughLoyaltyPoints_4() {
		Inventory inventory = Inventory.getInstance();
		cust1.loyaltyPoints = 100;
		boolean bool = cust1.hasEnoughLoyaltyPoints();
		
		Assert.assertEquals(true, bool);
	}
	
	@Test
	public void setName() {
		cust1.setName("New Diego");
		
		Assert.assertEquals("New Diego", cust1.name);
	}
	
	@Test
	public void setUsername() {
		cust1.setUsername("newuser");
		
		Assert.assertEquals("newuser", cust1.username);
	}
	
	@Test
	public void setEmail() {
		cust1.setEmail("newemail@gmail.com");
		
		Assert.assertEquals("newemail@gmail.com", cust1.email);
	}
	
	@Test
	public void setPassword() {
		cust1.setPassword("newpass");
		
		Assert.assertEquals("newpass", cust1.password);
	}
	
	@Test
	public void setAddress() {
		cust1.setAddress("New Address");
		
		Assert.assertEquals("New Address", cust1.address);
	}
	
	@Test
	public void setCreditCard() {
		cust1.setCreditCard("12345");
		
		Assert.assertEquals("12345", cust1.creditCardNo);
	}
	
	@Test
	public void setProvince() {
		cust1.setProvince("Yukon");
		
		Assert.assertEquals("Yukon", cust1.province);
	}
	
	//REQ-8
	@Test
	public void customerHasLateFee() {
		
		boolean bool = cust1.customerHasLateFee();
		
		Assert.assertEquals(false, bool);
	}
	
	//REQ-8
	@Test
	public void customerHasLateFee_2() {
		
		boolean bool = cust2.customerHasLateFee();
		
		Assert.assertEquals(true, bool);
	}
	
	//REQ-8
	@Test
	public void customerHasLateFee_3() {
		
		boolean bool = cust2.customerHasLateFee();
		
		Assert.assertEquals(true, bool);
		
		cust2.setProvince("ON");
		bool = cust2.customerHasLateFee();
		Assert.assertEquals(false, bool);
	}
	
	//REQ-8
	@Test
	public void customerHasLateFee_4() {
		cust2.setProvince("on");
		boolean bool = cust2.customerHasLateFee();
		Assert.assertEquals(true, bool);
	}
	
	//REQ-8
	@Test
	public void customerHasLateFee_5() {
		cust2.setProvince("on");
		boolean bool = cust2.customerHasLateFee();
		Assert.assertEquals(true, bool);
	}
	
	@Test
	public void movie_getPrice() {
		Inventory inventory = Inventory.getInstance();
		Movie movie1 = inventory.movie_database.get(10);
		cust1.addToCart(movie1);
		double price = cust1.getCartPrice();
		boolean bool = false;
		if (movie1.getPrice() == price) {
			bool = true;
		}
		Assert.assertEquals(true, bool);
	}
	
	@Test
	public void getCartPrice() {
		Inventory inventory = Inventory.getInstance();
		Movie movie1 = inventory.movie_database.get(1);
		cust1.addToCart(movie1);
		double price = cust1.getCartPrice();
		boolean bool = false;
		if (movie1.getPrice() == price) {
			bool = true;
		}
		Assert.assertEquals(true, bool);
	}
	
	//REQ-4
	@Test
	public void createOrder() {
		Inventory inventory = Inventory.getInstance();
		Movie movie1 = inventory.movie_database.get(1);
		Movie movie2 = inventory.movie_database.get(2);
		cust1.addToCart(movie1);
		
		Order order = new Order(cust1);
		order.addMovie(movie2);
		
		int len = order.orderList.size();
		Assert.assertEquals(1, len);
		
	}
	
	//REQ-9
	@Test
	public void updateStock() {
		//Update stock
		Inventory inventory = Inventory.getInstance();
		int original_len = inventory.movie_database.size();
		Movie movie1 = inventory.movie_database.get(1);
		Movie movie2 = inventory.movie_database.get(2);
		cust1.addToCart(movie1);
		cust1.addToCart(movie2);
		
		cust1.placeOrder();
		
		int len_2 = inventory.movie_database.size();
		
		Assert.assertEquals(original_len - 2, len_2);
	}
	
	//REQ-9
	@Test
	public void returnOrder_2() {
		//Return order and update stock
		Inventory inventory = Inventory.getInstance();
		int original_len = inventory.movie_database.size();
		Movie movie1 = inventory.movie_database.get(1);
		Movie movie2 = inventory.movie_database.get(2);
		cust1.addToCart(movie1);
		cust1.addToCart(movie2);
		
		cust1.placeOrder();
		
		int len_2 = inventory.movie_database.size();
		
		Assert.assertEquals(original_len - 2, len_2);
		
		cust1.returnOrder(cust1.pastOrders.get(0));
		
		
		int len_3 = inventory.movie_database.size();
		
		Assert.assertEquals(original_len, len_3);
		
	}
	
	//REQ-9
	@Test
	public void returnOrder_3() {
		//Return order and update stock
		Inventory inventory = Inventory.getInstance();
		int original_len = inventory.movie_database.size();
		Movie movie1 = inventory.movie_database.get(1);
		Movie movie2 = inventory.movie_database.get(2);
		cust1.addToCart(movie1);
		cust1.addToCart(movie2);
			
		cust1.placeOrder();
			
		int len_2 = inventory.movie_database.size();
			
		Assert.assertEquals(original_len - 2, len_2);
		
		boolean bool = cust1.returnOrder(cust1.pastOrders.get(0));

		Assert.assertEquals(true, bool);
			
	}
	
	//REQ-14
	@Test
	public void manageProfile() {
		cust1.setUsername("new_user");
		Assert.assertEquals(cust1.username, "new_user");	
	}
	
	//REQ-14
	@Test
	public void manageProfile2() {
		cust1.setEmail("new_email@gmail.com");
		Assert.assertEquals(cust1.email, "new_email@gmail.com");	
	}
	
	
	//REQ-14
	@Test
	public void manageProfile3() {
		cust1.setAddress("New address");
		Assert.assertEquals(cust1.address, "New address");	
	}
	
	//REQ-15
	@Test
	public void viewLoyaltyPoints() {
		int loyalty = Customer.getLoyaltyPoints(cust1.username);
		Assert.assertEquals(loyalty, 0);	
	}
	
	//REQ-15
	@Test
	public void viewLoyaltyPoints2() {
		int loyalty = Customer.getLoyaltyPoints(cust3.username);
		Assert.assertEquals(loyalty, 0);	
	}
	
	//REQ-16
	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

}

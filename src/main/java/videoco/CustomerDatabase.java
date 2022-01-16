package videoco;

import java.util.ArrayList;

public class CustomerDatabase {
	private static CustomerDatabase customer_database;
	public ArrayList<Customer> customer_database_list = new ArrayList<Customer>();
	
	private CustomerDatabase(){
		
		Customer cust1 = new Customer("Diego", "nicodemos", "2000", "nicodemo@my.yorku.ca", "299 Davos Road", "123456789", "ON" );
		Customer cust2 = new Customer("David", "davids", "1111", "david@my.yorku.ca", "40 Yonge Road", "123456789", "AB");
		Customer cust3 = new Customer("Daniel", "daniel32", "daniel", "daniel32@my.yorku.ca", "60 John Road", "123456789", "BC");
		Customer cust4 = new Customer("Derek", "derek", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust5 = new Customer("Daniela", "daniela1998", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust6 = new Customer("Vanessa", "vanevan", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust7 = new Customer("Kate", "derek", "katemovies", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust8 = new Customer("Luis Miguel", "lmiguel", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust9 = new Customer("Alberto", "albert_", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust10 = new Customer("Gianluigi", "gigolon", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust11 = new Customer("Angelo", "angoletto", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust12 = new Customer("Rita", "rits", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust13 = new Customer("Maria Luigia", "ma_luigia3000", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust14 = new Customer("Salvatore", "salva", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust15 = new Customer("Pasquale", "pasqualespos", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust16 = new Customer("Cristina", "cricri34", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust17 = new Customer("Nicodemo", "nicolino", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust18 = new Customer("Luis Augusto", "luisag13", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust19 = new Customer("Riccardo", "fickyfugs", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust20 = new Customer("Mario", "mariotto", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust21 = new Customer("Luigi", "luigi60", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust22 = new Customer("Peter", "pitspats", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust23 = new Customer("Randy", "randytheboss", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust24 = new Customer("Junior", "jrguerrero", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		Customer cust25 = new Customer("Victor", "vicbox", "3000", "derek@my.yorku.ca", "15 Richmond St", "123456789", "ON");
		
		customer_database_list.add(cust1);
		customer_database_list.add(cust2);
		customer_database_list.add(cust3);
		customer_database_list.add(cust4);
		customer_database_list.add(cust5);
		customer_database_list.add(cust6);
		customer_database_list.add(cust7);
		customer_database_list.add(cust8);
		customer_database_list.add(cust9);
		customer_database_list.add(cust10);
		customer_database_list.add(cust11);
		customer_database_list.add(cust12);
		customer_database_list.add(cust13);
		customer_database_list.add(cust14);
		customer_database_list.add(cust15);
		customer_database_list.add(cust16);
		customer_database_list.add(cust17);
		customer_database_list.add(cust18);
		customer_database_list.add(cust19);
		customer_database_list.add(cust20);
		customer_database_list.add(cust21);
		customer_database_list.add(cust22);
		customer_database_list.add(cust23);
		customer_database_list.add(cust24);
		customer_database_list.add(cust25);
		

		
	}
	
	public static CustomerDatabase getInstance() {
		if (customer_database == null) {
			customer_database = new CustomerDatabase();
		}
		return customer_database;
	}
		
	public  void addCustomer(Customer customer){
		customer_database_list.add(customer);
	}
	
	public void removeCustomer(Customer customer){
		this.customer_database_list.remove(customer);
	}
}

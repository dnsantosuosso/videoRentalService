package videoco;

import java.util.ArrayList;

public class WarehouseOne {
	
	private static WarehouseOne warehouse;
	public ArrayList<Order> warehouse_database = new ArrayList<Order>();
	
	private WarehouseOne() {
		//Constructor sets up Warehouse Database...
	}
	
	public static WarehouseOne getInstance() {
		if (warehouse == null) {
			warehouse = new WarehouseOne();
		}
		
		return warehouse;
	}
	
	//adds order to Warehouse
	public void addOrder(Order order){
		this.warehouse_database.add(order);
	}

}

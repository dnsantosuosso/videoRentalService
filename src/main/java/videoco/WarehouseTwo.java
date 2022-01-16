package videoco;

import java.util.ArrayList;

public class WarehouseTwo {
	
	private static WarehouseTwo warehouse;
	public ArrayList<Order> warehouse_database = new ArrayList<Order>();
	
	private WarehouseTwo() {
		//Constructor sets up Warehouse Database...
	}
	
	public static WarehouseTwo getInstance() {
		if (warehouse == null) {
			warehouse = new WarehouseTwo();
		}
		
		return warehouse;
	}
	
	//adds order to Warehouse
	public void addOrder(Order order){
		this.warehouse_database.add(order);
	}

}

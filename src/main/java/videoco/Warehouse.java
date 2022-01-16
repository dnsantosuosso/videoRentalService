package videoco;

import java.util.ArrayList;

public class Warehouse {
	
	private static Warehouse warehouse;
	public ArrayList<Order> warehouse_database = new ArrayList<Order>();
	public ArrayList<Order> delivered_database = new ArrayList<Order>();
	Inventory inventory = Inventory.getInstance();
	
	public static Order selected_order;
	Customer selected_customer;
	
	private Warehouse() {
		//Constructor sets up Warehouse Database...
	}
	
	public static Warehouse getInstance() {
		if (warehouse == null) {
			warehouse = new Warehouse();
		}
		
		return warehouse;
	}
	
	//adds order to Warehouse
	public void addOrder(Order order){
		this.warehouse_database.add(order);
	}
	
	//delivers order to Customer (removes order from warehouse)
	public void deliver(Order order){
		
		//update inventory
		for (Order o : this.warehouse_database) {
			if (order.equals(o)) {
				for (Movie m : order.orderList) {
					inventory.removeMovie(m);;
				}
			}
		}
		selected_order = order;
		
		
		
		this.warehouse_database.remove(order);
		this.delivered_database.add(order);
		
		CustomerDatabase cust_database = CustomerDatabase.getInstance();
		
		for (int i = 0; i < cust_database.customer_database_list.size(); i++) {
			if (order.username.equals(cust_database.customer_database_list.get(i).username)) {
				selected_customer = cust_database.customer_database_list.get(i);
			}
		}
		
		int subwarehouse = selected_customer.getClosestWarehouse();
		
		//sends order to closest warehouse from customer
		if (subwarehouse == 1) {
			WarehouseOne warehouse1 = WarehouseOne.getInstance();
			warehouse1.addOrder(selected_order);
		}
		else {
			WarehouseTwo warehouse2 = WarehouseTwo.getInstance();
			warehouse2.addOrder(selected_order);
		}
		
		//AFTER DELIVERY
		for (int i = 0; i < this.delivered_database.size(); i++) {
			this.delivered_database.get(i).status = "Delivered";
		}
		
		//Set due date in 2 weeks
		order.setDueDate();
		new DeliveredGUI();
	}
	
	//returns true if order was cancelled (meaning that it was not delivered)
	public boolean cancel(Order order) {
		boolean bool = false;
		if (order.getStatus().equals("Not delivered")) {
			this.delivered_database.remove(order);
			this.warehouse_database.add(order);
			order.status = "Cancelled";
			bool = true;
			
			order.timer.cancel();
			System.out.println("Order Cancelled");
			
			order.getCust().loyaltyPoints -= 1;
			
			//if user paid using loyalty points, revert loyalty points
			if (order.paidUsingLoyalty) {
				order.getCust().loyaltyPoints += 10; 
			}
		}
		return bool;
	}
	
	public boolean returnOrder(Order order) {
		boolean bool = false;
		
		if (order.getStatus().equals("Delivered")) {
			if (!order.getStatus().equals("Cancelled") || !order.getStatus().equals("Not delivered")) {
				this.delivered_database.remove(order);
				this.warehouse_database.add(order);
				
				//update inventory
				for (Order o : this.warehouse_database) {
					if (order.equals(o)) {
						for (Movie m : order.orderList) {
							inventory.addMovie(m);
						}
					}
				}
				order.status = "Returned";
				bool = true;
			}
		}
		return bool;
	}
	
	

}

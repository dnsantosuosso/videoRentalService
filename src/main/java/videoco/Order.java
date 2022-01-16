package videoco;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.management.timer.Timer;
import javax.swing.JFrame;

public class Order extends Thread implements Observable{
	public java.util.Timer timer = new java.util.Timer();
	public ArrayList<Movie> orderList = new ArrayList<Movie>();
	public String username;
	public String address;
	public int orderID;
	public String status;
	public String province;
	public double price = 0.0;
	public boolean paidUsingLoyalty;
	public Date due;
	
	
	public ArrayList<Observer> observerList = new ArrayList<Observer>();
	Warehouse warehouse = Warehouse.getInstance();
	
	public Order(Customer customer) {
		this.username = customer.username;
		this.address = customer.address;
		this.orderID = customer.numberOfOrders + 1;
		this.province = customer.province;
	}

	public void addMovie(Movie m) {
		// TODO Auto-generated method stub
		orderList.add(m);
		this.price = price + m.getPrice();
	}

	public void send() {
		// TODO Auto-generated method stub
		warehouse.addOrder(this);
		
		final Order order = this;
		
		//After approx 30 seconds, deliver order
		
		timer.schedule(
				new java.util.TimerTask() {
					@Override
					public void run() {
						warehouse.deliver(order);
						System.out.println("Order #" + order.orderID + " was delivered to Customer at " + order.address);
						notifyObservers();
					}
				},
				10000
				);
	}
	
	public String reviewOrder() {
		StringBuilder sb = new StringBuilder();
		if (!this.orderList.isEmpty()) {
			for (Movie s : this.orderList)
			{
			    sb.append(s.title);
			    sb.append(", ");
			}
			
			return sb.toString().substring(0, sb.toString().length()-2);
		}
		
		return "";
	}
	
	
	public String getStatus() {
		String status_ret = this.status;
		return status_ret;
	}
	
	public String getMovies() {
		
		StringBuilder sb = new StringBuilder();
		for (Movie m : this.orderList)
		{
		    sb.append(m.getTitle());
		    sb.append(", ");
		}
		
		return sb.toString().substring(0, sb.toString().length()-2);
	}
	
	public double getOrderPrice() {
		double balance = this.price;
		
		//if customer is outside of Ontario
		if (!this.province.equals("ON") || !this.province.equals("ontario") || !this.province.equals("Ontario") || !this.province.equals("ONTARIO") || !this.province.equals("on")){
			//extra $9.99 delivery
			balance = balance + 9.99;
		}
			
		return balance;
	}
	
	public Customer getCust() {
		CustomerDatabase customer_database = CustomerDatabase.getInstance();
		
		Customer cust = customer_database.customer_database_list.get(GUI.login_index);
		
		return cust;
	}
	
	public int getID() {
		return this.orderID;
	}

	public void add(Observer observer) {
		this.observerList.add(observer);
		
	}

	public void remove(Observer observer) {
		this.observerList.remove(observer);
		
	}
	
	public void setDueDate() {
		Date today = Calendar.getInstance().getTime();
		//Due in 2 weeks
		Date due = addHoursToJavaUtilDate(today, 14);
		this.due = due;
	}
	
	public Date getDueDate() {
		return this.due;
	}
	
	public Date addHoursToJavaUtilDate(Date date, int days) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, days);
	    return calendar.getTime();
	}

	public void notifyObservers() {
//		for (Observer o : this.observerList) {
//			o.update((JFrame) PastOrdersGUI.getFrames()[0]);
//		}
		
	}

}

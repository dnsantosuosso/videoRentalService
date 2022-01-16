package videoco;

import java.util.ArrayList;

public class VideoCompany {
	private static VideoCompany employee_database;
	public ArrayList<Employee> employee_database_list = new ArrayList<Employee>();
	
	private VideoCompany(){
		
		Employee employee1 = new Employee("Song", "song", "song123", "song@eecs.yorku.ca", "Toronto", "ON");
		employee_database_list.add(employee1);
		
	}
	
	public static VideoCompany getInstance() {
		if (employee_database == null) {
			employee_database = new VideoCompany();
		}
		return employee_database;
	}
		
	public  void addEmployee(Employee employee){
		employee_database_list.add(employee);
	}
	
	public void removeEmployee(Employee employee) {
		employee_database_list.remove(employee);
	}
}

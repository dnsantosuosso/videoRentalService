package videoco;

import java.util.ArrayList;

public class LoginDatabase {
	
	public static ArrayList<String> database = new ArrayList<String>();
	public static int size = 0;
	
	public static void addUser(String username, String password){
		database.add(username);
		database.add(password);
		size = size+1;
	}
}

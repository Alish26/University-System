package WSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import Admin.Admin;
import DataBase.Data;
import classes.User;

public class AdminTester implements MenuFactory, Serializable {
	
	public static void startMenu(User admin) throws Exception {
		
		String border = "";
		for(int i = 0; i < 14; i++) {
			border += "-";
		}
		
		String corner = border + "Admin" + border;
		String front = border + "Menu" + border;
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		while(true) {
			System.out.println(corner);
			System.out.println(front);
			System.out.println("1. Add User\n2. View Users\n3. Remove User\n4. See logs\n5. exit");
			System.out.println("Enter number: ");
			String choice = br.readLine().strip();
			
			if(choice.equals("1")) {
				
				((Admin) admin).addUser();
			}else if(choice.equals("2")) {
				
				((Admin) admin).viewUsers();
			}else if(choice.equals("3")) {
			
				((Admin) admin).removeUser();
			}else if(choice.equals("4")) {
				
				((Admin) admin).viewLogs();
			}else if(choice.equals("5")) {
				return;
			}else {
				
				System.out.println("Invalid number");
			}
		}
	}
}

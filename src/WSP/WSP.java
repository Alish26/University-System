package WSP;
import java.io.*;
import java.util.*;

import Admin.Admin;
import DataBase.Data;
import Executors.Executor;
import Managers.Manager;
import Students.Student;
import Teachers.Teacher;
import classes.Employee;
import classes.User;

public class WSP implements Serializable {
	
	public static void main(String[] args) throws Exception {
		
//		try {
//			
//			if(new File("users").exists()) {
//				Data.deserializeUsers();
//			}
//			
//			if(new File("logs").exists()) {
//				Data.deserializeLogs();
//			}
//			
//			if(new File("courseFiles").exists()) {
//				Data.deserializeCourseFiles();
//			}
//			
//			if(new File("news").exists()) {
//				Data.deserializeNews();
//			}
//			
//			if(new File("courses").exists()) {
//				Data.deserializeNews();
//			}
//			
//			if(new File("faculties").exists()) {
//				Data.deserializeFaculties();
//			}
//			
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return;
//		}
		
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String border = "";
		
		for(int i = 0; i < 14; i++) {
			border += "-";
		}
		String front = border + "Menu" + border;
		
		User admin = new Admin("Alisher", "Aip", 300000);
		Data.getUsers().add(admin);
		admin.setPassword("admin");
		Data.getLoginAndPasswords().put(admin.getLogin(), admin.getPassword());
		
		while(true) {
			System.out.println(front);
			System.out.println("Enter login: ");
			String login = br.readLine().strip();
			System.out.println("Enter password: ");
			String password = br.readLine().strip();
			
			if(!Data.getLoginAndPasswords().containsKey(login)) {
				
				System.out.println("Invalid Credentials");
			}else {
				if(!Data.getLoginAndPasswords().get(login).equals(password)) {
					
//					throw new LoginException("Invalid credentials", 400);
					System.out.println("Invalid credentials");
				}else {
					for(User user: Data.getUsers()) {
						
						if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
							
							if(user instanceof Admin) {
								AdminTester.startMenu(user);
							}
							
							if(user instanceof Student) {
								StudentTester.startMenu(user);
							}
							
							if(user instanceof Teacher) {
								TeacherTester.startMenu(user);
							}
							
							if(user instanceof Executor) {
								
							}
							
							if(user instanceof Manager) {
								ManagerTester.startMenu(user);
							}
						}
					}
				}
			}
			
		}
	}
}

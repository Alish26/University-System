package WSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import DataBase.Data;
import Managers.Manager;
import Teachers.Teacher;
import classes.User;

public class TeacherTester implements MenuFactory, Serializable {
	
	public static void startMenu(User user) throws IOException, LoginException, ClassNotFoundException {
		
		String border = "";
		for(int i = 0; i < 14; i++) {
			border += "-";
		}
		
		String corner = border + "Teacher" + border;
		String front = border + "Menu" + border;
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		Teacher teacher = ((Teacher) user);
		while(true) {
			System.out.println(corner);
			System.out.println(front);
			
			System.out.println("1. View student information\n2. Put Mark\n3. Put Attendace\n"
					+ "4. Add Course file\n5. Exit");
			
			String choice = br.readLine().strip();
			
			switch(choice) {
			
				case "1":
					
					System.out.println(teacher.getInfoAboutStudent());
					break;
				case "2":
					
					teacher.putMark();
					break;
				case "3":
					
					teacher.putAttendance();
					break;
				case "4":
					
					teacher.addFile();
					break;
				case "5":
					return;
				default:
					System.out.println("Invalid number");
			}
		
		}
	}
}

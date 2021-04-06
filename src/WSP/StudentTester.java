package WSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import Admin.Admin;
import DataBase.Data;
import Managers.Post;
import Students.Student;
import classes.User;

public class StudentTester implements MenuFactory, Serializable {
	
	public static void startMenu(User user) throws IOException, LoginException, ClassNotFoundException {
		
		String border = "";
		for(int i = 0; i < 14; i++) {
			border += "-";
		}
		
		String corner = border + "Student" + border;
		String front = border + "News" + border;
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		Student student = (Student)user;
		
		System.out.println(corner);
		System.out.println(front);
		
		student.viewNews();
		corner = border + "Menu" + border;
		
		while(true) {
			System.out.println(corner);
			System.out.println(front);
			
			
			System.out.println("1. View marks \n2. View transcript\n3. View journal\n4. Register for Course\n"
					+ "5. Drop Course\n6. View News\n7. Exit"
		);
			System.out.println("Enter number: ");
			String choice = br.readLine().strip();
			
			if(choice.equals("1")) {
				
				System.out.println(student.viewMarks());
			}else if(choice.equals("2")) {
				
				student.viewTranscript();
			}else if(choice.equals("3")) {
			
				student.viewJournal();
			}else if(choice.equals("4")) {
				
				student.registerForCourse();
			}else if(choice.equals("5")) {
				
				student.dropCourse();
			}else if(choice.equals("6")) {
				
				student.viewNews();
			}else if(choice.equals("7")) {
				return;
			}else {
				
				System.out.println("Invalid number");
			}
		}
	}
}

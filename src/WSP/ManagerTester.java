package WSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import DataBase.Data;
import Managers.Manager;
import Managers.Post;
import Teachers.Course;
import Teachers.Faculty;
import Teachers.Teacher;
import classes.User;

public class ManagerTester implements MenuFactory, Serializable {

	public static void startMenu(User user) throws IOException, LoginException, ClassNotFoundException {
		
		String border = "";
		for(int i = 0; i < 14; i++) {
			border += "-";
		}
		
		String corner = border + "Manager" + border;
		String front = border + "Menu" + border;
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		Manager manager = ((Manager) user);
		while(true) {
			System.out.println(corner);
			System.out.println(front);
			
			System.out.println("1. View student information\n2. View Teacher information\n3. View Course information\n"
					+ "4. Add Course for registration\n5. Assign Course for Teacher\n6. Add Course\n"
					+ "7. Manage News\n8. Exit");
			
			String choice = br.readLine().strip();
			
			switch(choice) {
			
				case "1":
					manager.viewStudentInformation();
					break;
				case "2":
					manager.viewTeacherInformation();
					break;
				case "3":
					manager.viewCourseInformation();
					break;
				case "4":
					manager.addCourseForRegistration();
					break;
				case "5":
					manager.assigneCourseForTeacher();
					break;
				case "6":
					manager.addCourse();
					break;
				case "7":
					manager.manageNews();
					break;
				case "8":
					return;
			}
		
		}
	}
}

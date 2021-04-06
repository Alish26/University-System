package Admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import DataBase.Data;
import Executors.Executor;
import Managers.Manager;
import Students.DEGREE;
import Students.Student;
import Teachers.FACULTIES;
import Teachers.Teacher;
import classes.Employee;
import classes.User;

public class Admin extends Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
	// Admin Constructor - Takes parameters of parent class Employee
	public Admin(String firstName, String lastName, int salary) {
		super(firstName, lastName, salary);
	}
	
	public void addToDatabase(User user, String log) {
		Data.getUsers().add(user);
		Data.getLoginAndPasswords().put(user.getLogin(), user.getPassword());
		Data.getLogs().add(log);
	}
	
	//addUser() -  read parameters from console, creates then adds new User to database
	public void addUser() throws Exception {
		int salary;
		
		String space = "";
		
		for(int i = 0; i < 7; i++) {
			space += " ";
		}
		
		System.out.println("1. Enter first name:");
		String firstName = br.readLine().strip();
		
		System.out.println("2.Enter last name:");
		String lastName = br.readLine().strip();
		System.out.println("3.Enter type of User:");
		
		String message = space + "1. Admin\n" + space + "2. Teacher\n" +space + "3. Student\n" + space
				+ "4. Manager\n" + space + "5. Executor";
		
		System.out.println(message);
		String typeOfUser = br.readLine().strip();
		
		String log;
		
		if(firstName.isEmpty() || lastName.isEmpty()) {
			System.out.println("Fill fields correctly");
		}
		
		switch(typeOfUser) {
		
			case "Admin":
				System.out.println("Enter salary of Admin: ");
				salary = Integer.parseInt(br.readLine().strip());
				
				log = "User " + firstName + " " + lastName + " role: Admin"+ " successfully added.";
				System.out.println(log);
				
				Admin admin = new Admin(firstName, lastName, salary);
				System.out.println("Login: " + admin.getLogin() + " Password: " + admin.getPassword());
				
				addToDatabase(admin, log);
				break;
				
			case "Manager":
				System.out.println("Enter salary of Manager: ");
				salary = Integer.parseInt(br.readLine().strip());
				log = "User: " + firstName + " " + lastName + "\nrole: Manager"+ "\nsuccessfully added.";
				System.out.println(log);
				
				Manager manager = new Manager(firstName, lastName, salary);
				System.out.println("Login: " + manager.getLogin() + " Password: " + manager.getPassword());
				
				addToDatabase(manager, log);
				break;
				
			case "Executor":
				System.out.println("Enter salary of Admin: ");
				salary = Integer.parseInt(br.readLine().strip());
				log = "User: " + firstName + " " + lastName + "\nrole: Executor"+ "\nsuccessfully added.";
				System.out.println(log);
				
				Executor executor = new Executor(firstName, lastName, salary);
				System.out.println("Login: " + executor.getLogin() + " Password: " + executor.getPassword());
				
				addToDatabase(executor, log);
				break;
			
			case "Teacher":
				System.out.println("Enter salary of Teacher: ");
				salary = Integer.parseInt(br.readLine().strip());
				System.out.println("Enter faculty of Teacher(with words): ");
				System.out.println("BS, FEOGI, FIT, ISE, KMA, MCM, SCE");
				
				String faculty = br.readLine().strip();
				Teacher teacher = new Teacher(firstName, lastName, salary, FACULTIES.valueOf(faculty));
				log = "User " + firstName + " " + lastName + " role: Teacher"+ " successfully added.";
				System.out.println(log);
				
				
				System.out.println("Login: " + teacher.getLogin() + " Password: " + teacher.getPassword());
				addToDatabase(teacher, log);
				break;
				
			case "Student":
				System.out.println("Enter year of study: ");
				int yearOfStudy = Integer.parseInt(br.readLine().strip());
				System.out.println("Enter degree(number): ");
				System.out.println("1. Bachelors\n2. Maters\n3. Foundation");
				int choice = Integer.parseInt(br.readLine().strip());
				DEGREE degree = DEGREE.BACHERLOR;
				if(choice == 1) {
					degree = DEGREE.BACHERLOR;
				}else if(choice == 2) {
					degree = DEGREE.MASTER;
				}else if(choice == 3){
					degree = DEGREE.FOUNDATION;
				}else {
					System.out.println("Invalid number");
				}
				
				System.out.println("Enter Faculty: ");
				
				
				log = "User: " + firstName + " " + lastName + "\nRole: Student"+ "\nSuccessfully added";
				Student student = new Student(firstName, lastName, degree, yearOfStudy);
				System.out.println(log);
				System.out.println("Login: " + student.getLogin() + "\nPassword: " + student.getPassword());
				addToDatabase(student,  log);
				break;
		}
	}
	
	/**
    * The removeUser() method deletes all information about User from Data
    * @throws IOException If an input or output
    *                      exception occurred
    */
	public void removeUser() throws IOException {
		System.out.println("Enter id of removing user: ");
		String id = br.readLine().strip();
		User u = Data.findUserById(id);
		if(u == null) {
			System.out.println("User with this id is not exist.");
			return;
		}
		String log = "User: " + u.getFirstName() + u.getLastName() + " was removed.";
		Data.getLoginAndPasswords().remove(u.getLogin());
		Data.getUsers().remove(u);
		Data.getLogs().add(log);
		
		System.out.println(log);
	}
	/**
    * The viewUsers() method outputs to console information about Users
    */
	public void viewUsers() {
		for(User u : Data.getUsers()) {
			System.out.println(u);
		}
	}
	/**
     * The viewLogs() method outputs all of the operations in chronological order
     */
	public void viewLogs() {
		for(String logs : Data.getLogs()) {
			System.out.println("\n" + logs + "\n");
		}
	}
}

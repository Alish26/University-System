package Managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Vector;

import DataBase.Data;
import Students.Student;
import Teachers.Course;
import Teachers.CourseFile;
import Teachers.Faculty;
import Teachers.Teacher;
import classes.Employee;
import classes.User;

public class Manager extends Employee implements ManageNews, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	public Manager(String firstName, String lastName, int salary) {
		super(firstName, lastName, salary);
	}
	
	public void manageNews() throws IOException {
		System.out.println("1. Add News\n2. Delete News");
		System.out.println("Enter number: ");
		int choice = Integer.parseInt(br.readLine().strip());
		if(choice == 1) {
			addPost();
		}else if(choice == 2) {
			deletePost();
		}else {
			System.out.println("Invalid number");
		}
	}
	
	public void addPost() throws IOException {
		System.out.println("Enter title of a post: ");
		String postTitle = br.readLine().strip();
		String text = "";
		System.out.println("Type text of a post(# to exit): ");
		char ch = (char)br.read();
		while(ch != '#') {
			text += ch;
			ch = (char)br.read();
		}
		Post post = new Post(postTitle, text);
		Data.getNews().add(post);
		String log = "Post added.";
		System.out.println(log);
		Data.getLogs().add(log);
	}
	
	public void deletePost() throws IOException {
		System.out.println("Enter title of removing post:");
		String postTitle = br.readLine().strip();
		Data.getNews().remove(Data.findPost(postTitle));
		String log = "Post removed";
		System.out.println(log);
		Data.getLogs().add(log);
	}
	
	public void viewTeacherInformation() throws IOException {
		System.out.println("Enter Teacher login: ");
		String login = br.readLine().strip();
		Teacher teacher = findTeacherByLogin(login);
		System.out.println(teacher);
	}
	
	public Teacher findTeacherByLogin(String login) {
		for(User user : Data.getUsers()) {
			if(user.getLogin().equals(login)) {
				return (Teacher) user;
			}
		}
		return null;
	}
	
	public Course findCourse(String title) {
		for(Course course : Data.getCourses()) {
			if(course.getCourseTitle().equals(title)) {
				return course;
			}
		}
		
		return null;
	}
	
	public void assigneCourseForTeacher() throws IOException {
		System.out.println("Enter Teacher login: ");
		String login2 = br.readLine().strip();
		Teacher teacher = findTeacherByLogin(login2);
		System.out.println("Enter course title: ");
		String courseTitle2 = br.readLine().strip();
		Course course2 = findCourse(courseTitle2);
		teacher.getCourses().add(course2);
		System.out.println(course2 + "successfully added.");
	} 
	
	public void addCourseForRegistration() throws IOException {
		System.out.println("Enter faculty: ");
		String facultyName = br.readLine().strip();
		Faculty faculty = Data.findFaculty(facultyName);
		System.out.println("Enter course title: ");
		String courseTitle = br.readLine().strip();
		Course course = findCourse(courseTitle);
		System.out.println(course + "successfully added.");
		faculty.getCourses().add(course);
	}
	
	public void addCourse()  throws IOException {
		System.out.println("Enter course name: ");
		String courseTitle = br.readLine().strip();
		System.out.println("Enter number of course files: ");
		int n = Integer.parseInt(br.readLine().strip());
		Vector<CourseFile> courseFiles = null;
		System.out.println("Enter " + n + " names of files(one line = one name): ");
		for(int i = 0; i < n; i++) {
			System.out.println("Enter name of file: ");
			String title = br.readLine().strip();
			if(Data.findCourseFile(title) != null) courseFiles.add(Data.findCourseFile(title));
			else System.out.println("Course not found");
		}
		
		System.out.println("Enter credits of Course: ");
		int credit = Integer.parseInt(br.readLine().strip());
		System.out.println("Enter prerequisit courses number: ");
		Vector<Course> courses = new Vector<Course>();
		n = Integer.parseInt(br.readLine().strip());
		
		for(int i = 0; i < n; i++) {
			String title = br.readLine().strip();
			if(Data.findCourse(title) != null) {
				Data.getCourses().add(Data.findCourse(title));
			}else {
				System.out.println("No such Course");
			}
		}
		
		Course c = new Course(courseTitle, courseFiles, credit, courses);
		String log = "New course " + c.getCourseTitle() + " added.";
		Data.getCourses().add(c);
		Data.getLogs().add(log);
		System.out.println(log);
	}
	
	public void viewCourseInformation() throws IOException {
		System.out.println("Enter course title: ");
		String title = br.readLine().strip();
		Course course = Data.findCourse(title);
		System.out.println(course);
	}
	
	public void viewStudentInformation() throws NumberFormatException, IOException {
		Student student = null;
		System.out.println("Find student by: ");
		System.out.println("1. ID\n2. Login");
		int choice2 = Integer.parseInt(br.readLine().strip());
		if(choice2 == 1) {
			System.out.println("Enter ID: ");
			String id = br.readLine().strip();
			student = findStudentById(id);
			
		}else if(choice2 == 2) {
			System.out.println("Enter Login: ");
			String login = br.readLine().strip();
			student = findStudentByLogin(login);
		}
		System.out.println(student);
	}
	
	public Student findStudentById(String id) {
		
		for(User user : Data.getUsers()) {
			if(user.getId().equals(id)) {
				return (Student) user;
			}
		}
		
		return null;
	}
	
	public Student findStudentByLogin(String login) {
		for(User user : Data.getUsers()) {
			if(user.getLogin().equals(login)) {
				return (Student) user;
			}
		}
		
		return null;
	}
}

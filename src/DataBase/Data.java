package DataBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import Managers.Post;
import Teachers.Course;
import Teachers.CourseFile;
import Teachers.Faculty;
import classes.User;

public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Data INSTACE = new Data();
	private static HashSet<User> users = new HashSet<User>();
	private static HashMap<String, String> loginAndPasswords= new HashMap<String, String>();
	private static Vector<Course> courses = new Vector<Course>();
	private static Vector<String> logs = new Vector<String>();
	private static Vector<Faculty> faculties = new Vector<Faculty>();
	private static Vector<Post> news = new Vector<Post>(); 
	private static Vector<CourseFile> courseFiles = new Vector<CourseFile>();
	private static FileInputStream fis; 
	private static FileOutputStream fos; 
	private static ObjectOutputStream oos; 
	private static ObjectInputStream oin; 
//	private static Vector<Order> orders = new Vector<Order>();
	
	private Data() {}
	public static final Data getInstance() {
		if(INSTACE == null) return new Data();
		return INSTACE;
	}
	
	public static void desAll() throws ClassNotFoundException, IOException {
		deserializeCourseFiles();
		deserializeCourses();
		deserializeFaculties();
		deserializeLogs();
		deserializeNews();
		deserializeUsers();
	}
	
	public static void saveAll() throws IOException, ClassNotFoundException {
		serialaizeCourseFiles();
		serialaizeCourses();
		serialaizeFaculties();
		serialaizeLogs();
		serialaizeNews();
		serialaizeUsers();
	}
	
	
	public static void deserializeCourseFiles() throws IOException, ClassNotFoundException{ 
	    fis = new FileInputStream("courseFiles"); 
	    oin = new ObjectInputStream(fis); 
	    courseFiles = (Vector<CourseFile>) oin.readObject(); 
	} 
	
	public static void serialaizeCourseFiles()throws IOException{ 
	    fos = new FileOutputStream("courseFiles"); 
	    oos = new ObjectOutputStream(fos); 
	    oos.writeObject(courseFiles); 
	    oos.close(); 
	} 
	
	public static void deserializeNews() throws IOException, ClassNotFoundException{ 
	    fis = new FileInputStream("courses"); 
	    oin = new ObjectInputStream(fis); 
	    news = (Vector<Post>) oin.readObject(); 
	} 
	
	public static void serialaizeNews()throws IOException{ 
	    fos = new FileOutputStream("news"); 
	    oos = new ObjectOutputStream(fos); 
	    oos.writeObject(news); 
	    oos.close(); 
	} 
	
	public static void deserializeFaculties() throws IOException, ClassNotFoundException{ 
	    fis = new FileInputStream("faculties"); 
	    oin = new ObjectInputStream(fis); 
	    faculties = (Vector<Faculty>) oin.readObject(); 
	} 
	
	public static void serialaizeFaculties()throws IOException{ 
	    fos = new FileOutputStream("faculties"); 
	    oos = new ObjectOutputStream(fos); 
	    oos.writeObject(faculties); 
	    oos.close(); 
	} 
	
	public static void deserializeLogs() throws IOException, ClassNotFoundException{ 
	    fis = new FileInputStream("logs"); 
	    oin = new ObjectInputStream(fis); 
	    logs = (Vector<String>) oin.readObject(); 
	} 
	
	public static void serialaizeLogs()throws IOException{ 
	    fos = new FileOutputStream("logs"); 
	    oos = new ObjectOutputStream(fos); 
	    oos.writeObject(logs); 
	    oos.close(); 
	} 
	
	public static void deserializeCourses() throws IOException, ClassNotFoundException{ 
	    fis = new FileInputStream("courses"); 
	    oin = new ObjectInputStream(fis); 
	    courses = (Vector<Course>) oin.readObject(); 
	} 
	
	public static void serialaizeCourses()throws IOException{ 
	    fos = new FileOutputStream("courses"); 
	    oos = new ObjectOutputStream(fos); 
	    oos.writeObject(courses); 
	    oos.close(); 
	} 
	
	
	public static void deserializeUsers() throws IOException, ClassNotFoundException{ 
	    fis = new FileInputStream("users"); 
	    oin = new ObjectInputStream(fis); 
	    users = (HashSet<User>) oin.readObject(); 
	} 
	public static void serialaizeUsers()throws IOException, ClassNotFoundException{ 
	    fos = new FileOutputStream("users"); 
	    oos = new ObjectOutputStream(fos); 
	    oos.writeObject(users); 
	    oos.close(); 
	} 
	
	
	public static User findUserById(String id) {
		for(User u : users) {
			if(u.getId().equals(id)) return u;
		}
		return null;
	}
	
	public static Faculty findFaculty(String name) {
		for(Faculty faculty : faculties) {
			if(faculty.getFaculty().equals(name)) {
				return faculty;
			}
		}
		
		return null;
	}
	
	public static CourseFile findCourseFile(String title) {
		for(CourseFile c : courseFiles) {
			if(c.getTitle().equals(title)) {
				return c;
			}
		}
		
		return null;
	}
	
	public static Course findCourse(String title) {
		for(Course course : courses) {
			if(course.getCourseTitle().equals(title)) {
				return course;
			}
		}
		
		return null;
	}
	
	public static Post findPost(String title) {
		for(Post p : news) {
			if(p.getTitle().equals(title)) {
				return p;
			}
		}
		
		return null;
	}
	
	public static Vector<String> getLogs() {
		return logs;
	}
	
	
	public static void setLogs(Vector<String> newLogs) {
		logs = newLogs;
	}
	
	public static HashSet<User> getUsers() {
		return users;
	}
	
	public static void setUsers(HashSet<User> users) {
		Data.users = users;
	}
	
	public static HashMap<String, String> getLoginAndPasswords() {
		return loginAndPasswords;
	}
	
	public static void setLoginAndPasswords(HashMap<String, String> loginAndPasswords) {
		Data.loginAndPasswords = loginAndPasswords;
	}
	
	public static Vector<Course> getCourses() {
		return courses;
	}
	
	public static void setCourses(Vector<Course> courses) {
		Data.courses = courses;
	}
	
	public static Vector<Post> getNews() {
		return news;
	}
	
	public static void setNews(Vector<Post> news) {
		Data.news = news;
	}
	
//	public static Vector<Order> getOrders() {
//		return orders;
//	}
//	
//	public static void setOrders(Vector<Order> orders) {
//		Data.orders = orders;
//	}
}

package Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import DataBase.Data;
import Managers.Post;
import Teachers.Course;
import Teachers.Faculty;
import classes.User;

public class Student extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	private double gpa;
	private DEGREE levelOfEducation;
	private HashMap<Course, HashMap<Date, ATTENDANCE> > journal;
	private HashMap<Course, Mark> marks;
	private int yearOfStudy;
	private Faculty faculty;
	//private Vector<Course> courses;
	
	public Student(String firstName, String lastName, DEGREE degree, int yearOfStudy) {
		super(firstName, lastName);
		levelOfEducation = degree;
		this.yearOfStudy = yearOfStudy;
		journal = new HashMap<Course, HashMap<Date, ATTENDANCE>>();
		marks = new HashMap<Course, Mark>();
	}
	
	public void registerForCourse() throws IOException {
		Course c = null;
		System.out.println("Enter course name: ");
		String courseName = br.readLine().strip();
		
		c = Data.findCourse(courseName);
		if(c == null) {
			System.out.println("Course don't exits");
		}else {
			marks.put(c, new Mark());
			HashMap<Date, ATTENDANCE> innerMap = new HashMap<Date, ATTENDANCE>();
			journal.put(c, innerMap);
			System.out.println("Successfully registered. ");
			
		}
	}
	
	public void dropCourse() throws IOException {
		Course course = null;
		System.out.println("Enter course name: ");
		String courseName = br.readLine().strip();
		course = Data.findCourse(courseName);
		
		if(course == null) {
			System.out.println("Course don't exists");
			return;
		}
		marks.remove(course);
		journal.remove(course);
		System.out.println("Succesfully dropped course.");
	}
	
	public String viewTranscript() {
		String transcript = "";
		
		for(Map.Entry course : marks.entrySet()) {
			transcript += "Course: " + ((Course) course.getKey()).getCourseTitle() + " Mark: " + ((Mark) course.getValue()).getOverall() + " Gpa: " + gpa + "\n";
		}
		
		System.out.println(transcript);
		return transcript;
	}
	
	public void viewNews() throws NumberFormatException, IOException {
		while(true) {
			for(Post p : Data.getNews()) {
				System.out.println(p);
			}
			System.out.println("1. Menu\nEnter number: ");
			int choice = Integer.parseInt(br.readLine().strip());
			
			if(choice != 1) {
				System.out.println("Invalid number");
			}else break;
		}
	}
	
	public String viewJournal() {
		String res = "";
		for(Map.Entry course : journal.entrySet()) {
			res += ((Course) course.getKey()).getCourseTitle() + ": ";
			for(Map.Entry course2 : ((HashMap<Course, HashMap<Date, ATTENDANCE>>) course.getValue()).entrySet()) {
				res += "[ " + ((ATTENDANCE)course2.getValue()).toString() + " ]";
			}
		}
		System.out.println(res);
		return res;
	}
	
	
	public HashMap<Course, HashMap<Date, ATTENDANCE>> getJournal() {
		return journal;
	}

	public void setJournal(HashMap<Course, HashMap<Date, ATTENDANCE>> journal) {
		this.journal = journal;
	}

	public String viewMarks() {
		String s = "";
		for(Map.Entry course : marks.entrySet()) {
			s += " Course: " + ((Course) course.getKey()).getCourseTitle();
			s += " First Attestation: " + ((Mark) course.getValue()).getFirstAttestation();
			s += " Second Attestation: " + ((Mark) course.getValue()).getSecondAttestation();
			s += " Final Attestation: " + ((Mark) course.getValue()).getFinalAttestation();
			s += "\n";
		}
		return s;
	}
	
	public HashMap<Course, Mark> getMarks() {
		return marks;
	}
	
	public void setMarks(HashMap<Course, Mark> marks) {
		this.marks = marks;
	}
	
	public double getGpa() {
		calculateGpa();
		return gpa;
	}
	
	public void calculateGpa() {
		int totalGrades = 0, totalCredits = 0;
		for(Map.Entry course : marks.entrySet()) {
			totalGrades += ((Mark) course.getValue()).getOverall();
			totalCredits += ((Course) course.getKey()).getCredit();
		}
		double gpa = (double)totalGrades/totalCredits;
		setGpa(gpa);
	}
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public DEGREE getLevelOfEducation() {
		return levelOfEducation;
	}

	public void setLevelOfEducation(DEGREE levelOfEducation) {
		this.levelOfEducation = levelOfEducation;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Student s = (Student)obj;
		return gpa == s.getGpa();
	}
	
	public String toString() {
		return super.toString() + "\nGpa: " + gpa;
	}
	
}

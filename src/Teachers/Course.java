package Teachers;

import java.io.Serializable;
import java.util.Vector;

public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courseTitle;
	private Vector<CourseFile> courseBook;
	private int credit;
	private Vector<Course> prerequisits;
	
	public Course(String courseTitle, Vector<CourseFile> courseBook, int credit, Vector<Course> prerequisits) {
		this.courseTitle = courseTitle;
		this.courseBook = courseBook;
		this.credit = credit;
		this.prerequisits = prerequisits;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Vector<CourseFile> getCourseBook() {
		return courseBook;
	}

	public void setCourseBook(Vector<CourseFile> courseBook) {
		this.courseBook = courseBook;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Vector<Course> getPrerequisits() {
		return prerequisits;
	}

	public void setPrerequisits(Vector<Course> prerequisits) {
		this.prerequisits = prerequisits;
	}
	
	public String toString() {
		return "Title: " + courseTitle + " Credits: " + credit + "\n";
	}
}

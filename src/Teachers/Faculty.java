package Teachers;

import java.io.Serializable;
import java.util.Vector;

public class Faculty implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FACULTIES faculty;
	private Vector<Course> courses;
	
	public Faculty(FACULTIES faculty, Vector<Course> courses) {
		this.faculty = faculty;
		this.courses = courses;
	}

	public String getFaculty() {
		return faculty.toString();
	}

	public void setFaculty(FACULTIES faculty) {
		this.faculty = faculty;
	}

	public Vector<Course> getCourses() {
		return courses;
	}

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
	
	
}

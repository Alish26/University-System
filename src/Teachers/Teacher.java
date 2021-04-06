package Teachers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;


import DataBase.Data;
import Students.Student;
import classes.Employee;
import classes.User;
import Students.Mark;
import Students.ATTENDANCE;
import Students.Date;

public class Teacher extends Employee implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	    FACULTIES faculty;
	    
	    Vector<Course> courses;
	    Vector<Student> students;
	    Vector<CourseFile> courseFiles;

	    public Teacher(String firstName, String lastName, int salary, FACULTIES faculty){
	        super(firstName, lastName, salary);
	        this.faculty=faculty;
	        courseFiles = new Vector<CourseFile>();
	        courses = new Vector<Course>();
	    }

	    public void addFile() throws NumberFormatException, IOException{
	    	System.out.println("Enter number of course files: ");
			int n = Integer.parseInt(br.readLine().strip());
			System.out.println("Enter " + n + " names of files(one line = one name): ");
			for(int i = 0; i < n; i++) {
				System.out.println("Enter name of file: ");
				String title = br.readLine().strip();
				if(Data.findCourseFile(title) != null) {
					courseFiles.add(Data.findCourseFile(title));
					
					System.out.println("Course file added.");
				}
				else System.out.println("Course not found.");
			}
			
	    }
	    
	    public void deleteFile() throws IOException{
	    	System.out.println("Enter name of file: ");
			String title = br.readLine().strip();
			
			if(Data.findCourseFile(title) != null) {
				courseFiles.remove(Data.findCourseFile(title));
				
				System.out.println("Course file deleted.");
			}
			else System.out.println("Course not found.");
	    }
	    
	    public void putMark() throws NumberFormatException, IOException{
	        System.out.println("Choose course: ");
	        for(int i = 0; i < courses.size() && !courses.isEmpty(); i++) {
	        	System.out.println(i + 1 + ": " + courses.get(i));
	        }
	        int idx = 0;
	        idx = Integer.parseInt(br.readLine().strip());
	        if(idx < 1 || idx > courses.size() || courses.isEmpty()) {
	        	System.out.println("Course don't exit");
	        	return;
	        }
	        
	        Course course  = courses.get(idx - 1); 
	   
	        idx = 1;
	        Vector<Student> students = new Vector<Student>();
	        for(User user : Data.getUsers()) {
	        	
	        	if(user instanceof Student) {
	        		System.out.println(idx + " : " + user.getFirstName() +  " "+ user.getLastName());
	        		students.add(((Student)user));
	        		idx += 1;
	        	}
	        }
	        if(students.isEmpty()) {
	        	System.out.println("Students don't exits");
	        	return;
	        }
	        System.out.println("Enter student number: ");
	     
	        
	        int choice = Integer.parseInt(br.readLine().strip());
	        Student student = students.get(choice - 1);
	        System.out.println("Choose attestation: ");
	        System.out.println("1. First attestation\n2. Second Attestation\n3. Final");
	        choice = Integer.parseInt(br.readLine().strip());
	        System.out.println("Enter mark numeric value: ");
	        
	        Mark mark = student.getMarks().get(course);
	        int m = Integer.parseInt(br.readLine().strip());
	        
	        if(choice == 1) {
	        	
	        	mark.setFirstAttestation(m);
	        }else if(choice == 2) {
	        	
	        	mark.setSecondAttestation(m);
	        }else if(choice == 3) {
	        	
	        	mark.setFinalAttestation(m);
	        }else {
	        	System.out.println("Invalid number");
	        }
	    }
	    
	    public void putAttendance() throws NumberFormatException, IOException {
	    	System.out.println("Choose course: ");
	        for(int i = 0; i < courses.size() && !courses.isEmpty(); i++) {
	        	System.out.println(i + 1 + ": " + courses.get(i));
	        }
	        int idx = 0;
	        idx = Integer.parseInt(br.readLine().strip());
	        if(idx < 1 || idx > courses.size()) {
	        	System.out.println("Course don't exit");
	        	return;
	        }
	        
	        Course course  = courses.get(idx - 1); 
	        System.out.println("Enter student number: ");
	        idx = 1;
	        Vector<Student> students = new Vector<Student>();
	        for(User user : Data.getUsers()) {
	        	
	        	if(user instanceof Student) {
	        		System.out.println(idx + " : " + user.getFirstName() + user.getLastName());
	        		students.add((Student)user);
	        	}
	        	idx += 1;
	        }
	        
	        int choice = Integer.parseInt(br.readLine().strip());
	        Student student = students.get(choice - 1);
	        
	    	System.out.println("Enter day: ");
	    	int day = Integer.parseInt(br.readLine().strip());
	    	System.out.println("Enter month: ");
	        int month = Integer.parseInt(br.readLine().strip());
	        
	        System.out.println("Enter year: ");
	        int year = Integer.parseInt(br.readLine().strip());
	        
	        Date date = new Date(day, month, year);
	        
	        HashMap<Date, ATTENDANCE> innerMap = new  HashMap<Date, ATTENDANCE>();
	        ATTENDANCE att;
	        
	        System.out.println("Choose: ");
	        System.out.println("1. Participated\n2.Absent");
	        choice = Integer.parseInt(br.readLine().strip());
	        if(choice == 1) {
	        	att = ATTENDANCE.PARTICIPATED;
	        }else {
	        	att = ATTENDANCE.ABSENT;
	        }
	        
	        innerMap.put(date, att);
	        student.getJournal().put(course, innerMap);
	        System.out.println("Putted");
	    }
	    
	    public String getInfoAboutStudent() throws IOException{
	    	System.out.println("Enter student id: ");
	    	String id = br.readLine().strip();
	    	
	    	Student student = (Student) Data.findUserById(id);
	    	if(student == null) return "Invalid ID";
	        return "Name: " + student.getFirstName() + "Surname: "+student.getLastName() + "ID: "+ student.getId() + "\n";
	    }
	    
	    
	    public FACULTIES getFaculty() {
			return faculty;
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

		public Vector<Student> getStudents() {
			return students;
		}

		public void setStudents(Vector<Student> students) {
			this.students = students;
		}

}

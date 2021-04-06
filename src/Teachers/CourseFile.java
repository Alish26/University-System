package Teachers;

import java.io.Serializable;
import java.util.Vector;

public class CourseFile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String text;
	private Vector<String> authors;
	
	public CourseFile(String title, String text, Vector<String> authors) {
		this.title = title;
		this.text = text;
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Vector<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Vector<String> authors) {
		this.authors = authors;
	}
	
}

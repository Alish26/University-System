package Managers;

import java.io.Serializable;

public class Post implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String text;
	
	public Post(String title, String text) {
		this.title = title;
		this.text = text;
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
	
	public String toString() {
		String space = "";
		for(int i = 0; i < 7; i++) {
			space += " ";
		}
		
		return space + title + "\n" + text;
	}
}

package classes;

import java.io.Serializable;

public abstract class User implements Comparable<User>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String id;
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = generateLogin();
		this.password = generatePassword();
		this.id = generateId();
	}
	
	public String generateId() {
		String id = "";
		for(int i = 0; i < 8; i++) {
			id += (int)(Math.random()*10)%10;
		}
		return id;
	}
	
	public String generateLogin() {
		String newLogin = "";
		newLogin += firstName.charAt(0) + "_";
		newLogin += lastName;
		return newLogin;
	}
	
	public String generatePassword() {
		String password = "";
		password += firstName;
		for(int i = 0; i < 4; i++) {
			password += "" + (int)(Math.random() * 10) % 10; 
		}
		return password;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nID: " + id;
	}
	
	@Override
	public int compareTo(User u) {
		int compare = lastName.compareTo(u.getLastName());
		if(compare != 0) return compare;
		compare = firstName.compareTo(u.getFirstName());
		if(compare != 0) return compare;
		compare = id.compareTo(u.getId());
		return compare;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		User u = (User) obj;
		
		return  firstName.equals(u.getFirstName()) && 
				lastName.equals(u.getLastName()) &&
				login.equals(u.getLogin()) && id.equals(u.getId());
	}
	
}

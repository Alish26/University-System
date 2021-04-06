package classes;

import java.io.Serializable;

public class Employee extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int salary;
	
	public Employee(String firstName, String lastName, int salary) {
		super(firstName, lastName);
		this.salary = salary;
		
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee e = (Employee) obj;
		if (salary != e.salary)
			return false;
		return true;
	}
}

package Executors;

import java.io.Serializable;

import classes.Employee;

public class Executor extends Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Executor(String firstName, String lastName, int salary) {
		super(firstName, lastName, salary);
	}

}

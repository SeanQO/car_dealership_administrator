package model;

import java.util.ArrayList;

public class Admin extends Person {
	
	private static final long serialVersionUID = 1;
	
	private double salary;
	private int sells;
	private ArrayList<Seller> sellers;
	
	public Admin(String name, String lastname, String email, long id, int phoneNumber) {
		super(name, lastname, email, id, phoneNumber);
		
	}

}

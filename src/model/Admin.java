package model;

import java.util.ArrayList;

public class Admin extends Person {
	
	private static final long serialVersionUID = 1;
	
	private double salary;
	private int sells;
	private ArrayList<Seller> sellers;
	
	public Admin(String name, String lastname, String email, long id, long phoneNumber,
					double salary) {
		super(name, lastname, email, id, phoneNumber);
		this.salary = salary;
		
	}

	public double getSalary() {
		return salary;
	}
	
	public int getSells() {
		return sells;
	}

	public ArrayList<Seller> getSellers() {
		return sellers;
	}
	
	public void setSellers(ArrayList<Seller> sellers) {
		this.sellers = sellers; 
	}
	
	
	public boolean addSeller(Seller seller) {
		boolean added = false;
		
		return added;
		
	}
	
	public void addSell() {
		sells ++;
	}
	
	public boolean removeSeller(Seller seller) {
		boolean removed = false;
		
		return removed;
	}

}

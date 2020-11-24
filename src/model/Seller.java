package model;

public class Seller extends Person {
	
	private static final long serialVersionUID = 1;
	private static final int MAX_CLIENTS = 5;
	
	private double salary;
	private int sells;
	private Client[] inchargeOfClients;
	
	public Seller(String name, String lastname, String email, long id, int phoneNumber,
					double salary) {
		
		super(name, lastname, email, id, phoneNumber);
		
		inchargeOfClients = new Client[MAX_CLIENTS];
		this.salary = salary;
		sells = 0;
		
	}
	
	
	
}

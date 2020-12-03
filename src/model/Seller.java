package model;

public class Seller extends Person {
	
	private static final long serialVersionUID = 1;
	private static final int MAX_CLIENTS = 5;
	private double salary;
	private int sells;
	private Client[] clients;
	
	public Seller(String name, String lastname, String email, long id, Long  phoneNumber,
					double salary) {
		
		super(name, lastname, email, id, phoneNumber);
		
		clients = new Client[MAX_CLIENTS];
		this.salary = salary;
		sells = 0;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static int getMaxClients() {
		return MAX_CLIENTS;
	}

	public double getSalary() {
		return salary;
	}

	public int getSells() {
		return sells;
	}

	public Client[] getClients() {
		return clients;
	}
	
	
	public boolean addClient(String name, String lastname, String email, long id, int phoneNumber) {
		Client client = new Client(name, lastname, email, id, phoneNumber, this);
		
		for (int i = 0; i < clients.length; i++) {
			if ( clients[i] == null ) {
				clients[i] = client;
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public boolean removeClient(Client client) {
		boolean removed = false;
		
		return removed;
	}
	
	
}

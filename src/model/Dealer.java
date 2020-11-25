package model;

import java.util.ArrayList;

public abstract class Dealer {
	
	private Dealer nextDealer;
	private Dealer prevDealer;
	
	private String name;
	private Admin admin;
	private String adress;	
	private double earnings;
	private int sales;
	private ArrayList<Client> clients;
	private ArrayList<Seller> sellers;
	
	public Dealer(String name, Admin admin, String adress) {
		this.name = name;
		this.admin = admin;
		this.adress = adress;
		earnings = 0;
		sales = 0;
		clients = new ArrayList<Client>();
		sellers = new ArrayList<Seller>();
		nextDealer = null;
		prevDealer = null;
	}

	public Dealer getNextDealer() {
		return nextDealer;
	}
	
	public void setNextDealer(Dealer nextDealer) {
		this.nextDealer = nextDealer;
	}

	public Dealer getPrevDealer() {
		return prevDealer;
	}
	

	public void setPrevDealer(Dealer prevDealer) {
		this.prevDealer = prevDealer;
	}
	
	public String getName() {
		return name;
	}

	public Admin getAdmin() {
		return admin;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	public String getAdress() {
		return adress;
	}

	public double getEarnings() {
		return earnings;
	}

	public int getSales() {
		return sales;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public ArrayList<Seller> getSellers() {
		return sellers;
	}

	
	public abstract boolean addVehicle(Vehicle vehicle);

	public abstract boolean removeVehicle(Vehicle vehicle);
	
	
}

package model;

import java.util.ArrayList;

public abstract class Dealer implements Comparable<Dealer>{
	
	private Dealer nextDealer;
	private Dealer prevDealer;
	
	
	private String name;
	private Admin admin;
	private String adminName;
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
		
		adminName = admin.getName();
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
	
	public String getAdminName() {
		return adminName;
	}
	
	public void setAdmin(Admin admin) {
		adminName = admin.getName();
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
	
	
	public void addClient(Client client) {
		clients.add(client);
	}
	
	public void addSeller(Seller seller) {
		sellers.add(seller);
	}
	
	public ArrayList<Client> getClients() {
		return clients;
	}

	public ArrayList<Seller> getSellers() {
		return sellers;
	}
	
	public Seller getSeller(long id) {
		for (Seller seller : sellers) {
			if (seller.getId() == id) {
				return seller;
			}
			
		}
		
		return null;
	}
	
	public ArrayList<Seller> getAvailableSellers(){
		ArrayList<Seller> availableSellers = new ArrayList<Seller>();
		
		for (Seller seller : sellers) {
			if (seller.getClients()[4] == null) {
				availableSellers.add(seller);
				
			}

		}
		
		return availableSellers;
	}

	public int compareTo(Dealer p) {
		int difference;
		if(this.name.equals(p.name)) {
			difference = this.name.compareTo(p.name);
		}else {
			difference = this.name.compareTo(p.name);
		}
		return difference;
	}
	
	public abstract boolean addVehicle(Vehicle vehicle);

	public abstract boolean removeVehicle(Vehicle vehicle);
	
	
}

package model;

public class Company {
	
	private String name;
	private int nit;
	private double totalEarnings;
	private int totalSales;
	
	private Admin principalAdmin;
	private Dealer firstDealer;
	
	
	
	public Company(String name, int nit, Admin principalAdmin) {
		this.name = name;
		this.nit = nit;
		totalEarnings = 0;
		totalSales = 0;
		this.principalAdmin = principalAdmin;
		firstDealer = null;
	}

	public String getName() {
		return name;
	}
	
	public int getNit() {
		return nit;
	}
	
	public double getTotalEarnings() {
		return totalEarnings;
	}
	
	public int getTotalSales() {
		return totalSales;
	}
	
	public Admin getPrincipalAdmin() {
		return principalAdmin;
	}
	
	public Dealer getFirstDealer() {
		return firstDealer;
	}
	
	public void setFirstDealer(Dealer firstDealer) {
		this.firstDealer = firstDealer;
	}
	
}

package model;

public class Vehicle {

	private double totalSalePrice;
	private double basePrice;
	private String brand;
	private double displacement;
	private int mileage;
	private boolean used;
	
	public Vehicle(double totalSalePrice, double basePrice, String brand, double displacement, int mileage,
			boolean used) {
		super();
		this.totalSalePrice = totalSalePrice;
		this.basePrice = basePrice;
		this.brand = brand;
		this.displacement = displacement;
		this.mileage = mileage;
		this.used = used;
	}

	public double getTotalSalePrice() {
		return totalSalePrice;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public String getBrand() {
		return brand;
	}

	public double getDisplacement() {
		return displacement;
	}

	public int getMileage() {
		return mileage;
	}

	public boolean isUsed() {
		return used;
	}
	
	
	
}

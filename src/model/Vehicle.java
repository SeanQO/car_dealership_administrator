package model;

public class Vehicle {

	private Vehicle head;
	private Vehicle right;
	private Vehicle left;
	
	private String id;
	private double totalSalePrice;
	private String brand;
	private double weight;
	private String typeOfMotor;
	private double topSpeed;
	private int mileage;
	private boolean used;
	
	public Vehicle(String id, double totalSalePrice, String brand, double weight, String typeOfMotor, double topSpeed,
			int mileage, boolean used) {
		super();
		this.id = id;
		this.totalSalePrice = totalSalePrice;
		this.brand = brand;
		this.weight = weight;
		this.typeOfMotor = typeOfMotor;
		this.topSpeed = topSpeed;
		this.mileage = mileage;
		this.used = used;
	}

	

	public String getId() {
		return id;
	}

	public double getTotalSalePrice() {
		return totalSalePrice;
	}

	public String getBrand() {
		return brand;
	}

	public double getWeight() {
		return weight;
	}

	public String getTypeOfMotor() {
		return typeOfMotor;
	}

	public double getTopSpeed() {
		return topSpeed;
	}

	public int getMileage() {
		return mileage;
	}

	public boolean isUsed() {
		return used;
	}

	public Vehicle getHead() {
		return head;
	}

	public Vehicle getRight() {
		return right;
	}

	public Vehicle getLeft() {
		return left;
	}

	public void setHead(Vehicle head) {
		this.head = head;
	}

	public void setRight(Vehicle right) {
		this.right = right;
	}

	public void setLeft(Vehicle left) {
		this.left = left;
	}

	public String vehiculeInfo() {
		return ""+id+","+totalSalePrice+","+","+brand+","+weight+","+topSpeed+","+mileage+","+used;
	}
	
}

package model;

public class Vehicle {

	private Vehicle head;
	private Vehicle right;
	private Vehicle left;
	
	private String id;
	private double basePrice;
	private String brand;
	private double weight;
	private double topSpeed;
	private double mileage;
	private boolean used;
	private int numOfPassengers;
	
	public Vehicle(String id, double basePrice, String brand, double weight,
					double mileage, boolean used, int numOfPassengers) {
		super();
		this.id = id;
		this.basePrice = basePrice;
		this.brand = brand;
		this.weight = weight;
		topSpeed = 0;//TODO: give random topSpeed
		this.mileage = mileage;
		this.used = used;
		this.numOfPassengers = numOfPassengers;
	}

	

	public String getId() {
		return id;
	}
	
	public double getBasePrice() {
		return basePrice;
	}

	public String getBrand() {
		return brand;
	}

	public double getWeight() {
		return weight;
	}

	public double getTopSpeed() {
		return topSpeed;
	}

	public double getMileage() {
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
	
	public int getNumOfPassengers() {
		return numOfPassengers;
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
		return ""+id+","+basePrice+","+","+brand+","+weight+","+topSpeed+","+mileage+","+used;
	}
	
	public int compareTo(Vehicle v) {
		int difference;
		if(this.id.equals(v.id)) {
			difference = this.id.compareTo(v.id);
		}else {
			difference = this.id.compareTo(v.id);
		}
		return difference;
	}
	
	public Vehicle getMin() {
		Vehicle min = this;
		while(min.getLeft()!=null) {
				min=min.getLeft();
		}
		return min;
	}
}

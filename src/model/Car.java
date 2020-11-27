package model;

public class Car extends Vehicle{

	public static final String SEDAN="Sedan";
	public static final String VAN = "Van";
	private String carType;
	private int noDoors;
	private boolean polarized;

	public Car(String id, double totalSalePrice, String brand, double weight, String typeOfMotor, double topSpeed, int mileage, boolean used) {
		super(id, totalSalePrice, brand, weight, typeOfMotor, topSpeed, mileage, used);

	}

	public String getCarType() {
		return carType;
	}

	public int getNoDoors() {
		return noDoors;
	}

	public boolean isPolarized() {
		return polarized;
	}
	
	
}

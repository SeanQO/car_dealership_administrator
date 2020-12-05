package model;

public class Car extends Vehicle{

	public static final String SEDAN="Sedan";
	public static final String VAN = "Van";
	private String carType;
	private int noDoors;
	private boolean polarized;

	public Car(String id, double basePrice, String brand, double weight, String typeOfMotor,
			double mileage, boolean used,  int numOfPassengers,
			String carType, int noDoors, boolean polarized) {
		super(id, basePrice, brand, weight,mileage, used, numOfPassengers);
		
		
		this.carType = carType;
		this.noDoors = noDoors;
		this.polarized = polarized;
		
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

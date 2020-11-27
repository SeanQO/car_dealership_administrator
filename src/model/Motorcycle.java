package model;

public class Motorcycle extends Vehicle {
	
	private double tankCapacity;
	private String gasType;
	private double gasConsumtion;
	private String motorcycleType;

	public Motorcycle(String id, double totalSalePrice, String brand, double weight, String typeOfMotor,
			double topSpeed, int mileage, boolean used) {
		super(id, totalSalePrice, brand, weight, typeOfMotor, topSpeed, mileage, used);
	
	}

	public double getTankCapacity() {
		return tankCapacity;
	}

	public String getGasType() {
		return gasType;
	}

	public double getGasConsumtion() {
		return gasConsumtion;
	}

	public String getMotorcycleType() {
		return motorcycleType;
	}
	
	
	
}

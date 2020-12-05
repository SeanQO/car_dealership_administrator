package model;

public class Motorcycle extends Vehicle {
	
	private double tankCapacity;
	private String gasType;
	private double gasConsumtion;
	private String motorcycleType;

	public Motorcycle(String id, double basePrice, String brand, double weight, String typeOfMotor,
			int mileage, boolean used,  int numOfPassengers,
			double tankCapacity, String gasType, double gasConsumtion, String motorcycleType ) {
		
		super(id, basePrice, brand, weight,mileage, used, numOfPassengers);
		
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasConsumtion = gasConsumtion;
		this.motorcycleType = motorcycleType;
	
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

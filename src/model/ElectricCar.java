package model;

public class ElectricCar extends Car implements Electric{
	private boolean fastCharger;
	private double batteryLife;
	private double batteryConsumption;

	public ElectricCar(String id, double basePrice, String brand, double weight, String typeOfMotor,
				double mileage, boolean used,  int numOfPassengers,
				String carType, int noDoors, boolean polarized,
				boolean fastCharger, double batteryLife, double batteryConsumption) {

		super(id, basePrice, brand, weight, typeOfMotor, mileage, used, numOfPassengers, carType, noDoors, polarized);
		this.fastCharger = fastCharger;
		this.batteryLife = batteryLife;
		this.batteryConsumption = batteryConsumption;
	}


	@Override
	public boolean getFastCharger(){
		return fastCharger;
	}


	@Override
	public double getBatteryLife(){
		return batteryLife;
	}


	@Override
	public double getBatteryConsumption(){
		return batteryConsumption;
	}

}
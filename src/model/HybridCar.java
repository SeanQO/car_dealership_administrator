package model;

public class HybridCar extends Car implements Electric, Gasoline{
	private boolean fastCharger;
	private double batteryLife;
	private double batteryConsumption;
	public double tankCapacity;
	public String gasType;
	public double gasConsumption;

	public HybridCar(String id, double basePrice, String brand, double weight, String typeOfMotor,
			double mileage, boolean used,  int numOfPassengers,
			String carType, int noDoors, boolean polarized,
				double tankCapacity, String gasType, double gasConsumption, boolean fastCharger, double batteryLife,double batteryConsumption) {
		
		super(id, basePrice, brand, weight, typeOfMotor, mileage, used, numOfPassengers, carType, noDoors, polarized);
		
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasConsumption = gasConsumption;
		this.fastCharger = fastCharger;
		this.batteryLife = batteryLife;
		this.batteryConsumption = batteryConsumption;
	}

	@Override
	public double getTankCapacity(){
		return tankCapacity;
	}


	@Override
	public String getGasType(){
		return gasType;
	}


	@Override
	public double getGasConsumption(){
		return gasConsumption;
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
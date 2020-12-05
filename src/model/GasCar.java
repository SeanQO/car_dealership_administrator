package model;

public class GasCar extends Car implements Gasoline{
	private double tankCapacity;
	private String gasType;
	private double gasConsumption;

	public GasCar(String id, double basePrice, String brand, double weight, String typeOfMotor,
			double mileage, boolean used,  int numOfPassengers,
			String carType, int noDoors, boolean polarized,
				double tankCapacity, String gasType, double gasConsumption) {

		super(id, basePrice, brand, weight, typeOfMotor, mileage, used, numOfPassengers, carType, noDoors, polarized);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasConsumption = gasConsumption;
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


}
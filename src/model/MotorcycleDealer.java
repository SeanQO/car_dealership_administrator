package model;

import customException.DoubleRegistrationException;
import customException.EmptyDataException;

public class MotorcycleDealer extends Dealer {

	public MotorcycleDealer(String name, Admin admin, String adress) {
		super(name, admin, adress);
		
	}
	
	@Override
	public boolean addVehicle(Vehicle vehicle) throws DoubleRegistrationException, EmptyDataException {
		addVehicle(vehicle.getId(),vehicle.getTotalSalePrice(),vehicle.getBrand(),vehicle.getWeight(),vehicle.getTypeOfMotor(),vehicle.getTopSpeed(),vehicle.getMileage(),vehicle.isUsed());
		return true;
	}


	@Override
	public boolean removeVehicle(Vehicle vehicle) {
		deleteVehicle(vehicle.getId());
		return true;
	}
	
}

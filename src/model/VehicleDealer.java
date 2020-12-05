package model;

import customException.DoubleRegistrationException;
import customException.EmptyDataException;

public class VehicleDealer extends Dealer {

	public VehicleDealer(String name, Admin admin, String adress) {
		super(name, admin, adress);
		
	}

	public boolean addMotorcycle(Vehicle vehicle) throws DoubleRegistrationException{
		addVehicle(vehicle);
		return true;
	}

	
	public boolean removeMotorcycle(Vehicle vehicle) {
		deleteVehicle(vehicle.getId());
		return true;
	}
	

}

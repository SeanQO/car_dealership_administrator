package model;

import customException.DoubleRegistrationException;

public class MotorcycleDealer extends Dealer {

	public MotorcycleDealer(String name, Admin admin, String adress) {
		super(name, admin, adress);
		
	}
	
	public boolean addMotorcycle(Motorcycle motorcycle) throws DoubleRegistrationException{
		addVehicle(motorcycle);
		return true;
	}

	
	public boolean removeMotorcycle(Motorcycle motorcycle) {
		deleteVehicle(motorcycle.getId());
		return true;
	}
	
}

package model;

import customException.DoubleRegistrationException;
import customException.EmptyDataException;

public class CarDealer extends Dealer {

	public CarDealer(String name, Admin admin, String adress) {
		super(name, admin, adress);
		
	}

	public boolean addMotorcycle(Car car) throws DoubleRegistrationException{
		addVehicle(car);
		return true;
	}

	
	public boolean removeMotorcycle(Car car) {
		deleteVehicle(car.getId());
		return true;
	}

}

package model;

public class CarDealer extends Dealer {

	public CarDealer(String name, Admin admin, String adress) {
		super(name, admin, adress);
		
	}

	@Override
	public boolean addVehicle(Vehicle car) {
		
		return false;
	}

	@Override
	public boolean removeVehicle(Vehicle car) {
		
		return false;
	}

}

package model;

public class MotorcycleDealer extends Dealer {

	public MotorcycleDealer(String name, Admin admin, String adress) {
		super(name, admin, adress);
		
	}
	
	@Override
	public boolean addVehicle(Vehicle motorcycle) {
		
		return false;
	}

	@Override
	public boolean removeVehicle(Vehicle motorcycle) {
		
		return false;
	}
	
}

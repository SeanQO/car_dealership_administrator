package model;

public class SimulationVehicle {

	private int max;
	private int current;
	private int size;
	
	public SimulationVehicle(Vehicle vehicle, int max, int current, int size) {
		
	}
	
	public void advance() {
		if(current<max) {
			current++;
			int numberSize = size;
			int numberFilled = (int)((current/(double)max)*numberSize);
			for(int i = 0; i<numberFilled;i++) {
				
			}
		}
	}
	
	public boolean finished() {
		return current>=max;
	}
}

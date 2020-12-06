package threads;

import model.SimulationVehicle;
import ui.DealershipGUI;

public class SimulationThread extends Thread{
	
	private SimulationVehicle sm;
	private DealershipGUI dsg;
	private long sleepTime;
	
	public SimulationThread(SimulationVehicle sm,DealershipGUI dsg, long sleepTime ) {
		this.sm = sm;
		this.dsg = dsg;
		this.sleepTime = sleepTime;
	}
	
	public void run() {
		while(!sm.finished()) {
			sm.advance();
			try {
				Thread.sleep(sleepTime);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

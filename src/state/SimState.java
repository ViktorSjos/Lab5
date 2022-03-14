//changes the state of the simulation

*@author Jonathan Westerdahl, Felix Woxblom,Isak Sandegren,Viktor Sjöstedt

package state;

import java.util.Observable;

public class SimState extends Observable {

	boolean Running = false;  //variable that is true if the simulation is running
	double CurrentTime = 0;   

	public SimState() {

	}
	
	//starts simulation by setting running to true

	public void StartSim() {
		Running = true;
	}
	
	//stops simulation by setting running to false

	public void StopSim() {
		Running = false;
		return;
	}
	
	//returns running

	public boolean RunCheck() {
		return Running;

	}

	public void UpdateObs() {
		setChanged();
		notifyObservers();
	}

}

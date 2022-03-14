package state;

import java.util.Observable;
/**
 * @author Jonathan Westerdahl, Felix Woxblom,Isak Sandegren,Viktor Sjöstedt
 *      Represent general simulation state
 * 
 */
public class SimState extends Observable {

	boolean Running = false;
	double CurrentTime = 0;

	public SimState() {

	}
	/**
 	*  Sets the simulation to running
 	*/
	public void StartSim() {
		Running = true;
	}
/**
 *  stops the simulation 
 */
	public void StopSim() {
		Running = false;
		return;
	}
/**
 * checks if the simulation is running
 * @return 
 */
	public boolean RunCheck() {
		return Running;

	}

	public void UpdateObs() {
		setChanged();
		notifyObservers();
	}

}

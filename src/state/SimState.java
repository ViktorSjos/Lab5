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

	public void StartSim() {
		Running = true;
	}

	public void StopSim() {
		Running = false;
		return;
	}

	public boolean RunCheck() {
		return Running;

	}

	public void UpdateObs() {
		setChanged();
		notifyObservers();
	}

}

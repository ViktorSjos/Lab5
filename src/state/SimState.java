package state;

import java.util.Observable;

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

package events;

import GeneralSim.Event;
import GeneralSim.EventQueue;
import state.StoreState;

/**
 * A class representing an event stopping the simulation
 * 
 * @author Jonathan Westerdahl, Felix Woxblom, Isak Sandegren, Viktor Sjöstedt
 *
 */
public class StoppingEvent extends Event {
	StoreState state;
	EventQueue queue;
	double ExTime;

	/**
	 * The constructor
	 * 
	 * @param state Object of the class StoreState
	 * @param queue Object of the class EventQueue
	 */
	public StoppingEvent(StoreState state, EventQueue queue) {
		super(state, queue);
		this.queue = queue;
		this.ExTime = 999;
		this.state = state;
	}

	/**
	 * Runs the event
	 */
	public void Execute() {
		queue.RemoveEvent();
		state.ChangeName("Stop");
		state.SimStopTime(this.ExTime);
		state.UpdateObs();
		state.StopSim();

	}

	/**
	 * Gets the time
	 */
	public double GetExecutionTime() {
		return this.ExTime;
	}

}

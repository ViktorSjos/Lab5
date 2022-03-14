
package events;

import GeneralSim.Event;
import GeneralSim.EventQueue;
import state.*;

/**
 * A class representing an event closing the store
 * 
 * @author Jonathan Westerdahl, Felix Woxblom, Isak Sandegren, Viktor Sjöstedt
 *
 */
public class ClosingEvent extends Event {
	private StoreState sState;
	private EventQueue queue;
	private double ExTime;

	/**
	 * The constructor
	 * 
	 * @param sState Object for the StoreState class
	 * @param queue  Object for the EventQueue class
	 * @param time   The current time
	 */
	public ClosingEvent(StoreState sState, EventQueue queue, double time) {
		super(sState, queue);
		this.sState = sState;
		this.queue = queue;
		ExTime = time;
	}

	/**
	 * Runs the event
	 */
	public void Execute() {
		queue.RemoveEvent();
		sState.CurrentTime(this.ExTime);
		sState.UpdateTimeInQueue();
		sState.UpdateTimeLedigaKassor();
		sState.ChangeName("Closed");
		sState.closeStore();
		sState.UpdateObs();
	}

	/**
	 * Gets the new time
	 */
	public double GetExecutionTime() {
		return this.ExTime;
	}
}

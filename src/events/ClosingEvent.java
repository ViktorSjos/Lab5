
package events;

import GeneralSim.Event;
import GeneralSim.EventQueue;
import state.*;

public class ClosingEvent extends Event {
	private StoreState sState;
	private EventQueue queue;
	private double ExTime;

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

	public double GetExecutionTime() {
		return this.ExTime;
	}
}
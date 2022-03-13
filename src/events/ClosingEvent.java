package events;

import state.*;

public class ClosingEvent extends Event {
	private StoreState sState;

	public ClosingEvent(StoreState sState, EventQueue queue, CustomerQueue cQueue, double time) {
		super(time, "Closing");
		this.sState = sState;
	}

	/**
	 * Runs the event
	 */
	public void ExecuteEvent() {
		sState.closeStore();
	}

}
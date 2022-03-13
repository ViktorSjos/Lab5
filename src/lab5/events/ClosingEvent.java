package lab5.events;

import lab5.state.*;

public class ClosingEvent extends Event2 {
	private StoreState sState;

	public ClosingEvent(StoreState sState, EventQueue queue, CustomerQueue cQueue, double time) {
		super(time, "Closing");
		this.sState = sState;
	}

	/**
	 * Runs the event
	 */
	public void runEvent() {
		sState.closeStore();
	}

}

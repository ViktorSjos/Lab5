package lab5.events;

import lab5.state.*;

public class ClosingEvent extends Event {
	private StoreState sState;

	public ClosingEvent(SimState state, EventQueue queue) {
		super(state, queue);
	}

	/**
	 * Runs the event
	 */
	public void runEvent() {
		sState.closeStore();
	}

}

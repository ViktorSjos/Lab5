
package events;

import state.*;

public class ClosingEvent extends Event {
	private StoreState sState;
	private double ExTime;

	public ClosingEvent(StoreState sState, EventQueue queue, double time) {
		super(sState, queue);
		this.sState = sState;
		ExTime = time;
	}

	/**
	 * Runs the event
	 */
	public void ExecuteEvent() {
		sState.closeStore();
	}

}
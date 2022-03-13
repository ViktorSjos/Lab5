
package lab5.events;

import lab5.state.*;

public class PayingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	private Customer customer;
	private double ExTime;

	public PayingEvent(StoreState sState, EventQueue eQueue, CustomerQueue cQueue) {
		super(time, "Paying");
		this.sState = sState;
		this.eQueue = eQueue;
		this.cQueue = cQueue;
		ExTime = this.ExecutionTime(state.getCurrentTime+Timer.timeToPick());
	}

	/**
	 * Runs the event
	 */
	public void Execute() {
		sState.changeCurrentCustomer(id);
		sState.changeCustomersPaying(-1);
		sState.changeFreeRegisters(1);

		if (cQueue.getCustomerQueueLength() > 0) {
			Event2 paying = new PayingEvent(sState, eQueue, cQueue.getFirstInLine(),
					sState.getCurrentTime() + Timer.timeToPay());
			sState.changeCustomersShopping(-1);
			sState.changeFreeRegisters(-1);
			sState.changeCustomersPaying(+1);
			eQueue.AddEvent(paying);
			cQueue.removeFirstInLine();
		}
		// Tror att det här ska vara ett förinställt event istället
		if (sState.getCurrentTime() >= 10 && sState.Open == true) {
			Event2 closed = new ClosingEvent();
		}
	}
}

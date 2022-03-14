package events;

import state.*;

public class PayingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	private int Customer;
	private double ExTime;

	public PayingEvent(StoreState sState, EventQueue eQueue, int customer) {
		super(sState, eQueue);
		this.sState = sState;
		this.eQueue = eQueue;
		ExTime = sState.GetCurrentTime() + sState.GetTimer().timeToPay();
	}

	/**
	 * Runs the event
	 */
	public void Execute() {
		sState.CurrentTime(this.ExTime);
		sState.changeCurrentCustomer(Customer);
		sState.ChangeName("Paying");
		sState.UpdateTimeLedigaKassor();
		sState.changeFreeRegisters(1);
		sState.RemoveCustomer();

		if (cQueue.getCustomerQueueLength() > 0) {
			Event paying = new PayingEvent(sState, eQueue, cQueue.getFirstInLine());
			sState.changeFreeRegisters(-1);
			eQueue.AddEvent(paying);
			cQueue.removeFirstInLine();
		}
	}
}
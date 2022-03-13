package events;

import state.*;

public class PayingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	private int Customer;
	private double ExTime;

	public PayingEvent(StoreState sState, EventQueue eQueue, CustomerQueue cQueue, int customer) {
		super(sState, eQueue);
		this.sState = sState;
		this.eQueue = eQueue;
		this.cQueue = cQueue;
		ExTime = sState.GetCurrentTime() + Timer.timeToPay();
	}

	/**
	 * Runs the event
	 */
	public void Execute() {
		sState.CurrentTime(this.ExTime);
		sState.changeCurrentCustomer(Customer);
		sState.ChangeName("Paying");
		sState.changeCustomersPaying(-1);
		sState.UpdateTimeLedigaKassor();
		sState.changeFreeRegisters(1);

		if (cQueue.getCustomerQueueLength() > 0) {
			Event paying = new PayingEvent(sState, eQueue, cQueue, cQueue.getFirstInLine());
			sState.changeFreeRegisters(-1);
			sState.changeCustomersPaying(+1);
			eQueue.AddEvent(paying);
			cQueue.removeFirstInLine();
		}
	}
}

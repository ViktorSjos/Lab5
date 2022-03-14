package events;

import state.*;

public class PayingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	private int Customer;
	private double ExTime;

	public PayingEvent(StoreState sState, EventQueue eQueue, int customer, CustomerQueue cQueue) {
		super(sState, eQueue);
		this.sState = sState;
		this.cQueue = cQueue;
		this.eQueue = eQueue;
		this.Customer = customer;
		ExTime = sState.GetCurrentTime() + sState.GetPaytime();
	}

	/**
	 * Runs the event
	 */
	public void Execute() {
		eQueue.RemoveEvent();
		sState.UpdateTimeInQueue();
		sState.UpdateTimeLedigaKassor();
		sState.CurrentTime(this.ExTime);
		sState.changeCurrentCustomer(this.Customer);
		sState.ChangeName("Paying");
		sState.UpdateTimeLedigaKassor();
		sState.changeFreeRegisters(1);
		sState.RemoveCustomer();

		if (cQueue.getCustomerQueueLength() > 0) {
			Event paying = new PayingEvent(sState, eQueue, cQueue.getFirstInLine(), this.cQueue);
			sState.changeFreeRegisters(-1);
			eQueue.AddEvent(paying);
			cQueue.removeFirstInLine();
			
		}
		sState.UpdateObs();
	}

	public double GetExecutionTime() {
		return this.ExTime;
	}
}
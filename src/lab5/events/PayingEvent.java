
package lab5.events;

import java.util.Timer;

import lab5.state.*;

public class PayingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	private int Customer;
	private double ExTime;

	public PayingEvent(StoreState sState, EventQueue eQueue, CustomerQueue cQueue, double time) {
		super(sState, eQueue);
		this.sState = sState;
		this.eQueue = eQueue;
		this.cQueue = cQueue;
		ExTime = this.ExecutionTime(sState.getCurrentTime() + Timer.timeToPay());
	}

	/**
	 * Runs the event
	 */
	public void ExecuteEvent() {
		sState.changeCurrentCustomer(Customer);
		sState.changeName("Paying");
		sState.changeCustomersPaying(-1);
		sState.UpdateTimeLedigaKassor();
		sState.changeFreeRegisters(1);

		if (cQueue.getCustomerQueueLength() > 0) {
			Event paying = new PayingEvent(sState, eQueue, cQueue.getFirstInLine(), Customer, ExTime);
			sState.changeCustomersShopping(-1);
			sState.changeFreeRegisters(-1);
			sState.changeCustomersPaying(+1);
			eQueue.AddEvent(paying);
			cQueue.removeFirstInLine();
		}
	}
}

package lab5.events;

import lab5.state.*;

public class PickingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	private CreateCustomer customer;

	/**
	 * The constructor
	 * 
	 * @param Tar in
	 */
	public PickingEvent(StoreState sState, EventQueue eQueue, CustomerQueue cQueue, CreateCustomer customer, double time) {
		super(time, "Picking");
		this.sState = sState;
		this.eQueue = eQueue;
		this.cQueue = cQueue;
		this.customer = customer;
	}

	/**
	 * If there are free registers paying event gets sent to eventQueue, otherwise
	 * send customer to CustomerQueue
	 */
	private void ExecuteEvent() {
		if (sState.getFreeRegister() > 0) {
			sState.changeCurrentCustomer(customer.GetId);
			Event2 paying = new PayingEvent(sState, eQueue, cQueue, sState.getCurrentTime() + Timer.timeToPay());
			sState.changeCustomersShopping(-1);
			sState.changeFreeRegisters(-1);
			sState.changeCustomersPaying(+1);
			eQueue.AddEvent(paying);
		} else {
			cQueue.addToArray(id);
		}
	}
}

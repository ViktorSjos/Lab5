package events;

import state.*;

public class PickingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	private CreateCustomer customer;
	double ExTime;

	/**
	 * The constructor
	 * 
	 * @param Tar in
	 */
	public PickingEvent(StoreState sState, EventQueue eQueue, CustomerQueue cQueue, CreateCustomer customer) {
		super(time, "Picking");
		this.sState = sState;
		this.eQueue = eQueue;
		this.cQueue = cQueue;
		this.customer = customer;
		ExTime = this.ExecutionTime(state.getCurrentTime+Timer.timeToPick());
	}

	/**
	 * If there are free registers paying event gets sent to eventQueue, otherwise
	 * send customer to CustomerQueue
	 */
	private void Execute() {
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

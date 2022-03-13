package events;


import state.*;

public class PickingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	private int customer;
	double ExTime;

	/**
	 * The constructor
	 * 
	 * @param Tar in
	 */
	public PickingEvent(StoreState sState, EventQueue eQueue, int customer) {
		super(sState, eQueue);
		this.sState = sState;
		this.eQueue = eQueue;
		this.cQueue = sState.GetCQ();
		this.customer = customer;
		ExTime = sState.GetCurrentTime() + sState.GetTimer().timeToPay();
	}

	/**
	 * If there are free registers paying event gets sent to eventQueue, otherwise
	 * send customer to CustomerQueue
	 */
	private void Execute() {
		if (sState.getFreeRegister() > 0) {
			sState.changeCurrentCustomer(this.customer);
			Event paying = new PayingEvent(sState, eQueue, customer);
			sState.changeFreeRegisters(-1);
			sState.changeCustomersPaying(+1);
			eQueue.AddEvent(paying);
		} else {
			cQueue.addToArray(customer);
		}
	}
}
package lab5.events;

import lab5.state.*;

public class PickingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	int customer
	/**
	 * The constructor
	 * 
	 * @param Tar in
	 */
	public PickingEvent(SimState state, EventQueue queue, int Customer) {//när vi skapar eventet säger vi också vilken kund det är som gör saken.
		super(state, queue);
		this.customer=Customer
	}

	/**
	 * If there are free registers paying event gets sent to eventQueue, otherwise
	 * send customer to CustomerQueue
	 */
	private void runEvent() {
		if (sState.getFreeRegister() > 0) {
			sState.changeCurrentCustomer(id);
			Event paying = new PayingEvent(Timer.timeToPay());
			sState.changeCustomersShopping(-1);
			sState.changeFreeRegisters(-1);
			sState.changeCustomersPaying(+1);
			eQueue.AddEvent(paying);
		} else {
			cQueue.addToArray(id);
		}
	}
}

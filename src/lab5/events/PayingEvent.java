package lab5.events;

import lab5.state.*;

public class PayingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	int Customer

	public PayingEvent(SimState state, EventQueue queue,int customer) {
		super(state, queue);
		this.customer=Customer
	}

	/**
	 * Runs the event
	 * 
	 * 
	 */
	public void runEvent() {
		sState.changeCurrentCustomer(id); // id ligger nu lagrat i event. 
		sState.changeCustomersPaying(-1);
		sState.changeFreeRegisters(1);

		if (cQueue.getCustomerQueueLength() > 0) {
			// Vet inte hur jag ska ta in nuvarande tiden + tiden det tar för eventen
			Event paying = new PayingEvent(CurrentTime + Timer.timeToPay(), cQueue.getFirstInLine());
			sState.changeCustomersShopping(-1);
			sState.changeFreeRegisters(-1);
			sState.changeCustomersPaying(+1);
			eQueue.AddEvent(paying);
			cQueue.removeFirstInLine();
		}
		if (CurrentTime >= 10 && sState.Open == true) { // closingevent borde väl skapas i början av allt?
			// Behöver ha några andra parametrar
			Event closed = new ClosingEvent(state, eQueue);
		}
	}
}
/*
package lab5.events;

import lab5.state.*;

public class PayingEvent extends Event2 {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	private Customer customer;

	public PayingEvent(StoreState sState, EventQueue eQueue, CustomerQueue cQueue, double time) {
		super(time, "Paying");
		this.sState = sState;
		this.eQueue = eQueue;
		this.cQueue = cQueue;
	}

	/**
	 * Runs the event
	 */
	public void runEvent() {
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
*/

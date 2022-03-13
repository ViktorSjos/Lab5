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

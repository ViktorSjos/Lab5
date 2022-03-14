package events;

import GeneralSim.Event;
import GeneralSim.EventQueue;
import state.*;

/**
 * A class representing an event where the customer pays and leaves
 * 
 * @author Jonathan Westerdahl, Felix Woxblom, Isak Sandegren, Viktor Sjöstedt
 *
 */
public class PayingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	private int Customer;
	private double ExTime;

	/**
	 * The constructor
	 * 
	 * @param sState   Object of the StoreState class
	 * @param eQueue   Object of the EventQueue class
	 * @param customer The customer ID
	 * @param cQueue   Object of the CustomerQueue class
	 */
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
		sState.CurrentTime(this.ExTime);
		sState.UpdateTimeInQueue();
		sState.UpdateTimeLedigaKassor();
		sState.changeCurrentCustomer(this.Customer);
		sState.ChangeName("Paying");
		sState.UpdateObs();
		sState.changeFreeRegisters(1);
		sState.RemoveCustomer();
		if (cQueue.getCustomerQueueLength() > 0) {
			Event paying = new PayingEvent(sState, eQueue, cQueue.getFirstInLine(), this.cQueue);
			sState.changeFreeRegisters(-1);
			sState.UpdateObs();
			eQueue.AddEvent(paying);
			cQueue.removeFirstInLine();
		}
	}

	/**
	 * Gets the new time
	 */
	public double GetExecutionTime() {
		return this.ExTime;
	}
}

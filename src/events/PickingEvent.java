package events;

import GeneralSim.Event;
import GeneralSim.EventQueue;
import state.*;

/**
 * A class representing an event where the customer picks up items and goes to
 * pay
 * 
 * @author Jonathan Westerdahl, Felix Woxblom, Isak Sandegren, Viktor Sjöstedt
 *
 */
public class PickingEvent extends Event {

	private StoreState sState;
	private EventQueue eQueue;
	private CustomerQueue cQueue;
	private int customer;
	double ExTime;

	/**
	 * The constructor
	 * 
	 * @param sState   Object for the StoreState class
	 * @param eQueue   Object for the EventQueue class
	 * @param customer The customer ID
	 */
	public PickingEvent(StoreState sState, EventQueue eQueue, int customer) {
		super(sState, eQueue);
		this.sState = sState;
		this.eQueue = eQueue;
		this.cQueue = sState.GetCQ();
		this.customer = customer;
		ExTime = sState.GetCurrentTime() + sState.GetPicktime();
	}

	/**
	 * Runs the event
	 */
	public void Execute() {
		eQueue.RemoveEvent();
		sState.CurrentTime(this.ExTime);
		sState.ChangeName("Picking");
		sState.changeCurrentCustomer(this.customer);
		sState.UpdateTimeInQueue();
		sState.UpdateTimeLedigaKassor();
		if (sState.getFreeRegister() > 0) {
			Event paying = new PayingEvent(sState, eQueue, this.customer, this.cQueue);
			eQueue.AddEvent(paying);
			sState.UpdateObs();
			sState.changeFreeRegisters(-1);
		} else {
			sState.UpdateObs();
			cQueue.addToArray(this.customer);
			sState.IncKöat();
		}
	}

	/**
	 * Gets the time
	 */
	public double GetExecutionTime() {
		return this.ExTime;
	}
}

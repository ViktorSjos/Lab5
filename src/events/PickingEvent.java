package events;

import GeneralSim.Event;
import GeneralSim.EventQueue;
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
		ExTime = sState.GetCurrentTime() + sState.GetPicktime();
	}

	/**
	 * If there are free registers paying event gets sent to eventQueue, otherwise
	 * send customer to CustomerQueue
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

	public double GetExecutionTime() {
		return this.ExTime;
	}
}
package events;

import GeneralSim.Event;
import GeneralSim.EventQueue;
import state.SimState;
import state.StoreState;

public class CustomerArrival extends Event {

	int Customer;
	double ExTime;
	String name;
	StoreState state;
	EventQueue queue;

	public CustomerArrival(StoreState state, EventQueue queue) {
		super(state, queue);
		this.state = state;
		this.queue = queue;
		name = "Arrival";
		ExTime = state.GetCurrentTime() + state.GetArrivaltime(); // calculate time
	}

	public void Execute() {
		queue.RemoveEvent();
		state.CurrentTime(this.ExTime);
		if (!state.RunCheck()) {
			return;
		}
		if (!state.OpenCheck()) {
			state.setCurrCustom(state.getCurrCustomNR());
			state.ChangeName(name);
			state.UpdateObs();
			return;
		}
		
		
		CustomerArrival FirstCustomer = new CustomerArrival(state, queue);
		queue.AddEvent(FirstCustomer);
		if (!state.SpaceAvalible()) {
			state.setCurrCustom(state.getCurrCustomNR());
			state.ChangeName(name);
			state.UpdateObs();
			return;
		}

		// Create this customer
		state.ChangeName(name);
		this.Customer = state.AddCustomer();
		state.setCurrCustom(this.Customer);
		PickingEvent pick = new PickingEvent(state, queue, this.Customer);
		queue.AddEvent(pick);
		// Add next cutomer
		state.UpdateTimeInQueue();
		state.UpdateTimeLedigaKassor();
		state.UpdateObs();
	}

	public double GetExecutionTime() {
		return this.ExTime;
	}

}

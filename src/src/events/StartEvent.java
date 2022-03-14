package events;

import state.SimState;
import state.StoreState;

public class StartEvent extends Event {

	StoreState state;
	EventQueue queue;
	double ExTime;

	public StartEvent(StoreState state, EventQueue queue) {
		super(state, queue);
		this.state = state;
		this.queue = queue;
		this.ExTime = 0;
		// SEND STORE OPENED TO VIEW
	}

	public void Execute() {
		queue.RemoveEvent();
		state.StartSim();
		state.OpenSet();
		state.ChangeName("Start");
		CustomerArrival FirstCustomer = new CustomerArrival(state, queue);
		queue.AddEvent(FirstCustomer);
		state.UpdateObs();

	}

	public double GetExecutionTime() {
		return this.ExTime;
	}

}

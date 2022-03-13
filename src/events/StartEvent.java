package events;

import lab5.state.CreateCustomer.Customer;
import lab5.state.SimState;
import lab5.state.StoreState;

public class StartEvent extends Event{

	public StartEvent(StoreState state, EventQueue queue) {
		super(state, queue);
		
		this.ExecutionTime(0);
		state.StartSim();
		CustomerArrival FirstCustomer = new CustomerArrival(state,queue);
		queue.AddEvent(FirstCustomer);
		//SEND STORE OPENED TO VIEW
	}


}

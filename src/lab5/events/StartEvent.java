package lab5.events;

import lab5.state.CreateCustomer.Customer;
import lab5.state.SimState;
import lab5.state.StoreState;

public class StartEvent extends Event{
	
	StoreState storeState;

	public StartEvent(SimState state, EventQueue queue) {
		super(state, queue);
		this.ExecutionTime(0);
		state.StartSim();
		Customer newCustomer = storeState.AddCustomer();
		CustomerArrival FirstCustomer = new CustomerArrival(state,queue,newCustomer);
		queue.AddEvent(FirstCustomer);
	}


}

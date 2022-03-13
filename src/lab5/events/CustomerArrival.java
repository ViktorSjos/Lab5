package lab5.events;

import lab5.state.CreateCustomer.Customer;
import lab5.state.SimState;
import lab5.state.StoreState;

public class CustomerArrival extends Event{
	
	int customer;
	StoreState storeState;

	public CustomerArrival(SimState state, EventQueue queue, int Customer) {
		super(state, queue);
		this.customer = Customer;
		this.ExecutionTime(100); //calculate time
	}
	
	public void Execute() {
		SimState state = super.getState();
		
		if(!state.RunCheck()) {
			return;
		}
		if(!storeState.SpaceAvalible()) { //SpaceAvalible ökar missed customers om den retunerar false.
			return;
		}
		storeState.CustomerArrived();  // den här ökar bara antalet kunder i affären nu.
		
	}
	
	
	


}

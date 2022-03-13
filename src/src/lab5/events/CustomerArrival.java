package lab5.events;

import java.util.Timer;
import lab5.state.CreateCustomer.Customer;
import lab5.state.SimState;
import lab5.state.StoreState;

public class CustomerArrival extends Event{
	
	int Customer;
	double ExTime;
	String name;
	StoreState state;
	EventQueue queue;

	public CustomerArrival(StoreState state, EventQueue queue) {
		super(state, queue);
		this.state = state;
		this.queue = queue;
		name = "Ankomst";
		ExTime = this.ExecutionTime(state.GetCurrentTime()+Timer.timeToNextCustomer()); //calculate time
	}
	
	public void Execute() {
		state.CurrentTime(this.ExTime);
		
		//SEND CUTOMER ARRIVED TO VIEW
		
		if(!state.RunCheck()) {
			return;
		}
		if(!state.SpaceAvalible()) {
			//CALL FUNTION
			return;
		}
		//Create this customer
		state.ChangeName(name);
		this.Customer = state.AddCustomer();
		PickingEvent pick = new PickingEvent(state, queue, this.Customer);
		queue.AddEvent(pick);
		
		//Add next cutomer
		CustomerArrival FirstCustomer = new CustomerArrival(state, queue);
		queue.AddEvent(FirstCustomer);
		
		
		
		
	}
	
	
	


}

package events;




import state.SimState;
import state.StoreState;
import state.Timer;

public class StartEvent extends Event{
	
	StoreState state;
	EventQueue queue;

	public StartEvent(StoreState state, EventQueue queue) {
		super(state, queue);
		
		this.ExecutionTime(0);

		//SEND STORE OPENED TO VIEW
	}
	
	public void Execute() {
		
		state.StartSim();
		CustomerArrival FirstCustomer = new CustomerArrival(state,queue);
		queue.AddEvent(FirstCustomer);
		
	}


}

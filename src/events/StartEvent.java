package events;




import state.SimState;
import state.StoreState;
import state.Timer;

public class StartEvent extends Event{
	
	StoreState state;
	EventQueue queue;
	double ExTime;

	public StartEvent(StoreState state, EventQueue queue) {
		super(state, queue);
		this.state = state;
		this.queue = queue;
		this.ExTime = 0;
		System.out.println("MADE START EVENT");
		//SEND STORE OPENED TO VIEW
	}
	
	public void Execute() {
		state.StartSim();
		state.OpenSet();
		state.ChangeName("Start");
		CustomerArrival FirstCustomer = new CustomerArrival(state,queue);
		queue.AddEvent(FirstCustomer);
		
	}
	
	public double GetExecutionTime() {
		return this.ExTime;
	}

}

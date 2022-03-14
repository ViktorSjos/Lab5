package events;



import state.SimState;
import state.StoreState;
import state.Timer;

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
		
		ExTime = state.GetCurrentTime()+state.GetTimer().timeToNextCustomer(); //calculate time
	}
	
	public void Execute() {
		System.out.println("TEST CUSTOMER");
		state.CurrentTime(this.ExTime);
		
		//SEND CUTOMER ARRIVED TO VIEW
		
		if(!state.RunCheck()) {
			return;
		}
		if(!state.SpaceAvalible()) {
			//CALL FUNTION
			return;
		}
		if(!state.OpenCheck()) {
			return;
		}
		//Create this customer
		state.ChangeName(name);
		this.Customer = state.AddCustomer();
		state.setCurrCustom(this.Customer);
		PickingEvent pick = new PickingEvent(state, queue,this.Customer);
		queue.AddEvent(pick);
		
		//Add next cutomer
		CustomerArrival FirstCustomer = new CustomerArrival(state, queue);
		queue.AddEvent(FirstCustomer);
		
		
		
		
	}
	public double GetExecutionTime() {
		return this.ExTime;
	}
	
	
	


}

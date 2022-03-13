package events;



import state.*;

public class Event {
	
	private StoreState state;
	private EventQueue queue;
	private double ExTime;

	public Event(StoreState state, EventQueue queue) {
		this.state = state;
		this.queue = queue;
	}
	
	public void ExecutionTime(double d){
		this.ExTime = d;
	}
	
	public double GetExecutionTime() {
		return this.ExTime;
	}
	
	public SimState getState() {
		return state;
	}
	
	public EventQueue getQueue() {
		return queue;
	}
	
	public void ExectueEffect(SimState state) {
		
	}
	


	public void Exectue() {
		// TODO Auto-generated method stub
		
	}

}


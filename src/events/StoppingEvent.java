
package events;

import state.StoreState;

public class StoppingEvent extends Event {

	StoreState state;
	EventQueue queue;
	double ExTime;

	public StoppingEvent(StoreState state, EventQueue queue) {
		super(state, queue);
		this.ExTime = 999;
	}
	
	public void Execute() {
		
		state.StopSim();
	}
	
	public double GetExecutionTime() {
		return this.ExTime;
	}

}
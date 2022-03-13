
package events;

import state.StoreState;

public class StoppingEvent extends Event {

	StoreState state;
	EventQueue queue;

	public StoppingEvent(StoreState state, EventQueue queue) {
		super(state, queue);
		this.ExecutionTime(999);
	}
	
	public void Execute() {
		
		state.StopSim();
		
	}

}
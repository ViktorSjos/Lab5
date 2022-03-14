
package events;

import state.StoreState;

public class StoppingEvent extends Event {

	StoreState state;
	EventQueue queue;
	double ExTime;

	public StoppingEvent(StoreState state, EventQueue queue) {
		super(state, queue);
		this.queue = queue;
		this.ExTime = 999;
		this.state = state;
	}

	public void Execute() {

		queue.RemoveEvent();
		state.ChangeName("Stop");
		state.SimStopTime(this.ExTime);
		state.UpdateObs();
		state.StopSim();

	}

	public double GetExecutionTime() {
		return this.ExTime;
	}

}
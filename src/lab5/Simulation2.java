package lab5;

import events.ClosingEvent;
import events.StartEvent;
import events.StoppingEvent;
import state.StoreState;
import GeneralSim.EventQueue;

public class Simulation2 {

	StoreState state;
	EventQueue queue;

	public Simulation2(EventQueue queue, StartEvent start, StoppingEvent stop, StoreState State, ClosingEvent close) {
		this.queue = queue;
		queue.AddEvent(start);
		queue.AddEvent(stop);
		queue.AddEvent(close);
		this.state = State;
		run(queue);
	}

	public void run(EventQueue queue2) {
		state.StartSim();
		while (state.RunCheck()) {
			queue2.NextEvent();
		}
	}

}

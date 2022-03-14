package lab5;

import events.ClosingEvent;
import events.EventQueue;
import events.StartEvent;
import events.StoppingEvent;

import gui.SimView;
import state.StoreState;

public class Simulation {

	SimView view;
	StoreState state;
	int test = 0;

	public Simulation(EventQueue queue, StartEvent start, StoppingEvent stop, SimView view2, StoreState State,
			ClosingEvent close) {
		queue.AddEvent(start);
		queue.AddEvent(stop);
		queue.AddEvent(close);
		this.view = view2;
		this.state = State;
		run(queue);
	}

	public void run(EventQueue queue) {
		state.StartSim();
		while (state.RunCheck()) {
			queue.NextEvent();
		}
		view.resultat();
	}

}

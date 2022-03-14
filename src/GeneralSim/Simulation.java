package GeneralSim;

import events.ClosingEvent;
import events.StartEvent;
import events.StoppingEvent;
import gui.StoreView;
import state.StoreState;

public class Simulation {

	StoreView view;
	StoreState state;

	public Simulation(EventQueue queue, StartEvent start, StoppingEvent stop, StoreView view2, StoreState State,
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

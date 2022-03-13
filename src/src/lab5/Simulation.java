package lab5;

import java.util.Queue;

import lab5.events.EventQueue;
import lab5.events.StartEvent;
import lab5.state.StoreState;

public class Simulation {
	
	public Simulation(EventQueue queue, StartEvent start, StopEvent stop) {
		queue.AddEvent(start);
		run(queue);
	}
	
	public static void run(EventQueue queue){
		while(!queue.IsEmpty()) {
			queue.NextEvent();
		}
	}

}

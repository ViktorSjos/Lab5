package lab5;



import events.EventQueue;
import events.StartEvent;
import events.StoppingEvent;
import state.StoreState;

public class Simulation {
	
	public Simulation(EventQueue queue, StartEvent start, StoppingEvent stop) {
		queue.AddEvent(start);
		queue.AddEvent(stop);
		
		run(queue);
	}
	
	public static void run(EventQueue queue){
		while(!queue.IsEmpty()) {
			queue.NextEvent();
		}
	}

}

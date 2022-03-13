package events;

import java.util.ArrayList;
import state.StoreState;

public class EventQueue {
	
	private ArrayList<Event> Queue = new ArrayList<Event>();
	
	public EventQueue(){
		
	}
	
	public void AddEvent(Event Ev) {
		if (Queue.isEmpty()) {
			Queue.add(Ev);
			return;
		}
		for (int i = -1; i<Queue.size(); i++) {
			if (i+1 == Queue.size()) {
				Queue.add(i+1,Ev);
				break;
			}
			if (Ev.GetExecutionTime() >= Queue.get(i+1).GetExecutionTime()) {
			}
			else {
				Queue.add(i+1,Ev);
				break;
			}
		}
	}
	
	public void NextEvent() {
		if (Queue.isEmpty()) {
			return;
		}
		Queue.get(0).Exectue();
		Queue.remove(0);
	}
	
	public EventQueue GetQueue() {
		return this;
	}
	
	public boolean IsEmpty(){
		if (Queue.isEmpty()) {
			return true;
		}
		return false;
	}

}

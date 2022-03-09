package lab5.events;

import java.util.ArrayList;

public class EventQueue {
	
	int Time = 0;
	ArrayList<Event> Queue = new ArrayList<Event>();
	ArrayList<Event> Temp = new ArrayList<Event>();
	
	public EventQueue(){
		
		
		
	}
	
	public void AddEvent(Event Ev) {
		if (Queue.isEmpty()) {
			Queue.add(Ev);
			return;
		}
		for (int i = 0; i<=Queue.size(); i++) {
			if (Ev.GetExecutionTime() <= Queue.get(i).GetExecutionTime()) {
				Temp.add(Ev);
			}
			else {
				Temp.add(Queue.get(i));
			}
			Queue = Temp;
			Temp.clear();
		}
		
	}
	
	public void DoEvent(Object Event) {
		Queue.get(0);
		Queue.remove(0);
	}

}

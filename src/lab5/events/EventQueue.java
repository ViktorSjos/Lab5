package lab5.events;

import java.util.ArrayList;

public class EventQueue {
	
	int Time = 0;
	ArrayList<Object> Queue = new ArrayList<Object>();
	ArrayList<Object> Temp = new ArrayList<Object>();
	
	public EventQueue(){
		
		
		
	}
	
	public void AddEvent(Object Event) {
		int NewEventTime = Event.time;
		if (Queue.isEmpty()) {
			Queue.add(Event);
			return;
		}
		for (int i = 0; i<=Queue.size(); i++) {
			if (NewEventTime <= Queue.get(i).time) {
				Temp.add(Event);
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

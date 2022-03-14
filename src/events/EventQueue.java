package events;


import java.util.ArrayList;

import events.Event;

public class EventQueue {
	
	private ArrayList<Event> Queue = new ArrayList<Event>();
	
	public EventQueue(){
		
	}
	
	public void AddEvent(Event Ev) {
		
//		if (Queue.isEmpty()) {
//			Queue.add(Ev);
//			return;
//		}
//		for (int i = -1; i<Queue.size(); i++) {
//			if (i+1 == Queue.size()) {
//				Queue.add(i+1,Ev);
//				break;
//			}
//			if (Ev.GetExecutionTime() >= Queue.get(i+1).GetExecutionTime()) {
//			}
//			else {
//				Queue.add(i+1,Ev);
//				break;
//			}
//		}
//	}
		if (Queue.isEmpty()) {
			Queue.add(Ev);
			return;
		} else {
			for (int i = 0; i < Queue.size(); i++) {
				
				if (Queue.get(i).GetExecutionTime() > Ev.GetExecutionTime()) {
					Queue.add(i, Ev);
					System.out.println("Added event "+Ev);
					break;
				} else if (i == Queue.size() - 1) {
					Queue.add(Ev);
					System.out.println("Added event "+Ev);
					break;
				}
			}
		}
	}

			
	
	public void NextEvent() {
		if (Queue.isEmpty()) {
			return;
		}
		Queue.get(0).Execute();
		Queue.remove(0);
	}
	
	public ArrayList<Event> GetQueue() {
		return Queue;
	}
	
	public boolean IsEmpty(){
		if (Queue.isEmpty()) {
			return true;
		}
		return false;
	}

}

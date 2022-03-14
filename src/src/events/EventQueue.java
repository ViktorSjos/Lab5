package events;

import java.util.ArrayList;
import events.Event;

public class EventQueue {

	private ArrayList<Event> Queue = new ArrayList<Event>();

	public EventQueue() {

	}

	public void AddEvent(Event Ev) {

		if (Queue.isEmpty()) {
			Queue.add(Ev);
			return;
		} else {
			for (int i = 0; i < Queue.size(); i++) {

				if (Queue.get(i).GetExecutionTime() > Ev.GetExecutionTime()) {
					Queue.add(i, Ev);
					break;
				} else if (i == Queue.size() - 1) {
					Queue.add(Ev);
					break;
				}
			}
		}
	}

	public void NextEvent() {
		for (int i = 0; i < Queue.size(); i++) {

		}
		if (Queue.isEmpty()) {
			return;
		}
		Queue.get(0).Execute();
	}

	public void RemoveEvent() {
		Queue.remove(0);
	}

	public ArrayList<Event> GetQueue() {
		return Queue;
	}

	public boolean IsEmpty() {
		if (Queue.isEmpty()) {
			return true;
		}
		return false;
	}

}

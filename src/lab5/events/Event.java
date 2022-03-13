package lab5.events;

import java.awt.Taskbar.State;

import lab5.state.*;

public class Event {
	
	private StoreState state;
	private EventQueue queue;
	private int ExTime;

	public Event(StoreState state, EventQueue queue) {
		this.state = state;
		this.queue = queue;
	}
	
	public void ExecutionTime(int t){
		this.ExTime = t;
	}
	
	public int GetExecutionTime() {
		return this.ExTime;
	}
	
	public SimState getState() {
		return state;
	}
	
	public EventQueue getQueue() {
		return queue;
	}
	
	public void ExectueEffect(SimState state) {
		
	}
	
	

}

/*package lab5.events;

import lab5.state.*;

public class Event2 {

	public double currTime;
	public String eventName;

	/**
	 * The constructor
	 * 
	 * @param time,  The time of the event
	 * @param event, The name of the event
	 */
	public Event2(double time, String event) {
		currTime = time;
		eventName = event;
	}

	public void checkStop(SimState state) {
		if (eventName == "StoppingEvent") {
			state.stop();
		}
	}

	/**
	 * Gets the current time of the store
	 * 
	 * @return the current time
	 */
	public double getCurrentTime() {
		return currTime;
	}

	/**
	 * Gets the current event name
	 * 
	 * @return the event name
	 */
	public String getCurrentEventName() {
		return eventName;
	}

}
*/

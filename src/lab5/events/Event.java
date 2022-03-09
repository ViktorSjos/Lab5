package lab5.events;

import java.awt.Taskbar.State;

import lab5.state.*;

public class Event {
	
	private SimState state;
	private EventQueue queue;
	private int ExTime;

	public Event(SimState state, EventQueue queue) {
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

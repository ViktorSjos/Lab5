package lab5;

import java.awt.EventQueue;

import lab5.events.StartEvent;
import lab5.state.SimState;
import lab5.state.StoreState;

public class Simulation {
	
	public static void main(String[] args) {
		System.out.println("test");
		EventQueue Queue = new EventQueue();
		StoreState storeState = new StoreState();
		SimState simState = new SimState();
	}

}

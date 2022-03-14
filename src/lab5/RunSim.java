package lab5;

import GeneralSim.EventQueue;
import GeneralSim.SimView;
import GeneralSim.Simulation;
import events.ClosingEvent;
import events.StartEvent;
import events.StoppingEvent;
import gui.StoreView;
import random.ExponentialRandomStream;
import random.UniformRandomStream;
import state.CustomerQueue;
import state.StoreState;

public class RunSim {
//	//Simuleringsexempel 1
//	public static final int M = 5;
//	public static final double L = 1;
//	public static final int N = 2;
//
//	public static final double LOW_COLLECTION_TIME = 0.5d;
//	public static final double HIGH_COLLECTION_TIME = 1.0d;
//
//	public static final double LOW_PAYMENT_TIME = 2.0d;
//	public static final double HIGH_PAYMENT_TIME = 3.0d;
//
//	public static final long SEED = 1234;
//	public static final double END_TIME = 10.0d;
//	public static final double STOP_TIME = 999.0d;

	// SimuleringsExempel 2

	public static final double LOW_COLLECTION_TIME = 0.6;
	public static final double HIGH_COLLECTION_TIME = 0.9;

	public static final double LOW_PAYMENT_TIME = 0.35;
	public static final double HIGH_PAYMENT_TIME = 0.6;

	public static final int MaxCust = 7;
	public static final double L = 3;
	public static final int Registers = 2;

	public static final double Close = 8;
	public static final double Start = 999;
	public static final int SEED = 13;

	/**
	 * 
	 * Runs the simulator.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		EventQueue queue = new EventQueue();
		CustomerQueue Cque = new CustomerQueue();
		StoreState state = new StoreState(MaxCust, Registers, Cque, L, SEED, LOW_COLLECTION_TIME, HIGH_COLLECTION_TIME, LOW_PAYMENT_TIME, HIGH_PAYMENT_TIME);
		StoreView view = new StoreView(state, L, LOW_COLLECTION_TIME, HIGH_COLLECTION_TIME, LOW_PAYMENT_TIME, HIGH_PAYMENT_TIME, Registers, MaxCust, SEED);
		StartEvent start = new StartEvent(state, queue);
		ClosingEvent close = new ClosingEvent(state, queue, Close);
		StoppingEvent stop = new StoppingEvent(state, queue);
		Simulation sim = new Simulation(queue, start, stop, view, state, close);
	}
}
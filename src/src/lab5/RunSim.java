package lab5;

import events.ClosingEvent;
import events.EventQueue;
import events.StartEvent;
import events.StoppingEvent;
import gui.SimView;
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

	public static final double Picklower = 0.5;
	public static final double Pickwidth = 1;

	public static final double Paylower = 2;
	public static final double Paywidth = 3;

	public static final int MaxCust = 5;
	public static final double Lambda = 1;
	public static final int Registers = 2;

	public static final double Close = 10;
	public static final double Start = 999;
	public static final long Seed = 1234;

	/**
	 * 
	 * Runs the simulator.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		EventQueue queue = new EventQueue();
		CustomerQueue Cque = new CustomerQueue();
		ExponentialRandomStream Erand = new ExponentialRandomStream(Lambda, Seed);
		UniformRandomStream UrandPay = new UniformRandomStream(Paylower, Paywidth, Seed);
		UniformRandomStream UrandPick = new UniformRandomStream(Picklower, Pickwidth, Seed);
		StoreState state = new StoreState(MaxCust, Registers, Cque, Erand, UrandPay, UrandPick);
		SimView view = new SimView(state, Lambda, Picklower, Pickwidth, Paylower, Paywidth, Registers, MaxCust, Seed);
		StartEvent start = new StartEvent(state, queue);
		ClosingEvent close = new ClosingEvent(state, queue, Close);
		StoppingEvent stop = new StoppingEvent(state, queue);
		Simulation sim = new Simulation(queue, start, stop, view, state, close);
	}
}
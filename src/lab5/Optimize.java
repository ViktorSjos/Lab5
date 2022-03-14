package lab5;

import java.util.Random;

import GeneralSim.EventQueue;
import GeneralSim.Simulation;
import state.CustomerQueue;
import state.StoreState;
import events.ClosingEvent;
import events.StartEvent;
import events.StoppingEvent;
import gui.StoreView;
import random.ExponentialRandomStream;
import random.UniformRandomStream;

/**
 * 
 * Main program that finds the optimal amount of registers.
 * 
 */
public class Optimize implements K {

	private int Registers = 1;
	private StoreState state;
	private int OpminalKassa = Integer.MAX_VALUE;

	/**
	 * Runs the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Optimize a = new Optimize();

		a.printGetOptimalKassor();
		a.printGetOptimalRandomKassor();
	}

	/**
	 * Runs a simulator.
	 * 
	 * @param seed     to try.
	 * @param Ammaount of kassor to try.
	 * @return the state the state.
	 */
	public StoreState run(long seed, int Registers) {
		EventQueue queue = new EventQueue();
		CustomerQueue Cque = new CustomerQueue();
		StoreState state = new StoreState(M, Registers, Cque, L, SEED, LOW_COLLECTION_TIME, HIGH_COLLECTION_TIME, LOW_PAYMENT_TIME, HIGH_PAYMENT_TIME);
		StartEvent start = new StartEvent(state, queue);
		StoppingEvent stop = new StoppingEvent(state, queue);
		ClosingEvent close = new ClosingEvent(state, queue, END_TIME);
		Simulation2 sim = new Simulation2(queue, start, stop, state, close);
		return state;
	}

	/**
	 * Calculates the optimal amount of register.
	 * 
	 * @param seed to try.
	 * @return the optimal amount of kassor.
	 */
	public int getOptimalKassor(long seed) {
		StoreState beststate = run(seed, Registers);
		for (int i = 1; i <= beststate.GetMaxCustomers(); i++) {
			StoreState testState = run(seed, Registers);

			if (testState.getMissedCustomers() < beststate.getMissedCustomers()) {
				beststate = testState;
			}

			if (beststate.getMissedCustomers() == 0) {
				break;
			}
			Registers++;
		}
		Registers = 1;
		this.state = beststate;
		return beststate.GetRegisters();
	}

	/**
	 * 
	 * Finds the optimal amount of registers required.
	 * 
	 * @param seed that is used to generate other seeds.
	 */
	public int getOptimalRandomKassor(long Seed) {
		Random rand = new Random();
		rand.setSeed(Seed);

		int i = 0;

		while (i < 100) {
			long seed = rand.nextLong();
			int nrOfReg = getOptimalKassor(seed);
			if (nrOfReg < OpminalKassa) {
				OpminalKassa = nrOfReg;
				i = 0;
			}
			i++;
		}
		return OpminalKassa;
	}

	/**
	 * Runs getOptimalKassor and print its result.
	 */
	public void printGetOptimalKassor() {
		System.out.println("Optimal "+getOptimalKassor(SEED) + " kassor är den optimal mängden av kassor och det ger "
				+ this.state.getMissedCustomers() + " missade kunder.");
	}

	/**
	 * Runs getOptimalRandomKassor and print its result.
	 */
	public void printGetOptimalRandomKassor() {
		System.out.println("Random "+getOptimalRandomKassor(SEED) + " kassor är den optimal mängden av kassor och det ger "
				+ this.state.getMissedCustomers() + " missade kunder.");
	}
}
package random;

import java.util.Random;

/**
 * returns random values
 * 
 * @author Jonathan Westerdahl, Felix Woxblom,Isak Sandegren,Viktor Sjöstedt
 */
public class UniformRandomStream {

	private Random rand;
	private double lower, width;

	/**
	 * Constructor takes three arguments
	 * 
	 * @param lower
	 * @param upper
	 * @param seed
	 */
	public UniformRandomStream(double lower, double upper, long seed) {
		rand = new Random(seed);
		this.lower = lower;
		this.width = upper - lower;
	}

	/**
	 * constructor takes two arguments
	 * 
	 * @param lower
	 * @param upper
	 */

	public UniformRandomStream(double lower, double upper) {
		rand = new Random();
		this.lower = lower;
		this.width = upper - lower;
	}

	/**
	 * 
	 * @return returns the next random value
	 */
	public double next() {
		return lower + rand.nextDouble() * width;
	}
}

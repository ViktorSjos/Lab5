
package random;

import java.util.Random;

/**
 * generates random numbers
 * 
 * @author Jonathan Westerdahl, Felix Woxblom,Isak Sandegren,Viktor Sjöstedt
 */

public class ExponentialRandomStream {

	private Random rand;
	private double lambda;

	/**
	 * Constructor takes two arguments
	 * 
	 * 
	 * @param lambda
	 * @param seed
	 */
	public ExponentialRandomStream(double lambda, long seed) {
		rand = new Random(seed);
		this.lambda = lambda;
	}

	/**
	 * Constructor takes one argument
	 * 
	 * @param lambda
	 */
	public ExponentialRandomStream(double lambda) {
		rand = new Random();
		this.lambda = lambda;
	}

	/**
	 * 
	 * @return returns random number
	 */

	public double next() {
		return -Math.log(rand.nextDouble()) / lambda;
	}
}

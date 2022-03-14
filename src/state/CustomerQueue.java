/**
 * 
 */
package state;

import java.util.ArrayList;

/**
 * A class representing a customer queue;
 * 
 * @author Jonathan Westerdahl, Felix Woxblom, Isak Sandegren, Viktor Sjöstedt
 *
 */
public class CustomerQueue {
	private ArrayList<Integer> customerQueue = new ArrayList<Integer>();

	/**
	 * Adds the customer id to the array
	 * 
	 * @param The customer ID
	 */
	public void addToArray(int customer) {
		customerQueue.add(customer);
	}

	/**
	 * Returns the length of the queue
	 * 
	 * @return Length of queue
	 */
	public int getCustomerQueueLength() {
		return customerQueue.size();
	}

	/**
	 * Gets the array
	 * 
	 * @return The array
	 */
	public ArrayList<Integer> GetCustomerQueue() {
		return customerQueue;
	}

	/**
	 * Removes the first customer in line
	 */
	public void removeFirstInLine() {
		customerQueue.remove(0);
	}

	/**
	 * Returns the first customer in line
	 * 
	 * @return Position 0 in array
	 */
	public int getFirstInLine() {
		return customerQueue.get(0);
	}
}

package state;

import java.util.ArrayList;

public class CustomerQueue {
	private ArrayList<Integer> customerQueue = new ArrayList<Integer>();

	/**
	 * Adds the customer id to the array
	 * 
	 * @param customer id
	 */
	public void addToArray(int customer) {
		StoreState.UpdateTimeInQueue();
		customerQueue.add(customer);
	}

	/**
	 * Returns the length of the queue
	 * 
	 * @return length of queue
	 */
	public int getCustomerQueueLength() {
		return customerQueue.size();
	}

	/**
	 * Removes the first customer in line
	 */
	public void removeFirstInLine() {
		StoreState.UpdateTimeInQueue();
		customerQueue.remove(customerQueue.get(0));
	}

	/**
	 * Returns the first customer in line
	 * 
	 * @return position 0 in array
	 */
	public int getFirstInLine() {
		return customerQueue.get(0);
	}
}
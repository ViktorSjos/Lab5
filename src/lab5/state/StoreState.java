package lab5.state;

import java.util.ArrayList;

import lab5.events.Event;
import lab5.state.CreateCustomer.Customer;


public class StoreState {
	
	ArrayList<Customer> CustomersInStore = new ArrayList<Customer>();
	CreateCustomer createCustomer = new CreateCustomer();
	
	int MaxCustomers = 20; //maximalt antal customers
	int MissedCustomers = 0;
	
	public StoreState() {
		//Constructor
	}
	
	public Customer AddCustomer() {

		Customer newCustomer = createCustomer.NewCustomer();
		return newCustomer;
	}
	
	public void CustomerArrived(Customer c) {
		CustomersInStore.add(c);
	}
	
	public boolean SpaceAvalible() {
		if (CustomersInStore.size() == MaxCustomers) {
			return false;
		}
		return true;
	}


}

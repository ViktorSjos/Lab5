package lab5.state;

import java.util.ArrayList;

import lab5.events.Event;
import lab5.state.CreateCustomer.Customer;

public class StoreState {

	int LedigaKassor;
	int Customers = 0; // borde det inte vara så här det ska stå, alla som är inne i affären, Fylls
						// alltid på med det minsta lediga positiva heltalet.
						// CustomersPaying försvinner också den från customers, Då är en ny int ledig
						// för nästa kund,

	double currentTime = 0; // ändra från mainloop i simulation
	double TimeInQueue = 0; // en Variabel som costumerQueue får ändra på.
	double TimePlockTid = 0; //
	double TimeInKassa = 0;
	double LastTime = 0;
	double LastTimePayed = 0;

	int MaxCustomers; // maximalt antal customers
	int MissedCustomers = 0;

	int CustomerNr = 0;
	int currCustom = 0; // Variabel som ändras när ett event körs för att veta vilken kund som gör
						// något. Skickas senare till view
	int köat = 0;

	String Name;
	CustomerQueue Queue = new CustomerQueue();
	public boolean Open = false; // Om det får komma in nya kunder.

	public StoreState(int AntalKassor, int maxKunder) {
		// Constructor
		LedigaKassor = AntalKassor;
		MaxCustomers = maxKunder;

	}

	public int CustomerArrived() {
		Customers++;
		return CustomerNr;
	}

	public boolean SpaceAvalible() {
		CustomerNr++; // kundens nummer går upp med varje som försöker komma in. eller kommer in.
		if (Customers > MaxCustomers) {
			MissedCustomers++;
			return false;
		}

		return true;
	}

	public void UpdateTimeInQueue() {// Varje gång kön ändras måste denna uppdateras, Innan kön har uppdaterats.
										// Alltså vid plockhändelse och betalningshändelse.
		TimeInQueue += CustomerQueue.getCustomerQueueLength() * (currentTime - LastTime);
		LastTime = currentTime; // LastTime är senast kön blev uppdaterad.
	}

	public void UpdateTimeLedigaKassor() {// Varje gång Kassorna uppdateras ändras måste denna uppdateras innan
											// uppdateringen sker, med tiden som uppdateringen ska ske
		TimeInKassa += LedigaKassor * (currentTime - LastTimePayed);
		LastTimePayed = currentTime; // LastTime är senast kön blev uppdaterad.
	}

	/**
	 * Returns the current amount of free registers
	 * 
	 * @return Free registers
	 */
	public int getFreeRegister() {
		return LedigaKassor;
	}

	/**
	 * Changes the amount of free registers
	 * 
	 * @param num The amount to change by
	 */
	public void changeFreeRegisters(int num) {
		LedigaKassor += num;
	}

	/**
	 * Changes the amount of customers currently paying
	 * 
	 * @param num The amount to change by
	 */
	public void changeCustomersPaying(int num) {
		// Skrivit det såhär tills vi vet hur vi gör med arrays
		customPaying += num;
	}

	/**
	 * Changes the customer currently doing an event
	 * 
	 * @param num The customer ID
	 */
	public void changeCurrentCustomer(int num) {
		currCustom = 0;
		currCustom += num;
	}

	/**
	 * Changes the amount of customers currently picking items
	 * 
	 * @param num
	 */
	public void changeCustomersShopping(int num) {
		// Skrivit det såhär tills vi vet hur vi gör med arrays
		customInStore += num;
	}

	/**
	 * Changes the stores state to being closed
	 */
	public void closeStore() {
		Open = false;
	}

	/**
	 * Get the current time of the store
	 * 
	 * @return current time
	 */
	public double getCurrentTime() {
		return currentTime;
	}

	/**
	 * Checks if the store is open
	 * 
	 * @return Open state
	 */
	public boolean getShopOpen() {
		return Open;
	}

	public void ChangeName(String NewName) {
		Name = NewName;
	}

}

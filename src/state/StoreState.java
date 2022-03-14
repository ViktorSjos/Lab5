package state;

import java.util.Observable;

import random.ExponentialRandomStream;
import random.UniformRandomStream;

/**
 * @author Jonathan Westerdahl, Felix Woxblom,Isak Sandegren,Viktor Sjöstedt
 * 		
 *         represents the current state of the simulation. And keeps track of
 *         variables related to view.
 * 
 */
public class StoreState extends SimState {

	private int LedigaKassor;
	private int Customers = 0; // borde det inte vara så här det ska stå, alla som är inne i affären, Fylls
	// alltid på med det minsta lediga positiva heltalet.
	// CustomersPaying försvinner också den från customers, Då är en ny int ledig
	// för nästa kund,

	private double currentTime = 0; // ändra från mainloop i simulation
	private double TimeInQueue = 0; // en Variabel som costumerQueue får ändra på.
	private double TimePlockTid = 0; //
	private double TimeInKassa = 0;
	private int Kassor;
	private double LastTime = 0;
	private double LastTimePayed = 0;
	private int customPaying = 0;
	private String openOrClosed = "";
	private double SimStopTime;

	private int MaxCustomers; // maximalt antal customers
	private int MissedCustomers = 0;

	private int CustomerNr = 0;
	private int currCustom = 0; // Variabel som ändras när ett event körs för att veta vilken kund som gör
	// något. Skickas senare till view
	private int köat = 0;
	private int CustomerPaid = 0;

	private String Name;
	CustomerQueue Queue = new CustomerQueue();
	public boolean Open = false; // Om det får komma in nya kunder.
	ExponentialRandomStream Erand;
	UniformRandomStream UrandPay;
	UniformRandomStream UrandPick;

	/**
	 * Constructor
	 * 
	 * Specifies
	 * 
	 * @param M
	 * @param AntalKassor
	 * @param Que
	 * @param L
	 * @param SEED
	 * @param LOW_COLLECTION_TIME
	 * @param HIGH_COLLECTION_TIME
	 * @param LOW_PAYMENT_TIME
	 * @param HIGH_PAYMENT_TIME
	 */
	public StoreState(int M, int AntalKassor, CustomerQueue Que, double L, int SEED, double LOW_COLLECTION_TIME,
			double HIGH_COLLECTION_TIME, double LOW_PAYMENT_TIME, double HIGH_PAYMENT_TIME) {
		// Constructor
		this.LedigaKassor = AntalKassor;
		this.Kassor = AntalKassor;
		this.MaxCustomers = M;
		ExponentialRandomStream Erand = new ExponentialRandomStream(L, SEED);
		UniformRandomStream UrandPay = new UniformRandomStream(LOW_PAYMENT_TIME, HIGH_PAYMENT_TIME, SEED);
		UniformRandomStream UrandPick = new UniformRandomStream(LOW_COLLECTION_TIME, HIGH_COLLECTION_TIME, SEED);
		this.Erand = Erand;
		this.UrandPay = UrandPay;
		this.UrandPick = UrandPick;

	}

	/**
	 * adds a customer to the stor
	 * 
	 * @return returns the customer number of the customer that triggered the event
	 */
	public int AddCustomer() {
		CustomerNr++;
		Customers++;
		return CustomerNr - 1;
	}

	/**
	 * removes customer from store
	 */

	public void RemoveCustomer() {
		Customers--;
		CustomerPaid++;
	}

	/**
	 * checks if store is open
	 * 
	 * @return
	 */

	public boolean OpenCheck() {
		return Open;
	}

	/**
	 * sets the store to open
	 */
	public void OpenSet() {
		Open = true;
	}

	/**
	 * notifies the observer
	 */
	public void UpdateObs() {
		setChanged();
		notifyObservers();
	}

	/**
	 * checks if there is space in the store if not the amount of missed customers
	 * increases by one
	 * 
	 * @return
	 */

	public boolean SpaceAvalible() {
		// kundens nummer går upp med varje som försöker komma in. eller kommer in.
		if (Customers >= MaxCustomers) {
			MissedCustomers++;
			CustomerNr++;
			return false;
		}

		return true;
	}

	/**
	 * Updates the time spent in the queue since the last time the function was
	 * called.
	 * 
	 */

	public void UpdateTimeInQueue() {// Varje gång kön ändras måste denna uppdateras, Innan kön har uppdaterats.
										// Alltså vid plockhändelse och betalningshändelse.
		setTimeInQueue(getTimeInQueue() + Queue.getCustomerQueueLength() * (this.currentTime - this.LastTime));
		LastTime = currentTime; // LastTime är senast kön blev uppdaterad.
	}

	/**
	 * Updates the time the registers has been unnocipied since the last time the
	 * function was called.
	 * 
	 */
	public void UpdateTimeLedigaKassor() {// Varje gång Kassorna uppdateras ändras måste denna uppdateras innan
											// uppdateringen sker, med tiden som uppdateringen ska ske
		setTimeInKassa(getTimeInKassa() + getLedigaKassor() * (this.currentTime - this.LastTimePayed));
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
		setCurrCustom(0);
		setCurrCustom(getCurrCustom() + num);
	}

	/**
	 * 
	 * Sets the simulation to running
	 */
	public void StartSim() {
		Running = true;
	}

	/**
	 * stops the simulation
	 * 
	 */
	public void StopSim() {
		Running = false;
	}

	/**
	 * checks if the simulation is running
	 */

	public boolean RunCheck() {
		return Running;

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
	public void CurrentTime(double time) {
		currentTime = time;
	}

	/**
	 * 
	 * @return returns the current time of the simmulation
	 */
	public double GetCurrentTime() {
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

	/**
	 * 
	 * @return returns the string o if the store is open otherwise C
	 */
	public String GetOpenOrClosed() {
		if (OpenCheck()) {
			return "O";

		} else {
			return "C";
		}
	}

	/**
	 * 
	 * @param NewName returns the name of the last event that changed the state
	 */
	public void ChangeName(String NewName) {
		Name = NewName;
	}

	public int getLedigaKassor() {
		return LedigaKassor;
	}

	public double getTimeInKassa() {
		return TimeInKassa;
	}

	public void setTimeInKassa(double timeInKassa) {
		TimeInKassa = timeInKassa;
	}

	public int getCustomers() {
		return Customers;
	}

	public void setCustomers(int customers) {
		Customers = customers;
	}

	public int getMissedCustomers() {
		return MissedCustomers;
	}

	public void setMissedCustomers(int missedCustomers) {
		MissedCustomers = missedCustomers;
	}

	public int getKöat() {
		return köat;
	}

	public void setKöat(int köat) {
		this.köat = köat;
	}

	public double getTimeInQueue() {
		return TimeInQueue;
	}

	public void setTimeInQueue(double timeInQueue) {
		TimeInQueue = timeInQueue;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public int getCurrCustomNR() {
		return CustomerNr;
	}

	public int getCurrCustom() {
		return currCustom;
	}

	public void setCurrCustom(int currCustom) {
		this.currCustom = currCustom;
	}

	public void IncKöat() {
		köat++;
	}

	public int GetRegisters() {
		return this.Kassor;
	}

	public int GetCustomerPaid() {
		return CustomerPaid;
	}

	public int GetMaxCustomers() {
		return MaxCustomers;
	}

	/**
	 * 
	 * @return exponential random stream
	 */
	public double GetArrivaltime() {
		return Erand.next();
	}

	public double GetPaytime() {
		return UrandPay.next();
	}

	public double GetPicktime() {
		return UrandPick.next();
	}

	public CustomerQueue GetCQ() {
		return Queue;
	}

	public StoreState GetState() {
		return this;
	}

	public void SimStopTime(double time) {
		SimStopTime = time;

	}

	public double GetSimStopTime() {
		return SimStopTime;
	}
}

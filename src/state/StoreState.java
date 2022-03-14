package state;

import java.util.Observable;

import random.ExponentialRandomStream;
import random.UniformRandomStream;

public class StoreState extends SimState {

	private int LedigaKassor;
	private int Customers = 0; // borde det inte vara s� h�r det ska st�, alla som �r inne i aff�ren, Fylls
	// alltid p� med det minsta lediga positiva heltalet.
	// CustomersPaying f�rsvinner ocks� den fr�n customers, D� �r en ny int ledig
	// f�r n�sta kund,

	private double currentTime = 0; // �ndra fr�n mainloop i simulation
	private double TimeInQueue = 0; // en Variabel som costumerQueue f�r �ndra p�.
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
	private int currCustom = 0; // Variabel som �ndras n�r ett event k�rs f�r att veta vilken kund som g�r
	// n�got. Skickas senare till view
	private int k�at = 0;
	private int CustomerPaid = 0;

	private String Name;
	CustomerQueue Queue = new CustomerQueue();
	public boolean Open = false; // Om det f�r komma in nya kunder.
	ExponentialRandomStream Erand;
	UniformRandomStream UrandPay;
	UniformRandomStream UrandPick;

	public StoreState(int M, int AntalKassor, CustomerQueue Que, double L, int SEED, double LOW_COLLECTION_TIME, double HIGH_COLLECTION_TIME, double LOW_PAYMENT_TIME, double HIGH_PAYMENT_TIME) {
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

	public void IncK�at() {
		k�at++;
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

	public double GetArrivaltime() {
		return Erand.next();
	}

	public double GetPaytime() {
		return UrandPay.next();
	}

	public double GetPicktime() {
		return UrandPick.next();
	}

	public int AddCustomer() {
		CustomerNr++;
		Customers++;
		return CustomerNr - 1;
	}

	public void RemoveCustomer() {
		Customers--;
		CustomerPaid++;
	}

	public boolean OpenCheck() {
		return Open;
	}

	public void OpenSet() {
		Open = true;
	}

	public CustomerQueue GetCQ() {
		return Queue;
	}

	public void UpdateObs() {
		setChanged();
		notifyObservers();
	}

	public boolean SpaceAvalible() {
		// kundens nummer g�r upp med varje som f�rs�ker komma in. eller kommer in.
		if (Customers >= MaxCustomers) {
			MissedCustomers++;
			CustomerNr++;
			return false;
		}

		return true;
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

	public void UpdateTimeInQueue() {// Varje g�ng k�n �ndras m�ste denna uppdateras, Innan k�n har uppdaterats.
										// Allts� vid plockh�ndelse och betalningsh�ndelse.
		setTimeInQueue(getTimeInQueue() + Queue.getCustomerQueueLength() * (this.currentTime - this.LastTime));
		LastTime = currentTime; // LastTime �r senast k�n blev uppdaterad.
	}

	public void UpdateTimeLedigaKassor() {// Varje g�ng Kassorna uppdateras �ndras m�ste denna uppdateras innan
											// uppdateringen sker, med tiden som uppdateringen ska ske
		setTimeInKassa(getTimeInKassa() + getLedigaKassor() * (this.currentTime - this.LastTimePayed));
		LastTimePayed = currentTime; // LastTime �r senast k�n blev uppdaterad.
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
		// Skrivit det s�h�r tills vi vet hur vi g�r med arrays
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

	public void StartSim() {
		Running = true;
	}

	public void StopSim() {
		Running = false;
	}

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
	 * @return 
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

	public int getK�at() {
		return k�at;
	}

	public void setK�at(int k�at) {
		this.k�at = k�at;
	}

	public double getTimeInQueue() {
		return TimeInQueue;
	}

	public String GetOpenOrClosed() {
		if (OpenCheck()) {
			return "O";

		} else {
			return "C";
		}
	}

	public void setTimeInQueue(double timeInQueue) {
		TimeInQueue = timeInQueue;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

}
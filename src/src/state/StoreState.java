package state;






public class StoreState extends SimState{

	private static int LedigaKassor;
	private static int Customers = 0; // borde det inte vara så här det ska stå, alla som är inne i affären, Fylls
						// alltid på med det minsta lediga positiva heltalet.
							// CustomersPaying försvinner också den från customers, Då är en ny int ledig
							// för nästa kund,

	static double currentTime = 0; // ändra från mainloop i simulation
	private static double TimeInQueue = 0; // en Variabel som costumerQueue får ändra på.
	double TimePlockTid = 0; //
	private static double TimeInKassa=0;
	double LastTime = 0;
	double LastTimePayed = 0;
	int customPaying = 0;
	
	int MaxCustomers; // maximalt antal customers
	private static int MissedCustomers = 0;

	int CustomerNr = 0;
	private static int currCustom = 0; // Variabel som ändras när ett event körs för att veta vilken kund som gör
						// något. Skickas senare till view
	private static int köat = 0;
	
	private static String Name;
	CustomerQueue Queue = new CustomerQueue();
	public static boolean Open = false; // Om det får komma in nya kunder.

	public StoreState(int AntalKassor, int maxKunder) {
		// Constructor
		LedigaKassor = AntalKassor;
		MaxCustomers = maxKunder;

	}
	
	public int AddCustomer() {
		CustomerNr++;
		return CustomerNr-1;
	}

	public boolean SpaceAvalible() {
		CustomerNr++; //kundens nummer går upp med varje som försöker komma in. eller kommer in.
		if (getCustomers() > MaxCustomers) {
			setMissedCustomers(getMissedCustomers() + 1);
			return false;
		}
		
		return true;
	}


	public void UpdateTimeInQueue(){//Varje gång kön ändras måste denna uppdateras, Innan kön har uppdaterats. Alltså vid plockhändelse och betalningshändelse.
		setTimeInQueue(getTimeInQueue() + CustomerQueue.getCustomerQueueLength()*(currentTime-LastTime)); 
		LastTime=currentTime; // LastTime är senast kön blev uppdaterad.
	}

	public void UpdateTimeLedigaKassor(){//Varje gång Kassorna uppdateras ändras måste denna uppdateras innan uppdateringen sker, med tiden som uppdateringen ska ske
		setTimeInKassa(getTimeInKassa() + getLedigaKassor().size()*(currentTime-LastTimePayed)); 
		LastTimePayed=currentTime; // LastTime är senast kön blev uppdaterad.
	}

	/**
	 * Returns the current amount of free registers
	 * 
	 * @return Free registers
	 */
	public int getFreeRegister() {
		return getLedigaKassor();
	}

	/**
	 * Changes the amount of free registers
	 * 
	 * @param num The amount to change by
	 */
	public void changeFreeRegisters(int num) {
		setLedigaKassor(getLedigaKassor() + num);
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
	public void ChangeName(String NewName){
		Name = NewName;
	}

	public static int getLedigaKassor() {
		return LedigaKassor;
	}

	public void setLedigaKassor(int ledigaKassor) {
		LedigaKassor = ledigaKassor;
	}

	public static double getTimeInKassa() {
		return TimeInKassa;
	}

	public void setTimeInKassa(double timeInKassa) {
		TimeInKassa = timeInKassa;
	}

	public static int getCustomers() {
		return Customers;
	}

	public void setCustomers(int customers) {
		Customers = customers;
	}

	public static int getMissedCustomers() {
		return MissedCustomers;
	}

	public void setMissedCustomers(int missedCustomers) {
		MissedCustomers = missedCustomers;
	}

	public static int getKöat() {
		return köat;
	}

	public void setKöat(int köat) {
		this.köat = köat;
	}

	public static double getTimeInQueue() {
		return TimeInQueue;
	}

	public void setTimeInQueue(double timeInQueue) {
		TimeInQueue = timeInQueue;
	}

	public static String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public static int getCurrCustom() {
		return currCustom;
	}

	public void setCurrCustom(int currCustom) {
		this.currCustom = currCustom;
	}

}
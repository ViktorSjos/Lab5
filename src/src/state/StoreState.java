package state;






public class StoreState extends SimState{

	private int LedigaKassor;
	private int Customers = 0; // borde det inte vara s� h�r det ska st�, alla som �r inne i aff�ren, Fylls
						// alltid p� med det minsta lediga positiva heltalet.
							// CustomersPaying f�rsvinner ocks� den fr�n customers, D� �r en ny int ledig
							// f�r n�sta kund,

	 double currentTime = 0; // �ndra fr�n mainloop i simulation
	private double TimeInQueue = 0; // en Variabel som costumerQueue f�r �ndra p�.
	double TimePlockTid = 0; //
	private double TimeInKassa=0;
	double LastTime = 0;
	double LastTimePayed = 0;
	int customPaying = 0;
	
	int MaxCustomers; // maximalt antal customers
	private int MissedCustomers = 0;

	int CustomerNr = 0;
	private int currCustom = 0; // Variabel som �ndras n�r ett event k�rs f�r att veta vilken kund som g�r
						// n�got. Skickas senare till view
	private int k�at = 0;
	
	private String Name;
	Timer timer;
	CustomerQueue Queue = new CustomerQueue();
	public boolean Open = false; // Om det f�r komma in nya kunder.

	public StoreState(int AntalKassor, int maxKunder, CustomerQueue Que, Timer timer) {
		// Constructor
		LedigaKassor = AntalKassor;
		MaxCustomers = maxKunder;
		this.timer = timer;
	}
	
	public int AddCustomer() {
		CustomerNr++;
		return CustomerNr-1;
	}
	
	public Timer GetTimer() {
		return timer;
	}
	
	public CustomerQueue GetCQ(){
		return Queue;
	}

	public boolean SpaceAvalible() {
		CustomerNr++; //kundens nummer g�r upp med varje som f�rs�ker komma in. eller kommer in.
		if (getCustomers() > MaxCustomers) {
			setMissedCustomers(getMissedCustomers() + 1);
			return false;
		}
		
		return true;
	}


	public void UpdateTimeInQueue(){//Varje g�ng k�n �ndras m�ste denna uppdateras, Innan k�n har uppdaterats. Allts� vid plockh�ndelse och betalningsh�ndelse.
		setTimeInQueue(getTimeInQueue() + Queue.getCustomerQueueLength()*(currentTime-LastTime)); 
		LastTime=currentTime; // LastTime �r senast k�n blev uppdaterad.
	}

	public void UpdateTimeLedigaKassor(){//Varje g�ng Kassorna uppdateras �ndras m�ste denna uppdateras innan uppdateringen sker, med tiden som uppdateringen ska ske
		setTimeInKassa(getTimeInKassa() + getLedigaKassor()*(currentTime-LastTimePayed)); 
		LastTimePayed=currentTime; // LastTime �r senast k�n blev uppdaterad.
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

	public  int getLedigaKassor() {
		return LedigaKassor;
	}

	public void setLedigaKassor(int ledigaKassor) {
		LedigaKassor = ledigaKassor;
	}

	public  double getTimeInKassa() {
		return TimeInKassa;
	}

	public void setTimeInKassa(double timeInKassa) {
		TimeInKassa = timeInKassa;
	}

	public  int getCustomers() {
		return Customers;
	}

	public void setCustomers(int customers) {
		Customers = customers;
	}

	public  int getMissedCustomers() {
		return MissedCustomers;
	}

	public void setMissedCustomers(int missedCustomers) {
		MissedCustomers = missedCustomers;
	}

	public  int getK�at() {
		return k�at;
	}

	public void setK�at(int k�at) {
		this.k�at = k�at;
	}

	public  double getTimeInQueue() {
		return TimeInQueue;
	}

	public void setTimeInQueue(double timeInQueue) {
		TimeInQueue = timeInQueue;
	}

	public  String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public  int getCurrCustom() {
		return currCustom;
	}

	public void setCurrCustom(int currCustom) {
		this.currCustom = currCustom;
	}

}
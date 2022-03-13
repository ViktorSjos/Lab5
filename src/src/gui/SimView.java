package gui;

import lab5.events.Event;
import lab5.events.EventQueue;
import lab5.state.CustomerQueue;
import lab5.state.StoreState;

public class SimView {
	
	static int N;
	static int M;
	static int lambda;
	static int P_min;
	static int P_max;
	static int K_min;
	static int K_max;
	static int f;
	
	
	
	public static void SimView() {
		
		System.out.println("Parametrar");
		System.out.println("==========");
		System.out.println("");
		System.out.println("Antal Kassor: " + N);
		System.out.println("Max som ryms: " + M);
		System.out.println("Ankomsthastighet: " + lambda);
		System.out.println("Plocktider: [" + P_min + ", " + P_max +"]");
		System.out.println("Betaltider: [" + K_min + ", " + K_max +"]");
		System.out.println("Fr�: " + f);
		System.out.println("");
		System.out.println("F�rlopp");
		System.out.println("=======");
		System.out.println("Tid   H�ndelse   Kund   ?   led   ledT   I   $   :-(   k�at   k�T   k�ar   Kassak�");
		
			
		}
	
	public void printEvent() {
		System.out.println(StoreState.getCurrentTime() + StoreState.getName() + StoreState.getCurrCustom() +  StoreState.Open 
				+ StoreState.getLedigaKassor() + StoreState.getTimeInKassa() + 
				StoreState.getCustomers() + StoreState.getMissedCustomers() + StoreState.getK�at() 
				+ StoreState.getTimeInQueue() + CustomerQueue.getCustomerQueueLength()
				+ CustomerQueue.customerQueue);
		
	}
		
	
	
		
		
	
	
	public static void main(String[] args) {
		SimView();
	}

}
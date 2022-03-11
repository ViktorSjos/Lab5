package lab5.state;

import java.util.ArrayList;

import lab5.events.Event;
import lab5.state.CreateCustomer.Customer;


public class StoreState {
	
	ArrayList<Customer> CustomersInStore = new ArrayList<Customer>();
	CreateCustomer createCustomer = new CreateCustomer(); // nu har vi ju customers som objekt
	
	
	ArrayList<Kassa> Kassor = new ArrayList<Kassa>();
	
	int[] Customers; // borde det inte vara så här det ska stå, alla som är inne i affären, Fylls alltid på med det minsta lediga positiva heltalet.
	int[] CustomersInStore; // alla som plockar i affären
	int[] CustomersInQueue;	// alla som står i kö i affären, costumerQueue håller reda på ordningen.
	int[] CustomersPaying; // alla som för tillfället håller på att betala  ,när en person flyttas från CustomersPaying försvinner också den från customers, Då är en ny int ledig för nästa kund,
	
	
	
	int MaxCustomers = 20; //maximalt antal customers
	int MissedCustomers = 0;
	int TimeInQueue= 0; // en Variabel som costumerQueue får ändra på.
	int TimePlockTid=0; //
	
	
	public boolean Open = false //Om det får komma in nya kunder.
	
	
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
	
	public void SendToQueue(int Customer){ // det här borde vara ett event, Eftersom plock event är klart.
		
		if (ComstumerQueue.Queue.isEmpty()){// om kön är tom se om det finns ledig kassa.
			for(int i=0; i<Kassor.size(); i++){
				if(Kassor.get(i).isOccupid==false){ //Någon kassa är ledig flyttas kunden direkt till kassan
					CustomersInStore.Remove(CustomersInStore.indexOf(Costumer)); //tar bort kunden från Instore och flyttar till en kassa
					CustomersPaying.add(Costumer); //lägger till som betalande
					Kassor.get(i).newCustomer();
					return;
				}
			}else{// om alla kassor är upptagna flyttas kunden till kön.
			CustomersInStore.Remove(CustomersInStore.indexOf(Costumer));
			CustomersInQueue.add(Customer); //så som jag gjort det nu behövs inte customerqueue...
			}
			
		return;
		
		}
		
	}
	private class Kassa(){ //ska (eller kan) läggas i annan fil event ändrar sedan kassan till tom eller occupied, samt andra funktioner som påverkar kön.
		boolean isOccupied=False;
		int CustomerNr=-1 // -1 om kassan inte har en Costumer i sig, annars customerNR
		int KassaNummer;
		public Kassa(int KassaNr){ //konstrukorn
			KassaNummer=KassaNr;
		public newCustomer(int Customer){
			isOccupid=true;
			CustomerNr=Costumer;
		}
		public CustomerLeaving(){ //den här borde nog också kommunicera med costumerqueue för att hämta en ny kund till kassan.
			isOccupied=false;	
			CustomerNr=-1;
		}
		}
	}
	


}

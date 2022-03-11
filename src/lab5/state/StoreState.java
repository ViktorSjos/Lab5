package lab5.state;

import java.util.ArrayList;

import lab5.events.Event;
import lab5.state.CreateCustomer.Customer;


public class StoreState {

	
	
	int LedigaKassor; 
	int[] Customers; // borde det inte vara så här det ska stå, alla som är inne i affären, Fylls alltid på med det minsta lediga positiva heltalet.
	int[] CustomersInStore; // alla som plockar i affären
	int[] CustomersInQueue;	// alla som står i kö i affären, costumerQueue håller reda på ordningen.
	int[] CustomersPaying; // alla som för tillfället håller på att betala  ,när en person flyttas från CustomersPaying försvinner också den från customers, Då är en ny int ledig för nästa kund,
	
	
	float currentTime=0; // ändra från mainloop i simulation
	int MaxCustomers; //maximalt antal customers
	int MissedCustomers = 0;
	int TimeInQueue=0; // en Variabel som costumerQueue får ändra på.
	int TimePlockTid=0; //
	
	int LastTime=0;
	
	int CustomerNr=0
	public boolean Open = false //Om det får komma in nya kunder.
	
	
	public StoreState(int AntalKassor,int maxKunder) {
		//Constructor
		LeidgaKassor=AntalKassor; 
		MaxCustomers=maxKunder;
		
		
		
	}
	
	public void AddCustomer(int CustomerNr) {
		CustomersInStore.add(CustomerNr);
		Customer.add(CustomerNr);
		//Skapa Plockevent !!!

	}
	
	public void CustomerArrived() { // Lägg till event får köra den här
		if (CustomerInStore>=MaxCustomers && Open==true){
			MissedCustomers++;
			CustomerNr++;
		}else{
			if(Open){
				addCustomer(CustomerNr);
				CustomerNr++;
			}
		CustomerNr++;
		}
		}
		
			
	}
	
	public boolean SpaceAvalible() {
		if (CustomersInStore.size() == MaxCustomers) {
			return false;
		}
		return true;
	}
	
	public void SendToQueue(int Customer){ // det här borde vara ett event, Eftersom plock event är klart.
		
		if (ComstumerQueue.Queue.isEmpty() && LedigaKassor>0){// om kön är tom och det finns ledig kassa.
				CustomersInStore.Remove(CustomersInStore.indexOf(Costumer)); //tar bort kunden från Instore och flyttar till en kassa
				CustomersPaying.add(Costumer); //lägger till som betalande
				LedigaKassor--;
				return; //den här borde också skapa ett nytt event som är ett betalningsevent som också borde räkna ut en ny tid.
				}
			}else{// om alla kassor är upptagna ställer sig kunden i  kön.
			CustomersInStore.Remove(CustomersInStore.indexOf(Costumer));
			CustomersInQueue.add(Customer); //så som jag gjort det nu behövs inte customerqueue...
			}
			
		return;
		
		
		
	}
	}
	public UpdateTimeInQueue(float Time){//Varje gång kön ändras måste denna uppdateras? Innan kön har blivit uppdaterad. Alltså vid plockhändelse och betalningshändelse.
		TimeInQueue+=CustomersInQueue.size()*(Time-LastTime); 
		LastTime=Time; // LastTime är senast kön blev uppdaterad.
	}
	


}

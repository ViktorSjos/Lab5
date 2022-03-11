package lab5.events;

import java.util.ArrayList;

public class EventQueue {
	
	int Time = 0;
	ArrayList<Event> Queue = new ArrayList<Event>();
	ArrayList<Event> Temp = new ArrayList<Event>();
	
	public EventQueue(){
		
		
		
	}
	
	public void AddEvent(Event Ev) {
		if (Queue.isEmpty()) {
			Queue.add(Ev);
			return;
		}
		for (int i = 0; i<=Queue.size(); i++) {
			if (Ev.GetExecutionTime() <= Queue.get(i).GetExecutionTime()) {
				Temp.add(Ev);
			}
			else {
				Temp.add(Queue.get(i));
			}
			Queue = Temp;
			Temp.clear();
		}
		
	}
	
	public void DoEvent(Object Event) { // kanske bara borde retunera eventet. 
		Queue.get(0);
		Queue.remove(0);
		// if (Queue.isEmpty()==False){
		// x = Queue.get(0);
		// Queue.remove(0);
		// return x.ExecuteEffect //borde gå att endast skicka metoden som har en effekt tillbaka. Då skickar vi allt vi behöver från event till simulation. 
		// det borde fungera eftersom metoden inte längre behöver hämta information från eventklassen utan endast från state. (beroende på hur vi gör med customers osv.
		//} else{return}
	}

}

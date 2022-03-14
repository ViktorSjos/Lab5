package state;

public class SimState {
	
	boolean Running = false;
	double CurrentTime = 0;
	
	public SimState(){
		
	}
	
	public void StartSim() {
		Running = true;
	}
	
	public void StopSim() {
		Running = false;
		System.out.println("STOOOP");
		return;
	}
	
	public boolean RunCheck() {
		return Running;
		
	}

}
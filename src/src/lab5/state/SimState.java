package lab5.state;

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
	}
	
	public boolean RunCheck() {
		return Running;
		
	}

}
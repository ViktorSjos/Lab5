package State;

import java.util.Random;

public class Timer {
	
	private Random rand;
	private double lambda;
	private double Picklower; 
	private double Pickwidth;
	private double Paylower; 
	private double Paywidth;
	  
	
	  
	public double timeToNextCustomer(double lambda) {
		rand = new Random();
	    this.lambda = lambda;
	  	return -Math.log(rand.nextDouble())/lambda;
	}
	
	public double timeToPick(double lower, double upper) {
		rand = new Random();
	    this.Picklower = lower;
	    this.Pickwidth = upper-lower;
	    return Picklower+rand.nextDouble()*Pickwidth;
	}
	
	public double timeToPay(double lower, double upper) {
		rand = new Random();
	    this.Paylower = lower;
	    this.Paywidth = upper-lower;
	    return Paylower+rand.nextDouble()*Paywidth;
	}

	
	/*
	 * Test funktion för tiderna
	 * 
	public static void main(String[] args) {
		Timer myapp = new Timer();
		
		System.out.println(myapp.timeToNextCustomer(1.0));
		System.out.println(myapp.timeToPick(0.5, 1.0));
		System.out.println(myapp.timeToPay(0.5, 1.0));
	}*/
}
		
		

package state;

import java.util.Random;

public class Timer {

    private double lambda;
    private double Picklower; 
    private double Pickwidth;
    private double Paylower; 
    private double Paywidth;
    private Random rand;
    private double lower, width;
    public Timer(double Lambda, double Picklower, double Pickwidth, double Paylower, double Paywidth) {

    this.lambda = Lambda;
    this.Picklower = Picklower;
    this.Pickwidth = Pickwidth;
    this.Paylower = Paylower;
    this.Paywidth = Paywidth;
    }


    public double timeToNextCustomer() {
        rand = new Random();
        System.out.println("TEST CUSTOMER");
        System.out.println(-Math.log(rand.nextDouble())/lambda);
          return -Math.log(rand.nextDouble())/lambda;
    }

    public double timeToPick() {
        rand = new Random();
        return -Math.log(rand.nextDouble())/lambda;
    }

    public double timeToPay() {
        rand = new Random();
        return -Math.log(rand.nextDouble())/lambda;
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
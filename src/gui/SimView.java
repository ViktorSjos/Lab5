package gui;

import java.util.Random;

import events.Event;
import events.EventQueue;
import state.CustomerQueue;
import state.StoreState;

public class SimView {

    private double lambda;
    private double Picklower; 
    private double Pickwidth;
    private double Paylower; 
    private double Paywidth;
    private Random rand;
    int test = 0;

    StoreState StoreState;

    public SimView(StoreState StoreState,double Lambda, double Picklower, double Pickwidth, double Paylower, double Paywidth, int N, int M) {
        this.StoreState=StoreState;
        this.lambda = Lambda;
        this.Picklower = Picklower;
        this.Pickwidth = Pickwidth;
        this.Paylower = Paylower;
        this.Paywidth = Paywidth;

        System.out.println("Parametrar");
        System.out.println("==========");
        System.out.println("");
        System.out.println("Antal Kassor: " + N);
        System.out.println("Max som ryms: " + M);
        System.out.println("Ankomsthastighet: " + lambda);
        System.out.println("Plocktider: [" + Picklower + ", " + Pickwidth +"]");
        System.out.println("Betaltider: [" + Paylower + ", " + Paywidth +"]");
        System.out.println("Frör: " + lambda);
        System.out.println("");
        System.out.println("Färlopp");
        System.out.println("=======");
        System.out.println("Tid   Händelse   Kund   ?   led   ledT   I   $   :(   käat   käT   käar   Kassakä");


        }

    public void printEvent() {
    	test++;
    	System.out.println(test);
        System.out.println(StoreState.GetCurrentTime() +"  "+ StoreState.getName() +"  "+ StoreState.getCurrCustom() +"  "+  StoreState.Open 
                +"  "+ StoreState.getFreeRegister() +"  "+ StoreState.getTimeInKassa() +"  "+ 
                StoreState.getCustomers() +"  "+ StoreState.getMissedCustomers() +"  "+ StoreState.getKöat() 
                +"  "+ StoreState.getTimeInQueue() +"  "+StoreState.GetCQ().getCustomerQueueLength()
                +"  "+ StoreState.GetCQ().GetCustomerQueue());

    }



}
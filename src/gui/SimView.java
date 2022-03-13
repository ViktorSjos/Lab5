package gui;

import events.Event;
import events.EventQueue;
import state.CustomerQueue;
import state.StoreState;

public class SimView {

    static int N;
    static int M;
    static int lambda;
    static int P_min;
    static int P_max;
    static int K_min;
    static int K_max;
    static int f;

    StoreState StoreState;

    public SimView(StoreState StoreState) {
        this.StoreState=StoreState;

        System.out.println("Parametrar");
        System.out.println("==========");
        System.out.println("");
        System.out.println("Antal Kassor: " + N);
        System.out.println("Max som ryms: " + M);
        System.out.println("Ankomsthastighet: " + lambda);
        System.out.println("Plocktider: [" + P_min + ", " + P_max +"]");
        System.out.println("Betaltider: [" + K_min + ", " + K_max +"]");
        System.out.println("Frär: " + f);
        System.out.println("");
        System.out.println("Färlopp");
        System.out.println("=======");
        System.out.println("Tid   Händelse   Kund   ?   led   ledT   I   $   :(   käat   käT   käar   Kassakä");


        }

    public void printEvent() {
        System.out.println(StoreState.GetCurrentTime() + StoreState.getName() + StoreState.getCurrCustom() +  StoreState.Open 
                + StoreState.getLedigaKassor() + StoreState.getTimeInKassa() + 
                StoreState.getCustomers() + StoreState.getMissedCustomers() + StoreState.getKöat() 
                + StoreState.getTimeInQueue() +StoreState.GetCQ().getCustomerQueueLength()
                + StoreState.GetCQ().GetCustomerQueue());

    }



}
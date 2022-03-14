package gui;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import GeneralSim.Event;
import GeneralSim.EventQueue;
import GeneralSim.SimView;
import state.CustomerQueue;
import state.StoreState;

public class StoreView extends SimView implements Observer {

	private double lambda;
	private double Picklower;
	private double Pickwidth;
	private double Paylower;
	private double Paywidth;
	private Random rand;
	private long seed;

	StoreState StoreState;
	String CustVal;

	public StoreView(StoreState StoreState, double Lambda, double Picklower, double Pickwidth, double Paylower,
			double Paywidth, int N, int M, long seed) {
		StoreState.addObserver(this);

		this.StoreState = StoreState;
		this.lambda = Lambda;
		this.Picklower = Picklower;
		this.Pickwidth = Pickwidth;
		this.Paylower = Paylower;
		this.Paywidth = Paywidth;
		this.seed = seed;

		System.out.println("Parametrar");
		System.out.println("==========");
		System.out.println("");
		System.out.println("Antal Kassor: " + N);
		System.out.println("Max som ryms: " + M);
		System.out.println("Ankomsthastighet: " + lambda);
		System.out.println("Plocktider: [" + Picklower + ", " + Pickwidth + "]");
		System.out.println("Betaltider: [" + Paylower + ", " + Paywidth + "]");
		System.out.println("Frö: " + seed);
		System.out.println("");
		System.out.println("Förlopp");
		System.out.println("=======");
		System.out.println("Tid" + "\t" + "Händelse" + "\t" + "Kund" + "\t" + "?" + "\t" + "led" + "\t" + "ledT" + "\t"
				+ "I" + "\t" + "$" + "\t" + ":(" + "\t" + "köat" + "\t" + "köT" + "\t" + "käar" + "\t" + "Kassakö");

	}

	public void update(Observable arg0, Object arg1) {

		if (StoreState.getName() == "Start") {
			System.out.println(String.format("%.2f", StoreState.GetCurrentTime()) + "\t" + StoreState.getName());
			return;
		}
		if (StoreState.getName() == "Stop") {
			System.out.println(String.format("%.2f", StoreState.GetSimStopTime()) + "\t" + StoreState.getName());
			return;
		}
		String CustVal = String.valueOf(StoreState.getCurrCustom());
		if (StoreState.getName() == "Closed") {
			CustVal = "---";
		}
		System.out.println(String.format("%.2f", StoreState.GetCurrentTime()) + "\t" + StoreState.getName() + "\t"
				+ "\t" + CustVal + "\t" + StoreState.GetOpenOrClosed() + "\t" + StoreState.getFreeRegister() + "\t"
				+ String.format("%.2f", StoreState.getTimeInKassa()) + "\t" + StoreState.getCustomers() + "\t"
				+ StoreState.GetCustomerPaid() + "\t" + StoreState.getMissedCustomers() + "\t" + StoreState.getKöat()
				+ "\t" + String.format("%.2f", StoreState.getTimeInQueue()) + "\t"
				+ StoreState.GetCQ().getCustomerQueueLength() + "\t" + StoreState.GetCQ().GetCustomerQueue());

	}

	public void resultat() {
		System.out.println("RESULTAT");
		System.out.println("========");
		System.out.println("");
		System.out.println("1) Av " + StoreState.getCurrCustomNR() + " handlade "
				+ (StoreState.getCurrCustomNR() - StoreState.getMissedCustomers()) + " medan "
				+ StoreState.getMissedCustomers() + " missades.");
		System.out.println("");
		System.out.println("2) Total tid " + StoreState.getLedigaKassor() + " kassor varit lediga: "
				+ String.format("%.2f", StoreState.getTimeInKassa()) + " te.");
		System.out.println("Genomsnittlig ledig kassatid: "
				+ String.format("%.2f", (StoreState.getTimeInKassa() / StoreState.getLedigaKassor())) + " te. (dvs "
				+ String.format("%.2f",
						(((StoreState.getTimeInKassa() / StoreState.getLedigaKassor()) / (StoreState.GetCurrentTime())))
								* 100)
				+ "% av tiden från öppning tills sista kunden betalat).");
		System.out.println("");
		System.out.println("3) Total tid " + StoreState.getKöat() + " kunder tvingats köa: "
				+ String.format("%.2f", StoreState.getTimeInQueue()) + " te.");
		System.out.println("Genomsnittlig kötid: "
				+ String.format("%.2f", (StoreState.getTimeInQueue() / StoreState.getKöat())) + " te.");

	}

}
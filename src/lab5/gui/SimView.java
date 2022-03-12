package lab5.gui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimView extends JPanel{
	
	


	int N;
	int M;
	int lambda;
	int P_min;
	int P_max;
	int K_min;
	int K_max;
	int f;
	
	public SimView() {
		
		JFrame frame = new JFrame();
		
		JLabel label1 = new JLabel("Parametrar");
		JLabel label2 = new JLabel("=============");
		JLabel label3 = new JLabel("Antal kassor: " + N);
		JLabel label4 = new JLabel("Max som ryms: " + M);
		JLabel label5 = new JLabel("Ankomsthastighet: " + lambda);
		JLabel label6 = new JLabel("Plocktider: [" + P_min + ", " + P_max +"]");
		JLabel label7 = new JLabel("Betaltider: [" + K_min + ", " + K_max +"]");
		JLabel label8 = new JLabel("Frö: " + f);
		JLabel label9 = new JLabel("     ");
		JLabel label10 = new JLabel("FÖRLOPP");
		JLabel label11 = new JLabel("========");
		JLabel label12 = new JLabel("Tid       Händelse       	Kund	       ?	       "
				+       	"led	       ledT	       I	       $	       :-(	"
				+ "       	köat	       köT	       	köar"
				+ "		        [Kassakö]");
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 500, 200));
		panel.setLayout(new GridLayout(0,1));
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(label9);
		panel.add(label10);
		panel.add(label11);
		panel.add(label12);
		
		
		//Här ska en forloop som skriver ut eventens värden va
		
		label10.setLocation(200, 200);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("Förlopp");
		frame.pack();
		
		frame.setResizable(true);
		frame.setVisible(true);
	}
	
	

	
	
	public static void main(String[] args) {
		new SimView();
	}

}

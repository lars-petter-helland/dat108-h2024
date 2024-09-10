package baller;

import static baller.Constants.*;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallerMain {

	public static void main(String[] args) {
		
		//Her oppretter vi et ball-objekt med gitt farge
		Ball roedBall = new Ball(Color.RED);
		
		//Her oppretter vi en tegneflate og legger til ballobjektet
		JPanel tegneflate = new JPanel();
		tegneflate.setLayout(null);
		tegneflate.add(roedBall);
		
		//Her oppretter vi selve 2D-grafikk-vinduet legger til tegneflaten
		JFrame grafikkvinduet = new JFrame();
		grafikkvinduet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grafikkvinduet.setLayout(new BorderLayout());
		grafikkvinduet.setSize(PANE_SIZE, PANE_SIZE);
		grafikkvinduet.add(tegneflate);
		
		//Her starter vi applikasjonen ved å gjøre grafikkvinduet synlig
		//og be ballen om å gjøre animasjonen, dvs. bevege og tegne seg 
		//på nytt i evig løkke.
		grafikkvinduet.setVisible(true);
		
		roedBall.animate();
		
		/*
		 * Oppgave:
		 * I stedet for kun én rød ball, så ønsker vi 3 baller
		 * som alle går samtidig.
		 * 
		 * Hvordan løser vi det?
		 */
		
	}

}






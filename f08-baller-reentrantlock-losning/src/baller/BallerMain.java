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
		Ball blaaBall = new Ball(Color.BLUE);
		Ball gronBall = new Ball(Color.GREEN);
		
		//Her oppretter vi en tegneflate og legger til ballobjektet
		JPanel tegneflate = new JPanel();
		tegneflate.setLayout(null);
		tegneflate.add(roedBall);
		tegneflate.add(blaaBall);
		tegneflate.add(gronBall);
		
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
		
		/*
		 * Oppgave:
		 * I stedet for kun én rød ball, så ønsker vi 3 baller
		 * som alle går samtidig.
		 * 
		 * Hvordan løser vi det?
		 */
		
		//Alternativ der vi oppretter tråder i main() som kjører animate.
//		new Thread(() -> roedBall.animate()).start();
//		new Thread(() -> blaaBall.animate()).start();
//		new Thread(() -> gronBall.animate()).start();
		
		//Alternativ der Ball.animate() selv starter en ny tråd for animeringen.
		roedBall.animate();
		blaaBall.animate();
		gronBall.animate();
		
		//Vi kan også tenke oss andre varianter ...
		
	}

}






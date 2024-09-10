package ballstafett;

import static ballstafett.Constants.*;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StafettMain {

	public static void main(String[] args) {
		
		//Tre baller som beveger seg horisontalt, i bane 1,2 og 3
		Ball roedBall = new Ball(Color.RED, 1);
		Ball gronBall = new Ball(Color.GREEN, 2);
		Ball blaaBall = new Ball(Color.BLUE, 3);
		
		//Her oppretter vi en tegneflaten og legger til ballene
		JPanel tegneflate = new JPanel();
		tegneflate.setLayout(null);
		tegneflate.add(roedBall);
		tegneflate.add(gronBall);
		tegneflate.add(blaaBall);
		
		//Her oppretter vi selve 2D-grafikk-vinduet legger til tegneflaten
		JFrame grafikkvinduet = new JFrame();
		grafikkvinduet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grafikkvinduet.setLayout(new BorderLayout());
		grafikkvinduet.setSize(PANE_SIZE, PANE_SIZE/2);
		grafikkvinduet.add(tegneflate);
		
		//Her starter vi applikasjonen ved å gjøre grafikkvinduet synlig
		//og be ballen om å gjøre animasjonen, dvs. bevege og tegne seg 
		//på nytt i evig løkke.
		grafikkvinduet.setVisible(true);
		
		new Thread(() -> roedBall.animate()).start();
		new Thread(() -> gronBall.animate()).start();
		new Thread(() -> blaaBall.animate()).start();
	}
}






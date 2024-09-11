package ballstafett;

import static ballstafett.Constants.BALL_DIAMETER;
import static ballstafett.Constants.MAX_VX_VY;
import static ballstafett.Constants.SLEEP_TIME;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ball extends JPanel {

	private Container tegneflaten;
	private Color farge;
	private int fart;

	public Ball(Color farge, int bane) {
		this.farge = farge;
		this.fart = randomVxVy();
		this.setSize(getPreferredSize());
		this.setLocation(0, bane * 2 * BALL_DIAMETER);
	}

	public void animate() {
		
		/* Triks: Tegneflaten fra main er "parent" til alle ballene siden
		 * de er lagt til denne med add(). Kan derfor bruke den som lock.
		 * 
		 * Vi kunne brukt et annet felles objekt som lock, men da
		 * måtte dette blitt gitt som parameter i konstruktøren.
		 */
		tegneflaten = getParent();
		
		while (isVisible()) {
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
			}
			move();
			repaint();
		}
	}

	public void move() {

		int x = getX();
		int y = getY();

		if (erIMaal(x)) {
			/*
			 * Oppgave: Tenker at hvis vi er kommet i mål, så tar vi en pause til neste ball
			 * kommer i mål. Deretter løper vi igjen.
			 */
			synchronized (tegneflaten) {
				try {
					tegneflaten.notifyAll();	// Gi beskjed til ball(er) som venter at de kan fortsette
					tegneflaten.wait();			// Vent til en annen ball gir beskjed
				} catch (InterruptedException e) {
				}
			}
			fart *= -1; // Skifter retning før vi begynner å løpe igjen
		}
		x += fart;
		setLocation(x, y);
	}

	private boolean erIMaal(int x) {
		return x + fart < 0 && fart < 0 || x + BALL_DIAMETER + fart > tegneflaten.getWidth() && fart > 0;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(BALL_DIAMETER, BALL_DIAMETER);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(farge);
		g.fillOval(0, 0, BALL_DIAMETER - 1, BALL_DIAMETER - 1);
		g.setColor(Color.black);
		g.drawOval(0, 0, BALL_DIAMETER - 1, BALL_DIAMETER - 1);
	}

	private int randomVxVy() {
		return (int) Math.round((Math.random() * MAX_VX_VY) + 1);
	}
}

//Luke Raeside, TU Dublin 2020
//Had a bit of fun with the Graphics

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawFrameOnly extends JFrame implements ActionListener {

	int delay = 50; // Set lower to make plane and missile faster

	public DrawFrameOnly() {

		Font f;

		JLabel colorLabel = new JLabel("H");
		colorLabel.setFont(new Font("Courier New", Font.ITALIC, 15));

		setSize(600, 600);
		setVisible(true);
	}

	public void paint(Graphics g) {
		Polygon currentPlane = null;
		Rectangle currentMissile = null;

		super.paint(g);

		int i = 0;

		Color currentColor = new Color(0, 0, 0);

		g.setColor(currentColor);

		for (i = 0; i < 50; i++) {

			try {
				Thread.sleep(delay);
				g.clearRect(0, 0, getWidth(), getHeight());

				currentPlane = getPlane(g, i);
				g.drawPolygon(currentPlane);
				currentMissile = getMissile(g, i);
				g.fillRect((int) currentMissile.getX(), (int) currentMissile.getY(), (int) currentMissile.getWidth(),
						(int) currentMissile.getHeight());
				if (i == 48) {
					g.setColor(Color.RED);
					g.drawPolygon(currentPlane);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// Remove comments to add in pilot at end - WARNING - he does not make it!
		g.setColor(Color.BLACK);
		g.drawString(">-|o", (int)currentPlane.getBounds().getX(), (int)currentPlane.getBounds().getY()+80);
		g.setColor(Color.RED);
		g.fillOval((int)currentPlane.getBounds().getX()+25, (int)currentPlane.getBounds().getY()+73,30,15);
		
	}

	public Polygon getPlane(Graphics g, int i) {

		int[] xValues = { 30 + (i * 10), 40 + (i * 10), 40 + (i * 10), 60 + (i * 10), 60 + (i * 10), 70 + (i * 10),
				70 + (i * 10), 80 + (i * 10), 80 + (i * 10), 70 + (i * 10), 70 + (i * 10), 60 + (i * 10), 60 + (i * 10),
				40 + (i * 10), 40 + (i * 10), 30 + (i * 10) };
		int[] yValues = { 50 + (i * 5), 50 + (i * 5), 60 + (i * 5), 60 + (i * 5), 30 + (i * 5), 30 + (i * 5),
				60 + (i * 5), 60 + (i * 5), 70 + (i * 5), 70 + (i * 5), 100 + (i * 5), 100 + (i * 5), 70 + (i * 5),
				70 + (i * 5), 80 + (i * 5), 80 + (i * 5) };
		Polygon poly = new Polygon(xValues, yValues, 16);
		g.fillPolygon(xValues, yValues, 16);
		return poly;
	}

	public Rectangle getMissile(Graphics g, int i) {
		Rectangle rect = new Rectangle(550, 550 - (i * 5), 10, 20);
		return rect;
	}

	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}

	public static void main(String[] args) {
		new DrawFrameOnly();
	}

}

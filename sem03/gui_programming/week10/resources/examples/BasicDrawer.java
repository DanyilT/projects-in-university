import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class BasicDrawer extends JFrame {

	public void paint(Graphics g) {
		
		super.paint(g);
		
		System.out.print("Call to paint");
		
		g.setColor(new Color(160,90,168));
		
		g.drawString("Hello", 50, 50);
		
		g.fillArc(100, 100, 90, 90, 0, 90);
		
		g.setColor(Color.RED);
		
		g.drawRoundRect(40, 200, 78, 78, 10, 10);
		
		g.drawOval(65, 220, 5, 5);
		
		g.drawOval(95, 220, 5, 5);
		
		g.drawArc(62,230,40,40,0,-180);

	}
	
	public BasicDrawer() {
		setSize(400,400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BasicDrawer();
	}
	
}

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GiantButtonNoLayout extends JFrame {

	public GiantButtonNoLayout() {
		
		JButton firstButton = new JButton("FirstButton");
		JButton secondButton = new JButton("SecondButton");
		
		Container contentPane = getContentPane();
		
		contentPane.add(firstButton);
		contentPane.add(secondButton);
		
		setSize(300,300);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new GiantButtonNoLayout();

	}

}

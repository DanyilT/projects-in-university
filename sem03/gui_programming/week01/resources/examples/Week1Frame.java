import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Week1Frame extends JFrame {

	public static void main(String[] args) {
		
		Week1Frame frame = new Week1Frame();
	}
	
	public Week1Frame() {
		
		setSize(400,400);
		JButton group7Button = new JButton("Hello Group 7");
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.add(group7Button);
		
		Container myPane = getContentPane();

		myPane.add(buttonPanel,BorderLayout.CENTER);
		
		setVisible(true);
		
	}

}

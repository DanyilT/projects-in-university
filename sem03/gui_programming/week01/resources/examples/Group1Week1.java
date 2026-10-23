import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Group1Week1 extends JFrame {

	public static void main(String[] args) {
		Group1Week1 frame = new Group1Week1();

	}
	
	public Group1Week1() {
		setSize(300,400);
		JButton helloButton = new JButton("Hello Group 1");
		JPanel buttonPanel = new JPanel();	
		buttonPanel.add(helloButton);
		
		
		Container myPane = getContentPane();
		myPane.add(buttonPanel,BorderLayout.NORTH);
		
		setVisible(true);
	}

}

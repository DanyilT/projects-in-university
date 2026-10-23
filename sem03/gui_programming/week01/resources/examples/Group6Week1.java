import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Group6Week1 extends JFrame {

	public static void main(String[] args) {
		
		Group6Week1 frame = new Group6Week1();
	}
	
	public Group6Week1() {
		setSize(600,600);
		
		JPanel buttonPanel = new JPanel();
		
		JButton okButton = new JButton("Push Me");
		
		buttonPanel.add(okButton);
		Container contentPane = getContentPane();
		contentPane.add(buttonPanel);
		setVisible(true);

	}

}

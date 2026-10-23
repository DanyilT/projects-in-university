import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Week1Group3 extends JFrame {

	public static void main(String[] args) {
		Week1Group3 frame = new Week1Group3();
	}

	public Week1Group3()

	{

		setSize(800, 800);

		Container contentPane = getContentPane();
		JButton clickButton = new JButton("Click Here");

		JPanel buttonPanel = new JPanel();
		JLabel brianLabel = new JLabel("Hi I'm Brian");

		ImageIcon brianImage = new ImageIcon("Kenno.jpg");
		brianLabel.setIcon(brianImage);
		buttonPanel.add(brianLabel);
		buttonPanel.add(clickButton);

		contentPane.add(buttonPanel);

		setVisible(true);
	}

}

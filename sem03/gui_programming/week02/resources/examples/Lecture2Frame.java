import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lecture2Frame extends JFrame {

	public static void main(String[] args) {
		
			new Lecture2Frame();
	}
	
	public Lecture2Frame() {
		Font bigFont = new Font("Arial",Font.BOLD | Font.ITALIC,40);
		
		ImageIcon brianImage = new ImageIcon("Kenno.jpg");
		
		setTitle("Brian Frame");
		JLabel favFoodLabel = new JLabel("Enter Fav Food");
		favFoodLabel.setIcon(brianImage);
		JTextField favFoodField = new JTextField(20);
		favFoodLabel.setFont(bigFont);
		JPanel favFoodPanel = new JPanel();
		
		favFoodPanel.add(favFoodLabel);
		favFoodPanel.add(favFoodField);
		
		//getContentPane().add(favFoodPanel);
		Container contentPane = getContentPane();
		contentPane.add(favFoodPanel,BorderLayout.SOUTH);		


		
		setSize(1000,500);
		setVisible(true);
		
		
	}

}

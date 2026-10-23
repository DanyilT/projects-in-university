import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Group1Week2 extends JFrame {

	public static void main(String[] args) {
		new Group1Week2();
	}
	
	public Group1Week2() {
		setSize(570,300);
		
		Font titleFont = new Font("Sans Serif",Font.BOLD,35);
		
		JLabel titleLabel = new JLabel("Raeside Med Center");
		titleLabel.setFont(titleFont);
		JPanel titlePanel = new JPanel();
		titlePanel.add(titleLabel);
		
		JPanel inputPanel = new JPanel();
		JLabel nameLabel = new JLabel("Name:");
		JLabel ageLabel = new JLabel("Age:");
		JLabel descLabel = new JLabel("Description of problem:");
		
		JTextField nameField = new JTextField(10);
		JTextField ageField = new JTextField(10);
		JTextArea descArea = new JTextArea(20,40);
		JScrollPane descScroller = new JScrollPane(descArea);
		
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(ageLabel);
		inputPanel.add(ageField);
		inputPanel.add(descLabel);
		inputPanel.add(descScroller);
		
		
		
		
		getContentPane().add(titlePanel,BorderLayout.NORTH);
		getContentPane().add(inputPanel);
		
		
		setVisible(true);
	}

}

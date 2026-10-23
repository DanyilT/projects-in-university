import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Group6Week2 extends JFrame{

	public static void main(String[] args) {
		new Group6Week2();

	}
	
	public Group6Week2() {
		setSize(300,550);
		
		Font bannerFont = new Font("Aerial",Font.BOLD | Font.ITALIC,45);
		
		JPanel welcomePanel = new JPanel();
		JPanel inputPanel = new JPanel();
		
		JLabel nameLabel = new JLabel("Name:");
		JLabel ageLabel = new JLabel("Age:");
		JLabel letterLabel = new JLabel("Cover Letter:");
		
		JTextField nameField = new JTextField(20);
		JTextField ageField = new JTextField(20);
		JTextArea letterArea = new JTextArea(20,20);
		JScrollPane letterScroll = new JScrollPane(letterArea);
		
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(ageLabel);
		inputPanel.add(ageField);
		inputPanel.add(letterLabel);
		inputPanel.add(letterScroll);
		
		
		JTextField regWelcomeField = new JTextField("Register App");
		regWelcomeField.setFont(bannerFont);
		
		welcomePanel.add(regWelcomeField);
		
		getContentPane().add(welcomePanel,BorderLayout.NORTH);
		getContentPane().add(inputPanel);
		
		setVisible(true);
	}

}

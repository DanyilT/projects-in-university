// Luke Raeside ITB 2015
// Program to demonstrate card layout, switch two cards (added as panels) in handler method

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CardLayoutExample extends JFrame implements ActionListener {

	String[] displayOptions = {"Display next card"};
	
	//Set up panels for card switching, uses two methods to build and return panels
	JPanel blackPanel=buildBlackTextPanel(), redPanel=buildRedTextPanel(), displayPanel=new JPanel();
	JComboBox<String> switchDisplay = new JComboBox<String>(displayOptions);
    Font textFont;

	public CardLayoutExample() {
		
		displayPanel.setLayout(new CardLayout());
		displayPanel.add(blackPanel);
		displayPanel.add(redPanel);
		switchDisplay.addActionListener(this);
		getContentPane().add(displayPanel, BorderLayout.NORTH);
		getContentPane().add(switchDisplay);
		
		setSize(300,300);
		setVisible(true);
		
	}
	
	//Build first panel to be added to the card
	public JPanel buildBlackTextPanel() {
		
		JPanel panel = null;
		
		panel = new JPanel();
				
		JLabel card1Label = new JLabel();
		card1Label.setText("Label on Card 1");
	    textFont = new Font("Serif", Font.BOLD | Font.ITALIC, 32);
		card1Label.setFont(textFont);
		panel.add(card1Label);
		
		//Returns the completed panel
		return panel;
		
	}
	
	//Builds second card for the panel
	public JPanel buildRedTextPanel() {
		
		JPanel panel = null;
		
		panel = new JPanel();
		
		JLabel card2Label = new JLabel("Label on Card 2");
	    textFont = new Font("Serif", Font.BOLD, 32);
		card2Label.setFont(textFont);
		card2Label.setForeground(Color.RED);
		panel.add(card2Label);
		
		//return the completed panel
		return panel;
	}
	
	public void actionPerformed(ActionEvent e) {
		//Get the card layout from the main panel
		CardLayout card = (CardLayout)displayPanel.getLayout();
		
		//Move to the next card in the card layout
		card.next(displayPanel);
		
	}

	public static void main(String[] args) {
		
		new CardLayoutExample();

	}

}

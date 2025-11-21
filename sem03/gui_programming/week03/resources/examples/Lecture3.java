import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Lecture3 extends JFrame {

	public static void main(String[] args) {
		new Lecture3();

	}
	
	public Lecture3() {
		setSize(500,200);
		
		ButtonGroup voteGroup = new ButtonGroup();
		
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JPanel votePanel = new JPanel();
		votePanel.setLayout(new GridLayout(1,3));
		
		JRadioButton ffButton = new JRadioButton("FF");
		JRadioButton fgButton = new JRadioButton("FG");
		JRadioButton sfButton = new JRadioButton("SF");
		
		JCheckBox yesNoBox = new JCheckBox("Yes/No");
		
		voteGroup.add(ffButton);
		voteGroup.add(fgButton);
		voteGroup.add(sfButton);
		
		votePanel.add(ffButton);
		votePanel.add(fgButton);
		votePanel.add(sfButton);
		
		bottomPanel.add(yesNoBox);
		bottomPanel.add(votePanel);
		
		topPanel.setLayout(new GridLayout(1,2));
		
		String[] consStrings = {"DUB","MTH"};
		
		JComboBox<String> consCombo = new JComboBox<>(consStrings);
		
		String[] partyStrings = {"FF","FG","G","SF"};
		
		JList<String> partyList = new JList<>(partyStrings);
		
		topPanel.add(consCombo);
		topPanel.add(partyList);
		
		getContentPane().add(topPanel,BorderLayout.NORTH);
		getContentPane().add(bottomPanel,BorderLayout.SOUTH);
	
		//getContentPane().setLayout(new FlowLayout());
		setVisible(true);
	}

}

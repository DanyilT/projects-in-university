import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class Week3Group7 extends JFrame {

	public static void main(String[] args) {
		new Week3Group7();

	}

	public Week3Group7() {
		setSize(250,250);
		
		String[] labArray = {"A05","A04"};
		
		JPanel displayPanel = new JPanel();
		JPanel listPanel = new JPanel();
		
		FlowLayout leftFlow = new FlowLayout();
		leftFlow.setAlignment(FlowLayout.RIGHT);
		
		displayPanel.setLayout(leftFlow);
		

		
		JComboBox<String> labCombo = new JComboBox<>(labArray);
		
		String[] groupArray = {"Group 7","Group 4"};
		
		JList<String> groupList = new JList<>(groupArray);
		
		displayPanel.add(labCombo,BorderLayout.WEST);
		listPanel.add(groupList);
		displayPanel.add(listPanel,BorderLayout.EAST);
		
		
		getContentPane().add(displayPanel);
		
		
		setVisible(true);
	}
}

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class Week3Group1 extends JFrame {

	public static void main(String[] args) {
		new Week3Group1();

	}
	
	
	public Week3Group1() {
		setSize(500,500);
		
		GridLayout rowsLayout = new GridLayout(1,2);
		FlowLayout leftyLayout = new FlowLayout();
		leftyLayout.setAlignment(FlowLayout.LEFT);
		
		JPanel holsPanel = new JPanel();
		
		String[] holsArray = {"Tenerife","Jamaica"};
		
		JComboBox<String> holsCombo = new JComboBox<>(holsArray);
		
		String[] activityArray = {"SightSeeing","Wind Surfing"};
		
		JList<String> holsList = new JList<>(activityArray);
		
		holsPanel.setLayout(leftyLayout);
		
		holsPanel.add(holsCombo);
		holsPanel.add(holsList);
		
		getContentPane().add(holsPanel,BorderLayout.EAST);
		
		
		setVisible(true);
	}

}

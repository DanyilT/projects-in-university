import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class Week3Group6 extends JFrame {

	public static void main(String[] args) {
		new Week3Group6();

	}
	
	public Week3Group6() {
		setSize(400,400);
		
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(2,1));
		
		String[] streets = {"O'Connell","Talbot"};
		
		JComboBox<String> streetCombo = new JComboBox<>(streets);
		
		listPanel.add(streetCombo);
		
		String[] cities = {"Galway","Dublin","Cork","Limerick"};
		
		JList<String> cityList = new JList<>(cities);
		
		listPanel.add(cityList);
		
		getContentPane().add(listPanel);
		
		
		setVisible(true);
	}

}

//Luke Raeside ITB 2015
//An example of BoxLayout in use

import java.awt.GraphicsConfiguration;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BoxLayoutExample extends JFrame {

	JLabel[] listOfCities = new JLabel[6];
	String[] cities = {"Dublin", "London", "Paris", "Berlin","Brussels", "Anderlecht"};
	JPanel citiesPanel = new JPanel();
	
	public BoxLayoutExample() {
		
		//Vertical layout set
		//citiesPanel.setLayout(new BoxLayout(citiesPanel,BoxLayout.Y_AXIS));
		//HORIZONTAL List:// 
		BoxLayout theBox = new BoxLayout(citiesPanel,BoxLayout.X_AXIS);
		citiesPanel.setLayout(theBox);

		
		initialiseCityLabels();
		this.getContentPane().add(citiesPanel);
		
		setSize(500,500);
		setVisible(true);
	}
	
	public void initialiseCityLabels() {
		
		//This loop creates 5 new labels and adds to the array of labels for display
		for (int i = 0; i < cities.length; i++) {
			listOfCities[i]=new JLabel();
			listOfCities[i].setText(cities[i]);
			citiesPanel.add(listOfCities[i]);
			//citiesPanel.add(Box.createHorizontalGlue()); //Can be added to make space
		}
	}

	public static void main(String[] args) {
		
		new BoxLayoutExample();

	}

}

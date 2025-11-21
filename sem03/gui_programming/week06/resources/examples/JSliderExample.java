// Luke Raeside ITB 2015

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class JSliderExample extends JFrame implements ChangeListener {
	
	//Label for the output from slider value
	JLabel outputLabel = new JLabel("Test will appear here");
	//Create the JSlider
	JSlider slider = new JSlider();
	
	public JSliderExample() {
		
		//Set the max and min values for the slider
		slider.setMaximum(100);
		slider.setMinimum(0);
		
		//Add listener to keep track of the changing values on slider
		slider.addChangeListener(this);
		
		getContentPane().add(slider, BorderLayout.NORTH);
		getContentPane().add(outputLabel);
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JSliderExample();
	}

	public void stateChanged(ChangeEvent e) {
		
		//This handler will be invoked every time the slider moves\changes value
		outputLabel.setText("Set: " + slider.getValue());	
	}

}

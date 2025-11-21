// Luke Raeside, ITB 2015

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class ProgBarExample extends JFrame {
	//Create the progress bar
	JProgressBar progBar;
	//Add a panel to hold the progress bar
	JPanel progPanel;

	//Construct to build the program
	public ProgBarExample() {
		//call method to set up the progress bar
		addBar();

		setSize(400,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ProgBarExample progBarTest = new ProgBarExample();
		//Call the awaitProg method to update value by 10 every second
		progBarTest.awaitProg();
	}
	
	//Method to set up the progress bar
	public void addBar() {
		progPanel = new JPanel();
		progBar = new JProgressBar();
		
		//sets the maximum values of the bar
		progBar.setMaximum(100);
		
		progPanel.add(progBar);
		
		this.getContentPane().add(progPanel);
	}
	
	//This method uses a delay thread Thread.sleep(time); to delay the setting of the current
	//value of the progress bar by 1 second (progBar.setValue) set every second increasing by 
	//10
	public void awaitProg() {
		int time = 1000; //1000 milliseconds is one second
		int total = 10;
		while(total <= 100) { //Every second 10 is added to the value
			total+=10;
			try {
				Thread.sleep(time);
				progBar.setValue(progBar.getValue()+10);
				validate();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Toolkit.getDefaultToolkit().beep(); //Beep when finished
	}

}

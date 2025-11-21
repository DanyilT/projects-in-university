//Luke Raeside ITB, 2015
//Program to demonstrate the color chooser

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class ColorChooserExample extends JFrame implements ActionListener {

	JPanel colorPanel = new JPanel();
	JButton colorChoice = new JButton("Change Colour");
	
	public ColorChooserExample() {
		
		//set a thick border on the panel
		colorPanel.setBorder(new LineBorder(Color.BLACK,5));
		this.getContentPane().add(colorPanel);
		this.getContentPane().add(colorChoice,BorderLayout.SOUTH);
		
		colorChoice.addActionListener(this);
		
		setSize(400,400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new ColorChooserExample();

	}

	public void actionPerformed(ActionEvent e) {
		
		//Launch color chooser and store the color selected by the use
		Color chosenColor = (new JColorChooser()).showDialog(colorPanel, "Choose colour", Color.BLACK);
		colorPanel.setBackground(chosenColor);
		
	}

}

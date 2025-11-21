import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class ColorAndFileChooserExample extends JFrame implements ActionListener {

	JPanel panelDisplays = new JPanel(new GridLayout(2,0));
	JPanel colorPanel = new JPanel();
	JPanel imagePanel = new JPanel();

	JPanel buttonPanel = new JPanel();
	JButton colorChoice = new JButton("Change Colour");
	JButton imageChoice = new JButton("Change Image");
	JLabel imageLabel = new JLabel();
	
	
	public ColorAndFileChooserExample() {
		
		colorPanel.setBorder(new LineBorder(Color.BLACK,5));
		imagePanel.setBorder(new LineBorder(Color.BLACK,5));
		imagePanel.add(imageLabel);
		
		this.getContentPane().add(colorPanel);

		buttonPanel.add(colorChoice);
		buttonPanel.add(imageChoice);
		
		panelDisplays.add(colorPanel);
		panelDisplays.add(imagePanel);

		this.getContentPane().add(buttonPanel,BorderLayout.SOUTH);
		this.getContentPane().add(panelDisplays);
		
		colorChoice.addActionListener(this);
		imageChoice.addActionListener(this);
		
		setSize(400,400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new ColorAndFileChooserExample();

	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==colorChoice) {
			Color chosenColor = (new JColorChooser()).showDialog(colorPanel, "Choose colour", Color.BLACK);
			colorPanel.setBackground(chosenColor);
		}
		else {
		
			JFileChooser fileChooser = new JFileChooser();
			int optionVal=fileChooser.showOpenDialog(panelDisplays);
			
			if (optionVal == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
	            imageLabel.setIcon(new ImageIcon(file.getName()));
	            System.out.println(file.getName());
	        } else {
	            System.out.println("No File");            
	        }
		}	
	}

}

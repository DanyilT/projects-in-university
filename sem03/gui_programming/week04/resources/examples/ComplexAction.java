import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComplexAction extends JFrame implements ActionListener {

	JButton button = new JButton("First Button"), buttonTwo = new JButton("Second Button");
	JLabel outputLabel = new JLabel("Text will change here");
	
	public ComplexAction() {

		super("Complex Action Test");
		Container contentPane = getContentPane();

		//create the panel and buttons
		JPanel panel = new JPanel();
		//add the action listeners
		button.addActionListener(this);
		buttonTwo.addActionListener(this);

		//add the buttons to the panel
		panel.add(button);
		panel.add(buttonTwo);
		panel.add(outputLabel);

		//add the panel to the frame and display it
		contentPane.add(panel);
		setSize(300, 200);
		setVisible(true);

	}// end of constructor

	public static void main(String args[]) {
		ComplexAction testcomplexAction = new ComplexAction();
	}

	public void actionPerformed(ActionEvent e) {
		String message = "";

		if (e.getSource()==button)
			message = "you clicked on the first button - Action 1";
		else
			message = "you clicked on the second button - Action 2";
		// System.out.println(e.toString());

		outputLabel.setText(message);
	}

} // end of class
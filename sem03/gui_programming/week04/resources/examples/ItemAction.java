import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ItemAction extends JFrame implements ItemListener {

	JCheckBox box1, box2;
	JLabel outputLabel = new JLabel("Output here");

	public ItemAction() {

		super("Complex Action Test");

		Container contentPane = getContentPane();

		// create the panel and buttons
		JPanel panel = new JPanel();
		box1 = new JCheckBox("Action 1");
		box2 = new JCheckBox("Action 2");

		// add the action listeners
		box1.addItemListener(this);
		box2.addItemListener(this);

		// add the buttons to the panel
		panel.add(box1);
		panel.add(box2);
		panel.add(outputLabel);

		// add the panel to the frame and display it
		contentPane.add(panel);
		setSize(400, 300);
		setVisible(true);

	}// end of constructor

	public static void main(String args[]) {

		ItemAction testcomplexAction = new ItemAction();

	}

	public void itemStateChanged(ItemEvent e) {
		String message = "";
		// Object source = e.getItemSelectable();
		if (e.getItemSelectable() == box1)
			message = "you clicked on the first box - Action 1";
		else
			message = "you clicked on the second box - Action 2";
		
		outputLabel.setText(message);
	}

} // end of class
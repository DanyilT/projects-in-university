import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListSelection extends JFrame implements ListSelectionListener {

	JList list;
	JLabel outputLabel = new JLabel("Message appears here");

	String choices[] = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto" };

	public ListSelection() {

		super("List Selection Example");
		Container contentPane = getContentPane();
		list = new JList(choices);
		list.addListSelectionListener(this);
		JScrollPane pane = new JScrollPane(list);
		contentPane.add(pane);
		contentPane.add(outputLabel, BorderLayout.SOUTH);
		setSize(400, 300);
		setVisible(true);
	}// end of constructor

	public static void main(String[] args) {
		ListSelection myList = new ListSelection();

	}

	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();
		if (source == list) {
			int selectionNum = 0;
			String message = "The selected index is: ";
			selectionNum = list.getSelectedIndex();
			outputLabel.setText(message + selectionNum);

		}

	}

}// end of class

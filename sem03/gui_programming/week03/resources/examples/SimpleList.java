import javax.swing.*;
import java.awt.*;

class SimpleList extends JFrame {

	public SimpleList() {

		super("An Example of a Simple List");

		Container contentPane = getContentPane();

		String choices[] = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto" };

		JList list = new JList(choices);
		JScrollPane pane = new JScrollPane(list);

		contentPane.add(pane);
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		SimpleList myList = new SimpleList();

	}

}

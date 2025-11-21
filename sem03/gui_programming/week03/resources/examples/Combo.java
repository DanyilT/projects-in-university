import javax.swing.*;
import java.awt.*;

class Combo extends JFrame {

	public Combo() {
		super("Combo Example");

		Container c = getContentPane();
		JPanel panel = new JPanel();

		String choices[] = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto" };

		JComboBox combo = new JComboBox();
		// inline
		JComboBox comboTwo = new JComboBox(choices);

		// loop construct
		// populating an array using a loop
		// start finish increment value
		for (int i = 0; i < choices.length; i++) {
			combo.addItem(choices[i]);
		}

		comboTwo.setEditable(true);
		comboTwo.setMaximumRowCount(4);
		panel.add(combo);
		panel.add(comboTwo);
		c.add(panel);
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		Combo myCombo = new Combo();

	}

}

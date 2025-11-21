import javax.swing.*;
import java.awt.*;

class Combo_Java_1_7 extends JFrame {

	public Combo_Java_1_7() {
		super("Combo Example");

		Container contentPane = getContentPane();
		JPanel panel = new JPanel();

		String choices[] = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto" };

		JComboBox<String> combo = new JComboBox<String>();
		// inline
		JComboBox<String> comboTwo = new JComboBox<String>(choices);

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
		contentPane.add(panel);
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		Combo_Java_1_7 myCombo = new Combo_Java_1_7();

	}

}

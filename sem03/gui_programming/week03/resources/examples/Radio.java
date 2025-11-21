import javax.swing.*;
import java.awt.*;

class Radio extends JFrame {

	public Radio() {

		super("An Example of a Radio Button Application");

		Container c = getContentPane();
		JPanel panel = new JPanel();
		JRadioButton bold = new JRadioButton("Bold");
		JRadioButton plain = new JRadioButton("Plain", true);
		panel.add(bold);
		panel.add(plain);

		c.add(panel);
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		Radio myRadio = new Radio();

	}

}

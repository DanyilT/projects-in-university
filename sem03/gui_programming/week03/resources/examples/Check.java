import javax.swing.*;
import java.awt.*;

class Check extends JFrame {

	public Check() {

		super("An Example of a Check Box Application");

		Container contentPane = getContentPane();
		JPanel panel = new JPanel();
		JCheckBox bold = new JCheckBox("bold");
		JCheckBox plain = new JCheckBox("plain", true);
		panel.add(bold);
		panel.add(plain);

		contentPane.add(panel);
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		Check myCheck = new Check();

	}

}

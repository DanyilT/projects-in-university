import javax.swing.*;
import java.awt.*;

class Password extends JFrame {

	public Password() {
		super("password Example");

		Container contentPane = getContentPane();
		JPanel panel = new JPanel();
		JPasswordField passField = new JPasswordField(20);
		JPasswordField passFieldTwo = new JPasswordField(20);
		passField.setEchoChar('?');
		panel.add(passField);
		panel.add(passFieldTwo);
		contentPane.add(panel);
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		Password passdemo = new Password();

	}

}

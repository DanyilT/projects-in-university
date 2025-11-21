
import javax.swing.*;

import java.awt.Dimension;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventDemo extends JFrame implements WindowListener {

	public WindowEventDemo() {
		setTitle("Window Event Window");
		addWindowListener(this);
		JLabel label = new JLabel("Watch System out messages for events");
		getContentPane().add(label, BorderLayout.CENTER);
		setSize(400,200);
		setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		setVisible(false);
		System.out.println("Window closing");
	}

	public void windowClosed(WindowEvent e) {
		System.out.println("Window closed");
	}

	public void windowOpened(WindowEvent e) {
		System.out.println("Window opened");
	}

	public void windowIconified(WindowEvent e) {
		System.out.println("Window iconified");
	}

	public void windowDeiconified(WindowEvent e) {
		System.out.println("Window deiconified");
	}

	public void windowActivated(WindowEvent e) {
		System.out.println("Window activated");
	}

	public void windowDeactivated(WindowEvent e) {
		System.out.println("Window deactivated");
	}
	
	public static void main(String[] args) {
		new WindowEventDemo();
	}
	
}

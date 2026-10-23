import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MnemonicSample extends JFrame {

	public static void main(String[] args) {
		
		new MnemonicSample();
		
	}
	
	public MnemonicSample() {
		
		JMenuBar menuBar = new JMenuBar();
		
		menuBar.add(buildMenu());
		
		setJMenuBar(menuBar);
		
		setSize(500,500);
		
		setVisible(true);
		
	}
	
	private JMenu buildMenu() {
		
		JMenu returnMenu = new JMenu("Test");
		JMenuItem testItem = new JMenuItem("Test");
		
		testItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test");
			}
		});
		
		returnMenu.add(testItem);
		
		returnMenu.setMnemonic('T');
		testItem.setMnemonic('T');
		testItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.ALT_MASK));
		
		return returnMenu;
		
	}

}

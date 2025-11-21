import javax.swing.*;
import java.awt.*;

public class MenuBar3Methods extends JFrame {

	public MenuBar3Methods() {

		super("Menu With Items");

		JMenuBar mb = new JMenuBar();

		JMenu helpMenu = new JMenu("Help", true);


		mb.add(buildFileMenu());
		mb.add(buildHelpMenu());
		setJMenuBar(mb);

		setSize(300, 200);
		setVisible(true);

	}

	public static void main(String[] args) {

		MenuBar3Methods myMenuBar = new MenuBar3Methods();

	}
	
	public static JMenu buildFileMenu() {
				
		JMenu fileMenu = new JMenu("File", false);
		
		fileMenu.add(new JMenuItem("new"));
		fileMenu.add(new JMenuItem("open"));
		fileMenu.addSeparator();

		fileMenu.add(new JMenuItem("print"));
		fileMenu.add(new JMenuItem("exit"));
		
		return fileMenu;
		
	}
	
	private static JMenu buildHelpMenu() {
		JMenu helpMenu = new JMenu("Help", false);
		
		helpMenu.add(new JMenuItem("up"));
		helpMenu.add(new JMenuItem("down"));
		helpMenu.addSeparator();

		helpMenu.add(new JMenuItem("foward"));
		helpMenu.add(new JMenuItem("back"));
		
		return helpMenu;
	
	}

}
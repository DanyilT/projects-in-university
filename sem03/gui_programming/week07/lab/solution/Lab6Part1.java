import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab6Part1 extends JFrame {

    private JDesktopPane desktopPane = new JDesktopPane();

    public Lab6Part1() {
        // Create the frame
        setTitle("Games Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the menu bar for the frame
        setJMenuBar(createMenu());

        // Add the desktop pane to the center of the frame
        add(desktopPane, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    private JMenuBar createMenu() {
        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu gamesMenu = new JMenu("Games Menu");

        // Create menu items
        JMenuItem chessMenuItem = new JMenuItem("Launch Chess Game");
        JMenuItem snakesMenuItem = new JMenuItem("Launch Snakes and Ladders");

        // Add menu items to the menu
        gamesMenu.add(chessMenuItem);
        gamesMenu.add(snakesMenuItem);
        menuBar.add(gamesMenu);

        // Add action listeners to menu items
        chessMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchGame(desktopPane, "Chess Game", "img/Part1/Chess Game.png");
            }
        });

        snakesMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchGame(desktopPane, "Snakes and Ladders", "img/Part1/Snakes and Ladders.png");
            }
        });

        return menuBar;
    }

    private void launchGame(JDesktopPane desktopPane, String title, String imagePath) {
        JInternalFrame internalFrame = new JInternalFrame(title, true, true, true, true);
        internalFrame.setSize(400, 400);
        internalFrame.setVisible(true);

        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        internalFrame.add(imageLabel, BorderLayout.CENTER);

        desktopPane.add(internalFrame);
        try {
            internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create an instance of Lab6Part1 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab6Part1());
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab6Part1 extends JFrame {

    public Lab6Part1() {
        // Create the frame
        setTitle("Games Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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
        setJMenuBar(menuBar);

        // Create desktop pane to hold internal frames
        JDesktopPane desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

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

        // Make the frame visible
        setVisible(true);
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

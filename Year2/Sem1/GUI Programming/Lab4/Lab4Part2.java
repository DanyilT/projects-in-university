import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Lab4Part2 extends JFrame {

    private JLabel imageLabel;

    public Lab4Part2() {
        // Create the frame
        setTitle("Streaming Services");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create the menu
        JMenu streamingMenu = new JMenu("Streaming Services");

        // Create the menu items
        JMenuItem netflixItem = new JMenuItem("Netflix");
        JMenuItem huluItem = new JMenuItem("Hulu");
        JMenuItem disneyPlusItem = new JMenuItem("Disney+");
        JMenuItem amazonPrimeItem = new JMenuItem("Amazon Prime");

        // Add menu items to the menu
        streamingMenu.add(netflixItem);
        streamingMenu.add(huluItem);
        streamingMenu.add(disneyPlusItem);
        streamingMenu.add(amazonPrimeItem);

        // Add the menu to the menu bar
        menuBar.add(streamingMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Create the label and add it to the center of the frame
        imageLabel = new JLabel("Select a streaming service", SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // Add ActionListeners to the menu items
        netflixItem.addActionListener(new StreamingServiceActionListener("img/Part2/Netflix_Logo_RGB.png"));
        huluItem.addActionListener(new StreamingServiceActionListener("img/Part2/hulu-Black-digital.png"));
        disneyPlusItem.addActionListener(new StreamingServiceActionListener("img/Part2/disney_logo_march_2024_050fef2e.png"));
        amazonPrimeItem.addActionListener(new StreamingServiceActionListener("img/Part2/prime-logo-rgb-prime-blue-master.png"));

        // Make the frame visible
        setVisible(true);
    }

    // ActionListener class to handle menu item selection
    private class StreamingServiceActionListener implements ActionListener {
        private String imagePath;

        public StreamingServiceActionListener(String imagePath) {
            this.imagePath = imagePath;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                BufferedImage originalImage = ImageIO.read(new File(imagePath));
                Image resizedImage = originalImage.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(resizedImage));
                imageLabel.setText("");
            } catch (IOException exception) {
                exception.printStackTrace();
                imageLabel.setText("Image not found");
                imageLabel.setIcon(null);
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of Lab4Part2 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab4Part2());
    }
}

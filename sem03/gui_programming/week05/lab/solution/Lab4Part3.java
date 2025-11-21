import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Lab4Part3 extends JFrame {

    private JLabel imageLabel;
    private JTextArea textArea;

    public Lab4Part3() {
        // Create the frame
        setTitle("News and Weather");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create the News menu
        JMenu newsMenu = new JMenu("News");
        newsMenu.setMnemonic('N');

        // Create the Weather menu
        JMenu weatherMenu = new JMenu("Weather");
        weatherMenu.setMnemonic('W');

        // Create the menu items for News
        JMenuItem localNewsItem = new JMenuItem("Local News");
        localNewsItem.setMnemonic('L');
        localNewsItem.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));
        JMenuItem internationalNewsItem = new JMenuItem("International News");
        internationalNewsItem.setMnemonic('I');
        internationalNewsItem.setAccelerator(KeyStroke.getKeyStroke("ctrl I"));

        // Create the menu items for Weather
        JMenuItem localWeatherItem = new JMenuItem("Local Weather");
        localWeatherItem.setMnemonic('O');
        localWeatherItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        JMenuItem internationalWeatherItem = new JMenuItem("International Weather");
        internationalWeatherItem.setMnemonic('T');
        internationalWeatherItem.setAccelerator(KeyStroke.getKeyStroke("ctrl T"));

        // Add menu items to the News menu
        newsMenu.add(localNewsItem);
        newsMenu.add(internationalNewsItem);

        // Add menu items to the Weather menu
        weatherMenu.add(localWeatherItem);
        weatherMenu.add(internationalWeatherItem);

        // Add the menus to the menu bar
        menuBar.add(newsMenu);
        menuBar.add(weatherMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Create the label for images and add it to the center of the frame
        imageLabel = new JLabel("", SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // Create the text area for descriptions and make it scrollable
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Add ActionListeners to the menu items
        localNewsItem.addActionListener(new MenuActionListener("img/Part3/local_news.png", "Ukrainian 'Дія' now available in all world countries!"));
        internationalNewsItem.addActionListener(new MenuActionListener("img/Part3/international_news.png", "The Unicorns' army has invaded the Earth! You are under our control, stupid humans!"));
        localWeatherItem.addActionListener(new MenuActionListener("img/Part3/local_weather.png", "Global warming is a myth! We all gonna die before it happens!"));
        internationalWeatherItem.addActionListener(new MenuActionListener("img/Part3/international_weather.png", "Aliens again drew circles on the fields, so the weather is expected to be sunny!"));

        // Make the frame visible
        setVisible(true);
    }

    // ActionListener class to handle menu item selection
    private class MenuActionListener implements ActionListener {
        private String imagePath;
        private String description;

        public MenuActionListener(String imagePath, String description) {
            this.imagePath = imagePath;
            this.description = description;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                BufferedImage originalImage = ImageIO.read(new File(imagePath));
                Image resizedImage = originalImage.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(resizedImage));
                textArea.setText(description);
            } catch (IOException exception) {
                exception.printStackTrace();
                imageLabel.setText("Image not found");
                imageLabel.setIcon(null);
                textArea.setText("");
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of Lab4Part3 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab4Part3());
    }
}

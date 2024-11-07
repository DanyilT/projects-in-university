import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Lab5Part3 extends JFrame {

    private JLabel[] labels;
    private JSlider slider;
    private ImageIcon blankIcon;
    private ImageIcon imageIcon;

    public Lab5Part3() {
        // Create the frame
        setTitle("BoxLayout with Slider");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a main panel with BoxLayout (horizontal layout)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        // Initialize blank and actual image icons
        blankIcon = createBlankIcon();
        ImageIcon originalIcon = new ImageIcon("img/Part3/venus-de-milo.jpg");
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(resizedImage);

        // Create the labels and add them to the main panel
        labels = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            labels[i] = new JLabel(blankIcon); // Set initial blank icon for each label
            labels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            mainPanel.add(labels[i]);
        }

        // Create the slider with min 0 and max 3 (matching label indexes)
        slider = new JSlider(0, 3, 0);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // Add a ChangeListener to the slider to update the labels dynamically
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue(); // Get the current slider value
                updateLabels(value); // Update label icons based on slider position
            }
        });

        // Add the main panel and slider to the frame
        add(mainPanel, BorderLayout.CENTER);
        add(slider, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    // Method to create a blank icon for non-active labels
    private ImageIcon createBlankIcon() {
        BufferedImage blankImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = blankImage.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 100, 100);
        g2d.dispose();
        return new ImageIcon(blankImage);
    }

    // Method to update label icons based on slider value
    private void updateLabels(int index) {
        // Loop through labels and set icon based on the current slider value
        for (int i = 0; i < labels.length; i++) {
            if (i == index) {
                labels[i].setIcon(imageIcon); // Set the actual image icon for the selected label
            } else {
                labels[i].setIcon(blankIcon); // Set blank icon for all other labels
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of Lab5Part3 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab5Part3());
    }
}

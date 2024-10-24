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
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a main panel with BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        // Create the blank and image icons
        blankIcon = createBlankIcon();
        imageIcon = new ImageIcon(new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB));

        // Create the labels and add them to the main panel
        labels = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            labels[i] = new JLabel(blankIcon);
            labels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            mainPanel.add(labels[i]);
        }

        // Create the slider with min 0 and max 3
        slider = new JSlider(0, 3, 0);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // Add a ChangeListener to the slider to update the labels
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                updateLabels(value);
            }
        });

        // Add the main panel and slider to the frame
        add(mainPanel, BorderLayout.CENTER);
        add(slider, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    private ImageIcon createBlankIcon() {
        BufferedImage blankImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = blankImage.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 50, 50);
        g2d.dispose();
        return new ImageIcon(blankImage);
    }

    private void updateLabels(int index) {
        for (int i = 0; i < labels.length; i++) {
            if (i == index) {
                labels[i].setIcon(imageIcon);
            } else {
                labels[i].setIcon(blankIcon);
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of Lab5Part3 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab5Part3());
    }
}

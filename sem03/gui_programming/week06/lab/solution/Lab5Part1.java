import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Lab5Part1 extends JFrame {

    private JProgressBar progressBar;
    private JSlider slider;

    public Lab5Part1() {
        // Create the JFrame, set appropriate size and set title
        setTitle("Progress Bar and Slider Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create the progress bar with min 0 and max 50
        progressBar = new JProgressBar(0, 50);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        // Create the slider with min 0 and max 50
        slider = new JSlider(0, 50);
        slider.setValue(0);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // Add a ChangeListener to the slider to update the progress bar
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                progressBar.setValue(value);
            }
        });

        // Add the components to the main panel
        mainPanel.add(progressBar, BorderLayout.NORTH);
        mainPanel.add(slider, BorderLayout.SOUTH);

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of Lab5Part1 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab5Part1());
    }
}

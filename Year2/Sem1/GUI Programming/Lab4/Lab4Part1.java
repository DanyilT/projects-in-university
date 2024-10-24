import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab4Part1 extends JFrame {

    private JLabel textLabel;

    public Lab4Part1() {
        // Create the frame
        setTitle("Font Size Selector");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create the checkboxes
        JCheckBox tinyFontCheckBox = new JCheckBox("Tiny Font");
        JCheckBox largeFontCheckBox = new JCheckBox("Large Font");
        JCheckBox veryBigFontCheckBox = new JCheckBox("Very Big Font");
        JCheckBox hugeFontCheckBox = new JCheckBox("Huge Font");

        // Create a ButtonGroup to ensure only one checkbox is selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(tinyFontCheckBox);
        group.add(largeFontCheckBox);
        group.add(veryBigFontCheckBox);
        group.add(hugeFontCheckBox);

        // Create a panel for the checkboxes and add them to the panel
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.add(tinyFontCheckBox);
        checkBoxPanel.add(largeFontCheckBox);
        checkBoxPanel.add(veryBigFontCheckBox);
        checkBoxPanel.add(hugeFontCheckBox);

        // Add the checkbox panel to the top of the frame
        add(checkBoxPanel, BorderLayout.NORTH);

        // Create the label and add it to the center of the frame
        textLabel = new JLabel("Text To Resize", SwingConstants.CENTER);
        add(textLabel, BorderLayout.CENTER);

        // Add ActionListeners to the checkboxes
        tinyFontCheckBox.addActionListener(new FontSizeActionListener(12));
        largeFontCheckBox.addActionListener(new FontSizeActionListener(18));
        veryBigFontCheckBox.addActionListener(new FontSizeActionListener(24));
        hugeFontCheckBox.addActionListener(new FontSizeActionListener(30));

        // Make the frame visible
        setVisible(true);
    }

    // ActionListener class to handle font size changes
    private class FontSizeActionListener implements ActionListener {
        private int fontSize;

        public FontSizeActionListener(int fontSize) {
            this.fontSize = fontSize;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textLabel.setFont(new Font("Arial", Font.PLAIN, fontSize));
        }
    }

    public static void main(String[] args) {
        // Create an instance of Lab4Part1 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab4Part1());
    }
}

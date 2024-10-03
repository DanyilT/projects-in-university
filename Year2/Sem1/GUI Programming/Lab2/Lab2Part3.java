import javax.swing.*;
import java.awt.*;

public class Lab2Part3 extends JFrame {

    public Lab2Part3() {
        // Create the frame
        setTitle("ComboBox and RadioButton Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create the first JComboBox complete with String info
        String[] comboBox1Items = {"Pizza", "Borsch", "Cheeseburger", "Apple Pie", "Cannabis"}; // Select your favourite food
        JComboBox<String> comboBox1 = new JComboBox<>(comboBox1Items);

        // Create the second JComboBox complete with String info
        String[] comboBox2Items = {"Shrek", "Shrek 2", "Shrek the Third", "Shrek Forever After", "Puss in Boots", "Shrek 5: You didn't see this chapter?"}; // Find the imposter
        JComboBox<String> comboBox2 = new JComboBox<>(comboBox2Items);

        // Add the JComboBox’s to the top of the frame one-on-top-of-the-other
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new GridLayout(2, 1, 10, 10));
        comboBoxPanel.add(comboBox1);
        comboBoxPanel.add(comboBox2);
        add(comboBoxPanel, BorderLayout.NORTH);

        // Create TWO JRadioButtons complete with text added to the bottom of the frame
        JRadioButton topComboRadioButton = new JRadioButton("Top Combo");
        JRadioButton bottomComboRadioButton = new JRadioButton("Bottom Combo");

        // Make the radio buttons so only ONE can be selected
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(topComboRadioButton);
        radioButtonGroup.add(bottomComboRadioButton);

        // Add the label with the big and bold font above the buttons
        JLabel label = new JLabel("Please select which ComboBox you like the most from the two shown above");
        label.setFont(new Font("Arial", Font.BOLD, 10));

        // Create a panel for the radio buttons and label
        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.setLayout(new BorderLayout());
        radioButtonPanel.add(label, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(topComboRadioButton);
        buttonsPanel.add(bottomComboRadioButton);
        radioButtonPanel.add(buttonsPanel, BorderLayout.CENTER);

        // Add the radio button panel to the bottom of the frame
        add(radioButtonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of Lab2Part3. And run it on the Event Dispatch Thread using SwingUtilities.invokeLater(), this is make sure that the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab2Part3());
    }
}

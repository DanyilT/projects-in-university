package Lab3Part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Lab3Part2 class that demonstrates the use of try-catch blocks to handle ArrayIndexOutOfBoundsException and NumberFormatException in a GUI application.
 */
public class Lab3Part2 extends JFrame {
    private JTextField inputField;
    private JLabel outputLabel;

    private static final String[] cityArray = {"Cork", "Dublin", "Belfast", "Galway"};

    public Lab3Part2() {
        setTitle("City Array Index");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        JLabel promptLabel = new JLabel("Please enter the array index you wish to output:");
        inputField = new JTextField();
        JButton inputButton = new JButton("Submit");
        outputLabel = new JLabel();

        add(promptLabel);
        add(inputField);
        add(inputButton);
        add(outputLabel);

        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleInput();
            }
        });
    }

    /**
     * Handle the input from the user and display the corresponding city from the array
     */
    private void handleInput() {
        try {
            int index = Integer.parseInt(inputField.getText());
            outputLabel.setText(cityArray[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            String retryIndex = JOptionPane.showInputDialog(this, "You attempted to access beyond the limits of the array, please enter a number between 0 and 3:");
            try {
                int retry = Integer.parseInt(retryIndex);
                outputLabel.setText(cityArray[retry]);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                outputLabel.setText("Invalid input.");
            }
        } catch (NumberFormatException e) {
            outputLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Lab3Part2().setVisible(true);
        });
    }
}

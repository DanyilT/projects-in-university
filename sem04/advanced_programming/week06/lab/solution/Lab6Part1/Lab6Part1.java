package Lab6Part1;

import javax.swing.*;
import java.awt.*;

public class Lab6Part1 extends JFrame{
    private JLabel radiusLabel, resultLabel;
    private JTextField radiusField;
    private JButton calculateButton;

    public Lab6Part1() {
        setTitle("Lab6Part1");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        radiusLabel = new JLabel("Radius:");
        radiusField = new JTextField();
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Circumference: ");

        calculateButton.addActionListener(e -> {
            try {
                double radius = Double.parseDouble(radiusField.getText());
                double circumference = Utility.calculateCircumference(radius);
                resultLabel.setText("Circumference: " + circumference);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        });

        add(radiusLabel);
        add(radiusField);
        add(calculateButton);
        add(resultLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab6Part1().setVisible(true));
    }
}

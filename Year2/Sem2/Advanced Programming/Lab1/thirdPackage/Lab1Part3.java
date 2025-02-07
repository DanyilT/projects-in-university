package thirdPackage;

import firstPackage.Lab1Par1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab1Part3 extends JFrame {
    private JTextField textField;
    private JLabel resultLabel;

    public Lab1Part3() {
        setTitle("Lab1Part3");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel inputLabel = new JLabel("Input initial here: ");
        textField = new JTextField(10);
        JButton button = new JButton("Click here to retrieve student name from initials");
        resultLabel = new JLabel("Result of method call will appear here");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(inputLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(button, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(resultLabel, gbc);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText(Lab1Par1.getMyNameFromMyInitial(textField.getText().toUpperCase().toCharArray()));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab1Part3().setVisible(true);
            }
        });
    }
}

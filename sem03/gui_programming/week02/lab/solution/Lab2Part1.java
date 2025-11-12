import javax.swing.*;
import java.awt.*;

public class Lab2Part1 extends JFrame {

    public Lab2Part1() {
        // Create the JFrame and settings
        setTitle("Club Member Details Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the JPanel
        JPanel panel = new JPanel();

        // Set a good layout manager on JPanel
        panel.setLayout(new GridLayout(7, 2, 10, 10));

        // Create labels for the fields
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel surnameLabel = new JLabel("Surname:");
        JLabel cityLabel = new JLabel("City:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel enterPasswordLabel = new JLabel("Enter Password:");
        JLabel verifyPasswordLabel = new JLabel("Verify Password:");

        // Create input fields for the member info
        JTextField firstNameField = new JTextField();
        JTextField surnameField = new JTextField();
        JTextField cityField = new JTextField();
        JTextField ageField = new JTextField();

        // Create the password fields
        JPasswordField enterPasswordField = new JPasswordField();
        JPasswordField verifyPasswordField = new JPasswordField();

        // Add components to the panel
        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(surnameLabel);
        panel.add(surnameField);
        panel.add(cityLabel);
        panel.add(cityField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(enterPasswordLabel);
        panel.add(enterPasswordField);
        panel.add(verifyPasswordLabel);
        panel.add(verifyPasswordField);

        // Add panel to the JFrame content pane
        getContentPane().add(panel);

        // Make the JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of Lab2Part1. And run it on the Event Dispatch Thread using SwingUtilities.invokeLater(), this is make sure that the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab2Part1());
    }
}

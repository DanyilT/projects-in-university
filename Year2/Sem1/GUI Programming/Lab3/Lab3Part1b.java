import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3Part1b {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab3Part1b"); // Create a new frame
        frame.setSize(300, 200); // Set the size of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the frame when the user clicks the close button
        frame.setLocationRelativeTo(null); // Center the frame

        JPanel panel = new JPanel(); // Create a new panel
        JButton button = new JButton("My Text Changes When You Push Me"); // Create a new button

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setText("See, I Told You The Text Would Change?");
            }
        });

        // Add the button to the panel & add the panel to the frame
        panel.add(button);
        frame.getContentPane().add(panel);

        frame.setVisible(true); // Make the frame visible
    }
}

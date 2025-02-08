package Lab2Part4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * TestFourExceptionsGUI class that demonstrates the use of try-catch-finally blocks to handle different types of exceptions in a GUI application.
 */
public class TestFourExceptionsGUI extends JFrame implements ActionListener {
    private JButton testIOExceptionButton;
    private JButton testURLExceptionButton;
    private JButton testNullPointerExceptionButton;
    private JButton testGeneralExceptionButton;

    public TestFourExceptionsGUI() {
        // Set up the frame
        setTitle("Test Four Exceptions GUI");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        // Create buttons
        testIOExceptionButton = new JButton("Test IO Exception");
        testURLExceptionButton = new JButton("Test URL Exception");
        testNullPointerExceptionButton = new JButton("Test Null Pointer Exception");
        testGeneralExceptionButton = new JButton("Test General Exception");

        // Add buttons to the frame
        add(testIOExceptionButton);
        add(testURLExceptionButton);
        add(testNullPointerExceptionButton);
        add(testGeneralExceptionButton);

        // Add action listeners
        testIOExceptionButton.addActionListener(this);
        testURLExceptionButton.addActionListener(this);
        testNullPointerExceptionButton.addActionListener(this);
        testGeneralExceptionButton.addActionListener(this);
    }

    /**
     * Handle button click events
     * @param e The action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == testIOExceptionButton) {
            testException("Hi", "Whatever.txt", "http://www.itb.ie", false);
        } else if (e.getSource() == testNullPointerExceptionButton) {
            testException(null, "Real.txt", "http://www.itb.ie", false);
        } else if (e.getSource() == testURLExceptionButton) {
            testException("Hi", "Real.txt", "ht//www.itb.ie", false);
        } else if (e.getSource() == testGeneralExceptionButton) {
            testException("Hi", "Real.txt", "http://www.itb.ie", true);
        }
    }

    /**
     * Test method that throws different exceptions based on the input parameters
     * @param string The string to test
     * @param filename The filename to test
     * @param url The URL to test
     * @param generalExceptionActivated Whether to throw (activate) a general exception
     */
    public void testException(String string, String filename, String url, boolean generalExceptionActivated) {
        try {
            string.toCharArray(); // Null string potential error
            new FileReader(filename); // Unknown filename potential error
            new URL(url); // Badly written URL potential error
            if (generalExceptionActivated) { // Potential error
                this.clone(); // Will be caught as a general error!
            }
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(this, "The URL passed is not correctly formatted: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "There has been an input/output error: " + e.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "A null object has been passed to the method: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unidentified error has occurred: " + e.getMessage());
        } finally {
            JOptionPane.showMessageDialog(this, "The finally block has been called");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TestFourExceptionsGUI frame = new TestFourExceptionsGUI();
            frame.setVisible(true);
        });
    }
}

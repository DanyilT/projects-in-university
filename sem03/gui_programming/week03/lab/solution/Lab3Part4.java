import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3Part4 extends JFrame {

    private JLabel balanceLabel;
    private double balance = 0.0;

    public Lab3Part4() {
        // Create the JFrame, set appropriate size and set title
        setTitle("Mobile Top-up System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);

        // Create a title label
        JLabel titleLabel = new JLabel("Mobile Top-up System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create a panel for the buttons with GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBackground(Color.DARK_GRAY);

        // Create the buttons for the menu options
        JButton btnTopUp = new JButton("Top-up");
        JButton btnMakeCall = new JButton("Make Call");
        JButton btnSendText = new JButton("Send Text");

        // Add buttons to the button panel
        buttonPanel.add(btnTopUp);
        buttonPanel.add(btnMakeCall);
        buttonPanel.add(btnSendText);

        // Add the button panel to the center of the main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Create a label to display the balance
        balanceLabel = new JLabel("Balance: $0.00", JLabel.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        balanceLabel.setForeground(balance > 0.0 ? Color.GREEN : Color.RED);
        mainPanel.add(balanceLabel, BorderLayout.SOUTH);

        // Add the main panel to the JFrame
        add(mainPanel);

        // Add ActionListeners to the buttons
        btnTopUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balance += 10.0; // Top-up by $10
                updateBalance();
            }
        });

        btnMakeCall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (balance >= 2.0) { // Make call costs $2
                    balance -= 2.0;
                    updateBalance();
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient balance to make a call."); // please never call me
                }
            }
        });

        btnSendText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (balance >= 0.5) { // Send text costs $0.50
                    balance -= 0.5;
                    updateBalance();
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient balance to send a text.");
                }
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    private void updateBalance() {
        balanceLabel.setText(String.format("Balance: $%.2f", balance));
        balanceLabel.setForeground(balance > 0.0 ? Color.GREEN : Color.RED);
    }

    public static void main(String[] args) {
        // Create an instance of Lab3Part4. And run it on the Event Dispatch Thread using SwingUtilities.invokeLater(), this is make sure that the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab3Part4());
    }
}

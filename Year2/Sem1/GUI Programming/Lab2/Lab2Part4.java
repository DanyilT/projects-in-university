import javax.swing.*;
import java.awt.*;

public class Lab2Part4 extends JFrame {

    public Lab2Part4() {
        // Create the JFrame, set appropriate size and set title (with Fonts)
        setTitle("ATM Machine Menu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);

        // Create a title label
        JLabel titleLabel = new JLabel("ATM Machine Menu", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.GRAY);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create a panel for the buttons with GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBackground(Color.DARK_GRAY);

        // Create the buttons for the menu options (6 minimum)
        JButton btnBalance = new JButton("Check Balance");
        JButton btnWithdraw = new JButton("Withdraw Cash");
        JButton btnDeposit = new JButton("Deposit Cash");
        JButton btnTransfer = new JButton("Transfer Funds");
        JButton btnStatement = new JButton("Print Statement");
        JButton btnExit = new JButton("Exit");

        // Add buttons to the button panel
        buttonPanel.add(btnBalance);
        buttonPanel.add(btnWithdraw);
        buttonPanel.add(btnDeposit);
        buttonPanel.add(btnTransfer);
        buttonPanel.add(btnStatement);
        buttonPanel.add(btnExit);

        // Add the button panel to the center of the main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Create a label to instruct/help the user
        JLabel instructionLabel = new JLabel("Please select an option:", JLabel.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        instructionLabel.setForeground(Color.PINK);
        mainPanel.add(instructionLabel, BorderLayout.SOUTH);

        // Add the main panel to the JFrame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of Lab2Part4. And run it on the Event Dispatch Thread using SwingUtilities.invokeLater(), this is make sure that the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab2Part4());
    }
}

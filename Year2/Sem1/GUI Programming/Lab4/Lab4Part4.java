import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab4Part4 extends JFrame {

    private JLabel outputLabel;
    private JTextField inputField;
    private double balance = 0.0;

    public Lab4Part4() {
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

       // Create an input field for user input
        inputField = new JTextField();
        mainPanel.add(inputField, BorderLayout.NORTH);

        // Create an output label to show responses
        outputLabel = new JLabel("Please select an option", JLabel.CENTER);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        outputLabel.setForeground(Color.BLUE);
        mainPanel.add(outputLabel, BorderLayout.SOUTH);

        // Add the main panel to the JFrame
        add(mainPanel);

        // Add button listeners
        btnBalance.addActionListener(new ButtonActionListener("Balance checked"));
        btnWithdraw.addActionListener(new ButtonActionListener("Cash withdrawn"));
        btnDeposit.addActionListener(new ButtonActionListener("Cash deposited"));
        btnStatement.addActionListener(new ButtonActionListener("Statement printed"));
        btnExit.addActionListener(e -> System.exit(0));

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu menu = new JMenu("Options");
        menu.setMnemonic('O'); // Mnemonic

        // Create menu items
        JMenuItem menuItemBalance = new JMenuItem("Check Balance");
        menuItemBalance.setAccelerator(KeyStroke.getKeyStroke('B', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx())); // Accelerator
        JMenuItem menuItemWithdraw = new JMenuItem("Withdraw Cash");
        menuItemWithdraw.setAccelerator(KeyStroke.getKeyStroke('W', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx())); // Accelerator
        JMenuItem menuItemDeposit = new JMenuItem("Deposit Cash");
        menuItemDeposit.setAccelerator(KeyStroke.getKeyStroke('D', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx())); // Accelerator

        // Add menu items to the menu
        menu.add(menuItemBalance);
        menu.add(menuItemWithdraw);
        menu.add(menuItemDeposit);

        // Add menu to the menu bar
        menuBar.add(menu);

        // Set the menu bar to the frame
        setJMenuBar(menuBar);

        // Add menu item listeners
        menuItemBalance.addActionListener(new ButtonActionListener("Balance checked"));
        menuItemWithdraw.addActionListener(new ButtonActionListener("Cash withdrawn"));
        menuItemDeposit.addActionListener(new ButtonActionListener("Cash deposited"));

        // Make the frame visible
        setVisible(true);
    }

    // ActionListener class to handle button and menu item actions
    private class ButtonActionListener implements ActionListener {
        private String message;

        public ButtonActionListener(String message) {
            this.message = message;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (message) {
                case "Balance checked":
                    outputLabel.setText("Current balance: $" + balance);
                    break;
                case "Cash withdrawn":
                    try {
                        double amount = Double.parseDouble(inputField.getText());
                        if (amount <= balance) {
                            balance -= amount;
                            outputLabel.setText("Withdrew: $" + amount + " ~ New balance: $" + balance);
                        } else {
                            outputLabel.setText("Insufficient funds.");
                        }
                    } catch (NumberFormatException ex) {
                        outputLabel.setText("Invalid input.");
                    }
                    break;
                case "Cash deposited":
                    try {
                        double amount = Double.parseDouble(inputField.getText());
                        balance += amount;
                        outputLabel.setText("Deposited: $" + amount + " ~ New balance: $" + balance);
                    } catch (NumberFormatException ex) {
                        outputLabel.setText("Invalid input.");
                    }
                    break;
                case "Statement printed":
                    outputLabel.setText("Statement printed ~ Current balance: $" + balance);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of Lab4Part4 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab4Part4());
    }
}

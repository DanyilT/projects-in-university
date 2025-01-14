import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEvents extends JFrame {
    private final JLabel label;
    private final ImageIcon imageIcon;

    public MouseEvents() {
        // Code the JFrame
        setTitle("Mouse Events");
        setSize(480, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create the JLabel and set it in the frame
        label = new JLabel("An image will appear here when you move the mouse within the label", SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(label, BorderLayout.CENTER);

        // Create the image in Java
        imageIcon = new ImageIcon("img/venus-de-milo.jpg");

        label.addMouseListener(new MouseAdapter() {
            // Add the listener to show the image and border (new Color(purple))
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("");
                label.setIcon(imageIcon);
                label.setBorder(BorderFactory.createLineBorder(new Color(100, 50, 170), 2));
            }

            // Capture the exit event and set the label back to original
            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("An image will appear here when you move the mouse within the label");
                label.setIcon(null);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        });
    }

    // Run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MouseEvents mouseEvents = new MouseEvents();
            mouseEvents.setVisible(true);
        });
    }
}

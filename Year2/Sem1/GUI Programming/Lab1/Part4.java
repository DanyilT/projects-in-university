import javax.swing.*;
import java.awt.*;

public class Part4 extends JFrame {

    public Part4() {
        // Set the title of the frame
        setTitle("About Venus");

        // Set the size of the frame
        setSize(800, 600);

        // Create a JPanel to hold all components
        JPanel holderPanel = new JPanel();
        holderPanel.setLayout(new BoxLayout(holderPanel, BoxLayout.Y_AXIS)); // Set the layout to BoxLayout with Y_AXIS, so the components are stacked vertically

        // Create a JTextField with name in it
        JTextField nameField = new JTextField("Venus");
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameField.getPreferredSize().height)); // Fill the width with the parent and Fit the height of the content

        // Create a JTextArea with a small description
        JTextArea descriptionArea = new JTextArea("Venus is a Roman goddess whose functions encompass love, beauty, desire, sex, fertility, prosperity, and victory.\nThe Romans adapted the myths and iconography of her Greek counterpart Aphrodite for Roman art and Latin literature. In the later classical tradition of the West, Venus became one of the most widely referenced deities of Greco-Roman mythology as the embodiment of love and sexuality. As such, she is usually depicted nude."); // Copy from [Wikipedia](https://en.wikipedia.org/wiki/Venus_(mythology))
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100)); // Fill the width with the parent and Set the height to 100

        // Create a JLabel with a picture and text
        JLabel imageLabel = new JLabel("This is Venus-de-Milo");
        imageLabel.setFont(new Font("Serif", Font.BOLD, 16));
        ImageIcon imageIcon = new ImageIcon("img/Lab4/venus-de-milo.jpg");
        imageLabel.setIcon(imageIcon);

        // Create a JButton with text and an icon
        JButton likeButton = new JButton("Like");
        ImageIcon likeIcon = new ImageIcon("img/Lab4/ThumbUp.png"); // Icon from Iconly.Pro
        likeButton.setIcon(likeIcon);

        // Add all components to the JPanel
        holderPanel.add(nameField);
        holderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some spacing
        holderPanel.add(descriptionArea);
        holderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some spacing
        holderPanel.add(imageLabel);
        holderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some spacing
        holderPanel.add(likeButton);

        // Add the JPanel to the content pane of the JFrame
        Container contentPane = getContentPane();
        contentPane.add(holderPanel);

        // Make the frame visible
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the frame is closed
    }

    public static void main(String[] args) {
        // Create an instance of Part4
        new Part4();
    }
}

import javax.swing.*;
import java.awt.Container;

public class Lab1Part2 extends JFrame {

    public Lab1Part2() {
        // Set the size of the frame
        setSize(500, 300);

        // Create a JPanel
        JPanel labelHolderPanel = new JPanel();

        // Create the first JLabel without an image
        JLabel labelNoImage = new JLabel("Label with no image");

        // Create the second JLabel with an image
        JLabel imageLabel = new JLabel("Label with image");
        ImageIcon icon = new ImageIcon("img/Lab2/venus-de-milo.jpg"); // Path is dependent on where you run the program, if from 'Lab1/' then it should be 'img/venus-de-milo.jpg', if not add 'Lab1/' to the path
        imageLabel.setIcon(icon);

        // Create the third JLabel with a personalized image
        JLabel myImageChoiceLabel = new JLabel("My Image Choice");
        ImageIcon myIcon = new ImageIcon("img/Lab2/img2.png"); // Path is dependent on where you run the program, if from 'Lab1/' then it should be 'img/img2.png', if not add 'Lab1/' to the path
        myImageChoiceLabel.setIcon(myIcon);

        // Add all labels to the JPanel
        labelHolderPanel.add(labelNoImage);
        labelHolderPanel.add(imageLabel);
        labelHolderPanel.add(myImageChoiceLabel);

        // Add the JPanel to the content pane of the JFrame
        Container contentPane = getContentPane();
        contentPane.add(labelHolderPanel);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of Lab1Part2
        new Lab1Part2();
    }
}

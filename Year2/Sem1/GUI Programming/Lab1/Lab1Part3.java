import javax.swing.*;
import java.awt.Container;

public class Lab1Part3 extends JFrame {

    public Lab1Part3() {
        // Set the title of the frame
        setTitle("Buttons with Icons");

        // Set the size of the frame
        setSize(500, 100);

        // Create a JPanel
        JPanel buttonPanel = new JPanel();

        // Create the Save button with a custom icon
        JButton saveButton = new JButton("Save");
        ImageIcon saveIcon = new ImageIcon("img/Part3/Save.png"); // Icon from Iconly.Pro
        saveButton.setIcon(saveIcon);

        // Create the Open button with a custom icon
        JButton openButton = new JButton("Open");
        ImageIcon openIcon = new ImageIcon("img/Part3/Open.png"); // Icon from Iconly.Pro
        openButton.setIcon(openIcon);

        // Create the Delete button with a custom icon
        JButton deleteButton = new JButton("Delete");
        ImageIcon deleteIcon = new ImageIcon("img/Part3/Delete.png"); // Icon from Iconly.Pro
        deleteButton.setIcon(deleteIcon);

        // Create the Undo button with a custom icon
        JButton undoButton = new JButton("Undo");
        ImageIcon undoIcon = new ImageIcon("img/Part3/Undo.png"); // Icon from Iconly.Pro
        undoButton.setIcon(undoIcon);

        // Add all buttons to the JPanel
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(undoButton);

        // Add the JPanel to the content pane of the JFrame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel);

        // Make the frame visible
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the frame is closed
    }

    public static void main(String[] args) {
        // Create an instance of Lab1Part3
        new Lab1Part3();
    }
}

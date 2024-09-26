import javax.swing.*;
import java.awt.Container;

public class Part3 extends JFrame {

    public Part3() {
        // Set the size of the frame
        setSize(500, 100);

        // Create a JPanel
        JPanel buttonPanel = new JPanel();

        // Create the Save button with a custom icon
        JButton saveButton = new JButton("Save");
        ImageIcon saveIcon = new ImageIcon("img/Lab3/Save.png"); // Icon from Iconly.Pro
        saveButton.setIcon(saveIcon);

        // Create the Open button with a custom icon
        JButton openButton = new JButton("Open");
        ImageIcon openIcon = new ImageIcon("img/Lab3/Open.png"); // Icon from Iconly.Pro
        openButton.setIcon(openIcon);

        // Create the Delete button with a custom icon
        JButton deleteButton = new JButton("Delete");
        ImageIcon deleteIcon = new ImageIcon("img/Lab3/Delete.png"); // Icon from Iconly.Pro
        deleteButton.setIcon(deleteIcon);

        // Create the Undo button with a custom icon
        JButton undoButton = new JButton("Undo");
        ImageIcon undoIcon = new ImageIcon("img/Lab3/Undo.png"); // Icon from Iconly.Pro
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
    }

    public static void main(String[] args) {
        // Create an instance of Part3
        new Part3();
    }
}

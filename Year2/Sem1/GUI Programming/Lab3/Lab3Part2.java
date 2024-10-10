import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lab3Part2 extends JFrame {

    private JLabel imageLabel;
    private JTextArea infoTextArea;

    public Lab3Part2() {
        // Create the frame
        setTitle("Real Animals Images");
        setSize(Toolkit.getDefaultToolkit().getScreenSize()); // Make the frame full screen size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the panel for the JList
        JPanel listPanel = new JPanel();
        String[] animals = {"Cat", "Dragon", "Unicorn"};
        JList<String> animalList = new JList<>(animals);
        listPanel.add(new JScrollPane(animalList));

        // Create the panel for the JLabel
        JPanel imagePanel = new JPanel();
        imageLabel = new JLabel("Images will appear here: please select from the above list");
        imagePanel.add(imageLabel);

        // Create the panel for the JTextArea
        JPanel textPanel = new JPanel();
        infoTextArea = new JTextArea(3, 100);
        infoTextArea.setText("Information about the selected animal will appear here.");
        textPanel.add(new JScrollPane(infoTextArea));

        // Add panels to the frame
        getContentPane().add(listPanel, BorderLayout.NORTH);
        getContentPane().add(imagePanel, BorderLayout.CENTER);
        getContentPane().add(textPanel, BorderLayout.SOUTH);

        // Add listener to the JList
        animalList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String selectedAnimal = animalList.getSelectedValue();
                updateImageAndInfo(selectedAnimal);
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    private void updateImageAndInfo(String animal) {
        switch (animal) {
            case "Cat":
                imageLabel.setIcon(new ImageIcon("img/Part2/Cat-stablediffusion.jpg")); // Add 'Lab3/' to the path, if it can't find the image (this might help)
                imageLabel.setText("");
                infoTextArea.setText("This is a Cat - never trust them. You never know what deamons they are hiding.");
                break;
            case "Dragon":
                imageLabel.setIcon(new ImageIcon("img/Part2/Dragon-stablediffusion.jpg")); // Add 'Lab3/' to the path, if it can't find the image (this might help)
                imageLabel.setText("");
                infoTextArea.setText("This is a Dragon - you must have one at home, especially if you have a tower.");
                break;
            case "Unicorn":
                imageLabel.setIcon(new ImageIcon("img/Part2/Unicorn-stablediffusion.jpg")); // Add 'Lab3/' to the path, if it can't find the image (this might help)
                imageLabel.setText("");
                infoTextArea.setText("This is a Unicorn - they are cute, aren't they?. Don't worry if they become a demon and will eat your soul, you will be in a better place, probably.");
                break;
            default:
                imageLabel.setIcon(null);
                imageLabel.setText("Images will appear here: please select from the above list");
                infoTextArea.setText("Information about the selected animal will appear here.");
                break;
        }
    }

    public static void main(String[] args) {
        // Create an instance of Lab3Part2. And run it on the Event Dispatch Thread using SwingUtilities.invokeLater(), this is make sure that the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab3Part2());
    }
}

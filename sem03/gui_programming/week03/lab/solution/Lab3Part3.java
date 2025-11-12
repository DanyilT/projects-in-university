import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3Part3 extends JFrame {

    public Lab3Part3() {
        // Create the frame
        setTitle("Colors Favorites");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create the first JComboBox with colors
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Orange", "Pink", "Magenta"};
        JComboBox<String> colorComboBox = new JComboBox<>(colors);

        // Create the second JComboBox with favorite things
        String[] favoriteThings = {"Favourite Team", "Dream Car", "Dream Home", "Dream Job", "My Home Town"};
        JComboBox<String> favoriteThingsComboBox = new JComboBox<>(favoriteThings);

        // Add the JComboBox’s to the top of the frame
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new GridLayout(2, 1, 10, 10));
        comboBoxPanel.add(colorComboBox);
        comboBoxPanel.add(favoriteThingsComboBox);
        add(comboBoxPanel, BorderLayout.NORTH);

        // Create the JLabel for displaying images
        JLabel imageLabel = new JLabel("Images will appear here: please select from the above list", SwingConstants.CENTER);
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        add(imagePanel, BorderLayout.CENTER);

        // Create the JLabel for changing colors
        JLabel colorLabel = new JLabel("This label changes colour based on what you select", SwingConstants.CENTER);
        colorLabel.setOpaque(true);
        JPanel colorPanel = new JPanel();
        colorPanel.add(colorLabel);
        add(colorPanel, BorderLayout.SOUTH);

        // Add ActionListener to the color combo box
        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                switch (selectedColor) {
                    case "Red":
                        colorLabel.setBackground(Color.RED);
                        break;
                    case "Green":
                        colorLabel.setBackground(Color.GREEN);
                        break;
                    case "Blue":
                        colorLabel.setBackground(Color.BLUE);
                        break;
                    case "Yellow":
                        colorLabel.setBackground(Color.YELLOW);
                        break;
                    case "Orange":
                        colorLabel.setBackground(Color.ORANGE);
                        break;
                    case "Pink":
                        colorLabel.setBackground(Color.PINK);
                        break;
                    case "Magenta":
                        colorLabel.setBackground(Color.MAGENTA);
                        break;
                }
            }
        });

        // Add ActionListener to the favorite things combo box
        favoriteThingsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) favoriteThingsComboBox.getSelectedItem();
                switch (selectedItem) {
                    case "Favourite Team":
                        imageLabel.setIcon(new ImageIcon("img/Part3/Favourite Team-stablediffusion.png")); // You can add "Lab3/" to the path, depending on from where you are running the program
                        imageLabel.setText("");
                        break;
                    case "Dream Car":
                        imageLabel.setIcon(new ImageIcon("img/Part3/Dream Car-stablediffusion.png")); // You can add "Lab3/" to the path, depending on from where you are running the program
                        imageLabel.setText("");
                        break;
                    case "Dream Home":
                        imageLabel.setIcon(new ImageIcon("img/Part3/Dream Home-stablediffusion.png")); // You can add "Lab3/" to the path, depending on from where you are running the program
                        imageLabel.setText("");
                        break;
                    case "Dream Job":
                        imageLabel.setIcon(new ImageIcon("img/Part3/Dream Job-stablediffusion.png")); // You can add "Lab3/" to the path, depending on from where you are running the program
                        imageLabel.setText("");
                        break;
                    case "My Home Town":
                        imageLabel.setIcon(new ImageIcon("img/Part3/My Home Town-stablediffusion.png")); // You can add "Lab3/" to the path, depending on from where you are running the program
                        imageLabel.setText("");
                        break;
                    default:
                        imageLabel.setIcon(null);
                        imageLabel.setText("Images will appear here: please select from the above list");
                        break;
                }
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of Lab3Part3. And run it on the Event Dispatch Thread using SwingUtilities.invokeLater(), this is make sure that the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab3Part3());
    }
}

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Lab6Part2 extends JFrame {

    private JLabel imageLabel;
    private JLabel colorLabel;

    public Lab6Part2() {
        // Create the frame
        setTitle("Mouse with JFileChooser and JColorChooser");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the panel to hold the labels
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create the labels
        imageLabel = new JLabel("Choose an image here", JLabel.CENTER);
        imageLabel.setBorder(new LineBorder(Color.BLACK));
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.WHITE);

        colorLabel = new JLabel("Choose a colour here", JLabel.CENTER);
        colorLabel.setBorder(new LineBorder(Color.BLACK));
        colorLabel.setOpaque(true);
        colorLabel.setBackground(Color.WHITE);

        // Add mouse listeners to the labels
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                chooseImage();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imageLabel.setIcon(null);
            }
        });

        colorLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                chooseColor();
            }
        });

        // Add labels to the panel
        panel.add(imageLabel);
        panel.add(colorLabel);

        // Add panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }

    private void chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());
            imageLabel.setIcon(imageIcon);
        }
    }

    private void chooseColor() {
        Color color = JColorChooser.showDialog(this, "Choose a color", colorLabel.getBackground());
        if (color != null) {
            colorLabel.setBackground(color);
        }
    }

    public static void main(String[] args) {
        // Create an instance of Lab6Part2 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab6Part2());
    }
}

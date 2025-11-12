package Lab3Part1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Lab3Part1 extends JFrame {
    private JTextArea textArea;
    private JButton button;

    private static final String FILENAME = "myFavPastimes.txt";

    public Lab3Part1() {
        setTitle("Favorite Pastimes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        button = new JButton("Print My Pastimes From File");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readPastimesFromFile();
            }
        });
        add(button, BorderLayout.SOUTH);
    }

    private void readPastimesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error reading file.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Lab3Part1().setVisible(true);
        });
    }
}

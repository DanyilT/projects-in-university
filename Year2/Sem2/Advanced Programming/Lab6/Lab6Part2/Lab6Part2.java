package Lab6Part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;

public class Lab6Part2 extends JFrame {
    private JTextArea textArea;
    private JButton button;

    public Lab6Part2() {
        setTitle("Lab6Part2");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        button = new JButton("Show Info");

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        new InnerInfoClass();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab6Part2().setVisible(true));
    }

    // Inner Class
    class InnerInfoClass {
        public InnerInfoClass() {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Inner Class: ").append(this.getClass().getName()).append("\n");
                    sb.append("Outer Class: ").append(Lab6Part2.this.getClass().getName()).append("\n");

                    Field[] fields = Lab6Part2.this.getClass().getDeclaredFields();
                    sb.append("Outer Class Fields:\n");
                    for (Field field : fields) {
                        sb.append(field.getName()).append("\n");
                    }

                    textArea.setText(sb.toString());
                }
            });
        }
    }
}

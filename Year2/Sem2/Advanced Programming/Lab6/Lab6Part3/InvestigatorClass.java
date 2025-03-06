package Lab6Part3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class InvestigatorClass extends JFrame {
    private JTextArea textArea;
    private JButton investigateButton;

    public InvestigatorClass() {
        setTitle("InvestigatorClass");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        investigateButton = new JButton("Investigate");

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(investigateButton, BorderLayout.SOUTH);

        investigateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                investigateMysteryClass();
            }
        });
    }

    private void investigateMysteryClass() {
        try {
            Class<?> mysteryClass = Class.forName("mystery.MysteryJarClass");
            Method[] methods = mysteryClass.getDeclaredMethods();
            StringBuilder sb = new StringBuilder();

            for (Method method : methods) {
                sb.append("Method: ").append(method.getName()).append("\n");
                sb.append("Modifiers: ").append(Modifier.toString(method.getModifiers())).append("\n");
                sb.append("Return Type: ").append(method.getReturnType().getName()).append("\n");
                sb.append("Parameter Types: ");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> paramType : parameterTypes) {
                    sb.append(paramType.getName()).append(" ");
                }
                sb.append("\n\n");

                if (parameterTypes.length == 0) {
                    method.setAccessible(true);
                    Object instance = mysteryClass.getDeclaredConstructor().newInstance();
                    Object result = method.invoke(instance);
                    sb.append("Invoked Method Result: ").append(result).append("\n\n");
                }
            }

            textArea.setText(sb.toString());
        } catch (Exception ex) {
            textArea.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InvestigatorClass().setVisible(true));
    }
}

package Lab4Part4;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Lab4Part4 extends JFrame {
    private ResourceBundle bundle;
    private JButton catButton, carButton, cityButton;
    private JButton langButtonEn, langButtonUk, langButtonGa;

    public Lab4Part4() {
        // Load resource bundle for internationalization
        bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

        // Set up the frame
        setTitle(bundle.getString("frame.title"));
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        // Create object buttons
        catButton = new JButton(bundle.getString("button.cat"));
        carButton = new JButton(bundle.getString("button.car"));
        cityButton = new JButton(bundle.getString("button.city"));

        // Add object buttons to the frame
        add(catButton);
        add(carButton);
        add(cityButton);

        // Create language buttons with flag images
        langButtonEn = new JButton(bundle.getString("button.language.en"), new ImageIcon("flags/en.png"));
        langButtonUk = new JButton(bundle.getString("button.language.uk"), new ImageIcon("flags/uk.png"));
        langButtonGa = new JButton(bundle.getString("button.language.ga"), new ImageIcon("flags/ga.png"));

        // Add action listeners to language buttons
        langButtonEn.addActionListener(e -> switchLanguage(new Locale("en", "UK")));
        langButtonUk.addActionListener(e -> switchLanguage(new Locale("uk", "UA")));
        langButtonGa.addActionListener(e -> switchLanguage(new Locale("ga", "IE")));

        // Add language buttons to the frame
        JPanel langPanel = new JPanel();
        langPanel.add(langButtonEn);
        langPanel.add(langButtonUk);
        langPanel.add(langButtonGa);
        add(langPanel);
    }

    private void switchLanguage(Locale locale) {
        bundle = ResourceBundle.getBundle("messages", locale);
        setTitle(bundle.getString("frame.title"));
        carButton.setText(bundle.getString("button.car"));
        catButton.setText(bundle.getString("button.cat"));
        cityButton.setText(bundle.getString("button.city"));
        langButtonEn.setText(bundle.getString("button.language.en"));
        langButtonUk.setText(bundle.getString("button.language.uk"));
        langButtonGa.setText(bundle.getString("button.language.ga"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab4Part4().setVisible(true));
    }
}

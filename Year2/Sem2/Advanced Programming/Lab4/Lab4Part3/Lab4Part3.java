package Lab4Part3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

public class Lab4Part3 extends JFrame {
    private ResourceBundle bundle;
    private JComboBox<String> localeComboBox;
    private JTextArea textArea;

    public Lab4Part3() {
        // Load resource bundle for internationalization
        bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

        // Set the title of the frame using internationalization
        setTitle(bundle.getString("frame.title"));
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create and populate the combo box with available locales
        localeComboBox = new JComboBox<>();
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (Locale locale : availableLocales) {
            localeComboBox.addItem(locale.getDisplayName());
        }

        // Add listener to handle locale selection
        localeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Locale selectedLocale = availableLocales[localeComboBox.getSelectedIndex()];
                displayLocalizedInformation(selectedLocale);
            }
        });

        // Create and add the text area to display localized information
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(localeComboBox, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void displayLocalizedInformation(Locale locale) {
        // Reload resource bundle for the selected locale
        bundle = ResourceBundle.getBundle("messages", locale);

        // Set the title of the frame using internationalization
        setTitle(bundle.getString("frame.title"));

        StringBuilder sb = new StringBuilder();
        sb.append("Locale: ").append(locale.getDisplayName()).append("\n\n");

        // Display days of the week
        String[] weekdays = new DateFormatSymbols(locale).getWeekdays();
        sb.append("Days of the week:\n");
        for (String day : weekdays) {
            if (!day.isEmpty()) {
                sb.append(day).append("\n");
            }
        }

        // Display months of the year
        String[] months = new DateFormatSymbols(locale).getMonths();
        sb.append("\nMonths of the year:\n");
        for (String month : months) {
            if (!month.isEmpty()) {
                sb.append(month).append("\n");
            }
        }

        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab4Part3().setVisible(true));
    }
}

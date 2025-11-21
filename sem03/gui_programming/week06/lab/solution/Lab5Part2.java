import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab5Part2 extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JLabel resultLabel;
    private String[] responses = new String[3];

    public Lab5Part2() {
        // Create the JFrame, set appropriate size and set title
        setTitle("Survey GUI with CardLayout");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize CardLayout and card panel
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add survey panels
        cardPanel.add(createSurveyPanel("What is your favorite snack?", new String[]{"Chocolate", "Crisps", "Popcorn"}, 0), "Question1");
        cardPanel.add(createSurveyPanel("What is your favorite alter-ego?", new String[]{"Me", "Dany", "Your bestie"}, 1), "Question2");
        cardPanel.add(createSurveyPanel("What is your favorite color?", new String[]{"Pink", "Purple", "Queen Pink"}, 2), "Question3");

        // Add results panel
        cardPanel.add(createResultsPanel(), "Results");

        // Add card panel to the frame
        add(cardPanel);

        // Make the frame visible
        setVisible(true);
    }

    private JPanel createSurveyPanel(String question, String[] options, int questionIndex) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel questionLabel = new JLabel(question, JLabel.CENTER);
        panel.add(questionLabel, BorderLayout.NORTH);

        ButtonGroup group = new ButtonGroup();
        JPanel optionsPanel = new JPanel(new GridLayout(options.length, 1));
        for (String option : options) {
            JRadioButton radioButton = new JRadioButton(option);
            group.add(radioButton);
            optionsPanel.add(radioButton);
            radioButton.addActionListener(e -> responses[questionIndex] = option);
        }
        panel.add(optionsPanel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (questionIndex < 2) {
                    cardLayout.next(cardPanel);
                } else {
                    showResults();
                }
            }
        });
        panel.add(nextButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createResultsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        resultLabel = new JLabel("", JLabel.CENTER);
        panel.add(resultLabel, BorderLayout.CENTER);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> {
            responses = new String[3];
            cardLayout.first(cardPanel);
        });
        panel.add(restartButton, BorderLayout.SOUTH);

        return panel;
    }

    private void showResults() {
        StringBuilder results = new StringBuilder("<html>Survey Results:<br>");
        results.append("Favorite snack: ").append(responses[0]).append("<br>");
        results.append("Favorite alter-ego: ").append(responses[1]).append("<br>");
        results.append("Favorite color: ").append(responses[2]).append("</html>");
        resultLabel.setText(results.toString());
        cardLayout.show(cardPanel, "Results");
    }

    public static void main(String[] args) {
        // Create an instance of Lab5Part2 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab5Part2());
    }
}

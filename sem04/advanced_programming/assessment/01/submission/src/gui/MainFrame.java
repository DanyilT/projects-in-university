package gui;

import exceptions.InstrumentNotFoundException;
import instruments.Drums;
import instruments.Guitar;
import instruments.Instrument;
import instruments.Piano;
import internationalization.ResourceManager;
import logging.AssignmentLogger;    // Logger

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainFrame class for the GUI application.
 * This class handles the main window, user input, and interaction with the instrument classes.
 */
public class MainFrame extends JFrame implements ActionListener {
    private final JTextField instrumentField;
    private final JLabel inputLabel;
    private final JLabel imageLabel;
    private final JLabel instrumentLabel;
    private final JLabel instrumentDescriptionLabel;
    private final JButton showButton;
    private final JButton playButton;
    private final JButton switchLanguageButton;
    private final ResourceManager resourceManager;
    private Instrument currentInstrument;

    /**
     * Constructor for MainFrame.
     * Initializes the GUI components and sets up the layout.
     */
    public MainFrame() {
        AssignmentLogger.logConstructor(this);  // Logger

        // Initialize the frame
        resourceManager = new ResourceManager();
        setTitle(resourceManager.getString("gui.title"));
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top panel with Image
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("images/instrument.jpg"));
        topPanel.add(imageLabel);
        add(topPanel, BorderLayout.NORTH);

        // Center panel with instrument label and description
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        instrumentLabel = new JLabel("");
        instrumentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        instrumentDescriptionLabel = new JLabel("");
        instrumentDescriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(instrumentLabel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(instrumentDescriptionLabel);
        add(centerPanel, BorderLayout.CENTER);

        // Bottom panel with input & buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        // Row for input and label
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputLabel = new JLabel(resourceManager.getString("gui.inputLabel"));
        bottomPanel.add(inputLabel);
        inputPanel.add(inputLabel);

        instrumentField = new JTextField(15);
        bottomPanel.add(instrumentField);
        inputPanel.add(instrumentField);

        // Row for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        showButton = new JButton(resourceManager.getString("gui.buttonShow"));
        showButton.addActionListener(this);
        buttonPanel.add(showButton);

        playButton = new JButton(resourceManager.getString("gui.buttonPlay"));
        playButton.addActionListener(e -> {
            AssignmentLogger.logMethodEntry(this);  // Logger
            try {
                if (currentInstrument != null) {
                    currentInstrument.playSound();
                }
            } finally {
                AssignmentLogger.logMethodExit(this);   // Logger
            }
        });
        buttonPanel.add(playButton);

        switchLanguageButton = new JButton(resourceManager.getString("gui.buttonChangeLang"));
        switchLanguageButton.addActionListener((e) -> {
            AssignmentLogger.logMethodEntry(this);  // Logger
            try {
                resourceManager.switchLanguage();
                updateLabels();
            } finally {
                AssignmentLogger.logMethodExit(this);   // Logger
            }
        });
        buttonPanel.add(switchLanguageButton);

        bottomPanel.add(inputPanel);
        bottomPanel.add(buttonPanel);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Updates the labels in the GUI based on the current locale.
     */
    private void updateLabels() {
        AssignmentLogger.logMethodEntry(this);  // Logger
        try {
            setTitle(resourceManager.getString("gui.title"));
            inputLabel.setText(resourceManager.getString("gui.inputLabel"));
            instrumentLabel.setText(currentInstrument != null ? currentInstrument.getName().equalsIgnoreCase("drums") ? resourceManager.getString("instrument.drums") : currentInstrument.getName().equalsIgnoreCase("guitar") ? resourceManager.getString("instrument.guitar") : currentInstrument.getName().equalsIgnoreCase("piano") ? resourceManager.getString("instrument.piano") : "" : "");
            instrumentDescriptionLabel.setText(currentInstrument != null ? currentInstrument.getDescription(resourceManager) : "");
            showButton.setText(resourceManager.getString("gui.buttonShow"));
            playButton.setText(resourceManager.getString("gui.buttonPlay"));
            switchLanguageButton.setText(resourceManager.getString("gui.buttonChangeLang"));
        } finally {
            AssignmentLogger.logMethodExit(this);   // Logger
        }
    }

    /**
     * Action performed when the show button is clicked.
     * Validates the input and updates the instrument information.
     *
     * @param e ActionEvent triggered by the button click
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        AssignmentLogger.logMethodEntry(this);  // Logger
        try {
            String input = instrumentField.getText().trim().toLowerCase();

            // Validate input
            if (input.isEmpty()) {
                throw new InstrumentNotFoundException("Instrument input is empty");
            }

            // Check if the input is in Gaelic or English
            if (resourceManager.getCurrentLocale().getLanguage().equals("ga")) {
                switch (input) {
                    case "drumaí":
                        currentInstrument = new Drums();
                        break;
                    case "giotár":
                        currentInstrument = new Guitar();
                        break;
                    case "pianó":
                        currentInstrument = new Piano();
                        break;
                    default:
                        instrumentLabel.setText(resourceManager.getString("error.unrecognized"));
                        imageLabel.setIcon(new ImageIcon("images/instrument.jpg"));
                        currentInstrument = null;
                        return;
                }
            } else {
                switch (input) {
                    case "drums":
                        currentInstrument = new Drums();
                        break;
                    case "guitar":
                        currentInstrument = new Guitar();
                        break;
                    case "piano":
                        currentInstrument = new Piano();
                        break;
                    default:
                        instrumentLabel.setText(resourceManager.getString("error.unrecognized"));
                        imageLabel.setIcon(new ImageIcon("images/instrument.jpg"));
                        currentInstrument = null;
                        return;
                }
            }

            // Delay before showing
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            instrumentLabel.setText(currentInstrument.getName());
            instrumentLabel.setText(resourceManager.getString("instrument." + currentInstrument.getName().toLowerCase()));
            instrumentDescriptionLabel.setText(currentInstrument.getDescription(resourceManager));
            imageLabel.setIcon(new ImageIcon(currentInstrument.getImage()));
        } catch (InstrumentNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            AssignmentLogger.logMethodExit(this);   // Logger
        }
    }

    /**
     * Main method to run the application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        AssignmentLogger.logMethodEntry(MainFrame.class);   // Logger
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
        AssignmentLogger.logMethodExit(MainFrame.class);    // Logger
    }
}

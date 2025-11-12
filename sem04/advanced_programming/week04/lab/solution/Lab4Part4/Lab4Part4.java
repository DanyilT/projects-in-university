package Lab4Part4;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
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
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        // Create object buttons
        if (new File("../Lab4Part1/img/").exists() && new File("../Lab4Part1/sound/").exists()) {
            catButton = createButton(bundle.getString("button.cat"), "../Lab4Part1/img/cat.png", "../Lab4Part1/sound/cat.wav"); // img - AI generated with Stable Diffusion | sound - "cat meow by tuberatanka -- https://freesound.org/s/110011/ -- License: Creative Commons 0"
            carButton = createButton(bundle.getString("button.car"), "../Lab4Part1/img/car.png", "../Lab4Part1/sound/car.wav"); // img - AI generated with Stable Diffusion | sound - "Car Horn by yfjesse -- https://freesound.org/s/734253/ -- License: Creative Commons 0"
            cityButton = createButton(bundle.getString("button.city"), "../Lab4Part1/img/city.png", "../Lab4Part1/sound/city.wav"); // img - AI generated with Stable Diffusion | sound - "rain_heavy_traffic_04.wav by ania635 -- https://freesound.org/s/691532/ -- License: Creative Commons 0"
        } else {
            catButton = new JButton(bundle.getString("button.cat"));
            carButton = new JButton(bundle.getString("button.car"));
            cityButton = new JButton(bundle.getString("button.city"));
        }

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

    private JButton createButton(String text, String imagePath, String soundPath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(-1, 50, Image.SCALE_SMOOTH);
        JButton button = new JButton(text, new ImageIcon(image));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(soundPath);
            }
        });
        return button;
    }

    private void playSound(String soundPath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundPath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

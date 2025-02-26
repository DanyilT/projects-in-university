package Lab4Part1;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class EverydayObjectSoundGUI extends JFrame {
    private JButton catButton;
    private JButton carButton;
    private JButton cityButton;

    public EverydayObjectSoundGUI() {
        setTitle("Everyday Object Sound GUI");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 3));

        catButton = createButton("Cat", "img/cat.png", "sound/cat.wav"); // img - AI generated with Stable Diffusion | sound - "cat meow by tuberatanka -- https://freesound.org/s/110011/ -- License: Creative Commons 0"
        carButton = createButton("Car", "img/car.png", "sound/car.wav"); // img - AI generated with Stable Diffusion | sound - "Car Horn by yfjesse -- https://freesound.org/s/734253/ -- License: Creative Commons 0"
        cityButton = createButton("City", "img/city.png", "sound/city.wav"); // img - AI generated with Stable Diffusion | sound - "rain_heavy_traffic_04.wav by ania635 -- https://freesound.org/s/691532/ -- License: Creative Commons 0"

        add(catButton);
        add(carButton);
        add(cityButton);
    }

    private JButton createButton(String text, String imagePath, String soundPath) {
        JButton button = new JButton(text, new ImageIcon(imagePath));
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EverydayObjectSoundGUI().setVisible(true));
    }
}

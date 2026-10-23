package instruments;

import logging.AssignmentLogger;    // Logger

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Guitar class representing a musical instrument.
 * This class extends the Instrument class and implements the playSound method.
 */
public class Guitar extends Instrument {
    /**
     * Constructor for the Guitar class.
     * Initializes the name, image, and sound properties.
     */
    public Guitar() {
        super("Guitar", "images/guitar.jpg", new String[] {"sounds/Guitar1.wav", "sounds/Guitar2.wav", "sounds/Guitar3.wav"});
        AssignmentLogger.logConstructor(this);  // Logger
    }

    /**
     * Plays a random sound from the array of sounds.
     * This method uses Java Sound API to play the sound files.
     */
    @Override
    public void playSound() {
        AssignmentLogger.logMethodEntry(this);  // Logger
        try {
            // Randomly select a sound from the array
            int randomIndex = (int) (Math.random() * sound.length);
            String soundToPlay = sound[randomIndex];

            // Play the sound
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(soundToPlay)));
            clip.start();

            // Debugging output
            System.out.println("Playing sound: " + soundToPlay);
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
        AssignmentLogger.logMethodExit(this);   // Logger
    }
}

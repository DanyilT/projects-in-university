package instruments;

import internationalization.ResourceManager;
import logging.AssignmentLogger;    // Logger

/**
 * Abstract class representing a musical instrument.
 * This class contains common properties and methods for all instruments.
 */
public abstract class Instrument {
    protected String name;
    protected String image;
    protected String[] sound;

    /**
     * Constructor for the Instrument class.
     * Initializes the name, image, and sound properties.
     *
     * @param name  The name of the instrument.
     * @param image The image file path of the instrument.
     * @param sound An array of sound file paths for the instrument.
     */
    public Instrument(String name, String image, String[] sound) {
        AssignmentLogger.logConstructor(this);  // Logger
        this.name = name;
        this.image = image;
        this.sound = sound;
    }

    /**
     * Returns the name of the instrument.
     *
     * @return The name of the instrument.
     */
    public String getName() {
        AssignmentLogger.logMethodEntry(this);  // Logger
        try {
            return name;
        } finally {
            AssignmentLogger.logMethodExit(this);   // Logger
        }
    }

    /**
     * Returns the image file path of the instrument.
     *
     * @return The image file path of the instrument.
     */
    public String getImage() {
        AssignmentLogger.logMethodEntry(this);  // Logger
        try {
            return image;
        } finally {
            AssignmentLogger.logMethodExit(this);   // Logger
        }
    }

    /**
     * Returns the array of sound file paths for the instrument.
     *
     * @return The array of sound file paths for the instrument.
     */
    public String[] getSound() {
        AssignmentLogger.logMethodEntry(this);  // Logger
        try {
            return sound;
        } finally {
            AssignmentLogger.logMethodExit(this);   // Logger
        }
    }

    /**
     * Returns the description of the instrument from the resource manager.
     *
     * @param resourceManager The resource manager for internationalization.
     * @return The description of the instrument.
     */
    public String getDescription(ResourceManager resourceManager) {
        AssignmentLogger.logMethodEntry(this);  // Logger
        try {
            return resourceManager.getString("instrument." + name.toLowerCase() + ".description");
        } finally {
            AssignmentLogger.logMethodExit(this);   // Logger
        }
    }

    /**
     * Abstract method to play the sound of the instrument.
     * This method should be implemented by subclasses to provide specific sound playing functionality.
     */
    public abstract void playSound();
}

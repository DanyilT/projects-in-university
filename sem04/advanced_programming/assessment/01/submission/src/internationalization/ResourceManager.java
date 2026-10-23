package internationalization;

import logging.AssignmentLogger;    // Logger

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ResourceManager class for managing internationalization resources.
 * This class loads resource bundles based on the current locale and provides methods to switch languages.
 */
public class ResourceManager {
    private ResourceBundle resourceBundle;
    private Locale currentLocale;

    /**
     * Constructor for ResourceManager.
     * Initializes the current locale and loads the resource bundle.
     */
    public ResourceManager() {
        AssignmentLogger.logConstructor(this);  // Logger
        currentLocale = Locale.ENGLISH; // Default locale
        loadBundle();
    }

    /**
     * Returns the current locale.
     *
     * @return The current locale.
     */
    public Locale getCurrentLocale() {
        AssignmentLogger.logMethodEntry(this);  // Logger
        try {
            return currentLocale;
        } finally {
            AssignmentLogger.logMethodExit(this);   // Logger
        }
    }

    /**
     * Loads the resource bundle based on the current locale.
     */
    private void loadBundle() {
        AssignmentLogger.logMethodEntry(this);  // Logger
        try {
            resourceBundle = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        } catch (Exception e) {
            System.err.println("Error loading resource bundle: " + e.getMessage());
        } finally {
            AssignmentLogger.logMethodExit(this);   // Logger
        }
    }

    /**
     * Returns a string from the resource bundle based on the provided key.
     *
     * @param key The key for the desired string.
     * @return The string associated with the key in the current locale.
     */
    public String getString(String key) {
        AssignmentLogger.logMethodEntry(this);  // Logger
        try {
            return resourceBundle.getString(key);
        } finally {
            AssignmentLogger.logMethodExit(this);   // Logger
        }
    }

    /**
     * Switches the current locale between English and Gaelic.
     * This method updates the resource bundle accordingly.
     */
    public void switchLanguage() {
        AssignmentLogger.logMethodEntry(this);  // Logger
        try {
            if (currentLocale.equals(Locale.ENGLISH)) {
                currentLocale = new Locale("ga"); // Gaelic
            } else {
                currentLocale = Locale.ENGLISH;
            }
            loadBundle();
        } finally {
            AssignmentLogger.logMethodExit(this);   // Logger
        }
    }
}

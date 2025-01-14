package data;

// download snakeyaml and add it to external libraries https://repo1.maven.org/maven2/org/yaml/snakeyaml/2.3/snakeyaml-2.3.jar
import org.yaml.snakeyaml.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public abstract class DataHandler {
    private final Yaml yaml;

    // Constructor to initialize the YAML object
    protected DataHandler() {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        this.yaml = new Yaml(options);
    }

    // Generic method to read YAML data
    protected Map<String, Object> readData(String file) {
        try (FileReader reader = new FileReader(file)) {
            return yaml.load(reader);
        } catch (IOException e) {
            System.out.println("Error reading YAML file: " + e.getMessage());
            return null;
        }
    }

    // Generic method to write YAML data
    protected void writeData(String file, Map<String, Object> data) {
        try (FileWriter writer = new FileWriter(file)) {
            yaml.dump(data, writer);
        } catch (IOException e) {
            System.out.println("Error writing YAML file: " + e.getMessage());
        }
    }

    // Abstract method to define update logic in subclasses
    protected abstract void updateData(String file, String key, Object value);
}

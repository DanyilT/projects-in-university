import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {
        String namesFilePath = "files/names.txt";
        String descriptionsFilePath = "files/descriptions.txt";

        // Arrays to store the contents of the files
        String[] names = new String[7];
        String[] descriptions = new String[7];

        // Read files into arrays
        readFile(namesFilePath, names);
        readFile(descriptionsFilePath, descriptions);

        // Print the descriptions corresponding to each name
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i].trim() + " - " + descriptions[i].trim());
        }
    }

    public static void readFile(String filename, String[] array) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (int i = 0; i < lines.size(); i++) {
                array[i] = lines.get(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

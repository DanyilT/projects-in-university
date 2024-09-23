import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Question2 {
    private static final int PASSWORD_LENGTH = 18;
    private static final Random random = new Random();

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("files/passwords.txt"))) {
            for (int i = 0; i < 20; i++) {
                String password = generatePassword();
                writer.write(password);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generatePassword() {
        StringBuilder stringBuilder = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            // ASCII range for printable characters is 33-126, inclusive
            int rndCharNum = 33 + random.nextInt(94); // 126-33=93, +1 because nextInt is exclusive
            char rndChar = (char) rndCharNum;
            stringBuilder.append(rndChar);
        }
        return stringBuilder.toString();
    }
}

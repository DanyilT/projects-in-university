import java.util.Random;

public class Question4 {
    public static void main(String[] args) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        String vowels = "aeiou";
        int vowelCount = 0;
        
        for (int i = 0; i < 100; i++) {
            char c = (char) ('a' + rand.nextInt(26));
            sb.append(c + " ");
            if (vowels.indexOf(c) >= 0) {
                vowelCount++;
            }
        }
        
        System.out.println(sb.toString());
        System.out.println("Frequency of vowels is: " + vowelCount);
    }
}

import netflix.*;
import dubdevs.*;

public class Main {
    public static void main(String[] args) {
        // Create Video objects for netflix and dubdevs packages
        netflix.Video movie1 = new netflix.Video();
        dubdevs.Video file2020 = new dubdevs.Video();

        // Print the objects
        System.out.println(movie1);
        System.out.println(file2020);
    }
}

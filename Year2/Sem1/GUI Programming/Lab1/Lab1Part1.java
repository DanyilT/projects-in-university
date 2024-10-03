import javax.swing.JFrame;
import java.awt.Container;

public class Lab1Part1 extends JFrame {

    public Lab1Part1() {
        // Set the size of the frame
        setSize(600, 300);

        // Set the location of the frame
        setLocation(500, 500);

        // Set the title of the frame
        setTitle("Dany");

        // Make the frame not resizable
        setResizable(false);

        // Get the content pane of the frame
        Container contentPane = getContentPane();

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of Lab1Part1
        new Lab1Part1();
    }
}

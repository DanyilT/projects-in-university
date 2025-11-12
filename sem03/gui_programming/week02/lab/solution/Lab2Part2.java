import javax.swing.*;
import java.awt.*;

public class Lab2Part2 extends JFrame {

    public Lab2Part2() {
        // Create the frame
        setTitle("Provinces and Cities of Ireland");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the first JList with complete String info (provinces)
        String[] provinces = {"Connacht", "Leinster", "Munster", "Ulster"};
        JList<String> provinceList = new JList<>(provinces);

        // Create the second JList with complete String info (cities)
        String[] cities = {"Dublin", "Cork", "Wicklow", "Sligo"};
        JList<String> cityList = new JList<>(cities);

        // Create a panel and add both JLists to it
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 10, 10)); // Layout the JLists side-by-side

        panel.add(new JScrollPane(provinceList));
        panel.add(new JScrollPane(cityList));

        // Add the panel to the bottom of the frame
        getContentPane().add(panel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of Lab2Part2. And run it on the Event Dispatch Thread using SwingUtilities.invokeLater(), this is make sure that the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab2Part2());
    }
}

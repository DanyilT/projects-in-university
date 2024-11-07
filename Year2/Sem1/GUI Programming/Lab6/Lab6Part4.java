import javax.swing.*;
import java.awt.*;

public class Lab6Part4 extends JFrame {

    public Lab6Part4() {
        // Create the frame
        setTitle("Seasonal Character Drawing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawHead(g);
        drawFace(g);
        drawBody(g);
        drawLimbs(g);
    }

    private void drawHead(Graphics g) {
        g.setColor(Color.PINK);
        g.fillOval(350, 100, 100, 100); // Head
    }

    private void drawFace(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(370, 130, 10, 10); // Left eye
        g.fillOval(420, 130, 10, 10); // Right eye
            g.drawArc(380, 160, 40, 20, 0, -180); // Smile
    }

    private void drawBody(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(350, 200, 100, 150); // Body
    }

    private void drawLimbs(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(250, 200, 100, 20); // Left arm
        g.fillRect(450, 200, 100, 20); // Right arm
        g.fillRect(350, 350, 20, 100); // Left leg
        g.fillRect(430, 350, 20, 100); // Right leg
    }

    public static void main(String[] args) {
        // Create an instance of Lab6Part4 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            Lab6Part4 frame = new Lab6Part4();
            frame.setVisible(true);
        });
    }
}

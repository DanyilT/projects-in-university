package Lab5Part4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopTheLights extends JFrame {
    private final TrafficLightPanel lightPanel;
    private Thread lightThread;
    private boolean running = false;

    public StopTheLights() {
        setTitle("Stop The Lights");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        lightPanel = new TrafficLightPanel();
        add(lightPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!running) {
                    running = true;
                    lightThread = new Thread(lightPanel);
                    lightThread.start();
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = false;
                if (lightThread != null) {
                    lightThread.interrupt();
                }
            }
        });

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StopTheLights().setVisible(true);
            }
        });
    }

    class TrafficLightPanel extends JPanel implements Runnable {
        private Color currentColor = Color.RED;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(100, 50, 100, 300);

            g.setColor(currentColor == Color.RED ? Color.RED : Color.DARK_GRAY);
            g.fillOval(125, 75, 50, 50);

            g.setColor(currentColor == Color.YELLOW ? Color.YELLOW : Color.DARK_GRAY);
            g.fillOval(125, 175, 50, 50);

            g.setColor(currentColor == Color.GREEN ? Color.GREEN : Color.DARK_GRAY);
            g.fillOval(125, 275, 50, 50);
        }

        @Override
        public void run() {
            while (running) {
                try {
                    switch (currentColor.toString()) {
                        case "java.awt.Color[r=255,g=0,b=0]": // Color.RED
                            currentColor = Color.YELLOW;
                            break;
                        case "java.awt.Color[r=255,g=255,b=0]": // Color.YELLOW
                            currentColor = Color.GREEN;
                            break;
                        case "java.awt.Color[r=0,g=255,b=0]": // Color.GREEN
                            currentColor = Color.RED;
                            break;
                    }
                    repaint();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

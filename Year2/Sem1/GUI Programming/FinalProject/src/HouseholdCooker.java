import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class HouseholdCooker extends JFrame {
    private final JLabel titleLabel;
    private final JPanel[] cookingZones;
    private final JSlider[] sliders;

    public HouseholdCooker() {
        setTitle("Household Cooker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Create title label
        titleLabel = new JLabel("DanyT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        // Create menu bar for font size
        JMenuBar menuBar = new JMenuBar();
        JMenu fontSizeMenu = new JMenu("Font Size");
        fontSizeMenu.setMnemonic('F');
        menuBar.add(fontSizeMenu);

        String[] fontSizes = {"Small", "Medium", "Large"};
        for (String size : fontSizes) {
            JMenuItem menuItem = new JMenuItem(size);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(size.charAt(0), InputEvent.CTRL_DOWN_MASK));
            menuItem.addActionListener(new FontSizeChangeListener());
            fontSizeMenu.add(menuItem);
        }
        setJMenuBar(menuBar);

        // Create panel for cooking zones
        JPanel zonesPanel = new JPanel(new GridBagLayout());
        zonesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cookingZones = new JPanel[4]; // Can be changed to 5 for 5 zones
        sliders = new JSlider[4]; // Can be changed to 5 for 5 zones

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);

        for (int i = 0; i < 4; i++) { // Can be changed to 5 for 5 zones
            JPanel zonePanel = new JPanel(new BorderLayout());
            cookingZones[i] = new CirclePanel();
            cookingZones[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            cookingZones[i].setOpaque(false);
            zonePanel.add(cookingZones[i], BorderLayout.CENTER);

            sliders[i] = new JSlider(0, 10, 0);
            sliders[i].setOrientation(JSlider.VERTICAL);
            sliders[i].addChangeListener(new ZoneSliderChangeListener(i));
            zonePanel.add(sliders[i], BorderLayout.WEST);

            gridBagConstraints.gridx = i % 2;
            gridBagConstraints.gridy = i / 2;

            // Can be used for 5 zones
            // int[][] positions = {{0, 0}, {2, 0}, {0, 2}, {2, 2}, {1, 1}};
            // gridBagConstraints.gridx = positions[i][0];
            // gridBagConstraints.gridy = positions[i][1];

            zonesPanel.add(zonePanel, gridBagConstraints);
        }

        add(zonesPanel, BorderLayout.CENTER);
    }

    // Inner class for font size change listener
    private class FontSizeChangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedSize = ((JMenuItem) e.getSource()).getText();
            switch (selectedSize) {
                case "Small":
                    titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                    break;
                case "Medium":
                    titleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
                    break;
                case "Large":
                    titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
                    break;
            }
        }
    }

    // Inner class for slider change listener
    private class ZoneSliderChangeListener implements ChangeListener {
        private final int zoneIndex;

        public ZoneSliderChangeListener(int zoneIndex) {
            this.zoneIndex = zoneIndex;
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            int value = sliders[zoneIndex].getValue();
            int redIntensity = (int) (255 * (value / 10.0));
            ((CirclePanel) cookingZones[zoneIndex]).setColor(new Color(redIntensity, 0, 0));
        }
    }

    // Inner class for circle panel (set color & draw circle)
    private static class CirclePanel extends JPanel {
        private Color color = new Color(0, 0, 0);

        public void setColor(Color color) {
            this.color = color;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            int diameter = Math.min(getWidth(), getHeight());
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;
            g.fillOval(x, y, diameter, diameter);
        }
    }

    // Run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HouseholdCooker cooker = new HouseholdCooker();
            cooker.setVisible(true);
        });
    }
}

import javax.swing.*;

public class Lab6Part3 extends JFrame {

    public Lab6Part3() {
        // Create the frame
        setTitle("Space Adventure Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set background image
        setContentPane(new JLabel(new ImageIcon("img/Part3/Space Adventure Game.png")));

        // Start the game
        startGame();
    }

    private void startGame() {
        String[] portals = {"Portal 1", "Portal 2", "Portal 3"};
        int choice = JOptionPane.showOptionDialog(this, "Choose a portal to enter:", "Space Adventure", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, portals, portals[0]);

        switch (choice) {
            case 0:
                path1();
                break;
            case 1:
                path2();
                break;
            case 2:
                path3();
                break;
            default:
                JOptionPane.showMessageDialog(this, "No portal chosen. Game over.");
                break;
        }
    }

    private void path1() {
        int choice = JOptionPane.showConfirmDialog(this, "You are presented with a cup of liquid to drink by an alien, do you drink it?", "Path 1", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/Part3/Alien.png"));
        boolean yesIsRandomCorrectDecision = Math.random() < 0.5;
        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, yesIsRandomCorrectDecision ? "The drink makes you stronger!\n You win!" : "The drink kills you!\n You lose!", "Outcome", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, yesIsRandomCorrectDecision ? "You refuse the drink and the alien gets angry.\n You lose!" : "You refuse the drink and the alien is pleased.\n You win!", "Outcome", JOptionPane.INFORMATION_MESSAGE);
        }
        startGame();
    }

    private void path2() {
        int choice = JOptionPane.showConfirmDialog(this, "The unicorn wants to say something! Let him cook?", "Path 2", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/Part3/Unicorn.png"));
        boolean yesIsRandomCorrectDecision = Math.random() < 0.1;
        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, yesIsRandomCorrectDecision ? "The unicorn saying that you are the chosen one! You can wish whatever you want!\n You win!" : "The unicorn had a bad day and he is going to destroy you!\n You lose!", "Outcome", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "You just killed him!", "Outcome", JOptionPane.INFORMATION_MESSAGE);
        }
        startGame();
    }

    private void path3() {
        int choice = JOptionPane.showConfirmDialog(this, "You find a mysterious artifact. Do you touch it?", "Path 3", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/Part3/Artifact.png"));
        boolean yesIsRandomCorrectDecision = Math.random() < 0.5;
        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, yesIsRandomCorrectDecision ? "The artifact grants you superpowers!\n You win!" : "The artifact takes all of your life energy, You are dying slowly!\n You lose!", "Outcome", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, yesIsRandomCorrectDecision ? "You leave the artifact and you'll never know what you missed!\n You lose!" : "You leave the artifact and miss out on its powers.\n You lose!", "Outcome", JOptionPane.INFORMATION_MESSAGE);
        }
        startGame();
    }

    public static void main(String[] args) {
        // Create an instance of Lab6Parte3 and run it on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab6Part3().setVisible(true));
    }
}

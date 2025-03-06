package Lab6Part4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MyAlbum extends JFrame {
    private Vector<AlbumItem> albumItems;
    private JLabel imageLabel;
    private JTextArea factsArea;
    private JButton nextButton;
    private int currentIndex = -1;

    public MyAlbum() {
        setTitle("My Album");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        albumItems = new Vector<>();
        imageLabel = new JLabel();
        factsArea = new JTextArea();
        nextButton = new JButton("Next");

        add(imageLabel, BorderLayout.CENTER);
        add(new JScrollPane(factsArea), BorderLayout.SOUTH);
        add(nextButton, BorderLayout.NORTH);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextItem();
            }
        });

        populateAlbum();
        showNextItem();
    }

    private void populateAlbum() {
        // Add 5 FavouriteSport objects
        albumItems.add(new FavouriteSport("France", "Climb", new ImageIcon("img/climbing.png")));
        albumItems.add(new FavouriteSport("England", "Goal", new ImageIcon("img/soccer.png")));
        albumItems.add(new FavouriteSport("USA", "Touchdown", new ImageIcon("img/football.png")));
        albumItems.add(new FavouriteSport("Canada", "Goal", new ImageIcon("img/hockey.png")));
        albumItems.add(new FavouriteSport("Brazil", "Goal", new ImageIcon("img/volleyball.png")));

        // Add 5 FavouriteAnimal objects
        albumItems.add(new FavouriteAnimal("Egypt", "4000 years", new ImageIcon("img/cat.png")));
        albumItems.add(new FavouriteAnimal("Germany", "15000 years", new ImageIcon("img/dog.png")));
        albumItems.add(new FavouriteAnimal("Middle East", "10000 years", new ImageIcon("img/sheep.png")));
        albumItems.add(new FavouriteAnimal("Arabian Peninsula", "3000 years", new ImageIcon("img/camel.png")));
        albumItems.add(new FavouriteAnimal("South America", "5000 years", new ImageIcon("img/llama.png")));
    }

    private void showNextItem() {
        if (albumItems.isEmpty()) return;

        currentIndex = (currentIndex + 1) % albumItems.size();
        AlbumItem currentItem = albumItems.get(currentIndex);

        imageLabel.setIcon(currentItem.getImage());
        factsArea.setText(currentItem.getFacts());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyAlbum().setVisible(true));
    }
}

package Lab3Part4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Lab3Part4 extends JFrame {
    private JTextArea textArea;

    /**
     * Constructor to initialize the GUI.
     */
    public Lab3Part4() {
        setTitle("Lab3Part4");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton createTableButton = new JButton("Create Table");
        JButton addSongButton = new JButton("Add Song");
        JButton readSongsButton = new JButton("Read Songs");
        JButton deleteSongButton = new JButton("Delete Song");

        createTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable();
            }
        });

        addSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSong("Song 1", "Artist 1");
                addSong("Song 2", "Artist 2");
            }
        });

        readSongsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readSongs();
            }
        });

        deleteSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSong(null);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));
        panel.add(createTableButton);
        panel.add(addSongButton);
        panel.add(readSongsButton);
        panel.add(deleteSongButton);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    /**
     * Main method to run the code.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Lab3Part4 dao = new Lab3Part4(); // Data Access Object
        dao.setVisible(true);

        /* Uncomment to run the code without GUI
        dao.createTable();
        dao.addSong("Song 1", "Artist 1");
        dao.addSong("Song 2", "Artist 2");
        System.out.println("Songs in the database:");
        dao.readSongs();
        dao.deleteSong(1);
        System.out.println("Songs in the database after deletion:");
        dao.readSongs();
        */
    }

    /**
     * Create table in the database.
     */
    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS songs (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), artist VARCHAR(255))";

        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created successfully.");
            textArea.append("Table created successfully.\n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating table: " + e.getMessage());
            textArea.append("Error creating table: " + e.getMessage() + "\n");
        }
    }

    /**
     * Add song to the database's table.
     * @param title song title
     * @param artist song artist
     */
    private void addSong(String title, String artist) {
        String sql = "INSERT INTO songs (title, artist) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, artist);
            pstmt.executeUpdate();
            System.out.println("Song added successfully.");
            textArea.append("Song added successfully.\n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error adding song: " + e.getMessage());
            textArea.append("Error adding song: " + e.getMessage() + "\n");
        }
    }

    /**
     * Read all songs from the database's table.
     */
    private void readSongs() {
        String sql = "SELECT * FROM songs";

        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Title: " + rs.getString("title") + ", Artist: " + rs.getString("artist"));
                textArea.append("ID: " + rs.getInt("id") + ", Title: " + rs.getString("title") + ", Artist: " + rs.getString("artist") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error reading songs: " + e.getMessage());
            textArea.append("Error reading songs: " + e.getMessage() + "\n");
        }
    }

    /**
     * Delete song from ther songs table by ID.
     * @param id song id to delete (null to delete the last song)
     */
    private void deleteSong(Integer id) {
        String sql = id == null ? "DELETE FROM songs WHERE id = (SELECT * FROM (SELECT MAX(id) FROM songs) AS temp)" : "DELETE FROM songs WHERE id = ?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (id != null)
                pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Song deleted successfully.");
            textArea.append("Song deleted successfully.\n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting song: " + e.getMessage());
            textArea.append("Error deleting song: " + e.getMessage() + "\n");
        }
    }

    /**
     * Class to get connection to the database.
     */
    private static class DBConnection {
        // Download JDBC Driver for SQL Server from https://dev.mysql.com/downloads/connector/j/ & add it to the project;
        // Install & run MySQL server;
        // Create database in console (mysql>):
        // CREATE DATABASE AdvancedProgramming_Lab3Part4;
        private static final String URL = "jdbc:mysql://localhost:3306/AdvancedProgramming_Lab3Part4";
        private static final String USER = "root";
        private static final String PASSWORD = "root";

        /**
         * Get connection to the database.
         * @return connection to the database
         * @throws SQLException if connection failed
         */
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }
}

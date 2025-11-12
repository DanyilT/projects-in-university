package game;

import cards.Deck;
import data.GameDataHandler;
import exceptions.InvalidPlayerDataException;
import players.Dealer;
import players.Player;
import players.UserPlayer;

import java.util.LinkedHashMap;
import java.util.Map;

import static data.GameDataHandler.gameDataFilePath;
import static game.GameEngine.actionLoop;

public class BlackjackGame {
    private static final GameDataHandler gameDataHandler = new GameDataHandler();
    private final Map<Integer, Player> players = new LinkedHashMap<>();

    public BlackjackGame() throws InvalidPlayerDataException {
        try {
            System.out.println("Blackjack game started");

            // Set the initial game settings
            System.out.println("Setting inbitial game settings");
            gameDataHandler.updateSettingsGameData(gameDataFilePath, "chips", 100);
            gameDataHandler.updateSettingsGameData(gameDataFilePath, "bet", 10);

            // Set the initial deck
            Deck deck = new Deck();

            // Check if players exist and have the correct structure
            Map<Integer, Object> playersData = (Map<Integer, Object>) (Map<?, Object>) gameDataHandler.readPlayerGameData(gameDataFilePath, null);
            if (playersData != null) {
                Map<Integer, String> playersIdAndName = new LinkedHashMap<>();
                playersData.forEach((key, value) -> playersIdAndName.put(key, value != null && ((Map<String, Object>) value).get("name") != null ? ((Map<String, Object>) value).get("name").toString() : "Player " + key));
                // Remove all players
                gameDataHandler.removePlayerGameData(gameDataFilePath, null);

                // Regenerate all players
                for (Map.Entry<Integer, String> entry : playersIdAndName.entrySet()) {
                    if (entry.getKey() == 0) {
                        players.put(entry.getKey(), new Dealer(deck));
                    } else {
                        players.put(entry.getKey(), new UserPlayer(entry.getValue(), deck));
                    }
                }
            } else {
                // If no players exist, create a dealer and a user player
                players.put(0, new Dealer(deck));
                players.put(1, new UserPlayer("Player 1", deck));
            }

            // Start the Game
            actionLoop(players);

            // Clear the deck
            deck.clearDeck();
        } catch (InvalidPlayerDataException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Create Dealer & Player not from game_data.yaml, but from code
        //Dealer dealer = new Dealer(deck); // Initialize the dealer
        //UserPlayer userPlayer = new UserPlayer("Dany", deck); // Initialize the user player
    }
}

package data;

import players.Player;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameDataHandler extends DataHandler {
    public static final String gameDataFilePath = "data/game_data.yaml";

    // Read the entire player data
    public Map<String, Object> readGameData(String file) {
        Map<String, Object> gameData = readData(file);
        return gameData != null ? gameData : null;
    }

    // Read the entire settings data
    public Map<String, Object> readSettingsGameData(String file) {
        Map<String, Object> gameData = readData(file);
        return gameData != null && gameData.containsKey("settings") ? (Map<String, Object>) gameData.get("settings") : null;
    }

    // Add a new setting
    public void updateSettingsGameData(String file, String key, Object value) {
        Map<String, Object> gameData = readData(file);

        if (gameData != null && gameData.containsKey("settings")) {
            ((Map<String, Object>) gameData.get("settings")).put(key, value);
        }

        writeData(file, gameData);
    }

    // Read player data or all players (if playerId is null)
    public Map<String, Object> readPlayerGameData(String file, Integer playerId) {
        Map<String, Object> gameData = readData(file);

        if (gameData != null && gameData.containsKey("players")) {
            Map<Integer, Object> players = (Map<Integer, Object>) gameData.get("players");
            return playerId != null ? players.containsKey(playerId) ? (Map<String, Object>) players.get(playerId) : null : (Map<String, Object>) (Map<?, ?>) players;
        }

        return null;
    }

    // Update a players data
    public void updatePlayerGameData(String file, Integer playerId, String key, Object value) {
        Map<String, Object> gameData = readData(file);

        if (gameData != null && gameData.containsKey("players")) {
            Map<Integer, Object> players = (Map<Integer, Object>) gameData.get("players");
            if (players.containsKey(playerId)) {
                ((Map<String, Object>) players.get(playerId)).put(key, value);
            }
        }

        writeData(file, gameData);
    }

    // Add a new player, if Player is null, a default player is created
    public void addPlayerGameData(String file, Player player) {
        Map<String, Object> gameData = readData(file);

        if (gameData != null) {
            Map<Integer, Object> players = (Map<Integer, Object>) gameData.get("players");
            Map<String, Object> newPlayer = new LinkedHashMap<>();
            Map<String, Object> settings = (Map<String, Object>) gameData.get("settings");

            if (players == null) {
                players = new LinkedHashMap<>();
                gameData.put("players", players);
            }
            int newId = players.size() == 0 ? 1 : players.containsKey(0) ? players.size() : players.size() + 1;

            if (player != null) {
                newId = player.getName().equals("Dealer") ? 0 : newId;
                newPlayer.put("name", player.getName());
                newPlayer.put("chips", player.getChips());
                newPlayer.put("bet", player.getBets());
                newPlayer.put("hand", player.getHands());
                newPlayer.put("count_value", player.getCountValues());
            } else {
                newPlayer.put("name", "Player " + newId);
                newPlayer.put("chips", (Integer) settings.get("chips") - (Integer) settings.get("bet"));
                newPlayer.put("bet", new LinkedHashMap<Integer, Integer>((Integer) settings.get("bet")));
                newPlayer.put("hand", new LinkedHashMap<>());
                newPlayer.put("count_value", null);
            }

            players.put(newId, newPlayer);
        }

        writeData(file, gameData);
    }

    // Remove a player, if playerId is null, all players are removed
    public void removePlayerGameData(String file, Integer playerId) {
        Map<String, Object> gameData = readData(file);

        if (gameData.containsKey("players")) {
            Map<Integer, Object> players = (Map<Integer, Object>) gameData.get("players");
            if (playerId != null) {
                players.remove(playerId);
            } else {
                players.clear();
            }
        }

        writeData(file, gameData);
    }

    // Update any game data: keys (settings, players) and rewrite the entire data
    @Override
    protected void updateData(String file, String key, Object value) {
        Map<String, Object> gameData = readData(file);

        if (gameData != null) {
            gameData.put(key, value);
        }

        writeData(file, gameData);
        System.out.println("Data updated in: " + file + " with key: " + key);
    }
}

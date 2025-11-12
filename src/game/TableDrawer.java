package game;

import data.GameDataHandler;

import java.util.List;
import java.util.Map;

import static data.GameDataHandler.gameDataFilePath;

public class TableDrawer {
    private final String filePath;
    private final int[] turnIndicator;

    public TableDrawer(int[] turnIndicator) {
        this.filePath = gameDataFilePath;
        this.turnIndicator = turnIndicator;
    }

    public void drawTable() {
        GameDataHandler gameDataHandler = new GameDataHandler();
        Map<Integer, Object> data = (Map<Integer, Object>) (Map<?, Object>) gameDataHandler.readPlayerGameData(filePath, null);
        if (data != null) {
            printTable(data);
        } else {
            System.out.println("No data available to draw the table.");
        }
    }

    private void printTable(Map<Integer, Object> data) {
        System.out.println("Blackjack Table");
        System.out.printf("%-2s %-15s %-10s %-10s %-30s %-15s%n", "", "Name", "Chips", "Bet", "Hand", "Count Value");

        for (Map.Entry<Integer, Object> entry : data.entrySet()) {
            Integer playerId = entry.getKey();
            Map<String, Object> playerData = (Map<String, Object>) entry.getValue();

            Map<Integer, Object> hands = (Map<Integer, Object>) playerData.get("hand");
            Map<Integer, Object> bets = (Map<Integer, Object>) playerData.get("bet");
            Map<Integer, Object> countValues = (Map<Integer, Object>) playerData.get("count_value");

            // Print the first hand (index 0)
            if (hands.containsKey(0)) {
                String hand = hands.get(0).toString();
                Integer bet = (bets != null) ? (Integer) bets.get(0) : 0;
                Integer chips = playerData.get("chips") != null && playerId != 0 ? (Integer) playerData.get("chips") : null;
                Integer countValue = (countValues != null) ? (Integer) countValues.get(0) : 0;
                String indicator = (turnIndicator != null && turnIndicator[0] == playerId && turnIndicator[1] == 0) ? " <--" : "";

                if (playerId == 0 && (turnIndicator == null || !(turnIndicator[0] == playerId))) {
                    List<String> dealerHand = (List<String>) hands.get(0);
                    hand = "[?, " + dealerHand.get(1) + "]";
                    countValue = 0;
                    indicator = " D";
                }

                System.out.printf("%-2d %-15s %-10d %-10d %-30s %-15d%s%n", playerId, playerData.get("name"), chips, bet, hand, countValue, indicator);
            }

            // Print the remaining hands
            for (Map.Entry<Integer, Object> handEntry : hands.entrySet()) {
                int handIndex = handEntry.getKey();
                if (handIndex == 0) continue;

                String hand = handEntry.getValue().toString();
                Integer bet = (bets != null) ? (Integer) bets.get(handIndex) : 0;
                Integer countValue = (countValues != null) ? (Integer) countValues.get(handIndex) : 0;
                String indicator = ((turnIndicator != null) && (turnIndicator[0] == playerId) && (turnIndicator[1] == handIndex)) ? " <--" : "";

                System.out.printf("%-2s %-15s %-10s %-10d %-30s %-15d%s%n",
                        playerId, "", "", bet, hand, countValue, indicator);
            }
        }
    }
}

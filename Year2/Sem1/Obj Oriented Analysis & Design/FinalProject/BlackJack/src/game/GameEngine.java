package game;

import data.GameDataHandler;
import exceptions.InsufficientChipsException;
import players.Dealer;
import players.Player;
import players.UserPlayer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static data.GameDataHandler.gameDataFilePath;

public class GameEngine {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GameDataHandler gameDataHandler = new GameDataHandler();

    public static void actionLoop(Map<Integer, Player> players) {
        // Loop through each player and ask for actions
        for (Map.Entry<Integer, Player> entry : players.entrySet()) {
            if (entry.getValue() instanceof UserPlayer player) {
                for (int handIndex : player.getHands().keySet()) {
                    // Draw the table
                    TableDrawer tableDrawer = new TableDrawer(new int[]{player.getPlayerId(), handIndex});
                    tableDrawer.drawTable();

                    // Run actions for each hand and check if the hand was split to run actions for the new hand
                    boolean handWasSplit = false;
                    handWasSplit = actionManager(player, handIndex);
                    while (handWasSplit) {
                        handIndex++;
                        tableDrawer = new TableDrawer(new int[]{player.getPlayerId(), handIndex});
                        tableDrawer.drawTable();
                        handWasSplit = actionManager(player, handIndex);
                    }
                }
            }
        }

        // Draw the table
        System.out.println("Dealer's turn");
        TableDrawer tableDrawer = new TableDrawer(new int[]{0, 0});
        tableDrawer.drawTable();

        // Dealer's turn
        Dealer dealer = (Dealer) players.get(0);
        dealer.dealerActions();
        tableDrawer.drawTable();

        // Determine winners
        Map<UserPlayer, Map<Integer, String>> winners = determineWinners(players);
        System.out.println("\n------------------");
        System.out.println("Winners:");
        for (Map.Entry<UserPlayer, Map<Integer, String>> winnerEntry : winners.entrySet()) {
            UserPlayer player = winnerEntry.getKey();
            Map<Integer, String> handsStatus = winnerEntry.getValue();

            for (Map.Entry<Integer, String> handEntry : handsStatus.entrySet()) {
                int handIndex = handEntry.getKey();
                String status = handEntry.getValue();
                System.out.println(player.toString());
                System.out.printf("\sPlayer: %s, Hand: %s ~ %s%n", player.getName(), player.getHands().get(handIndex), status);
            }
        }
    }

    private static boolean actionManager(UserPlayer player, int handIndex) {
        // Ask for action
        List<String> possibleActions = player.getPossibleActions(handIndex);
        System.out.println(player.getName() + " >> Hand : " + player.getHands().get(handIndex));
        if (!possibleActions.isEmpty()) {
            System.out.println("Can do: " + possibleActions);
            System.out.print("Choose an action: ");
            String action = scanner.nextLine();

            // Normalize the action input (dressing uniform)
            switch (action.toLowerCase()) {
                case "hit", "h":
                    if (possibleActions.contains("hit")) {
                        player.hit(handIndex);

                        // Ask again for action for this hand
                        TableDrawer tableDrawer = new TableDrawer(new int[]{player.getPlayerId(), handIndex});
                        tableDrawer.drawTable();
                        actionManager(player, handIndex);
                        break;
                    }
                case "stand", "s", "":
                    if (possibleActions.contains("stand")) {
                        player.stand(handIndex);
                        break;
                    }
                case "doubledown", "double down", "double", "dd", "d":
                    if (possibleActions.contains("doubleDown")) {
                        try {
                            player.doubleDown(handIndex);
                        } catch (InsufficientChipsException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                case "split", "sp":
                    if (possibleActions.contains("split")) {
                        player.split(handIndex);

                        // Ask again for action for this hand
                        TableDrawer tableDrawer = new TableDrawer(new int[]{player.getPlayerId(), handIndex});
                        tableDrawer.drawTable();
                        actionManager(player, handIndex);
                        return true;
                    }
                default:
                    System.out.println("Invalid action. Skipping...");
                    System.out.println("(default action) Stand");
                    player.stand(handIndex);
                    break;
            }
        }
        return false;
    }

    // Method that will determine winners and return all winners, and set new chips values & clear bets
    private static Map<UserPlayer, Map<Integer, String>> determineWinners(Map<Integer, Player> players) {
        Map<UserPlayer, Map<Integer, String>> winners = new TreeMap<>(Comparator.comparingInt(UserPlayer::getPlayerId));

        Dealer dealer = (Dealer) players.get(0);
        int dealerHandValue = dealer.getCountValues().get(0);
        boolean dealerBust = dealerHandValue > 21;

        for (Map.Entry<Integer, Player> entry : players.entrySet()) {
            if (entry.getValue() instanceof UserPlayer player) {
                Map<Integer, String> handsStatus = new HashMap<>();
                for (int handIndex : player.getHands().keySet()) {
                    int playerHandValue = player.getCountValues().get(handIndex);
                    boolean playerBust = playerHandValue > 21;

                    if (!playerBust && playerHandValue == 21 && player.getHands().get(handIndex).size() == 2 && !dealerBust && dealerHandValue != 21) {
                        // Blackjack
                        handsStatus.put(handIndex, "blackjack");
                        player.setChips((int) (player.getChips() + (int) player.getBets().get(handIndex) * 2.5));
                    } else if (playerBust || (!dealerBust && dealerHandValue > playerHandValue)) {
                        // Player loses
                        handsStatus.put(handIndex, "lose");
                    } else if (playerHandValue == dealerHandValue) {
                        // Push (tie)
                        handsStatus.put(handIndex, "push");
                        player.setChips(player.getChips() + player.getBets().get(handIndex));
                    } else {
                        // Player wins
                        handsStatus.put(handIndex, "win");
                        player.setChips(player.getChips() + player.getBets().get(handIndex) * 2);
                    }
                    player.setBets(new LinkedHashMap<>(player.getBets().put(handIndex, 0)));

                    // Update player chips in YAML
                    gameDataHandler.updatePlayerGameData(gameDataFilePath, player.getPlayerId(), "chips", player.getChips());
                    gameDataHandler.updatePlayerGameData(gameDataFilePath, player.getPlayerId(), "bet", player.getBets());
                }
                if (!handsStatus.isEmpty()) winners.put(player, handsStatus);
            }
        }
        return winners;
    }
}

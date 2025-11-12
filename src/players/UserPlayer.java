package players;

import cards.CardRank;
import cards.Deck;
import data.GameDataHandler;
import exceptions.InsufficientChipsException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static data.GameDataHandler.gameDataFilePath;

public class UserPlayer extends Player implements PlayerActions {
    private static final GameDataHandler gameDataHandler = new GameDataHandler();
    private static final Map<String, Object> settings = gameDataHandler.readSettingsGameData(gameDataFilePath);
    private static Deck deck;
    private final int playerId;

    public UserPlayer(String name, Deck deck) {
        super(name, null, new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>());
        UserPlayer.deck = deck;
        this.setChips((Integer) settings.get("chips") - (Integer) settings.get("bet"));
        this.getBets().put(0, (Integer) settings.get("bet"));
        this.getHands().put(0, dealInitialHand());
        this.getCountValues().put(0, countHandValue(this.getHands().get(0)));

        // Read existing players and determine the new player ID
        Map<Integer, Object> players = (Map<Integer, Object>) (Map<?, Object>) gameDataHandler.readPlayerGameData(gameDataFilePath, null);
        playerId = players != null ? players.containsKey(0) ? players.size() : players.size() + 1 : 1;

        savePlayerToFile(gameDataFilePath, this);
    }

    public int getPlayerId() {
        return playerId;
    }

    // Return the possible actions for the player's hand (hit, stand, double down, split)
    public List<String> getPossibleActions(int handIndex) {
        List<String> possibleActions = new ArrayList<>();

        if (getHands().containsKey(handIndex)) {
            List<String> hand = getHands().get(handIndex);
            int handValue = getCountValues().get(handIndex);

            // Check if the player can hit
            if (handValue < 21) {
                possibleActions.add("hit");
            }

            // Check if the player can stand (if value is 21, can stand only)
            if (handValue <= 21) {
                possibleActions.add("stand");
            }

            // Check if the player can double down
            if (handValue <  21 && hand.size() == 2 && getChips() >= getBets().get(handIndex)) {
                possibleActions.add("doubleDown");
            }

            // Check if the player can split
            if (hand.size() == 2) {
                if (CardRank.valueOf(hand.get(0).substring(0, hand.get(0).length() - 1).toUpperCase()).getValue().equals(CardRank.valueOf(hand.get(1).substring(0, hand.get(1).length() - 1).toUpperCase()).getValue())) {
                    possibleActions.add("split");
                }
            }
        }

        return possibleActions;
    }

    // Deal the initial hand for the player
    @Override
    protected final List<String> dealInitialHand() {
        ArrayList<String> hand = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            hand.add(deck.drawCard());
        }
        return hand;
    }

    // Hit the player's hand (draw one card)
    @Override
    public void hit(int handIndex) {
        if (getHands().containsKey(handIndex)) {
            getHands().get(handIndex).add(deck.drawCard());
            getCountValues().put(handIndex, countHandValue(getHands().get(handIndex)));

            updateYaml(gameDataFilePath, playerId, "hand", getHands());
            updateYaml(gameDataFilePath, playerId, "count_value", getCountValues());
        }
    }

    // Stand the player's hand (do nothing)
    @Override
    public void stand(int handIndex) {
        if (getHands().containsKey(handIndex)) {
            updateYaml(gameDataFilePath, playerId, "hand", getHands());
            updateYaml(gameDataFilePath, playerId, "count_value", getCountValues());
        }
    }

    // Double down on the player's hand (double the bet and draw one card)
    @Override
    public void doubleDown(int handIndex) throws InsufficientChipsException {
        if (getHands().containsKey(handIndex)) {
            if (getChips() < getBets().get(handIndex)) {
                throw new InsufficientChipsException("Not enough chips to double down.");
            } else {
                setChips(getChips() - getBets().get(handIndex));
                getBets().put(handIndex, getBets().get(handIndex) * 2);
                getHands().get(handIndex).add(deck.drawCard());
                getCountValues().put(handIndex, countHandValue(getHands().get(handIndex)));

                updateYaml(gameDataFilePath, playerId, "chips", getChips());
                updateYaml(gameDataFilePath, playerId, "bet", getBets());
                updateYaml(gameDataFilePath, playerId, "hand", getHands());
                updateYaml(gameDataFilePath, playerId, "count_value", getCountValues());
            }
        }
    }

    // Split the player's hand (create a new hand with the second card if the two cards have the same value)
    @Override
    public void split(int handIndex) {
        if (getHands().containsKey(handIndex) && getHands().get(handIndex).size() == 2) {
            String firstCard = getHands().get(handIndex).get(0);
            String secondCard = getHands().get(handIndex).get(1);

            // Check if the two cards have the same value
            if (CardRank.valueOf(firstCard.substring(0, firstCard.length() - 1).toUpperCase()).getValue().equals(CardRank.valueOf(secondCard.substring(0, secondCard.length() - 1).toUpperCase()).getValue())) {
                // Create a new hand & Move the second card to the new hand
                List<String> newHand = new ArrayList<>();
                newHand.add(secondCard);
                getHands().get(handIndex).remove(1);

                // Draw an additional card for each hand
                getHands().get(handIndex).add(deck.drawCard());
                newHand.add(deck.drawCard());

                // Add the new hand to the player's hands
                int newHandIndex = getHands().size(); // Don't use handIndex++ because this handIndex may not be the last index (e.g., if player split splited hand again)
                getHands().put(newHandIndex, newHand);

                // Update the hand values
                getCountValues().put(handIndex, countHandValue(getHands().get(handIndex)));
                getCountValues().put(newHandIndex, countHandValue(newHand));

                // Update chips & bet for the new hand
                setChips(getChips() - getBets().get(handIndex));
                getBets().put(newHandIndex, getBets().get(handIndex));

                // Save the updated player data to the YAML file
                updateYaml(gameDataFilePath, playerId, "chips", getChips());
                updateYaml(gameDataFilePath, playerId, "bet", getBets());
                updateYaml(gameDataFilePath, playerId, "hand", getHands());
                updateYaml(gameDataFilePath, playerId, "count_value", getCountValues());
            }
        }
    }

    @Override
    protected void updateYaml(String file, Integer playerId, String key, Object value) {
        gameDataHandler.updatePlayerGameData(file, playerId, key, value);
    }
}

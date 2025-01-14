package players;

import cards.Deck;
import data.GameDataHandler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static data.GameDataHandler.gameDataFilePath;

public final class Dealer extends Player implements PlayerActions {
    private static final GameDataHandler gameDataHandler = new GameDataHandler();
    private static Deck deck;
    private final int dealerId = 0;

    // Create a Dealer from the Player, and save it to data file
    public Dealer(Deck deck) {
        super("Dealer", Integer.MAX_VALUE, null, new LinkedHashMap<>(), new LinkedHashMap<>());
        Dealer.deck = deck;
        this.getHands().put(0, dealInitialHand());
        this.getCountValues().put(0, countHandValue(this.getHands().get(0)));

        savePlayerToFile(gameDataFilePath, this);
    }

    // Unforeseeable Dealer's actions
    public void dealerActions() {
        boolean isSoft17 = getCountValues().get(0) == 17 && getHands().get(0).stream().anyMatch(card -> card.startsWith("ACE")); // Is have CountValue 17 and have an Ace (will take another card)
        boolean isHard17 = getCountValues().get(0) >= 17 && getHands().get(0).stream().noneMatch(card -> card.startsWith("ACE")); // Is have CountValue 17 and don't have an Ace (will not take another card)
        boolean is21 = getCountValues().get(0) == 21; // Is have CountValue 21 (if take a card will lose)
        boolean isBust = getCountValues().get(0) > 21; // Is have CountValue more than 21 (lose)

        // Take all players' count values
        Map<Integer, Object> playersData = (Map<Integer, Object>) (Map<?, Object>) gameDataHandler.readPlayerGameData(gameDataFilePath, null);
        playersData.remove(dealerId);
        List<Integer> allCountValues = new ArrayList<>();
        for (Map.Entry<Integer, Object> entry : playersData.entrySet()) {
            Map<Integer, Integer> countValues = (Map<Integer, Integer>) ((Map<String, Object>) entry.getValue()).get("count_value");
            allCountValues.addAll(countValues.values());
        }
        //boolean isCountValueLessThanAllPlayersCountValuesAndAllPlayersCountValuesLessThan21 = getCountValues().get(0) < 21 && allCountValues.stream().allMatch(value -> value < 21 && getCountValues().get(0) < value); // Is have CountValue less than all players' count values and all players' count values less than 21 (will take another card, he has nothing to lose)
        //boolean isCanTakeAnotherCard = getCountValues().get(0) < 17 && allCountValues.stream().anyMatch(value -> value >= getCountValues().get(0) && getCountValues().get(0) <= 21); // Is have CountValue less than 17 and at least one player has a count value greater than or equal to the dealer's count value (will take another card)

        // Dealer's actions
        while (!is21 && !isBust && !isHard17) {

            if (isSoft17 || getCountValues().get(0) < 17) {
                hit(0);
            }

            // Update booleans
            isSoft17 = getCountValues().get(0) == 17 && getHands().get(0).stream().anyMatch(card -> card.startsWith("ACE"));
            isHard17 = getCountValues().get(0) >= 17 && getHands().get(0).stream().noneMatch(card -> card.startsWith("ACE"));
            is21 = getCountValues().get(0) == 21;
            isBust = getCountValues().get(0) > 21;
        }

        // Update the dealer's hand and count value in the YAML file
        updateYaml(gameDataFilePath, dealerId, "hand", getHands());
        updateYaml(gameDataFilePath, dealerId, "count_value", getCountValues());
    }

    // Deal the initial hand for the dealer
    @Override
    protected List<String> dealInitialHand() {
        ArrayList<String> hand = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            hand.add(deck.drawCard());
        }
        return hand;
    }

    // Hit the dealer's hand (draw one card)
    @Override
    public void hit(int handIndex) {
        handIndex = 0; // Dealer has only one hand
        if (getHands().containsKey(handIndex)) {
            getHands().get(handIndex).add(deck.drawCard());
            getCountValues().put(handIndex, countHandValue(getHands().get(handIndex)));

            updateYaml(gameDataFilePath, dealerId, "hand", getHands());
            updateYaml(gameDataFilePath, dealerId, "count_value", getCountValues());
        }
    }

    @Override
    public void stand(int handIndex) {
        // Dealer cannot stand
    }

    @Override
    public void doubleDown(int handIndex) {
        // Dealer cannot double down
    }

    @Override
    public void split(int handIndex) {
        // Dealer cannot split
    }

    @Override
    protected void updateYaml(String file, Integer playerId, String key, Object value) {
        gameDataHandler.updatePlayerGameData(file, playerId, key, value);
    }
}

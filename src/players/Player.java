package players;

import cards.CardRank;
import data.GameDataHandler;
import exceptions.InsufficientChipsException;

import java.util.LinkedHashMap;
import java.util.List;

public abstract class Player {
    private final String name;
    private Integer chips;
    private LinkedHashMap<Integer, Integer> bets;
    private LinkedHashMap<Integer, List<String>> hands;
    private LinkedHashMap<Integer, Integer> countValues;

    public Player(String name, Integer chips, LinkedHashMap<Integer, Integer> bets, LinkedHashMap<Integer, List<String>> hands, LinkedHashMap<Integer, Integer> countValues) {
        this.name = name;
        this.chips = chips;
        this.bets = bets;
        this.hands = hands;
        this.countValues = countValues;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public Integer getChips() {
        return chips;
    }

    public void setChips(Integer chips) {
        this.chips = chips;
    }

    public LinkedHashMap<Integer, Integer> getBets() {
        return bets;
    }

    public void setBets(LinkedHashMap<Integer, Integer> bets) {
        this.bets = bets;
    }

    public LinkedHashMap<Integer, List<String>> getHands() {
        return hands;
    }

    public LinkedHashMap<Integer, Integer> getCountValues() {
        return countValues;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", chips=" + chips +
                ", bets=" + bets +
                ", hands=" + hands +
                ", countValues=" + countValues +
                '}';
    }

    // Save the player to YAML
    protected void savePlayerToFile(String file, Player player) {
        GameDataHandler gameDataHandler = new GameDataHandler();
        gameDataHandler.addPlayerGameData(file, player);
    }

    // Remove the player from YAML
    protected void removePlayerFromYaml(String file, Integer playerId) {
        GameDataHandler gameDataHandler = new GameDataHandler();
        gameDataHandler.removePlayerGameData(file, playerId);
    }

    // Count and return the value of the hand
    protected Integer countHandValue(List<String> hand) {
        int count = 0;
        int aceCount = 0;
        for (String card : hand) {
            String rank = card.substring(0, card.length() - 1); // Extract the rank from the card string
            CardRank cardRank = CardRank.valueOf(rank.toUpperCase());
            if (cardRank == CardRank.ACE) {
                count += ((int[]) cardRank.getValue())[1]; // Use the higher value for ACE (11)
                aceCount++;
            } else if (cardRank.getValue() instanceof Integer) {
                count += (int) cardRank.getValue();
            }
        }
        while (count > 21 && aceCount > 0) {
            count -= ((int[]) CardRank.ACE.getValue())[1]; // Use the higher value for ACE (11)
            count += ((int[]) CardRank.ACE.getValue())[0]; // Use the lower value for ACE (1)
            aceCount--;
        }
        return count;
    }

    // Abstract methods for player actions
    protected abstract List<String> dealInitialHand();
    protected abstract void hit(int handIndex);
    protected abstract void stand(int handIndex);
    protected abstract void doubleDown(int handIndex) throws InsufficientChipsException;
    protected abstract void split(int handIndex);

    // Update the player in YAML
    protected abstract void updateYaml(String file, Integer playerId, String key, Object value);
}

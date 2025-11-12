package data;

import cards.Card;

import java.util.Map;

public class DeckDataHandler extends DataHandler {
    public static final String deckDataFilePath = "data/deck.yaml";

    // Read the entire deck
    public Map<String, Object> readDeck(String file) {
        Map<String, Object> data = readData(file);
        return data != null && data.containsKey("deck") ? data : null;
    }

    // Write (Update) the entire deck
    public void writeDeck(String file, Map<String, Card> deck) {
        writeData(file, Map.of("deck", deck));
    }

    // Update a single card in the deck: set new card data (value, counts, suit) for a card key
    @Override
    protected void updateData(String file, String cardKey, Object cardData) {
        Map<String, Object> data = readData(file);

        if (data != null && data.containsKey("deck")) {
            Map<String, Object> deck = (Map<String, Object>) data.get("deck");
            deck.put(cardKey, cardData);
        }

        writeData(file, data);
        System.out.println("Card " + cardKey + " updated in: " + file);
    }
}

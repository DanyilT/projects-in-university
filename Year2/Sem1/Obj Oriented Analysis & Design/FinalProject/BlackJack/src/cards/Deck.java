package cards;

import data.DeckDataHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static data.DeckDataHandler.deckDataFilePath;

public class Deck {
    private static final DeckDataHandler deckDataHandler = new DeckDataHandler();
    private static LinkedHashMap<String, Card> deck = new LinkedHashMap<>();

    public Deck() {
        // Open a new deck and pseudorandom shuffle it
        generateDeck();
        shuffleDeck();
    }

    public LinkedHashMap<String, Card> getDeck() {
        return deck;
    }

    // Generate 52 Cards and save them to the Deck (LinkedHashMap)
    private void generateDeck() {
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                String key = rank.name() + suit.getSymbol(); // Unique key (e.g., "A♥")
                deck.put(key, new Card(rank, suit));
            }
        }

        // Save deck to file deck.yaml
        deckDataHandler.writeDeck(deckDataFilePath, deck);
    }

    // Shuffle the deck
    private void shuffleDeck() {
        ArrayList<Map.Entry<String, Card>> cardList = new ArrayList<>(deck.entrySet());
        Collections.shuffle(cardList);
        LinkedHashMap<String, Card> shuffledDeck = new LinkedHashMap<>();
        for (Map.Entry<String, Card> entry : cardList) {
            shuffledDeck.put(entry.getKey(), entry.getValue());
        }
        deck = shuffledDeck;

        // Save deck to file deck.yaml
        deckDataHandler.writeDeck(deckDataFilePath, deck);
    }

    // Clear the deck
    public void clearDeck() {
        deck.clear();

        // Save deck to file deck.yaml
        deckDataHandler.writeDeck(deckDataFilePath, deck);
    }

    // Draw a card from the deck
    public String drawCard() {
        if (!deck.isEmpty()) {
            Map.Entry<String, Card> entry = deck.entrySet().iterator().next();
            deck.remove(entry.getKey());

            // Save deck to file deck.yaml
            deckDataHandler.writeDeck(deckDataFilePath, deck);

            return entry.getKey();
        }
        return null;
    }
}

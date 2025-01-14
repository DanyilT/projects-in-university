package cards;

public class Card {
    private final CardRank rank;
    private final CardSuit suit;

    // Create a card with a rank and a suit (e.g., "A♥")
    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Get the card as a string (e.g., "A♥")
    public String getCard() {
        return rank.name() + suit.getSymbol();
    }

    // Get the rank of the card (e.g., "A")
    public CardRank getRank() {
        return rank;
    }

    // Get the suit of the card (e.g., "♥")
    public CardSuit getSuit() {
        return suit;
    }
}

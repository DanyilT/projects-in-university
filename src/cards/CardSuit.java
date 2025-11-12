package cards;

public enum CardSuit {
    HEARTS('♥'),
    CLUBS('♣'),
    DIAMONDS('♦'),
    SPADES('♠');

    private final char symbol;

    CardSuit(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}

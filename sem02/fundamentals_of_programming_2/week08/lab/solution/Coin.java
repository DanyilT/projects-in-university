public class Coin {

    public static final int HEADS = 1; // read-only
    public static final int TAILS = 0; // read-only
    private int state; // current state of the coin

    // No-arg constructor
    public Coin() {
        // Simulate a fair coin flip
        flip();
    }

    // Constructor with state argument
    public Coin(int state) {
        this.state = state;
    }

    // Returns the current state of the coin
    public int getState() {
        return state;
    }

    // Simulate a fair coin flip
    public void flip() {
        state = (Math.random() > 0.5) ? HEADS : TAILS;
    }

    // Simulate a biased coin flip
    public void flip(double bias) {
        state = (Math.random() < bias) ? HEADS : TAILS;
    }

    // Returns the string representation of the coin's state
    public String toString() {
        return (state == HEADS) ? "HEADS" : "TAILS";
    }
}

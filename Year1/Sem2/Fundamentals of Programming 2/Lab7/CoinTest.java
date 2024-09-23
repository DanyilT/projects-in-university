public class CoinTest{
    // Size of Coin array
    public static final int NUMCOINS = 100;
    
    public static void main(String[] args) {
        // Local vars
        int headCount = 0;
        int tailCount = 0;
        double bias = 0.8;
        
        // Create the Coin array
        Coin[] coins = new Coin[NUMCOINS];

        // Populate the Coin array with Coin objects
        // Coin objects will have random HEAD/TAIL values
        for(int i = 0; i < coins.length; i++){
            coins[i] = new Coin();
            System.out.print(coins[i] + " ");
        }
        
        System.out.println();
        
        // Count the number of HEAD/TAIL values
        for(int i = 0; i < coins.length; i++){
            if (coins[i].getState() == Coin.HEADS)
                headCount++;
            else if (coins[i].getState() == Coin.TAILS)
                tailCount++;
        }
        // Print the count results
        System.out.printf("HEADS=%d TAILS=%d \n", headCount, tailCount);

        // Populate the array with biased coins
        for(int i = 0; i < coins.length; i++){
            coins[i].flip(bias);
            System.out.print(coins[i] + " ");
        }
        
        // Reset the HEAD/TAIL counts
        headCount = 0; tailCount = 0;
        
        // Count the number of HEAD/TAIL values
        for(int i = 0; i < coins.length; i++){
            if (coins[i].getState() == Coin.HEADS)
                headCount++;
            else if (coins[i].getState() == Coin.TAILS)
                tailCount++;
        }
        System.out.println();
        // Print the count results
        System.out.printf("HEADS=%d TAILS=%d \n", headCount, tailCount);

    }
}

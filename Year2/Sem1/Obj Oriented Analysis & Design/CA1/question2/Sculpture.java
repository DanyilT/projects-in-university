public final class Sculpture extends Exhibit {
    public String material;
    public static double taxRate = 0.055;

    @Override
    public String toString() {
        return material + " sculpture " + title + " (weight " + weightKg + "kg, " + value + ")";
    }

    public static String taxRateMessage() {
        return "Tax Rate = " + (int) (taxRate * 100) + "%";
    }
}

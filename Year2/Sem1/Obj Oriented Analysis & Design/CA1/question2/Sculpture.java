public class Sculpture extends Exhibit {
    public String material;
    public double taxRate = 0.055;

    @Override
    public String toString() {
        return material + " sculpture " + title + " (weight " + weightKg + "kg, " + value + ")";
    }

    public String taxRateMessage() {
        double percentage = taxRate * 100;
        return "Tax Rate = " + percentage + "%";
    }
}

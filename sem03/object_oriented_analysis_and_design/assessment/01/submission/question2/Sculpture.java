import java.math.BigDecimal;

public final class Sculpture extends Exhibit {
    public String material;
    public static double taxRate = 0.055;

    @Override
    public String toString() {
        return material + " sculpture " + title + " (weight " + weightKg + "kg, " + value + ")";
    }

    public static String taxRateMessage() {
        // the percentage without trailing zeros: 5.5 and 10 (the paper's expected output)
        return "Tax Rate = " + BigDecimal.valueOf(taxRate).multiply(BigDecimal.valueOf(100)).stripTrailingZeros().toPlainString() + "%";
    }
}

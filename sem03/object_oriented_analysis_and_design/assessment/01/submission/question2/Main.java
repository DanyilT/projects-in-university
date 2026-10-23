public class Main {
    public static void main(String[] args) {
        // Painting: Mona Lisa
        Painting mona = new Painting("Mona Lisa", ValueType.PRICELESS);
        mona.weightKg = 12.9;
        mona.oilBased = true;
        System.out.println(mona.toString());

        // Sculpture: Mr. Tato
        Sculpture bust = new Sculpture();
        bust.title = "Mr. Tato";
        bust.value = ValueType.EXPENSIVE;
        bust.weightKg = 75.9;
        bust.material = "bronze";
        System.out.println(bust.toString());

        // Sculpture: Tax Rate Message
        System.out.println(bust.taxRateMessage());
        bust.taxRate = 0.1;
        System.out.println(bust.taxRateMessage());
    }
}

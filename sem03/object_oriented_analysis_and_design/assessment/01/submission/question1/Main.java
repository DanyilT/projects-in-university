public class Main {
    public static void main(String[] args) {
        Painting mona = new Painting();

        mona.setTitle("Mona Lisa");
        mona.setValue(ValueType.PRICELESS);
        mona.weightKg = 12.9;
        mona.oilBased = true;

        System.out.println(mona.toString());
    }
}

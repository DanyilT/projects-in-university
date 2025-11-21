public class Painting extends Exhibit {
    public boolean oilBased;

    public Painting(String title, ValueType value) {
        this.title = title;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Painting = " + title + " (" + (oilBased ? "oil-based" : "not an oil painting") + ", weight " + weightKg + "kg, " + value + ")";
    }
}

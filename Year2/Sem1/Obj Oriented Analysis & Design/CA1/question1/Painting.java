public class Painting {
    private String title;
    private ValueType value = ValueType.CHEAP;
    public double weightKg;
    public boolean oilBased;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ValueType getValue() {
        return value;
    }

    public void setValue(ValueType value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Painting = " + title + " (" + (oilBased ? "oil-based" : "not an oil painting") + ", weight " + weightKg + "kg, " + value + ")";
    }
}

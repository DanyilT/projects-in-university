public abstract class Exhibit {
    protected String title;
    protected ValueType value = ValueType.CHEAP;
    public double weightKg;

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
}

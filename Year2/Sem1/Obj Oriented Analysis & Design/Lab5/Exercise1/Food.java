package Exercise1;

public class Food {
    private String name;
    private FreshType freshness;

    public Food(String name, FreshType freshness) {
        this.name = name;
        this.freshness = freshness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FreshType getFreshness() {
        return freshness;
    }

    public void setFreshness(FreshType freshness) {
        this.freshness = freshness;
    }

    @Override
    public String toString() {
        return "Food{name='" + name + "', freshness=" + freshness + "}";
    }
}

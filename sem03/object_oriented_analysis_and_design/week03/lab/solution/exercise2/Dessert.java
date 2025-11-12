public class Dessert {
    private String name;
    private Boolean needsHeating;

    public Dessert(String name, Boolean needsHeating) {
        this.name = name;
        this.needsHeating = needsHeating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNeedsHeating() {
        return needsHeating;
    }

    public void setNeedsHeating(Boolean needsHeating) {
        this.needsHeating = needsHeating;
    }

    private String needsHeatingString() {
        return needsHeating ? "(heating needed)" : "(no heating needed)";
    }

    @Override
    public String toString() {
        return "(DESSERT) " + name + " " + needsHeatingString();
    }
}

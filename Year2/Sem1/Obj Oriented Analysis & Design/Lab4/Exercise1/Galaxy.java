package Exercise1;

public class Galaxy extends Phone {
    private Boolean expandableMemory;

    public Galaxy(String make, String model, String os, int memory, int cameraMegaPixels, Boolean expandableMemory) {
        super(make, model, os, memory, cameraMegaPixels);
        this.expandableMemory = expandableMemory;
    }

    public Boolean getExpandableMemory() {
        return expandableMemory;
    }

    public void setExpandableMemory(Boolean expandableMemory) {
        this.expandableMemory = expandableMemory;
    }

    @Override
    public String toString() {
        return super.toString() + ", ExpandableMemory=" + expandableMemory + "]";
    }
}

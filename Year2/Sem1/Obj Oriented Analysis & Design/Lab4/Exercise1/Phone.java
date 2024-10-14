package Exercise1;

public class Phone {
    private String make;
    private String model;
    private String os;
    private int memory;
    private int cameraMegaPixels;

    public Phone(String make, String model, String os, int memory, int cameraMegaPixels) {
        this.make = make;
        this.model = model;
        this.os = os;
        this.memory = memory;
        this.cameraMegaPixels = cameraMegaPixels;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getCameraMegaPixels() {
        return cameraMegaPixels;
    }

    public void setCameraMegaPixels(int cameraMegaPixels) {
        this.cameraMegaPixels = cameraMegaPixels;
    }

    @Override
    public String toString() {
        return "Phone [make=" + make + ", model=" + model + ", os=" + os + ", memory=" + memory + ", cameraMegaPixels=" + cameraMegaPixels;
    }
}

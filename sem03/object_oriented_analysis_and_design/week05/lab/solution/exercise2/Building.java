public abstract class Building {
    private String address;
    private int sizeMetersSquared;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSizeMetersSquared() {
        return sizeMetersSquared;
    }

    public void setSizeMetersSquared(int sizeMetersSquared) {
        this.sizeMetersSquared = sizeMetersSquared;
    }
}

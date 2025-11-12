public abstract class Building {
    protected String address;
    protected int sizeMetersSquared;

    // Not need to use this getter in the subclasses (House class), because the address is protected
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Not need to use this getter in the subclasses (House class), because the sizeMetersSquared is protected
    public int getSizeMetersSquared() {
        return sizeMetersSquared;
    }

    public void setSizeMetersSquared(int sizeMetersSquared) {
        this.sizeMetersSquared = sizeMetersSquared;
    }
}

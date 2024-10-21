package Exercise3;

public class House extends Building {
    private int numBedrooms;
    private int numBathrooms;

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    @Override
    public String toString() {
        return "(HOUSE) address = " + address + " / size = " + sizeMetersSquared + " sq.m. / " + numBedrooms + " bedrooms / " + numBathrooms + " bathrooms";
    }
}

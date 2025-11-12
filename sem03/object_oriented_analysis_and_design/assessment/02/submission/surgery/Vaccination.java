package surgery;

public final class Vaccination {
    private String name;
    private int quantity;
    public InjectionType method;
    private static int numNeedles;
    public Pet pet;

    public Vaccination(InjectionType method) {
        this.method = method;

        if (method == InjectionType.NEEDLE) {
            numNeedles++;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws RuntimeException {
        if (quantity < 1) {
            throw new RuntimeException("quanitty cannot be less than 1");
        } else {
            this.quantity = quantity;
        }
    }

    public void setMethod(InjectionType method) {
        this.method = method;
    }

    public static int getNumNeedles() {
        return numNeedles;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", method=" + method +
                ", pet=" + pet +
                '}';
    }
}

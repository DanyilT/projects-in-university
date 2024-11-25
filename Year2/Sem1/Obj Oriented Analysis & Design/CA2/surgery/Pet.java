package surgery;

import people.Owner;

public class Pet {
    private String name;
    private String details = null;
    public Owner owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", owner=" + owner +
                '}';
    }
}

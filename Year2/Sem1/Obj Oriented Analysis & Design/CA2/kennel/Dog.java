package kennel;

import people.Owner;

public class Dog {
    private String name;
    private String dob;
    private boolean fullyVaccinated;
    public Owner owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isFullyVaccinated() {
        return fullyVaccinated;
    }

    public void setFullyVaccinated(boolean fullyVaccinated) {
        this.fullyVaccinated = fullyVaccinated;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", fullyVaccinated=" + fullyVaccinated +
                ", owner=" + owner +
                '}';
    }
}

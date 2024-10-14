package Exercise2;

public class Phone {
    public String phoneNumber;
    public Person owner;

    public Phone(String phoneNumber, Person owner) {
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Phone [phoneNumber=" + phoneNumber + ", owner=" + owner + "]";
    }
}

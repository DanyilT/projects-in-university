package Exercise2;

public class Person {
    public String firstName;
    public String surname;

    public Person(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "[firstName=" + firstName + ", surname=" + surname + "]";
    }
}

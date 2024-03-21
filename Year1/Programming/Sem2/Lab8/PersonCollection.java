import java.util.ArrayList;
import java.util.Iterator;

public class PersonCollection {
    private ArrayList<Person> people;

    public PersonCollection() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void displayPeople() {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public void removePerson(String name) {
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.toString().contains("Name: " + name)) {
                iterator.remove();
            }
        }
    }
}

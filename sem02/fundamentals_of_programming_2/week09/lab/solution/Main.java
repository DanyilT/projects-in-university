public class Main {
    public static void main(String[] args) {
        PersonCollection collection = new PersonCollection();
        
        // Adding people to the collection
        collection.addPerson(new Person("John"));
        collection.addPerson(new Athlete("Ellen", "Raheny Shamrocks"));
        collection.addPerson(new Employee("Alex", 45000.00));

        System.out.println("Before removal:");
        collection.displayPeople();
        
        // Removing Alex from the collection
        collection.removePerson("Alex");

        System.out.println("\nAfter removal:");
        collection.displayPeople();
    }
}

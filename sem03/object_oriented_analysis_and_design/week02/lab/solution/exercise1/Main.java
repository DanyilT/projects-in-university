public class Main {
    public static void main(String[] args) {
        // Create the objects
        Pet pet1 = new Pet("Gogu", "turtle", 34);
        Pet pet2 = new Pet("Lassie", "dog", 7);

        // Print the objects
        System.out.println("Initial objects:");
        System.out.println(pet1);
        System.out.println(pet2);

        pet1.setAge(100);
        pet2.setName("Aristotle");

        // Print what we changed
        System.out.println("\nWhat we changed:");
        System.out.println("Updated age of pet1: " + pet1.getAge());
        System.out.println("Updated name of pet2: " + pet2.getName());

        // Print the objects after the changes
        System.out.println("\nAfter the changes:");
        System.out.println(pet1);
        System.out.println(pet2);
    }
}

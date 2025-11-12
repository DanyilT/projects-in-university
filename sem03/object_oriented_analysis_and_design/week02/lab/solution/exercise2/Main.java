public class Main {
    public static void main(String[] args) {
        // Create the objects
        Book book1 = new Book("The Restaurant at the end of the Universe", 9.99);
        Book book2 = new Book("", -2.00);

        // Print the objects
        System.out.println("\nInitial objects:");
        System.out.println(book1);
        System.out.println(book2);
    }
}

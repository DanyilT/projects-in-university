// TestBook class
public class TestBook {
    public static void main(String[] args) {
        // Create a Book instance
        Book book = new Book("Aeneid", "Ivan Kotlyarevskyi", 1842);
        Book book1 = new Book("Ulysses", "James Joyce", 1921);
        Book book2 = new Book("Dracula", "Bram Stoker", 1897);

        // Print book's properties and results of methods as needed
        System.out.println("\nBook Object 1");
        System.out.println("Title: " + book1.getTitle());
        System.out.println("Author: " + book1.getAuthor());
        System.out.println("Year: " + book1.getYear());

        System.out.println("\nBook Object 2");
        System.out.println("Title: " + book2.getTitle());
        System.out.println("Author: " + book2.getAuthor());
        System.out.println("Year: " + book2.getYear());
    }
}

// Book class
public class Book {
    // Instance variables
    private String title;
    private String author;
    private int year;

    // Constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Methods (getters and setters)
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}

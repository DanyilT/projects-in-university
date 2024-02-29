// TestBook class
public class TestBook {
    public static void main(String[] args) {
        // Create Book instances and set properties
        Book book = new Book();
        book.setTitle("Aeneid");
        book.setAuthor("Ivan Kotlyarevskyi");
        book.setYear(1842);

        Book book1 = new Book();
        book1.setTitle("Ulysses");
        book1.setAuthor("James Joyce");
        book1.setYear(1921);

        Book book2 = new Book();
        book2.setTitle("Dracula");
        book2.setAuthor("Bram Stoker");
        book2.setYear(1897);

        // Print book's properties
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

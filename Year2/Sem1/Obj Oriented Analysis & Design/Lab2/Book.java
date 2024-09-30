public class Book {
    private String title;
    private double price;

    public Book(String title, double price) {
        if (title.isEmpty()) {
            this.title = "(no title set)";
        } else {
            this.title = title;
        }

        if (price < 0) {
            this.price = 7.7;
        } else {
            this.price = price;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            this.title = "(no title set)";
        } else {
            this.title = title;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = 7.7;
        } else {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Book {" + title + ", price=" + price + "}";
    }
}

public class Book {
    private int book_id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int quantity;
    private int available_copies;
    public Book(int book_id, String title, String author, String publisher, int year, int quantity) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.quantity = quantity;
        this.available_copies = quantity;
    }
    public int getBook_id() {
        return book_id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public int getYear() {
        return year;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getAvailableCopies() {
        return available_copies;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setAvailableCopies(int available_copies) {
        this.available_copies = available_copies;
    }
}

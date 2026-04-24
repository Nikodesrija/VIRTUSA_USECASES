import java.time.LocalDate;
public class Transaction {
    private int book_id;
    private int user_id;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    public Transaction(int book_id, int user_id) {
        this.book_id = book_id;
        this.user_id = user_id;
        this.issueDate = LocalDate.now();
        this.dueDate = issueDate.plusDays(7);
        this.returnDate = null;
    }
    public int getBook_id() {
        return book_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public LocalDate getIssueDate() {
        return issueDate;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

}

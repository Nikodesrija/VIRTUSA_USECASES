import java.time.LocalDate;
import java.util.*;
public class LibraryService {
    private Map<Integer, Book> books= new HashMap<>();
    private List<User> users= new ArrayList<>();
    private List<Transaction> transactions= new ArrayList<>();
    public void addBook(Book book) {
        boolean exists = books.containsKey(book.getBook_id());
        if(exists) {
            Book existingBook = books.get(book.getBook_id());
            existingBook.setAvailableCopies(existingBook.getAvailableCopies() + book.getQuantity());
            System.out.println(book.getTitle() + " already exists... Updated available copies.");
            return;
        }
        else{
        books.put(book.getBook_id(), book);
        System.out.println(book.getTitle() + " added to library.");
        }
    }
    public void updateBook(int book_id, String title, String author) {
        if(books.containsKey(book_id)) {
            Book book = books.get(book_id);
            book.setTitle(title);
            book.setAuthor(author);
            System.out.println("Book ID: " + book_id + " updated.");
        } else {
            System.out.println("Book ID: " + book_id + " not found.");
        }
    }
    public void removeBook(int book_id) {
        if(books.containsKey(book_id)) {
            Book book = books.get(book_id);
            if(book.getAvailableCopies() < book.getQuantity()) {
                System.out.println("Cannot remove book ID " + book_id + " as some copies are currently issued.");
                return;
            }
            books.remove(book_id);
            System.out.println("Book Id:" + book_id + " removed.");
        } else {
            System.out.println("Book Id:" + book_id + " not found.");
        }
    }
    public void UserRegister(User user) {
        boolean exists = users.stream().anyMatch(u -> u.getUserid() == user.getUserid());
        if(exists) {
            System.out.println("User already exists.");
            return;
        }
        else{
            users.add(user);
        System.out.println("Hi " + user.getName() + ",you have successfully registered.");
        }
    }
    public void searchBook(String keymatch){
        List<Book> result=books.values().stream()
                .filter(b -> b.getTitle().toLowerCase().contains(keymatch.toLowerCase()) ||
                        b.getAuthor().toLowerCase().contains(keymatch.toLowerCase())).toList();
        if(result.isEmpty()) {
            System.out.println("No books found!");
        } else {
            result.forEach(b -> System.out.println(b.getBook_id()+" with "+b.getTitle()+" by "+b.getAuthor()+" is available with "+b.getAvailableCopies()+" copies."));
        }
    }
    public void issueBook(int book_id, int user_id) {
        if(!books.containsKey(book_id)) {
            System.out.println("Book with ID :" + book_id + " not found.");
            return;
        }
        if(books.get(book_id).getAvailableCopies() <= 0) {
            System.out.println("No available copies for book: " + book_id + ".");
            return;
        }
        books.get(book_id).setAvailableCopies(books.get(book_id).getAvailableCopies() - 1);
        transactions.add(new Transaction(book_id,user_id));
       System.out.println("Book with ID " + book_id + " issued to user with ID " + user_id + ".");
    }
    public void returnBook(int book_id,int user_id){
        for(Transaction t:transactions){
            if(t.getBook_id()==book_id && t.getUser_id()==user_id && t.getReturnDate()==null){
                LocalDate today = LocalDate.now();
                t.setReturnDate(today);
                long daysLate = today.toEpochDay() - t.getDueDate().toEpochDay();
                double fine=(daysLate > 0) ? daysLate * 2.0 : 0.0;
                Book book = books.get(book_id);
                if(book != null) {
                    book.setAvailableCopies(book.getAvailableCopies() + 1);
                }
                System.out.println("Book ID: " + book_id + " returned by user with ID " + user_id);
                System.out.println("Fine amount:" + fine);
                return;
            }
        }
        System.out.println("Transaction not found!");
    }
    public void showAllBooks(){
        books.values().forEach(b->System.out.println("Book ID: " + b.getBook_id() + " with title " + b.getTitle() + " available copies: " + b.getAvailableCopies()));
    }
}

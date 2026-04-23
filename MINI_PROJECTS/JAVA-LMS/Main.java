import java.util.*;
import model.*;
import service.LibraryService;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LibraryService libraryService = new LibraryService();
        while(true){
            System.out.println("\n Welcome to Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Search Book");
            System.out.println("5. User Registration");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Show All Books");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine(); 
            switch(choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int book_Id = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = s.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = s.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = s.nextLine();
                    System.out.print("Enter Year: ");
                    int year = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = s.nextInt();
                    s.nextLine();
                    libraryService.addBook(new Book(book_Id, title, author, publisher, year, quantity));
                    break;
                case 2:
                    System.out.print("Enter Book ID to update: ");
                    int book_id = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter title: ");
                    String newTitle = s.nextLine();
                    System.out.print("Enter author: ");
                    String newAuthor = s.nextLine();
                    libraryService.updateBook(book_id, newTitle, newAuthor);
                    break;
                case 3:
                    System.out.print("Enter Book ID to remove: ");
                    int bookid = s.nextInt();
                    libraryService.removeBook(bookid);
                    break;
                case 4:
                    System.out.print("Enter Keyword to search Book: ");
                    String keyword = s.nextLine();
                    libraryService.searchBook(keyword);
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    int userId = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter User Name: ");
                    String userName = s.nextLine();
                    System.out.print("Enter User Email: ");
                    String userEmail = s.nextLine();
                    System.out.print("Enter User Phone: ");
                    String userPhone = s.nextLine();
                    libraryService.UserRegister(new User(userId, userName, userEmail, userPhone));
                    break;
                case 6:
                    System.out.print("Enter Book ID to issue: ");
                    int issueBookId = s.nextInt();
                    System.out.print("Enter User ID: ");
                    int issueUserId = s.nextInt();
                    libraryService.issueBook(issueBookId, issueUserId);
                    break;
                case 7:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = s.nextInt();
                    System.out.print("Enter User ID: ");
                    int returnUserId = s.nextInt();
                    libraryService.returnBook(returnBookId, returnUserId);
                    break;
                case 8:
                    libraryService.showAllBooks();
                    break;
                case 9:
                    System.out.println("Exiting... Thank you for using the Library Management System!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

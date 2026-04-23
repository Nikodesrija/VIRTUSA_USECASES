import java.time.LocalDateTime;
import java.util.*;
class InSufficientFundsException extends Exception{
    public InSufficientFundsException(String message){
        super(message);
    }
}
class Account{
    private String accountHolder;
    private double balance;
    private int transactionSequence=1;
    private ArrayList<String> transactions;
    Account(String accountHolder,double balance){
        this.accountHolder=accountHolder;
        this.balance=balance;
        this.transactions=new ArrayList<>();
    }
    public void deposit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Amount should be more than 0 for deposit");
        }
        balance+=amount;
        transactionHistory("Deposited",amount);
        System.out.println("ThankYou!! You have deposited Sucessfully");
    }
    public void withdraw(double amount) throws InSufficientFundsException{
        if(amount<=0){
            throw new IllegalArgumentException("Amount must be Positive, pls try again!");

        }
        if(amount>balance){
            throw new InSufficientFundsException("Transaction failed:Available balance is lower than requested amount");
        }
        balance-=amount;
        transactionHistory("Withdrawn",amount);
        System.out.println("ThankYou!! You have withdrawn Sucessfully");
    }
    public double getBalance(){
        return balance;
    }
    public void transactionHistory(String type,double amount){
        LocalDateTime now=LocalDateTime.now();
        String record="Txn#"+transactionSequence+" | "+ type + ":" +amount+ " |Time:"+now;
        if(transactions.size()==5){
            transactions.remove(0);
        }
        transactions.add(record);
        transactionSequence++;
    }
    public void RecentRecordStatements(int option){
        System.out.println("\n---Recent 5 transactions---");
        if(transactions.isEmpty()) {
            System.out.println("No recent transaction found");
            return;}
        if(option==1){
        transactions.stream().forEach(System.out::println);}
        else if(option==2){
            transactions.stream().filter(t->t.contains("Deposited")).forEach(System.out::println);
        }
        else if(option==3){
            transactions.stream().filter(t->t.contains("Withdrawn")).forEach(System.out::println);
        }
        else if(option==4){
            long transactionscount=transactions.stream().count();
            System.out.println("Total Transactions: "+transactionscount);
        }
        else{
            System.out.println("Invalid option");
        }
    }
}
public class FinSafe {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     System.out.print("Welcome to FinSafe!!\nEnter Account Holder Name:");
     String name=sc.nextLine();
     System.out.println("Enter Initial Balance:");
     double initialBalance=sc.nextDouble();
     if(initialBalance<0){
         System.out.println("Initial Balance cannot be negative,setting default value to 0");
         initialBalance=0;
     }
     Account account=new Account(name,initialBalance);
     while(true){
         System.out.println("\n======finSafe Wallet======");
         System.out.println("1.Deposit");
         System.out.println("2.Withdraw");
         System.out.println("3.View Transactions");
         System.out.println("4.Check Balance");
         System.out.println("5.Exit");
         System.out.println("Enter your Choice:");
         int choice=sc.nextInt();
         try{
             switch(choice){
                 case 1:
                     System.out.println("Enter deposit amount:");
                     double deposit=sc.nextDouble();
                     account.deposit(deposit);
                     break;
                 case 2:
                     System.out.println("Enter withdraw amount:");
                     double withdraw=sc.nextDouble();
                     account.withdraw(withdraw);
                     break;
                 case 3:
                     System.out.println("\n 1.View all Options");
                     System.out.println("2.Only Deposits");
                     System.out.println("3. Only Withdrawals");
                     System.out.println("4. Total Transactions");
                     System.out.print("Enter option: ");
                     int subChoice = sc.nextInt();
                     account.RecentRecordStatements(subChoice);
                     break;
                 case 4:
                     System.out.println("Your Current Balance: "+account.getBalance());
                     break;
                 case 5:
                     System.out.println("Thank you for using our service!");
                     return;
                 default:
                     throw new IllegalStateException("Invalid Choice! please select a option between 1 and 5...");
             }
         }catch(InSufficientFundsException e){
             System.out.println(e.getMessage());
         }
         catch (IllegalArgumentException e) {
             System.out.println(e.getMessage());

         } catch (Exception e) {
             System.out.println("Invalid input!");
             sc.next();
         }
     }
    }
}
import java.util.Scanner;

class BankingAccount {

  private double balance;

  public BankingAccount(double firstBalance) {
    balance = firstBalance;  
  }

  public double showBalance() {
    return balance;
  }

  public void depositAmount(double amount) {
    balance += amount;
  }

  public boolean withdrawAmount(double amount) {
    if(amount < balance) {
      balance -= amount;
      return true;
    }
    return false;
  }

}

class CashDispenser {

  private BankingAccount account;
  
  public CashDispenser(BankingAccount bankAccount) {
    account = bankAccount;
  }

  public void showMenu() {

    System.out.println("Welcome to the Cash Dispenser Service!");
    
    System.out.println("1. Check Balance");
    System.out.println("2. Deposit");
    System.out.println("3. Withdraw");
    System.out.println("4. Exit");

  }

  public void start() {

    Scanner scanner = new Scanner(System.in);

    while(true) {
    
      showMenu();

      System.out.print("Choose option: ");
      int choice = scanner.nextInt();

      switch(choice) {
        case 1:
          System.out.println("Current Balance: " + account.showBalance());
          break;

        case 2:
          System.out.print("Please enter amount to deposit: ");
          double amount = scanner.nextDouble();
          account.depositAmount(amount);        
          System.out.println("Deposit completed. Your current balance is: " + account.showBalance());
          break;

        case 3:
          System.out.println("Thank you for using Cash Dispenser!");
          scanner.close();
          return;
        
        default:
          System.out.println("Invalid option. Please enter valid choice.");
      }

    }

  }

}  

public class Main {

  public static void main(String[] args) {
    
    BankingAccount account = new BankingAccount(1500); 
    
    CashDispenser dispenser = new CashDispenser(account);
    dispenser.start();

  }

}

import java.util.ArrayList;
import java.util.Scanner;

public class UserAccount {

    private double balance;
    private final ArrayList<String> transactions;

    public UserAccount() {
        balance = 0.0;
        transactions = new ArrayList<>();
    }

    public void deposit(Scanner userInputToDeposit) {
        double amount = -1;
        while (amount <= 0) {
            System.out.print("Enter Amount to Deposit: ");
            if (!userInputToDeposit.hasNextDouble()) {
                System.out.println("Invalid input! Please enter a valid number.");
                userInputToDeposit.next(); // clear invalid input
                continue;
            }
            amount = userInputToDeposit.nextDouble();
            if (amount <= 0) {
                System.out.println("Deposit Must be Greater than Zero!");
            }
        }
        balance += amount;
        String record = String.format("Deposited: $%.2f", amount);
        transactions.add(record);
        System.out.printf("Deposit Successful! Current Balance: $%.2f%n", balance);
    }

    public void withdrawal(Scanner userInputToWithdrawal) {
        double amount = -1;
        while (amount <= 0 || amount > balance) {
            System.out.print("Enter withdrawal amount: ");
            if (!userInputToWithdrawal.hasNextDouble()) {
                System.out.println("Invalid input! Please enter a valid number.");
                userInputToWithdrawal.next(); // clear invalid input
                continue;
            }

            amount = userInputToWithdrawal.nextDouble();

            if (amount <= 0) {
                System.out.println("Withdrawal must be greater than zero!");
            } else if (amount > balance) {
                System.out.printf("Insufficient funds! Current Balance: $%.2f%n", balance);
            }
        }
        balance -= amount;
        String record = String.format("Withdrew: $%.2f", amount);
        transactions.add(record);
        System.out.printf("Withdrawal Successful! Current Balance: $%.2f%n", balance);
    }


    public void viewBalance() {
        System.out.printf("Current Balance: $%.2f%n", balance);
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String t : transactions) {
                System.out.println(" - " + t);
            }
        }
    }
}

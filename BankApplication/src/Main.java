import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserAccount account = new UserAccount();
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("*--BANK APPLICATION--*");
            System.out.println("1) Make a Deposit");
            System.out.println("2) Make a Withdrawal");
            System.out.println("3) View Account");
            System.out.println("4) EXIT");
            System.out.println("*--------------------*");
            System.out.print("Please Enter an Option: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                input.next();
                continue;
            }

            int userInput = input.nextInt();
            switch(userInput) {
                case 1:
                    account.deposit(input);
                    break;
                case 2:
                    account.withdrawal(input);
                    break;
                case 3:
                    account.viewBalance();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Please Enter a Valid Option!");
            }
        }
        input.close();
    }
}



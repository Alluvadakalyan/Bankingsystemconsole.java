
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int accountNumber = 1001;
        String name = "";
        double balance = 0;
        boolean accountCreated = false;
        int choice = 0;

        do {
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        if (accountCreated) {
                            System.out.println("Account already exists!");
                            break;
                        }

                        System.out.print("Enter your name: ");
                        name = sc.nextLine();

                        if (name.trim().isEmpty()) {
                            System.out.println("Name cannot be empty!");
                            break;
                        }

                        System.out.print("Enter initial deposit: ");
                        balance = Double.parseDouble(sc.nextLine());

                        if (balance < 0) {
                            System.out.println("Invalid deposit!");
                            balance = 0;
                            break;
                        }

                        accountCreated = true;
                        System.out.println("Account created successfully!");
                        System.out.println("Account Number: " + accountNumber);
                        break;

                    case 2:
                        if (!accountCreated) {
                            System.out.println("Create an account first!");
                        } else {
                            System.out.printf(
                                "Your balance: Rs. %.2f%n", balance);
                        }
                        break;

                    case 3:
                        if (!accountCreated) {
                            System.out.println("Create an account first!");
                            break;
                        }

                        System.out.print("Enter deposit amount: ");
                        double deposit =
                            Double.parseDouble(sc.nextLine());

                        if (deposit > 0) {
                            balance += deposit;
                            System.out.println("Deposit successful!");
                        } else {
                            System.out.println("Invalid amount!");
                        }
                        break;

                    case 4:
                        if (!accountCreated) {
                            System.out.println("Create an account first!");
                            break;
                        }

                        System.out.print("Enter withdrawal amount: ");
                        double withdraw =
                            Double.parseDouble(sc.nextLine());

                        if (withdraw <= 0) {
                            System.out.println("Invalid amount!");
                        } else if (withdraw > balance) {
                            System.out.println("Insufficient balance!");
                        } else {
                            balance -= withdraw;
                            System.out.println("Withdrawal successful!");
                        }
                        break;

                    case 5:
                        if (!accountCreated) {
                            System.out.println("Create an account first!");
                        } else {
                            System.out.println("\n--- Account Details ---");
                            System.out.println("Name: " + name);
                            System.out.println(
                                "Account Number: " + accountNumber);
                            System.out.printf(
                                "Balance: Rs. %.2f%n", balance);
                        }
                        break;

                    case 6:
                        System.out.println("Thank you for using our bank!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }

        } while (choice != 6);

        sc.close();
    }
}

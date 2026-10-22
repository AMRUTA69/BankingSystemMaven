import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class BankingSystem {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        accounts.put("SAV123", new SavingsAccount("SAV123", 1000.0));
        accounts.put("CHK456", new CheckingAccount("CHK456", 200.0));

        while (true) {
            System.out.println("\n=== BANKING CONSOLE MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 5) {
                System.out.println("Thank you!");
                break;
            }

            switch (choice) {
                case 1: handleCheckBalance(); break;
                case 2: handleDeposit(); break;
                case 3: handleWithdraw(); break;
                case 4: handleTransfer(); break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void handleCheckBalance() {
        Account acc = findAccount();
        if (acc != null) System.out.println("Balance: $" + acc.getBalance());
    }

    private static void handleDeposit() {
        Account acc = findAccount();
        if (acc != null) {
            System.out.print("Enter deposit amount: ");
            acc.deposit(scanner.nextDouble());
        }
    }

    private static void handleWithdraw() {
        Account acc = findAccount();
        if (acc != null) {
            System.out.print("Enter withdrawal amount: ");
            try {
                acc.withdraw(scanner.nextDouble());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void handleTransfer() {
        System.out.print("Enter source account: ");
        Account source = accounts.get(scanner.nextLine().toUpperCase());
        System.out.print("Enter destination account: ");
        Account dest = accounts.get(scanner.nextLine().toUpperCase());
        if (source != null && dest != null) {
            System.out.print("Enter amount: ");
            try {
                source.transfer(dest, scanner.nextDouble());
            } catch (IllegalArgumentException e) {
                System.out.println("Transfer failed: " + e.getMessage());
            }
        }
    }

    private static Account findAccount() {
        System.out.print("Enter account number: ");
        Account acc = accounts.get(scanner.nextLine().toUpperCase());
        if (acc == null) System.out.println("Account not found.");
        return acc;
    }
}
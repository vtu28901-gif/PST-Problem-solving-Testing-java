import java.util.*;

public class Task5 {

    static class BankAccount {
        private int balance;

        BankAccount(int balance) {
            this.balance = balance;
        }

        void deposit(int amount) {
            balance += amount;
        }

        void withdraw(int amount) {
            if (amount <= balance) {
                balance -= amount;
            }
        }

        int getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        BankAccount account = new BankAccount(0);

        for (int i = 0; i < n; i++) {
            String operation = sc.nextLine();
            String[] parts = operation.split(" ");

            int amount = Integer.parseInt(parts[1]);

            if (parts[0].equalsIgnoreCase("Deposit")) {
                account.deposit(amount);
            } else if (parts[0].equalsIgnoreCase("Withdraw")) {
                account.withdraw(amount);
            }
        }

        System.out.println(account.getBalance());
    }
}
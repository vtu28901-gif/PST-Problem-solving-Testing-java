package tasks;

import java.util.Scanner;

class Account2 {
    int balance = 0;

    void deposit(int amount) {
        balance += amount;
    }

    void withdraw(int amount) {
        balance -= amount;
    }
}

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Account2 account = new Account2();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String operation = input[0];
            int amount = Integer.parseInt(input[1]);

            if (operation.equals("Deposit")) {
                account.deposit(amount);
            } else if (operation.equals("Withdraw")) {
                account.withdraw(amount);
            }
        }

        System.out.println(account.balance);
        sc.close();
    }
}
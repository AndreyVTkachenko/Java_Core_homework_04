package part_02;

import exeption.InsufficientFundsException;

public class Account {
    protected double accountBalance;

    public Account(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным.");
        }
        this.accountBalance = initialBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    void deposit(double amount) {
        accountBalance += amount;
        System.out.println("Произведено пополнение счёта на сумму: " + amount);
        System.out.println("Текущий баланс счёта: " + accountBalance + "\n");
    }

    void withdrawal(double amount) throws InsufficientFundsException {
        if (amount > accountBalance) {
            throw new InsufficientFundsException("Недостаточно средств на счете.\n");
        }
        accountBalance -= amount;
        System.out.println("Произведено списание средств на сумму: " + amount);
        System.out.println("Текущий баланс счёта: " + accountBalance + "\n");
    }
}

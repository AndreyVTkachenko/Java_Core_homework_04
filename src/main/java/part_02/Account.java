package part_02;

import exeption.InsufficientFundsException;

public class Account {
    protected double accountBalance;
    protected String accountName;

    public Account(String accountName, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным.");
        }
        this.accountBalance = initialBalance;
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    void deposit(double amount) {
        accountBalance += amount;
        System.out.println("Произведено пополнение счёта " + getAccountName() + " на сумму: " + amount);
        showBalance();
    }

    void withdrawal(double amount) throws InsufficientFundsException {
        if (amount > accountBalance) {
            throw new InsufficientFundsException("Недостаточно средств на счете.");
        }
        accountBalance -= amount;
        System.out.println("Произведено списание средств с " + getAccountName() + " на сумму: " + amount);
        showBalance();
    }

    void showBalance() {
        System.out.println("Текущий баланс счёта: " + accountBalance);
    }
}

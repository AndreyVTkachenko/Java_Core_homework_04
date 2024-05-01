package part_02;

import exeption.InsufficientFundsException;

public class CreditAccount extends Account{
    private final double creditLimit;

    public CreditAccount(String accountName, double initialBalance, double creditLimit) {
        super(accountName, initialBalance);
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public void withdrawal(double amount) throws InsufficientFundsException {
        if (amount > accountBalance + creditLimit) {
            throw new InsufficientFundsException("Недостаточно средств и кредитного лимита на счете.");
        }
        accountBalance -= amount;
        System.out.println("Произведено списание средств с " + getAccountName() + " на сумму: " + amount);
        showBalance();
    }

    @Override
    public String toString() {
        return "Кредитный счет: " + accountBalance;
    }
}

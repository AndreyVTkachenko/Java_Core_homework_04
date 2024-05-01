package part_02;

import exeption.InsufficientFundsException;

public class CreditAccount extends Account{
    private double creditLimit;

    public CreditAccount(double initialBalance, double creditLimit) {
        super(initialBalance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdrawal(double amount) throws InsufficientFundsException {
        if (amount > accountBalance + creditLimit) {
            throw new InsufficientFundsException("Недостаточно средств и кредитного лимита на счете.");
        }
        accountBalance -= amount;
        System.out.println("Произведено списание средств со счета на сумму: " + amount);
        System.out.println("Текущий баланс счета: " + accountBalance + "\n");
    }


}

package perfect_solution;

/**
 * Дебетовый счет
 */
public class DebitAccount extends BankAccount {
    public DebitAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть положительной");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств на счете", balance);
        }

        balance -= amount;
    }
}

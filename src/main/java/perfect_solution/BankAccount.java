package perfect_solution;

/**
 * Базовый класс "Банковский счет"
 */
public abstract class BankAccount {

    /**
     * Текущий баланс счета в условных единицах
     */
    protected double balance;

    public BankAccount(double initialBalance) {
        // Защита состояния при первичной инициализации объекта счета
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
    }

    /**
     * Изменить текущий баланс счета
     * @param amount Сумма средств к зачислению
     */
    public void deposit(double amount) {
        // Защита состояния при изменении текущего баланса счета
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма депозита должна быть положительной");
        }
        balance += amount;
    }

    /**
     * Снятие средств
     * @param amount Сумма средств к снятию
     * @throws InsufficientFundsException Сумма снятия должна быть положительной/недостаточно средств на счете
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        // Защита состояния при изменении текущего баланса счета
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть положительной");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств на счете", balance);
        }

        balance -= amount;
    }

    /**
     * Получить текущий баланс счета
     * @return Текущий баланс счета
     */
    public double getBalance() {
        return balance;
    }
}

package perfect_solution;

/**
 * Кредитный счет
 */
public class CreditAccount extends BankAccount {
    public CreditAccount(double initialBalance) {
        super(initialBalance);
    }

    /**
     * Для примера. Мы запрещаем снимать средства с кредитных счетов, вы можете только
     * внести новые средства для погашения кредита
     * @param amount сумма средств к снятию
     */
    @Override
    public void withdraw(double amount) {
        throw new IllegalArgumentException("Запрещено снимать средства с кредитного счета");
    }
}

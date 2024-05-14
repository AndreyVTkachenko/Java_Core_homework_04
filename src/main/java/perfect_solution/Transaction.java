package perfect_solution;

/**
 * Транзакция
 */
public class Transaction {

    /**
     * Выполнить перевод средств между счетами
     * @param fromAccount Счет списания
     * @param toAccount Счет зачисления
     * @param amount Сумма перевода
     * @throws TransactionException Недостаточно средств на счете для проведения транзакции
     */
    public static void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) throws TransactionException {
        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Транзакция успешно завершена.");
        } catch (InsufficientFundsException e) {
            throw new TransactionException("Недостаточно средств на счете для проведения транзакции.", e);
        }
    }
}

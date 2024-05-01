package part_02;

import exeption.InsufficientFundsException;

public class Transaction {

    public static void transfer(Account fromAccount, Account toAccount, double amount) throws InsufficientFundsException {
        try {
            fromAccount.withdrawal(amount);
            toAccount.deposit(amount);

            System.out.println("Транзакция успешно завершена. Переведено " + amount + " с " + fromAccount.getAccountName() + " на " + toAccount.getAccountName());
            System.out.println("Текущий баланс после перевода:");
            System.out.println(fromAccount);
            System.out.println(toAccount);
        } catch (InsufficientFundsException e) {
            throw new InsufficientFundsException("Транзакция не удалась: " + e.getMessage());
        }
    }
}

package perfect_solution;

public class Main {
    public static void main(String[] args) {
        try {

            // Создание счетов
            BankAccount creditAccount = new CreditAccount(1000);
            BankAccount debitAccount = new DebitAccount(500);

            // Проведение транзакции
            Transaction.transfer(debitAccount, creditAccount, 200);

            // Вывод баланса после транзакции
            System.out.println("Баланс кредитного счета: " + creditAccount.getBalance());
            System.out.println("Баланс дебетового счета: " + debitAccount.getBalance());

        } catch (TransactionException e) {
            System.out.println("Ошибка транзакции: " + e.getMessage());
        }
    }
}

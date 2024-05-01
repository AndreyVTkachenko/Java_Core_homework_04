package part_02;

import exeption.InsufficientFundsException;

public class Main {
    public static void main(String[] args) {

        CreditAccount creditAccount = new CreditAccount(1000, 500);
        DebitAccount debitAccount = new DebitAccount(500);

        System.out.println("Баланс счёта: ");
        System.out.println("Кредитовый: " + creditAccount.getAccountBalance());
        System.out.println("Дебетовый: " + debitAccount.getAccountBalance());

        try {
            Transaction.transfer(creditAccount, debitAccount, 500);
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("Баланс счёта: ");
        System.out.println("Кредитовый: " + creditAccount.getAccountBalance());
        System.out.println("Дебетовый: " + debitAccount.getAccountBalance());
    }
}

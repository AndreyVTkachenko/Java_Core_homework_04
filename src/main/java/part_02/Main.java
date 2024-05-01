package part_02;

import exeption.InsufficientFundsException;

public class Main {
    public static void main(String[] args) {

        CreditAccount creditAccount = new CreditAccount(1000, 500);
        DebitAccount debitAccount = new DebitAccount(500);

        System.out.println("Баланс счёта: ");
        System.out.println("Кредитный: " + creditAccount.getAccountBalance());
        System.out.println("Дебетовый: " + debitAccount.getAccountBalance());

        try {
            Transaction.transfer(creditAccount, debitAccount, 100);
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("Баланс счёта: ");
        System.out.println("Кредитный: " + creditAccount.getAccountBalance());
        System.out.println("Дебетовый: " + debitAccount.getAccountBalance());

        try {
            Transaction.transfer(debitAccount, creditAccount, 200);
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Transaction.transfer(creditAccount, debitAccount, 2000);
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

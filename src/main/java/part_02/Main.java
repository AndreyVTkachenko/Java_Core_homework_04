package part_02;

import exeption.InsufficientFundsException;

public class Main {
    public static void main(String[] args) {

        CreditAccount creditAccount = new CreditAccount("Кредитный счёт", 1000, 1000);
        DebitAccount debitAccount = new DebitAccount("Дебетовый счёт",500);

        System.out.println("Баланс счёта: ");
        System.out.println("Кредитный: " + creditAccount.getAccountBalance());
        System.out.println("Лимит кредита: " + creditAccount.getCreditLimit());
        System.out.println("Дебетовый: " + debitAccount.getAccountBalance() + "\n");
        System.out.println("-----------------------------------------------------------");

        try {
            Transaction.transfer(creditAccount, debitAccount, 584.19);
            Transaction.transfer(debitAccount, creditAccount, 580.51);
            Transaction.transfer(creditAccount, debitAccount, 521.56);
            double withdrawalAmount = 200.17;
            debitAccount.withdrawal(withdrawalAmount);
            Transaction.transfer(creditAccount, debitAccount, 500.12);
            double depositAmount = 150.39;
            debitAccount.deposit(depositAmount);
            Transaction.transfer(debitAccount, creditAccount, 201.51);
            double withdrawalAmount2 = 1500.84;
            debitAccount.withdrawal(withdrawalAmount2);
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Баланс счётов после всех операций: ");
        System.out.println("Кредитный: " + String.format("%.2f", creditAccount.getAccountBalance()));
        System.out.println("Дебетовый: " + String.format("%.2f", debitAccount.getAccountBalance()));
    }
}

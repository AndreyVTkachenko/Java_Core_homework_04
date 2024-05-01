/*
1. Создать программу управления банковским счетом (Account).

Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита и сумму снятия средств.
При этом она должна обрабатывать следующие исключительные ситуации:
Попытка создать счет с отрицательным начальным балансом должна вызывать исключение IllegalArgumentException
с соответствующим сообщением.
Попытка внести депозит с отрицательной суммой должна вызывать исключение IllegalArgumentException
с соответствующим сообщением.
Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать исключение
InsufficientFundsException с сообщением о недостаточных средствах и текущим балансом.
Продемонстрируйте работу вашего приложения:
Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения
об ошибках.

2.* Создать несколько типов счетов, унаследованных от Account, например: CreditAccount, DebitAccount.

Создать класс (Transaction), позволяющий проводить транзакции между счетами (переводить сумму с одного счета
на другой)
Класс Transaction должен возбуждать исключение в случае неудачной попытки перевести деньги с одного счета на другой.
Продемонстрируйте работу вашего приложения:
Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения
об ошибках.

Достаточно выполнить только первую задачу, вторая задача является дополнительной.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account;

        System.out.println("Вас приветствует банк 'Рога и копыта'! Благодарим Вас за выбор нашего банка");
        System.out.println("1. Создать счет с нулевым балансом");
        System.out.println("2. Создать счет с положительным балансом");
        int click = scanner.nextInt();

        switch (click) {
            case 1:
                account = new Account(0);
                System.out.println("Счет успешно создан.");
                System.out.println(account);
                break;
            case 2:
                System.out.println("Введите начальный баланс счета:");
                double initialBalance = scanner.nextDouble();
                try {
                    account = new Account(initialBalance);
                    System.out.println("Счет успешно создан.");
                    System.out.println(account);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
            default:
                System.out.println("Неверный выбор.");
                return;
        }

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Пополнить счет");
            System.out.println("2. Списать со счета");
            System.out.println("3. Выйти");

            click = scanner.nextInt();
            double amount;

            switch (click) {
                case 1:
                    System.out.println("Введите сумму для пополнения:");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    break;
                case 2:
                    System.out.println("Введите сумму для списания:");
                    amount = scanner.nextDouble();
                    try {
                        account.withdrawal(amount);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Спасибо что выбрали наш банк!");
                    return;
                default:
                    System.out.println("Неверный выбор.");
                    break;
            }
        }
    }
}

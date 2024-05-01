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
        Account account;

        System.out.println("Вас приветствует банк 'Рога и копыта'! Благодарим Вас за выбор нашего банка");
        System.out.println("1. Создать счет с нулевым балансом");
        System.out.println("2. Создать счет с положительным балансом");

        try (Scanner scanner = new Scanner(System.in)) {
            int click = Integer.parseInt(scanner.nextLine());

            switch (click) {
                case 1:
                    account = new Account(0);
                    System.out.println("Счет успешно создан.");
                    System.out.println(account);
                    break;
                case 2:
                    System.out.println("Введите начальный баланс счета:");
                    double initialBalance = Double.parseDouble(scanner.nextLine());
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
                    System.out.println("Не хотите - как хотите.");
                    return;
            }

            while (true) {
                System.out.println("Выберите действие:");
                System.out.println("1. Пополнить счет");
                System.out.println("2. Списать со счета");
                System.out.println("3. Выйти");

                int choice = Integer.parseInt(scanner.nextLine());
                double amount;

                switch (choice) {
                    case 1:
                        double depositAmount = 0;
                        do {
                            try {
                                System.out.println("Введите сумму для пополнения:");
                                depositAmount = Double.parseDouble(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректный ввод. Оперируйте цифрами.");
                            }
                        } while (true);
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        double withdrawalAmount = 0;
                        do {
                            try {
                                System.out.println("Введите сумму для списания:");
                                withdrawalAmount = Double.parseDouble(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректный ввод. Оперируйте цифрами.");
                            }
                        } while (true);
                        try {
                            account.withdrawal(withdrawalAmount);
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
        } catch (NumberFormatException e) {
            System.out.println("Не хотите - как хотите.");
        }
    }
}

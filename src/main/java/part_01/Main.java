package part_01;

import exeption.InsufficientFundsException;

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

                switch (choice) {
                    case 1:
                        double depositAmount;
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
                        double withdrawalAmount;
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

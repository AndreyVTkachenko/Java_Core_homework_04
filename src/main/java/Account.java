public class Account {

    private double accountBalance;

    private double depositAmount;

    private double withdrawalAmount;

    public Account(double accountBalance, double depositAmount, double withdrawalAmount) {
        this.accountBalance = accountBalance;
        this.depositAmount = depositAmount;
        this.withdrawalAmount = withdrawalAmount;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    @Override
    public String toString() {
        return "Параметры банковского счёта: \nначальный баланс счета: " +
                accountBalance + "\nсумма депозита: " + depositAmount +
                "\nсумма снятия средств: " + withdrawalAmount;
    }

    void deposit(double amount) {
        accountBalance += amount;
        System.out.println("Произведено пополнение счёта на сумму: " + amount);
        System.out.println("Текущий баланс счёта: " + accountBalance);
    }

    void withdrawal(double amount) {
        accountBalance -= amount;
        System.out.println("Произведено списание средств на сумму: " + amount);
        System.out.println("Текущий баланс счёта: " + accountBalance);
    }
}

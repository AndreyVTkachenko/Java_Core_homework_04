package part_02;

public class DebitAccount extends Account{

    public DebitAccount(String accountName, double initialBalance) {
        super(accountName, initialBalance);
    }

    @Override
    public String toString() {
        return "Дебетовый счет: " + accountBalance;
    }
}

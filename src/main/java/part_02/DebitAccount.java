package part_02;

public class DebitAccount extends Account{

    public DebitAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public String toString() {
        return "Дебетовый счет: " + accountBalance;
    }
}

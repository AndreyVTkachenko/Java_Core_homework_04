package perfect_solution;

public class InsufficientFundsException extends Exception {
    private double balance;

    public InsufficientFundsException(String message, double balance) {
        super(message);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}

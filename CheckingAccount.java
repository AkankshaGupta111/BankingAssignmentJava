package Banking_system;

public class CheckingAccount extends BankAccount {

    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolderName, double overdraftLimit) {
        super(accountNumber, accountHolderName);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        double newBalance = getBalance() - amount;

        if (newBalance < -overdraftLimit) {
            System.out.println("Overdraft limit exceeded. Transaction denied.");
            return;
        }

        updateBalance(-amount);

        if (newBalance < 0) {
            System.out.println("Overdraft used! Current balance: $" + newBalance);
        } else {
            System.out.println("Withdrawn $" + amount);
        }
    }

    @Override
    public String getAccountDetails() {
        return "Checking Account #" + getAccountNumber()
                + ", Balance: $" + String.format("%.2f", getBalance())
                + ", Limit: $" + overdraftLimit;
    }
}

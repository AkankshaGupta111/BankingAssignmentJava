package Banking_system;
import java.util.ArrayList;
import java.util.List;

public class BankManager {

    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        BankAccount savings = new SavingsAccount("12345", "Abhi Uranw", 0.02);
        BankAccount checking = new CheckingAccount("67890", "Rahul Sharma", 500.0);

        accounts.add(savings);
        accounts.add(checking);

        for (BankAccount account : accounts) {
            System.out.println(account.getAccountDetails());
        }

        System.out.println("\nPerforming Transactions");
        savings.deposit(200);
        checking.withdraw(100);

        if (savings instanceof SavingsAccount) {
            ((SavingsAccount) savings).applyInterest();
        }

        System.out.println("\n Final Account Details");
        for (BankAccount account : accounts) {
            System.out.println(account.getAccountDetails());
        }
    }
}

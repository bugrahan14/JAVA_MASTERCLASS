package constructors;

/**
 * Kurucular: Varsayılan, parametreli, overload, this() zinciri.
 * Gerekli parametreleri kurucuda zorunlu kılmak.
 */
public class BankAccount {

    private final String accountNumber;
    private double balance;

    /** Sadece hesap numarası; bakiye 0. */
    public BankAccount(String accountNumber) {
        this(accountNumber, 0.0);
    }

    /** Hesap numarası ve başlangıç bakiyesi. this() ile tek noktada atama. */
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

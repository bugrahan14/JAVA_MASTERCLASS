package constructors;

/**
 * Kurucu pratiği: Farklı kurucu imzaları ile nesne oluşturma.
 */
public class ConstructorsDemo {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("TR001");
        System.out.println("Hesap: " + account1.getAccountNumber() + ", Bakiye: " + account1.getBalance());

        BankAccount account2 = new BankAccount("TR002", 1000.0);
        System.out.println("Hesap: " + account2.getAccountNumber() + ", Bakiye: " + account2.getBalance());

        account1.deposit(500);
        System.out.println("TR001 yeni bakiye: " + account1.getBalance());
    }
}

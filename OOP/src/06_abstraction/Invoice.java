package abstraction;

/**
 * Birden fazla interface implement etme: Payable + Printable.
 */
public class Invoice implements Payable, Printable {

    private String description;
    private double amount;

    public Invoice(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getPaymentDescription() {
        return description;
    }

    @Override
    public String getDisplayText() {
        return description + " - " + amount + " TL";
    }
}

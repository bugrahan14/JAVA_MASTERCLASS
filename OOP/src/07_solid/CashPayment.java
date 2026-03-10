package solid;

/**
 * O - Open/Closed: Başka bir ödeme türü; mevcut sınıflar değişmez.
 */
public class CashPayment implements PaymentProcessor {

    @Override
    public boolean process(double amount) {
        return amount >= 0;
    }

    @Override
    public String getType() {
        return "Nakit";
    }
}

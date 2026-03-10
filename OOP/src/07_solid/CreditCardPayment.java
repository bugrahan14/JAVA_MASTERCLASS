package solid;

/**
 * O - Open/Closed: Yeni ödeme türü = yeni sınıf.
 */
public class CreditCardPayment implements PaymentProcessor {

    @Override
    public boolean process(double amount) {
        return amount > 0;
    }

    @Override
    public String getType() {
        return "Kredi Kartı";
    }
}

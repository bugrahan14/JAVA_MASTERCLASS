package abstraction;

/**
 * Interface: Davranış sözleşmesi; birden fazla interface implement edilebilir.
 */
public interface Payable {

    double getAmount();

    String getPaymentDescription();
}

package solid;

/**
 * O - Open/Closed: Yeni ödeme türü eklemek için bu arayüzü implement eden
 * yeni sınıf eklenir; mevcut kod değiştirilmez.
 */
public interface PaymentProcessor {

    boolean process(double amount);

    String getType();
}

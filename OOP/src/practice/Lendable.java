package practice;

/**
 * Soyutlama: Ödünç verilebilir öğe sözleşmesi.
 * Farklı türler (PhysicalBook, EBook) implement eder.
 */
public interface Lendable {

    String getItemId();

    String getDisplayTitle();

    boolean isAvailable();

    void setAvailable(boolean available);
}

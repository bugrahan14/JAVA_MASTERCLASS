package encapsulation;

/**
 * Kapsülleme: private alanlar, getter/setter, geçerlik kontrolü tek yerde.
 * Fiyat negatif olamaz.
 */
public class Product {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    /** Setter'da kontrol: fiyat negatif atanmaz. */
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }
}

package solid;

/**
 * S - Single Responsibility: Sadece sipariş verisi tutar.
 * Rapor yazma ayrı sınıfta (OrderReportWriter).
 */
public class Order {

    private final String id;
    private final double total;

    public Order(String id, double total) {
        this.id = id;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }
}

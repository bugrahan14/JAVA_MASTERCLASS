package solid;

/**
 * S - Single Responsibility: Sadece rapor yazar.
 * Veri tutmaz; Order'ı parametre alır.
 */
public class OrderReportWriter {

    public String formatAsText(Order order) {
        return "Sipariş " + order.getId() + " - Toplam: " + order.getTotal() + " TL";
    }
}

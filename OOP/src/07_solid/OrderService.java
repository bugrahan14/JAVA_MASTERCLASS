package solid;

/**
 * D - Dependency Inversion: OrderService somut NotificationService'e değil,
 * NotificationService interface'ine bağımlı. Bağımlılık enjeksiyonu ile verilir.
 */
public class OrderService {

    private final NotificationService notificationService;

    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder(Order order) {
        notificationService.send("Sipariş verildi: " + order.getId());
    }
}

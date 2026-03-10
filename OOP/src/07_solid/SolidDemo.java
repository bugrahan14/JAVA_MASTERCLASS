package solid;

/**
 * SOLID pratiği: Tüm prensiplerin mini örnekleri.
 */
public class SolidDemo {

    public static void main(String[] args) {
        // S
        Order order = new Order("SIP-1", 100.0);
        OrderReportWriter writer = new OrderReportWriter();
        System.out.println(writer.formatAsText(order));

        // O
        PaymentProcessor p1 = new CreditCardPayment();
        PaymentProcessor p2 = new CashPayment();
        System.out.println(p1.getType() + " - " + p1.process(50));
        System.out.println(p2.getType() + " - " + p2.process(50));

        // L
        Rectangle rect = new Square();
        rect.setWidth(5);
        rect.setHeight(5);
        System.out.println("Square alan: " + rect.getArea());

        // I
        Duck duck = new Duck();
        duck.fly();
        duck.swim();

        // D
        NotificationService notifier = new EmailNotificationService();
        OrderService orderService = new OrderService(notifier);
        orderService.placeOrder(order);
    }
}

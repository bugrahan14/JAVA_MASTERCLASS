package abstraction;

/**
 * Soyutlama pratiği: abstract Shape, interface Payable/Printable.
 */
public class AbstractionDemo {

    public static void main(String[] args) {
        Shape circle = new Circle("Daire", 3);
        Shape square = new Square("Kare", 4);
        System.out.println(circle.getName() + " alan: " + circle.area());
        System.out.println(square.getName() + " alan: " + square.area());

        Invoice invoice = new Invoice("Kitap alımı", 50.0);
        System.out.println(invoice.getDisplayText());
        System.out.println("Ödeme: " + invoice.getPaymentDescription() + " - " + invoice.getAmount() + " TL");
    }
}

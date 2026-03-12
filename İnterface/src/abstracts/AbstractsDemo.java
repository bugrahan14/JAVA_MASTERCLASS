package abstracts;

/**
 * Abstract class ve Template Method örnekleri.
 */
public class AbstractsDemo {

    public static void main(String[] args) {
        System.out.println("--- Shape (abstract) ---");
        Shape circle = new Circle("Daire", 3.0);
        Shape rect = new Rectangle("Dikdörtgen", 4.0, 5.0);
        System.out.println(circle.getName() + " alan: " + circle.area());
        System.out.println(rect.getName() + " alan: " + rect.area());

        System.out.println("--- Template Method (DataProcessor) ---");
        DataProcessor processor = new CsvDataProcessor();
        processor.process();
    }
}

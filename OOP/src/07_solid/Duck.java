package solid;

/**
 * I - Interface Segregation: Ördek hem uçar hem yüzer; her iki interface'i implement eder.
 */
public class Duck implements Flyable, Swimmable {

    @Override
    public void fly() {
        System.out.println("Ördek uçuyor.");
    }

    @Override
    public void swim() {
        System.out.println("Ördek yüzüyor.");
    }
}

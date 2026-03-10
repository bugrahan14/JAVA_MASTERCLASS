package inheritance;

/**
 * Kalıtım pratiği: super, override, üst/alt referans.
 */
public class InheritanceDemo {

    public static void main(String[] args) {
        Car car = new Car("Toyota", 4);
        car.accelerate(10);
        System.out.println(car.getInfo());

        Bicycle bicycle = new Bicycle("Bianchi", true);
        bicycle.accelerate(5);
        System.out.println(bicycle.getInfo());
    }
}

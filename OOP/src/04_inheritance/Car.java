package inheritance;

/**
 * Kalıtım: extends, super(), override, @Override.
 */
public class Car extends Vehicle {

    private int doorCount;

    public Car(String brand, int doorCount) {
        super(brand);
        this.doorCount = doorCount;
    }

    @Override
    public void accelerate(double amount) {
        super.accelerate(amount * 1.5);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Kapı: " + doorCount;
    }
}

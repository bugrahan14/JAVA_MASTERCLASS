package inheritance;

/**
 * Kalıtım: Üst sınıf (base). Ortak alanlar ve davranış.
 * protected: Alt sınıflar erişebilir.
 */
public class Vehicle {

    protected String brand;
    protected double speed;

    public Vehicle(String brand) {
        this.brand = brand;
        this.speed = 0;
    }

    public void accelerate(double amount) {
        speed += amount;
    }

    public String getInfo() {
        return brand + " - Hız: " + speed;
    }
}

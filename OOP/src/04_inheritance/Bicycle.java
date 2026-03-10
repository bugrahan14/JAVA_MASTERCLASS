package inheritance;

/**
 * Kalıtım: Başka bir alt sınıf; override örneği.
 */
public class Bicycle extends Vehicle {

    private boolean hasBasket;

    public Bicycle(String brand, boolean hasBasket) {
        super(brand);
        this.hasBasket = hasBasket;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Sepet: " + (hasBasket ? "Var" : "Yok");
    }
}

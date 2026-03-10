package abstraction;

/**
 * Soyutlama: Shape'den türeyen somut sınıf.
 */
public class Circle extends Shape {

    private static final double PI = 3.14159;
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }
}

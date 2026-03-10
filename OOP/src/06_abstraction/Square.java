package abstraction;

/**
 * Soyutlama: Shape'den türeyen somut sınıf.
 */
public class Square extends Shape {

    private double side;

    public Square(String name, double side) {
        super(name);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

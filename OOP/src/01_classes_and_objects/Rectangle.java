package classes_and_objects;

/**
 * Sınıf ve nesne: Alan ve metotlar.
 * Veri (en, boy) + davranış (alan, çevre hesaplama).
 */
public class Rectangle {

    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }
}

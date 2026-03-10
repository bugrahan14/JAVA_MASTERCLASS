package solid;

/**
 * L - Liskov Substitution: Üst sınıf (base) sözleşmesi.
 * Alt sınıflar bu davranışı bozmamalı.
 */
public class Rectangle {

    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

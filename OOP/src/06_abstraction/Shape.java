package abstraction;

/**
 * Soyutlama: abstract sınıf, abstract metot.
 * Alt sınıflar area() implement etmek zorunda.
 */
public abstract class Shape {

    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double area();

    public String getName() {
        return name;
    }
}

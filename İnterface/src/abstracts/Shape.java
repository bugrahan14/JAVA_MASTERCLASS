package abstracts;

/**
 * Soyut şekil: abstract metot area(); concrete getName.
 * Alt sınıflar area() implement etmek zorunda.
 */
public abstract class Shape {

    protected final String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double area();

    public String getName() {
        return name;
    }
}

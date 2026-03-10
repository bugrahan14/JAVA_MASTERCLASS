package polymorphism;

/**
 * Çok biçimlilik: Üst tip; davranış alt sınıflarda override edilir.
 */
public class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String makeSound() {
        return "...";
    }
}

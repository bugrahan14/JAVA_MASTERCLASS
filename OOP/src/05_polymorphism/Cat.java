package polymorphism;

/**
 * Çok biçimlilik: makeSound() override.
 */
public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Miyav!";
    }
}

package polymorphism;

/**
 * Çok biçimlilik: makeSound() override.
 */
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Hav hav!";
    }
}

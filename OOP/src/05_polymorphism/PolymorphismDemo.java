package polymorphism;

/**
 * Çok biçimlilik pratiği: Üst tip referansı (Animal), runtime'da alt sınıf davranışı.
 * instanceof yerine polymorphism kullanımı.
 */
public class PolymorphismDemo {

    public static void main(String[] args) {
        Animal[] animals = {
            new Dog("Karabaş"),
            new Cat("Pamuk"),
            new Dog("Çakır")
        };

        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
        }
    }
}

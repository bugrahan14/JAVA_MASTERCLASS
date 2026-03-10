package classes_and_objects;

/**
 * Sınıf ve nesne pratiği: Person ve Rectangle kullanımı.
 * Nesne oluşturma, referans, metot çağrısı.
 */
public class ClassesAndObjectsDemo {

    public static void main(String[] args) {
        // Person nesnesi
        Person person = new Person();
        person.setName("Ayşe");
        person.setAge(25);
        System.out.println(person.introduce());

        // Rectangle nesnesi
        Rectangle rect = new Rectangle();
        rect.setWidth(5.0);
        rect.setHeight(3.0);
        System.out.println("Alan: " + rect.area() + ", Çevre: " + rect.perimeter());
    }
}

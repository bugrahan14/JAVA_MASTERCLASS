package classes_and_objects;

/**
 * Sınıf ve nesne: Temel sınıf örneği.
 * Alan (field) ve metot kavramları; tek sorumluluk.
 */
public class Person {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /** Tek iş: kendini tanıt. Kısa ve anlamlı metot. */
    public String introduce() {
        return "Ben " + name + ", " + age + " yaşındayım.";
    }
}

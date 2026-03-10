package encapsulation;

/**
 * Kapsülleme pratiği: Geçersiz değerler setter'da reddedilir.
 */
public class EncapsulationDemo {

    public static void main(String[] args) {
        Product product = new Product();
        product.setName("Kitap");
        product.setPrice(29.99);
        System.out.println(product.getName() + " - " + product.getPrice() + " TL");

        product.setPrice(-5);
        System.out.println("Negatif fiyat atandıktan sonra: " + product.getPrice());

        Student student = new Student();
        student.setName("Ali");
        student.setGrade(85);
        System.out.println(student.getName() + " not: " + student.getGrade());

        student.setGrade(150);
        System.out.println("Geçersiz not atandıktan sonra: " + student.getGrade());
    }
}

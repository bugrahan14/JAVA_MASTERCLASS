package practice;

/**
 * Kütüphane mini projesi: Tüm OOP konularının bir arada kullanımı.
 * - Encapsulation: Book, Member
 * - Inheritance + Polymorphism: PhysicalBook, EBook, Lendable
 * - SOLID: Library -> LendingService (D), SimpleLendingService
 */
public class LibraryDemo {

    public static void main(String[] args) {
        LendingService lendingService = new SimpleLendingService();
        Library library = new Library(lendingService);

        PhysicalBook physicalBook = new PhysicalBook("978-0-123", "Clean Code", "Robert Martin", "A-12");
        EBook ebook = new EBook("978-0-456", "Effective Java", "Joshua Bloch", "PDF");

        library.addItem(physicalBook);
        library.addItem(ebook);

        Member member = new Member("M001", "Ayşe");
        library.registerMember(member);

        System.out.println("Ödünç veriliyor: " + physicalBook.getDisplayTitle());
        boolean lent = library.lend(physicalBook.getIsbn(), member.getMemberId());
        System.out.println("Ödünç verildi: " + lent);
        System.out.println("Müsait mi: " + physicalBook.isAvailable());

        library.returnItem(physicalBook.getIsbn());
        System.out.println("İade sonrası müsait mi: " + physicalBook.isAvailable());
    }
}

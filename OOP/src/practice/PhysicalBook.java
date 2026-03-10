package practice;

/**
 * Kalıtım + polymorphism: Book'tan türeyen, Lendable implement eden fiziksel kitap.
 */
public class PhysicalBook extends Book implements Lendable {

    private final String shelfLocation;
    private boolean available = true;

    public PhysicalBook(String isbn, String title, String author, String shelfLocation) {
        super(isbn, title, author);
        this.shelfLocation = shelfLocation;
    }

    @Override
    public String getItemId() {
        return getIsbn();
    }

    @Override
    public String getDisplayTitle() {
        return getTitle() + " (" + getAuthor() + ")";
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }
}

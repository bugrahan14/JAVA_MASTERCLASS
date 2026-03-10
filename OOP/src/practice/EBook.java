package practice;

/**
 * Kalıtım + polymorphism: Elektronik kitap; Lendable implement eder.
 */
public class EBook extends Book implements Lendable {

    private final String format;
    private boolean available = true;

    public EBook(String isbn, String title, String author, String format) {
        super(isbn, title, author);
        this.format = format;
    }

    @Override
    public String getItemId() {
        return getIsbn() + "-" + format;
    }

    @Override
    public String getDisplayTitle() {
        return getTitle() + " [e-kitap: " + format + "]";
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }
}

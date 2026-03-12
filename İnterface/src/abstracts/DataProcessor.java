package abstracts;

/**
 * Template Method: process() iskeleti; readData ve transform alt sınıflarda.
 */
public abstract class DataProcessor {

    public final void process() {
        open();
        readData();
        transform();
        close();
    }

    protected abstract void readData();

    protected abstract void transform();

    private void open() {
        System.out.println("[DataProcessor] open");
    }

    private void close() {
        System.out.println("[DataProcessor] close");
    }
}

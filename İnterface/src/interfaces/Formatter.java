package interfaces;

/**
 * Tek abstract metot: functional interface.
 * Lambda ve method reference ile kullanılır.
 */
@FunctionalInterface
public interface Formatter {

    String format(String input);
}

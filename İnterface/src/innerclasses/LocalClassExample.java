package innerclasses;

/**
 * Local class: metot içinde tanımlı; effectively final dış değişkene erişir.
 */
public class LocalClassExample {

    public static void run(int multiplier) {
        final String prefix = "Sonuç: ";

        class Multiplier {
            int apply(int value) {
                return value * multiplier;
            }

            String format(int value) {
                return prefix + apply(value);
            }
        }

        Multiplier m = new Multiplier();
        System.out.println(m.format(5));
    }
}

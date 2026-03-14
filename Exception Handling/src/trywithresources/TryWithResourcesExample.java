package trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * try-with-resources (Java 7+): AutoCloseable kaynakları otomatik kapatır.
 * Clean code: finally ve null kontrolü gerekmez; suppressed exception
 * korunur; kod daha kısa ve okunabilir.
 */
public class TryWithResourcesExample {

    /**
     * Tek kaynak: try (Resource r = ...) ile açılır, blok bitince close() otomatik çağrılır.
     */
    public static String readFirstLine(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.readLine();
        }
        // reader.close() otomatik; IOException bloktan çıkarken fırlatılabilir
    }

    /**
     * Birden fazla kaynak: virgülle ayrılır; açılma sırasına göre ters sırada kapatılır.
     */
    public static void readTwoFiles(String path1, String path2) throws IOException {
        try (BufferedReader r1 = new BufferedReader(new FileReader(path1));
             BufferedReader r2 = new BufferedReader(new FileReader(path2))) {
            System.out.println(r1.readLine());
            System.out.println(r2.readLine());
        }
    }

    /**
     * Suppressed exception: try bloğunda exception fırlarsa ve close() da
     * exception fırlatırsa, ilk exception ana, close'daki suppressed olarak eklenir.
     */
    public static void demonstrateSuppressed() {
        try (BadResource resource = new BadResource()) {
            throw new RuntimeException("try içinde hata");
        } catch (Exception e) {
            System.out.println("Yakalanan: " + e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed: " + t.getMessage());
            }
        }
    }

    /** AutoCloseable ama close() exception fırlatan basit kaynak. */
    private static class BadResource implements AutoCloseable {
        @Override
        public void close() {
            throw new RuntimeException("close() hatası");
        }
    }

    public static void main(String[] args) {
        try {
            String line = readFirstLine("README.md");
            System.out.println("İlk satır: " + (line != null ? line : "(boş)"));
        } catch (IOException e) {
            System.err.println("Dosya hatası: " + e.getMessage());
        }

        System.out.println("--- Suppressed örneği ---");
        demonstrateSuppressed();
    }
}

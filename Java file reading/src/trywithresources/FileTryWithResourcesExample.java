package trywithresources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Dosya okumada try-with-resources kullanımı.
 * Clean code: stream/reader otomatik kapatılır; suppressed exception korunur.
 */
public class FileTryWithResourcesExample {

    public static void main(String[] args) {
        Path path = Paths.get("README.md");
        try {
            String first = readFirstLine(path);
            System.out.println("İlk satır: " + (first != null ? first : "(boş)"));
            readAndPrintFirstTwoLines(path);
        } catch (IOException e) {
            System.err.println("Dosya hatası: " + e.getMessage());
        }
    }

    /**
     * Tek kaynak: try (BufferedReader ...) ile açılır; blok bitince close() otomatik.
     */
    public static String readFirstLine(Path path) throws IOException {
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            return "";
        }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(path), StandardCharsets.UTF_8))) {
            String line = reader.readLine();
            return line != null ? line : "";
        }
    }

    /**
     * Birden fazla kaynak: virgülle ayrılır; ters sırada otomatik kapatılır.
     * Bu örnekte tek dosyadan iki "sanal" reader yerine tek reader ile iki satır okuyoruz.
     */
    public static void readAndPrintFirstTwoLines(Path path) throws IOException {
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(path), StandardCharsets.UTF_8))) {
            System.out.println("Satır 1: " + (reader.readLine() != null ? "okundu" : "(yok)"));
            System.out.println("Satır 2: " + (reader.readLine() != null ? "okundu" : "(yok)"));
        }
    }
}

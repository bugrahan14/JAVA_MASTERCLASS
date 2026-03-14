package buffered;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Buffered I/O: BufferedReader ile satır satır okuma.
 * Clean code: tek sorumluluklu metodlar; boş dosyada null değil boş liste/string.
 */
public class BufferedReaderExample {

    public static void main(String[] args) {
        Path path = Paths.get("README.md");
        try {
            List<String> lines = readAllLines(path);
            System.out.println("Satır sayısı: " + lines.size());
            String first = readFirstLine(path);
            System.out.println("İlk satır: " + (first != null && !first.isEmpty() ? first : "(boş)"));
        } catch (IOException e) {
            System.err.println("Dosya hatası: " + e.getMessage());
        }
    }

    /**
     * Tüm satırları List olarak döndürür. Dosya yoksa veya boşsa boş liste (null değil).
     * Clean code: try-with-resources; anlamlı isim; küçük metod.
     */
    public static List<String> readAllLines(Path path) throws IOException {
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        }
        return result;
    }

    /**
     * İlk satırı döndürür. Dosya boşsa veya yoksa boş string (null değil).
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
}

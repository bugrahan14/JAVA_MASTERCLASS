package bestpractices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Dosya okuma için clean code örnekleri: tek sorumluluk, encoding açık,
 * null yerine boş koleksiyon, try-with-resources, anlamlı isimler.
 */
public class FileReaderCleanCode {

    private final Charset charset;

    public FileReaderCleanCode(Charset charset) {
        this.charset = charset != null ? charset : StandardCharsets.UTF_8;
    }

    public FileReaderCleanCode() {
        this(StandardCharsets.UTF_8);
    }

    /**
     * Tüm satırları okur. Dosya yok veya boşsa boş liste (null değil).
     * Clean code: tek sorumluluk; encoding parametreyle verilir.
     */
    public List<String> readAllLines(Path path) throws IOException {
        if (path == null || !Files.exists(path) || !Files.isRegularFile(path)) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(path), charset))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        }
        return result;
    }

    /**
     * İlk satırı döndürür. Yoksa boş string (null değil).
     */
    public String readFirstLine(Path path) throws IOException {
        if (path == null || !Files.exists(path) || !Files.isRegularFile(path)) {
            return "";
        }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(path), charset))) {
            String line = reader.readLine();
            return line != null ? line : "";
        }
    }

    public static void main(String[] args) {
        FileReaderCleanCode service = new FileReaderCleanCode(StandardCharsets.UTF_8);
        Path path = Paths.get("README.md");
        try {
            List<String> lines = service.readAllLines(path);
            System.out.println("Satır sayısı: " + lines.size());
            String first = service.readFirstLine(path);
            System.out.println("İlk satır (ilk 50 karakter): " + (first.length() > 50 ? first.substring(0, 50) + "..." : first));
        } catch (IOException e) {
            System.err.println("Dosya hatası: " + e.getMessage());
        }
    }
}

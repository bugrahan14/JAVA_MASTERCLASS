package scanner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Scanner ile dosya okuma: token veya satır bazlı.
 * Clean code: encoding belirtilmeli (Scanner(Path, Charset)); try-with-resources.
 */
public class ScannerFileExample {

    public static void main(String[] args) {
        Path path = Paths.get("README.md");
        try {
            List<String> lines = readAllLinesWithScanner(path);
            System.out.println("Scanner ile satır sayısı: " + lines.size());
            if (!lines.isEmpty()) {
                System.out.println("İlk satır: " + lines.get(0).substring(0, Math.min(60, lines.get(0).length())) + "...");
            }
        } catch (IOException e) {
            System.err.println("Dosya hatası: " + e.getMessage());
        }
    }

    /**
     * Scanner ile satır satır okuma. Encoding açıkça UTF-8.
     * Clean code: try-with-resources; dosya yoksa boş liste.
     */
    public static List<String> readAllLinesWithScanner(Path path) throws IOException {
        if (!java.nio.file.Files.exists(path) || !java.nio.file.Files.isRegularFile(path)) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        }
        return result;
    }
}

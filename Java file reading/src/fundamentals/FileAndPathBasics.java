package fundamentals;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Temel kavramlar: File, Path, byte vs karakter, encoding.
 * Clean code: Path (NIO) modern API; encoding açıkça belirtilir.
 */
public class FileAndPathBasics {

    public static void main(String[] args) {
        demonstrateFile();
        demonstratePath();
        demonstrateEncoding();
    }

    /** java.io.File: dosya/klasör bilgisi (var mı, boyut, yol). */
    private static void demonstrateFile() {
        System.out.println("=== java.io.File ===\n");
        File file = new File("README.md");
        System.out.println("Var mı: " + file.exists());
        System.out.println("Dosya mı: " + file.isFile());
        System.out.println("Mutlak yol: " + file.getAbsolutePath());
        if (file.exists() && file.isFile()) {
            System.out.println("Boyut (byte): " + file.length());
        }
    }

    /** java.nio.file.Path: modern yol temsili; Paths.get ile oluşturulur. */
    private static void demonstratePath() {
        System.out.println("\n=== java.nio.file.Path ===\n");
        Path path = Paths.get("README.md");
        System.out.println("Path: " + path);
        System.out.println("Dosya adı: " + path.getFileName());
        System.out.println("Var mı: " + path.toFile().exists());

        // Alt dizin + dosya birleştirme (clean: Path API kullan)
        Path nested = Paths.get("src", "fundamentals", "FileAndPathBasics.java");
        System.out.println("Birleşik yol: " + nested);
    }

    /** Encoding: metin için charset her zaman açık olmalı (UTF-8 örnek). */
    private static void demonstrateEncoding() {
        System.out.println("\n=== Encoding (Charset) ===\n");
        // Clean code: StandardCharsets.UTF_8 kullan; Türkçe karakterler güvende
        System.out.println("Önerilen metin encoding: " + StandardCharsets.UTF_8.displayName());
        System.out.println("FileReader(path) tek başına kullanıldığında JVM varsayılan encoding kullanır;");
        System.out.println("bu ortamdan ortama değişir. Bu yüzden InputStreamReader + Charset tercih edin.");
    }
}

package nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * NIO: Path, Files.readAllLines, Files.readString (Java 11+), Files.lines (Stream).
 * Clean code: Charset her zaman belirtilir; boş dosya için boş koleksiyon.
 */
public class NioFilesExample {

    public static void main(String[] args) {
        Path path = Paths.get("README.md");
        try {
            List<String> lines = readAllLines(path);
            System.out.println("readAllLines - satır sayısı: " + lines.size());

            long lineCount = countLinesWithStream(path);
            System.out.println("Files.lines - satır sayısı: " + lineCount);

            // Files.readString(path, charset) Java 11+; README'de anlatıldı
            System.out.println("readString (tüm dosyayı tek String): Java 11+ ile kullanılabilir.");
        } catch (IOException e) {
            System.err.println("Dosya hatası: " + e.getMessage());
        }
    }

    /** Tüm satırları liste olarak okur. Dosya yoksa boş liste. */
    public static List<String> readAllLines(Path path) throws IOException {
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            return Collections.emptyList();
        }
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    /** Satır sayısını Stream ile sayar; büyük dosyalarda bellek dostu. */
    public static long countLinesWithStream(Path path) throws IOException {
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            return 0;
        }
        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            return stream.count();
        }
    }

}

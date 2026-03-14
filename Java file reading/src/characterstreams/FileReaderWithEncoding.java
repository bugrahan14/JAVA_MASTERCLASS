package characterstreams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Character stream ile okuma: encoding açıkça belirtilerek.
 * Clean code: FileReader(path) yerine InputStreamReader(FileInputStream, Charset) kullanın.
 */
public class FileReaderWithEncoding {

    public static void main(String[] args) {
        Path path = Paths.get("README.md");
        try {
            String content = readFileAsString(path, StandardCharsets.UTF_8);
            System.out.println("Okunan karakter sayısı (yaklaşık): " + (content != null ? content.length() : 0));
            if (content != null && !content.isEmpty()) {
                System.out.println("İlk satır: " + content.lines().findFirst().orElse("(boş)"));
            }
        } catch (IOException e) {
            System.err.println("Dosya hatası: " + e.getMessage());
        }
    }

    /**
     * Dosyayı belirtilen charset ile tek String olarak okur.
     * Clean code: Charset parametre; try-with-resources; Reader kapatılır.
     */
    public static String readFileAsString(Path path, Charset charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (Reader reader = new InputStreamReader(new FileInputStream(path.toFile()), charset)) {
            char[] buffer = new char[4096];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, len);
            }
        }
        return sb.toString();
    }
}

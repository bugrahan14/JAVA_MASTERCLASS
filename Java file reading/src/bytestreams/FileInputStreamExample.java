package bytestreams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Byte stream ile okuma: FileInputStream.
 * Clean code: try-with-resources ile kaynak mutlaka kapatılır; binary veya ham byte okuma.
 */
public class FileInputStreamExample {

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) {
        String path = "README.md";
        try {
            byte[] all = readAllBytes(path);
            System.out.println("Okunan byte sayısı: " + (all != null ? all.length : 0));

            int firstBytes = readFirstBytes(path, 100);
            System.out.println("İlk 100 byte okundu; toplam: " + firstBytes);
        } catch (IOException e) {
            System.err.println("Dosya hatası: " + e.getMessage());
        }
    }

    /**
     * Dosyanın tüm byte'larını okur. Küçük/orta dosyalar için uygundur.
     * Clean code: try-with-resources; null yerine boş dizi dönülebilir (bu örnekte dosya yoksa exception).
     */
    public static byte[] readAllBytes(String pathString) throws IOException {
        Path path = Paths.get(pathString);
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            throw new IOException("Dosya bulunamadı veya normal dosya değil: " + pathString);
        }
        try (InputStream in = new FileInputStream(path.toFile())) {
            byte[] buf = new byte[BUFFER_SIZE];
            int len;
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            while ((len = in.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            return baos.toByteArray();
        }
    }

    /**
     * İlk n byte'ı okur; buffer kullanarak bellek dostu örnek.
     * Clean code: buffer boyutu sabit; try-with-resources.
     */
    public static int readFirstBytes(String pathString, int maxBytes) throws IOException {
        byte[] buffer = new byte[Math.min(BUFFER_SIZE, maxBytes)];
        try (InputStream in = new FileInputStream(pathString)) {
            int total = 0;
            int len;
            while (total < maxBytes && (len = in.read(buffer, 0, Math.min(buffer.length, maxBytes - total))) != -1) {
                total += len;
            }
            return total;
        }
    }
}

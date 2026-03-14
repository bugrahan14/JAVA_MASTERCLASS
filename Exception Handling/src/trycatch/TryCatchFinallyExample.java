package trycatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * try-catch-finally temel kullanımı ve clean code kuralları:
 * - Spesifik exception yakalama (IOException)
 * - Boş catch yok; en azından log veya wrap
 * - finally ile kaynak kapatma (bu senaryoda try-with-resources daha iyi; ayrı örnekte)
 */
public class TryCatchFinallyExample {

    /**
     * Dosya okuma: try-catch-finally ile. Clean: önce spesifik IOException,
     * genel Exception sadece gerekirse; finally'de kapatma ve null kontrolü.
     */
    public static String readFirstLineLegacy(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            return reader.readLine();
        } catch (IOException e) {
            // Boş catch yok: en azından log veya wrap
            throw new RuntimeException("Dosya okunamadı: " + path, e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Kapatma hatası: log veya suppress; ana exception'ı kaybetmeyin
                    System.err.println("Reader kapatılamadı: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Birden fazla catch: spesifikten genele doğru sıra.
     * FileNotFoundException IOException'ın alt sınıfı olduğu için
     * önce FileNotFoundException, sonra IOException yakalanır.
     */
    public static void demonstrateMultipleCatch(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            try {
                System.out.println(reader.readLine());
            } finally {
                reader.close();
            }
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Dosya bulunamadı: " + path);
        } catch (IOException e) {
            System.err.println("Okuma hatası: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            String line = readFirstLineLegacy("varolmayan.txt");
            System.out.println(line);
        } catch (RuntimeException e) {
            System.out.println("Beklenen hata: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Cause: " + e.getCause().getMessage());
            }
        }

        demonstrateMultipleCatch("varolmayan.txt");
    }
}

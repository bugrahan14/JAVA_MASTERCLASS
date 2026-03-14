package bestpractices;

import custom.InvalidOrderStateException;
import custom.UserNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Exception için clean code uygulamaları:
 * - Fail fast (geçersiz argüman için hemen fırlat)
 * - Do not swallow (boş catch yok; log veya wrap)
 * - Spesifik catch ve anlamlı rethrow (cause zincirini koru)
 * - Exception'ı akış kontrolü için kullanmama
 */
public class ExceptionBestPractices {

    /**
     * Fail fast: Geçersiz parametre için hemen exception fırlat; sessizce devam etme.
     */
    public static int parsePositiveNumber(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("value null veya boş olamaz");
        }
        int num = Integer.parseInt(value);
        if (num <= 0) {
            throw new IllegalArgumentException("Pozitif sayı bekleniyor, verilen: " + num);
        }
        return num;
    }

    /**
     * Do not swallow: Catch edip hiçbir şey yapma; en azından log veya wrap.
     * Kötü: catch (IOException e) { }
     * İyi: logla veya RuntimeException ile wrap edip fırlat.
     */
    public static String readFileContent(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Dosya okunamadı: " + path, e);
        }
    }

    /**
     * Catch and rethrow: Alt katmanda yakala, context ekle veya logla, sonra anlamlı exception ile tekrar fırlat.
     * Cause zincirini korumak debug'ı kolaylaştırır.
     */
    public static void loadUserOrThrow(String userId) throws UserNotFoundException {
        try {
            // Simülasyon: DB veya API çağrısı IOException / SQLException fırlatabilir
            throw new IOException("Connection refused");
        } catch (IOException e) {
            throw new UserNotFoundException("Kullanıcı yüklenemedi: " + userId, userId, e);
        }
    }

    /**
     * Exception'ı akış kontrolü için kullanma. Normal akış if/state ile yönetilsin.
     * Kötü: try { getOrder(id) } catch (NotFoundException e) { return null; }
     * İyi: Optional<Order> findOrder(id) veya boolean exists(id) kullan.
     */
    public static boolean userExists(String userId) {
        // Gerçek uygulamada repo.exists(userId) gibi bir kontrol
        return userId != null && !userId.isBlank();
    }

    /**
     * Spesifik catch: Önce IOException, genel Exception sadece en dış katmanda.
     */
    public static void demonstrateSpecificCatch(Path path) {
        try {
            Files.readString(path);
        } catch (IOException e) {
            System.err.println("IO hatası: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Domain exception kullanımı: InvalidOrderStateException ile fail fast.
     */
    public static void cancelOrder(String orderId, String currentState) {
        if (!"PENDING".equals(currentState) && !"CONFIRMED".equals(currentState)) {
            throw new InvalidOrderStateException(
                    "Sadece PENDING veya CONFIRMED sipariş iptal edilebilir",
                    orderId,
                    currentState
            );
        }
        // İptal işlemi...
    }

    public static void main(String[] args) {
        try {
            parsePositiveNumber("-5");
        } catch (IllegalArgumentException e) {
            System.out.println("Fail fast örneği: " + e.getMessage());
        }

        try {
            loadUserOrThrow("user-123");
        } catch (UserNotFoundException e) {
            System.out.println("Rethrow örneği: " + e.getMessage() + ", userId=" + e.getUserId());
            if (e.getCause() != null) {
                System.out.println("Cause: " + e.getCause().getMessage());
            }
        }

        try {
            cancelOrder("ord-1", "SHIPPED");
        } catch (InvalidOrderStateException e) {
            System.out.println("Domain exception: " + e.getMessage());
            System.out.println("orderId=" + e.getOrderId() + ", currentState=" + e.getCurrentState());
        }
    }
}

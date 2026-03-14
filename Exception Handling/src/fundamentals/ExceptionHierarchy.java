package fundamentals;

/**
 * Java exception hiyerarşisini ve Throwable / Error / Exception türlerini
 * temel düzeyde gösteren örnek. Clean code: Sadece kavramı göstermek için
 * minimal kod; gerçek uygulamada Error'ları yakalamaya çalışmayın.
 */
public class ExceptionHierarchy {

    public static void main(String[] args) {
        demonstrateThrowableHierarchy();
        demonstrateCheckedVsUnchecked();
    }

    /**
     * Throwable -> Error ve Exception ayrımı.
     * Error örnekleri (OutOfMemoryError, StackOverflowError) genelde
     * yakalanmaz; JVM veya sistem kaynaklı ciddi hatalardır.
     */
    private static void demonstrateThrowableHierarchy() {
        // Exception: uygulama mantığında ele alınabilir
        try {
            throw new IllegalArgumentException("Geçersiz argüman");
        } catch (IllegalArgumentException e) {
            System.out.println("Yakalandı: " + e.getMessage());
        }

        // RuntimeException türü - derleyici try-catch zorunlu kılmaz
        try {
            String s = null;
            int len = s.length(); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NPE yakalandı: " + e.getMessage());
        }
    }

    /**
     * Checked exception: derleyici ya try-catch ya da throws istemez.
     * Unchecked (RuntimeException): derleyici zorunlu kılmaz.
     */
    private static void demonstrateCheckedVsUnchecked() {
        // Unchecked - try-catch zorunlu değil; yakalarsak her iki örnek de çalışır
        try {
            throwUnchecked();
        } catch (IllegalArgumentException e) {
            System.out.println("Unchecked yakalandı: " + e.getMessage());
        }

        // Checked - ya yakala ya da throws ile bildir (bu metot main olduğu için yakalıyoruz)
        try {
            throwChecked();
        } catch (Exception e) {
            System.out.println("Checked yakalandı: " + e.getMessage());
        }
    }

    private static void throwUnchecked() {
        throw new IllegalArgumentException("Bu unchecked; throws yazmaya gerek yok.");
    }

    /**
     * Checked exception fırlatan metot: imzada throws gerekir veya
     * çağıran try-catch kullanmalıdır.
     */
    private static void throwChecked() throws Exception {
        throw new Exception("Bu checked; derleyici try-catch veya throws ister.");
    }
}

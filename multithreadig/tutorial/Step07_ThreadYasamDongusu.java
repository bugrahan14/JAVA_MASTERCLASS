package tutorial;

/**
 * Adım 7: Thread yaşam döngüsü.
 * <p>
 * Bu adımda öğreneceksiniz: getState() ile thread durumları — NEW, RUNNABLE,
 * BLOCKED, WAITING, TIMED_WAITING, TERMINATED. Her durumun ne anlama geldiği.
 */
public final class Step07_ThreadYasamDongusu {

    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== ADIM 7: Thread Yaşam Döngüsü ==========\n");

        // NEW: oluşturuldu, start() çağrılmadı
        Thread t = new Thread(() -> {});
        System.out.println("start() öncesi: " + t.getState() + " (NEW)");

        t.start();
        Thread.sleep(50);
        System.out.println("Çalışırken: " + t.getState() + " (RUNNABLE veya zaten TERMINATED)");
        t.join();
        System.out.println("Bittikten sonra: " + t.getState() + " (TERMINATED)\n");

        System.out.println("• Özet: NEW → start() → RUNNABLE ↔ (BLOCKED | WAITING | TIMED_WAITING) → TERMINATED");
        System.out.println("• BLOCKED: synchronized ile lock beklerken.");
        System.out.println("• WAITING: wait() ile beklerken.");
        System.out.println("• TIMED_WAITING: sleep(ms) veya wait(ms) ile.\n");
    }
}

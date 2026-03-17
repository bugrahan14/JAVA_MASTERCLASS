package tutorial;

/**
 * Adım 6: Daemon thread.
 * <p>
 * Bu adımda öğreneceksiniz: JVM, tüm "user" thread'ler bittiğinde çıkar. Daemon
 * thread'ler arka planda çalışır; JVM kapanırken bunları beklemez. setDaemon(true)
 * start() öncesinde çağrılmalıdır.
 */
public final class Step06_DaemonThread {

    private static final int USER_SLEEP_MS = 400;
    private static final int DAEMON_INTERVAL_MS = 80;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== ADIM 6: Daemon Thread ==========\n");

        System.out.println("• User thread: Normal thread; JVM hepsi bitene kadar bekler.");
        System.out.println("• Daemon thread: Arka plan; JVM çıkarken bunları beklemez (örn. GC).\n");

        Thread daemon = new Thread(() -> {
            int n = 0;
            while (true) {
                n++;
                if (n % 5 == 0) {
                    System.out.println("  [Daemon] adım: " + n);
                }
                try {
                    Thread.sleep(DAEMON_INTERVAL_MS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Daemon-Thread");
        daemon.setDaemon(true); // start() ÖNCESİNDE olmalı
        daemon.start();

        Thread user = new Thread(() -> {
            System.out.println("  [User] çalışıyor...");
            sleep(USER_SLEEP_MS);
            System.out.println("  [User] bitti.");
        }, "User-Thread");
        user.start();
        user.join();

        System.out.println("\nUser thread bitti → JVM çıkıyor; daemon da sonlanır.");
        System.out.println("• Ne zaman daemon? Arka plan işleri (log, cache temizleme) için.\n");
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

package com.multithreading.fundamentals;

/**
 * Daemon vs user thread: JVM, tüm user thread'ler bittiğinde çıkar.
 * Daemon thread'ler arka planda çalışır; JVM çıkarken otomatik sonlanır (örn. GC thread).
 * setDaemon(true) start() öncesinde çağrılmalıdır.
 */
public final class DaemonThreadDemo {

    private static final int USER_THREAD_SLEEP_MS = 500;
    private static final int DAEMON_LOOP_DELAY_MS = 100;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Daemon vs User Thread ===\n");

        Thread daemon = new Thread(DaemonThreadDemo::daemonWork, "Daemon-Thread");
        daemon.setDaemon(true);
        daemon.start();

        Thread user = new Thread(DaemonThreadDemo::userWork, "User-Thread");
        user.start();
        user.join();

        System.out.println("User thread bitti. JVM çıkıyor — daemon thread de sonlanır (tam sayı görmeyebilirsiniz).");
    }

    private static void daemonWork() {
        int count = 0;
        while (true) {
            count++;
            if (count % 10 == 0) {
                System.out.println("  [Daemon] sayacı: " + count);
            }
            sleepQuietly(DAEMON_LOOP_DELAY_MS);
        }
    }

    private static void userWork() {
        System.out.println("  [User] çalışıyor...");
        sleepQuietly(USER_THREAD_SLEEP_MS);
        System.out.println("  [User] bitti.");
    }

    private static void sleepQuietly(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

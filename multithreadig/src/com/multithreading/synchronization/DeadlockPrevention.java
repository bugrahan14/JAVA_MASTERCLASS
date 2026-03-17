package com.multithreading.synchronization;

/**
 * Deadlock önleme: Lock'ları her zaman aynı sırada al (lock ordering).
 * Örneğin önce A, sonra B — her iki thread de aynı sırayı kullanır; deadlock oluşmaz.
 */
public final class DeadlockPrevention {

    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Deadlock Önleme (Lock Ordering) ===\n");
        System.out.println("Her iki thread de önce A, sonra B alıyor.\n");

        Thread t1 = new Thread(DeadlockPrevention::acquireAThenB, "Thread-1");
        Thread t2 = new Thread(DeadlockPrevention::acquireAThenB, "Thread-2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Her iki thread de güvenle tamamlandı.");
    }

    /** Her zaman önce A, sonra B — tutarlı sıra. */
    private static void acquireAThenB() {
        synchronized (LOCK_A) {
            System.out.println(Thread.currentThread().getName() + " LOCK_A aldı.");
            sleepQuietly(30);
            synchronized (LOCK_B) {
                System.out.println(Thread.currentThread().getName() + " LOCK_B aldı.");
            }
        }
    }

    private static void sleepQuietly(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

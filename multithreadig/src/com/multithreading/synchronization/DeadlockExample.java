package com.multithreading.synchronization;

/**
 * Deadlock örneği: İki kaynak (lock A, lock B), iki thread ters sırada kilit alıyor.
 * Thread1: A sonra B | Thread2: B sonra A -> bazen her ikisi de birer lock'ta takılır, deadlock.
 */
public final class DeadlockExample {

    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Deadlock Örneği ===\n");
        System.out.println("İki thread ters sırada lock alıyor; deadlock oluşabilir.");
        System.out.println("Birkaç saniye içinde çıkmazsa deadlock'ta demektir (Ctrl+C ile çıkın).\n");

        Thread t1 = new Thread(DeadlockExample::acquireAThenB, "Thread-A-then-B");
        Thread t2 = new Thread(DeadlockExample::acquireBThenA, "Thread-B-then-A");
        t1.start();
        t2.start();
        Thread.sleep(2000);
        System.out.println("Durum - t1: " + t1.getState() + ", t2: " + t2.getState());
        t1.join(1000);
        t2.join(1000);
    }

    private static void acquireAThenB() {
        synchronized (LOCK_A) {
            System.out.println(Thread.currentThread().getName() + " LOCK_A aldı.");
            sleepQuietly(50);
            synchronized (LOCK_B) {
                System.out.println(Thread.currentThread().getName() + " LOCK_B aldı.");
            }
        }
    }

    private static void acquireBThenA() {
        synchronized (LOCK_B) {
            System.out.println(Thread.currentThread().getName() + " LOCK_B aldı.");
            sleepQuietly(50);
            synchronized (LOCK_A) {
                System.out.println(Thread.currentThread().getName() + " LOCK_A aldı.");
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

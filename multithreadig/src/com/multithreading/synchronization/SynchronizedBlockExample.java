package com.multithreading.synchronization;

/**
 * synchronized metot yerine synchronized(lock) blok kullanımı.
 * Lock nesnesi private final tutulur; dışarıdan erişilmez (clean code).
 * Sadece kritik bölge kilitlenir; metotun geri kalanı paralel çalışabilir.
 */
public final class SynchronizedBlockExample {

    private static final int ITERATIONS = 10_000;
    private static final int THREAD_COUNT = 2;

    private int value;
    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlockExample demo = new SynchronizedBlockExample();
        demo.runDemo();
    }

    private void runDemo() throws InterruptedException {
        System.out.println("=== Synchronized Blok ===\n");

        value = 0;
        Thread t1 = new Thread(this::incrementWithBlock);
        Thread t2 = new Thread(this::incrementWithBlock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Sonuç: " + value + " (beklenen: " + (THREAD_COUNT * ITERATIONS) + ")");
    }

    private void incrementWithBlock() {
        for (int i = 0; i < ITERATIONS; i++) {
            synchronized (lock) {
                value++;
            }
        }
    }
}

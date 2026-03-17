package com.multithreading.synchronization;

/**
 * Race condition örneği: İki thread paylaşılan bir sayacı artırır.
 * Senkronizasyon olmadığı için sonuç tutarsız olur (beklenen 2 * INCREMENT_PER_THREAD değil).
 */
public final class RaceConditionExample {

    private static final int INCREMENT_PER_THREAD = 50_000;
    private static final int THREAD_COUNT = 2;

    private int counter;

    public static void main(String[] args) throws InterruptedException {
        RaceConditionExample demo = new RaceConditionExample();
        demo.runDemo();
    }

    private void runDemo() throws InterruptedException {
        System.out.println("=== Race Condition Örneği ===\n");
        System.out.println("Beklenen: " + (THREAD_COUNT * INCREMENT_PER_THREAD));
        System.out.println("(Senkronizasyon yok — sonuç genelde daha küçük çıkar)\n");

        counter = 0;
        Thread t1 = new Thread(this::incrementMany);
        Thread t2 = new Thread(this::incrementMany);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Gerçek sonuç: " + counter);
    }

    private void incrementMany() {
        for (int i = 0; i < INCREMENT_PER_THREAD; i++) {
            counter++; // okuma-artır-yazma atomik değil; race condition
        }
    }
}

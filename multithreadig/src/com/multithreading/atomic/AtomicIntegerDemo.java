package com.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger: Lock-free sayaç; incrementAndGet, compareAndSet.
 * Race condition olmadan atomik artırma ve güncelleme.
 */
public final class AtomicIntegerDemo {

    private static final int THREAD_COUNT = 4;
    private static final int INCREMENT_PER_THREAD = 25_000;

    private final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo demo = new AtomicIntegerDemo();
        demo.runDemo();
    }

    private void runDemo() throws InterruptedException {
        System.out.println("=== AtomicInteger ===\n");
        System.out.println("Beklenen: " + (THREAD_COUNT * INCREMENT_PER_THREAD));

        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(this::incrementMany);
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Sonuç: " + counter.get());

        demonstrateCompareAndSet();
    }

    private void incrementMany() {
        for (int i = 0; i < INCREMENT_PER_THREAD; i++) {
            counter.incrementAndGet();
        }
    }

    private void demonstrateCompareAndSet() {
        System.out.println("\ncompareAndSet örneği:");
        counter.set(10);
        boolean updated = counter.compareAndSet(10, 20);
        System.out.println("  10 -> 20: " + updated + ", değer: " + counter.get());
        boolean failed = counter.compareAndSet(10, 30);
        System.out.println("  Tekrar 10 -> 30 (beklenen false): " + failed + ", değer: " + counter.get());
    }
}

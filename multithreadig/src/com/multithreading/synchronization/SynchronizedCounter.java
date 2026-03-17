package com.multithreading.synchronization;

/**
 * Race condition'ı synchronized metot ile düzeltme.
 * increment() ve getCount() anlamlı isimlerle; tek bir paylaşılan sayaç thread-safe hale getirilir.
 */
public final class SynchronizedCounter {

    private static final int INCREMENT_PER_THREAD = 50_000;
    private static final int THREAD_COUNT = 2;

    private int count;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter demo = new SynchronizedCounter();
        demo.runDemo();
    }

    private void runDemo() throws InterruptedException {
        System.out.println("=== Synchronized Sayaç ===\n");
        System.out.println("Beklenen: " + (THREAD_COUNT * INCREMENT_PER_THREAD));

        count = 0;
        Thread t1 = new Thread(this::incrementMany);
        Thread t2 = new Thread(this::incrementMany);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Gerçek sonuç: " + getCount());
    }

    /** Thread-safe artırma. */
    public synchronized void increment() {
        count++;
    }

    /** Thread-safe okuma. */
    public synchronized int getCount() {
        return count;
    }

    private void incrementMany() {
        for (int i = 0; i < INCREMENT_PER_THREAD; i++) {
            increment();
        }
    }
}

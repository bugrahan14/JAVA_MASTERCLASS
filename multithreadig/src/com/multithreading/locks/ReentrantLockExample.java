package com.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock: lock() / unlock(); try-finally ile kilidi her zaman bırakma.
 * synchronized'a alternatif; timeout, adil sıra (fair) gibi seçenekler sunar.
 */
public final class ReentrantLockExample {

    private static final int ITERATIONS = 10_000;
    private static final int THREAD_COUNT = 2;

    private int counter;
    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample demo = new ReentrantLockExample();
        demo.runDemo();
    }

    private void runDemo() throws InterruptedException {
        System.out.println("=== ReentrantLock ===\n");

        counter = 0;
        Thread t1 = new Thread(this::incrementMany);
        Thread t2 = new Thread(this::incrementMany);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Sonuç: " + counter + " (beklenen: " + (THREAD_COUNT * ITERATIONS) + ")");
    }

    private void incrementMany() {
        for (int i = 0; i < ITERATIONS; i++) {
            lock.lock();
            try {
                counter++;
            } finally {
                lock.unlock();
            }
        }
    }
}

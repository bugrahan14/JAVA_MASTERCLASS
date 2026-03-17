package com.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock(): Kilidi hemen alırsa true, alamazsa bloklamadan false döner.
 * tryLock(timeout, unit) ile belirli süre dener; deadlock riskini azaltmak için kullanılır.
 */
public final class TryLockExample {

    private static final Lock LOCK_1 = new ReentrantLock();
    private static final Lock LOCK_2 = new ReentrantLock();
    private static final int TIMEOUT_MS = 100;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== tryLock ile Deadlock Riski Azaltma ===\n");

        Thread t1 = new Thread(TryLockExample::workWithTryLock, "Thread-1");
        Thread t2 = new Thread(TryLockExample::workWithTryLock, "Thread-2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Her iki thread tamamlandı.");
    }

    private static void workWithTryLock() {
        int attempts = 0;
        while (true) {
            attempts++;
            if (LOCK_1.tryLock()) {
                try {
                    if (LOCK_2.tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " her iki lock'u aldı (deneme: " + attempts + ")");
                            return;
                        } finally {
                            LOCK_2.unlock();
                        }
                    }
                } finally {
                    LOCK_1.unlock();
                }
            }
            sleepQuietly(TIMEOUT_MS);
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

package com.multithreading.bestpractices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ExecutorService ve lock'ları kapatma; try-finally ile kilidi her zaman bırakma.
 */
public final class ResourceCleanup {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Kaynak Temizliği ===\n");

        demonstrateExecutorShutdown();
        demonstrateLockInFinally();
    }

    private static void demonstrateExecutorShutdown() throws InterruptedException {
        System.out.println("1) ExecutorService:");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            executor.submit(() -> System.out.println("  Görev çalıştı."));
        } finally {
            executor.shutdown();
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }
        System.out.println("  shutdown() + awaitTermination() kullanıldı.\n");
    }

    private static void demonstrateLockInFinally() {
        System.out.println("2) Lock — try/finally:");
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println("  Kritik bölge çalıştı.");
        } finally {
            lock.unlock();
        }
        System.out.println("  unlock() finally içinde — kilit her zaman bırakılır.");
    }
}

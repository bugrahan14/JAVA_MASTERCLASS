package com.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Farklı thread pool türleri: fixed, cached, single.
 * Her birinin kullanım senaryosu kısa açıklanır.
 */
public final class ThreadPoolTypes {

    private static final int FIXED_POOL_SIZE = 2;
    private static final int TASK_SLEEP_MS = 100;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Pool Türleri ===\n");

        demonstrateFixedPool();
        demonstrateCachedPool();
        demonstrateSingleThreadExecutor();
    }

    /** Sabit sayıda thread; uzun ömürlü, sınırlı iş yükü için. */
    private static void demonstrateFixedPool() throws InterruptedException {
        System.out.println("1) newFixedThreadPool(" + FIXED_POOL_SIZE + "):");
        ExecutorService executor = Executors.newFixedThreadPool(FIXED_POOL_SIZE);
        executor.submit(() -> printPoolType("fixed-1"));
        executor.submit(() -> printPoolType("fixed-2"));
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println();
    }

    /** İhtiyaca göre thread oluşturur; kısa görevler için. */
    private static void demonstrateCachedPool() throws InterruptedException {
        System.out.println("2) newCachedThreadPool(): Kısa görevler, thread sayısı esnek.");
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            final int id = i;
            executor.submit(() -> printPoolType("cached-" + id));
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println();
    }

    /** Tek thread; sıralı işlem, kuyruk garantisi. */
    private static void demonstrateSingleThreadExecutor() throws InterruptedException {
        System.out.println("3) newSingleThreadExecutor(): Tek thread, sıralı çalışma.");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> printPoolType("single"));
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println();
    }

    private static void printPoolType(String label) {
        System.out.println("  [" + label + "] " + Thread.currentThread().getName());
        sleepQuietly(TASK_SLEEP_MS);
    }

    private static void sleepQuietly(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

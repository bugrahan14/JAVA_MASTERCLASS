package com.multithreading.coordination;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch: N iş tamamlanana kadar ana thread bekler.
 * countDown() her tamamlanan işte çağrılır; await() sıfıra inene kadar bloklar.
 */
public final class CountDownLatchDemo {

    private static final int WORKER_COUNT = 3;
    private static final int WORK_MS = 300;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== CountDownLatch ===\n");

        CountDownLatch latch = new CountDownLatch(WORKER_COUNT);
        ExecutorService executor = Executors.newFixedThreadPool(WORKER_COUNT);

        for (int i = 0; i < WORKER_COUNT; i++) {
            final int workerId = i + 1;
            executor.submit(() -> doWork(workerId, latch));
        }

        System.out.println("Ana thread: Tüm işler bitene kadar bekliyor...");
        latch.await();
        System.out.println("Ana thread: Tüm işler tamamlandı.");

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
    }

    private static void doWork(int workerId, CountDownLatch latch) {
        try {
            System.out.println("  İşçi " + workerId + " başladı.");
            Thread.sleep(WORK_MS);
            System.out.println("  İşçi " + workerId + " bitti.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}

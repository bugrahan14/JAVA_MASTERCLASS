package com.multithreading.coordination;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore: Sınırlı kaynak (örn. 3 eşzamanlı bağlantı).
 * acquire() izin alır (yoksa bekler), release() bırakır.
 */
public final class SemaphoreDemo {

    private static final int PERMITS = 3;
    private static final int TASK_COUNT = 6;
    private static final int USAGE_MS = 400;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Semaphore (Sınırlı Kaynak) ===\n");
        System.out.println("En fazla " + PERMITS + " görev aynı anda kaynağı kullanacak.\n");

        Semaphore semaphore = new Semaphore(PERMITS);
        ExecutorService executor = Executors.newFixedThreadPool(TASK_COUNT);

        for (int i = 0; i < TASK_COUNT; i++) {
            final int taskId = i + 1;
            executor.submit(() -> useResource(taskId, semaphore));
        }

        executor.shutdown();
        executor.awaitTermination(15, TimeUnit.SECONDS);
        System.out.println("Tüm görevler bitti.");
    }

    private static void useResource(int taskId, Semaphore semaphore) {
        try {
            semaphore.acquire();
            System.out.println("  Görev " + taskId + " kaynağı kullanıyor.");
            Thread.sleep(USAGE_MS);
            System.out.println("  Görev " + taskId + " kaynağı bıraktı.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}

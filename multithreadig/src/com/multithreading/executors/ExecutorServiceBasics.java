package com.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorService temelleri: newFixedThreadPool(n) ile görev gönderme.
 * submit(Runnable), shutdown(), awaitTermination() kullanımı.
 */
public final class ExecutorServiceBasics {

    private static final int POOL_SIZE = 2;
    private static final int TASK_COUNT = 5;
    private static final int TASK_SLEEP_MS = 200;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== ExecutorService Temelleri ===\n");

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        for (int i = 0; i < TASK_COUNT; i++) {
            final int taskId = i + 1;
            executor.submit(() -> runTask(taskId));
        }

        System.out.println("Tüm görevler gönderildi. shutdown() çağrılıyor...");
        executor.shutdown();

        boolean finished = executor.awaitTermination(10, TimeUnit.SECONDS);
        if (finished) {
            System.out.println("Tüm görevler tamamlandı.");
        } else {
            System.out.println("Timeout: Bazı görevler hala çalışıyor.");
        }
    }

    private static void runTask(int taskId) {
        String name = Thread.currentThread().getName();
        System.out.println("  Görev " + taskId + " başladı [" + name + "]");
        sleepQuietly(TASK_SLEEP_MS);
        System.out.println("  Görev " + taskId + " bitti [" + name + "]");
    }

    private static void sleepQuietly(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

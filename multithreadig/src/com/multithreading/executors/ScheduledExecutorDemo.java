package com.multithreading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Zamanlanmış görevler: schedule (tek sefer), scheduleAtFixedRate (periyodik).
 */
public final class ScheduledExecutorDemo {

    private static final int INITIAL_DELAY_SEC = 1;
    private static final int PERIOD_SEC = 2;
    private static final int DEMO_DURATION_SEC = 6;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== ScheduledExecutorService ===\n");

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        System.out.println("Tek seferlik görev 1 sn sonra:");
        scheduler.schedule(
            () -> System.out.println("  [Tek sefer] çalıştı."),
            INITIAL_DELAY_SEC,
            TimeUnit.SECONDS
        );

        System.out.println("Periyodik görev her " + PERIOD_SEC + " sn:");
        scheduler.scheduleAtFixedRate(
            () -> System.out.println("  [Periyodik] " + System.currentTimeMillis()),
            INITIAL_DELAY_SEC,
            PERIOD_SEC,
            TimeUnit.SECONDS
        );

        Thread.sleep(DEMO_DURATION_SEC * 1000L);
        scheduler.shutdown();
        scheduler.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("\nScheduler kapatıldı.");
    }
}

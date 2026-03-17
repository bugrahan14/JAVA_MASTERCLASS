package com.multithreading.coordination;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier: N thread belirli bir noktada buluşur; hepsi gelince bariyer açılır.
 * Tekrar kullanılabilir (cyclic). Ortak bir aşamaya senkronize etmek için.
 */
public final class CyclicBarrierDemo {

    private static final int PARTY_SIZE = 3;
    private static final int PHASES = 2;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== CyclicBarrier ===\n");

        CyclicBarrier barrier = new CyclicBarrier(PARTY_SIZE, () -> System.out.println("  >>> Bariyer açıldı.\n"));

        ExecutorService executor = Executors.newFixedThreadPool(PARTY_SIZE);
        for (int i = 0; i < PARTY_SIZE; i++) {
            final int id = i + 1;
            executor.submit(() -> runPhases(id, barrier));
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    private static void runPhases(int id, CyclicBarrier barrier) {
        try {
            for (int phase = 1; phase <= PHASES; phase++) {
                System.out.println("Thread " + id + " faz " + phase + " başladı.");
                Thread.sleep(100L * id);
                System.out.println("Thread " + id + " bariyere geldi.");
                barrier.await();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

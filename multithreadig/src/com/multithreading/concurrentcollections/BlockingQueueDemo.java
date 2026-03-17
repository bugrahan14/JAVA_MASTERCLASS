package com.multithreading.concurrentcollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * LinkedBlockingQueue ile producer-consumer: put() dolu kuyrukta bloklar,
 * take() boş kuyrukta bloklar. Thread-safe kuyruk.
 */
public final class BlockingQueueDemo {

    private static final int CAPACITY = 3;
    private static final int ITEMS_TO_PRODUCE = 6;
    private static final int CONSUMER_DELAY_MS = 150;
    private static final int PRODUCER_DELAY_MS = 80;
    /** Poison pill: consumer bunu görünce döngüden çıkar. */
    private static final int POISON_PILL = -1;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== BlockingQueue (Producer-Consumer) ===\n");

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(CAPACITY);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> producer(queue));
        executor.submit(() -> consumer(queue));

        executor.shutdown();
        executor.awaitTermination(15, TimeUnit.SECONDS);
        System.out.println("Bitti.");
    }

    private static void producer(BlockingQueue<Integer> queue) {
        try {
            for (int i = 0; i < ITEMS_TO_PRODUCE; i++) {
                queue.put(i);
                System.out.println("  Üretildi: " + i + " (kuyruk: " + queue.size() + ")");
                Thread.sleep(PRODUCER_DELAY_MS);
            }
            queue.put(POISON_PILL);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void consumer(BlockingQueue<Integer> queue) {
        try {
            while (true) {
                Integer item = queue.take();
                if (item == POISON_PILL) {
                    break;
                }
                System.out.println("  Tüketildi: " + item);
                Thread.sleep(CONSUMER_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

package com.multithreading.concurrentcollections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CopyOnWriteArrayList: Okuma ağırlıklı senaryoda thread-safe liste.
 * Yazma sırasında kopya alınır; okumalar bloklanmaz. Az yazma çok okuma için uygundur.
 */
public final class CopyOnWriteArrayListDemo {

    private static final int READER_COUNT = 3;
    private static final int WRITER_COUNT = 1;
    private static final int ITERATIONS = 5;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== CopyOnWriteArrayList ===\n");

        List<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");

        ExecutorService executor = Executors.newFixedThreadPool(READER_COUNT + WRITER_COUNT);

        for (int i = 0; i < READER_COUNT; i++) {
            final int readerId = i;
            executor.submit(() -> readLoop(list, readerId));
        }
        for (int i = 0; i < WRITER_COUNT; i++) {
            executor.submit(() -> writeLoop(list));
        }

        Thread.sleep(2000);
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("Son liste: " + list);
    }

    private static void readLoop(List<String> list, int readerId) {
        for (int i = 0; i < ITERATIONS; i++) {
            for (String s : list) {
                System.out.println("  Okuyucu-" + readerId + " gördü: " + s);
            }
            sleepQuietly(50);
        }
    }

    private static void writeLoop(List<String> list) {
        for (int i = 0; i < ITERATIONS; i++) {
            list.add("C" + i);
            sleepQuietly(100);
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

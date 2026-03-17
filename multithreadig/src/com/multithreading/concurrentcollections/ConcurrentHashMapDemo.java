package com.multithreading.concurrentcollections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ConcurrentHashMap: Thread-safe map; atomic computeIfAbsent, putIfAbsent vb.
 * Segment tabanlı eşzamanlılık; okuma bloklamaz.
 */
public final class ConcurrentHashMapDemo {

    private static final int THREAD_COUNT = 4;
    private static final int ENTRIES_PER_THREAD = 100;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== ConcurrentHashMap ===\n");

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int t = 0; t < THREAD_COUNT; t++) {
            final int threadId = t;
            executor.submit(() -> addEntries(map, threadId));
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Toplam entry: " + map.size());

        // computeIfAbsent: yoksa hesapla ve ekle (atomik)
        map.computeIfAbsent("default", k -> 0);
        System.out.println("computeIfAbsent örneği: default = " + map.get("default"));
    }

    private static void addEntries(ConcurrentHashMap<String, Integer> map, int threadId) {
        for (int i = 0; i < ENTRIES_PER_THREAD; i++) {
            String key = "thread-" + threadId + "-" + i;
            map.put(key, threadId * ENTRIES_PER_THREAD + i);
        }
    }
}

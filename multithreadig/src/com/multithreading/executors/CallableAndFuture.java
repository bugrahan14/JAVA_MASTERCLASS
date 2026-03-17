package com.multithreading.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Callable ve Future: Sonuç dönen asenkron iş.
 * Callable<T> -> Future.get() ile sonucu alırız; get(timeout) ile zaman aşımı.
 */
public final class CallableAndFuture {

    private static final int COMPUTATION_MS = 500;
    private static final int TIMEOUT_MS = 2000;

    public static void main(String[] args) {
        System.out.println("=== Callable ve Future ===\n");

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> future = executor.submit(new ComputeTask());
            System.out.println("Görev gönderildi, sonuç bekleniyor...");

            Integer result = future.get(TIMEOUT_MS, TimeUnit.MILLISECONDS);
            System.out.println("Sonuç: " + result);
        } catch (TimeoutException e) {
            System.out.println("Zaman aşımı: görev " + TIMEOUT_MS + " ms içinde bitmedi.");
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    private static final class ComputeTask implements Callable<Integer> {
        @Override
        public Integer call() throws InterruptedException {
            Thread.sleep(COMPUTATION_MS);
            return 42;
        }
    }
}

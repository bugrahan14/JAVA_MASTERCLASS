package com.multithreading.coordination;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Klasik producer-consumer: wait() / notifyAll() ve koşul döngüsü (while (!condition) wait()).
 * Paylaşılan kuyruk; producer doluysa bekler, consumer boşsa bekler.
 */
public final class WaitNotifyDemo {

    private static final int CAPACITY = 2;
    private static final int ITEMS_TO_PRODUCE = 5;
    private static final int PRODUCER_DELAY_MS = 100;
    private static final int CONSUMER_DELAY_MS = 200;

    private final Queue<Integer> queue = new LinkedList<>();
    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyDemo demo = new WaitNotifyDemo();
        demo.runDemo();
    }

    private void runDemo() throws InterruptedException {
        System.out.println("=== wait() / notifyAll() Producer-Consumer ===\n");

        Thread producer = new Thread(this::produce);
        Thread consumer = new Thread(this::consume);
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("Bitti.");
    }

    private void produce() {
        try {
            for (int i = 0; i < ITEMS_TO_PRODUCE; i++) {
                synchronized (lock) {
                    while (queue.size() >= CAPACITY) {
                        lock.wait();
                    }
                    queue.add(i);
                    System.out.println("  Üretildi: " + i);
                    lock.notifyAll();
                }
                Thread.sleep(PRODUCER_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void consume() {
        try {
            for (int i = 0; i < ITEMS_TO_PRODUCE; i++) {
                synchronized (lock) {
                    while (queue.isEmpty()) {
                        lock.wait();
                    }
                    int item = queue.poll();
                    System.out.println("  Tüketildi: " + item);
                    lock.notifyAll();
                }
                Thread.sleep(CONSUMER_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

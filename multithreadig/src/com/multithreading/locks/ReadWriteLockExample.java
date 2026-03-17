package com.multithreading.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock: Çok okuyucu, tek yazıcı. Okuma kilidi paylaşılır, yazma kilidi tektir.
 * Okuma ağırlıklı senaryoda throughput artar.
 */
public final class ReadWriteLockExample {

    private static final int READER_COUNT = 4;
    private static final int READS_PER_READER = 100;
    private static final int WRITES = 3;

    private String data = "başlangıç";
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample demo = new ReadWriteLockExample();
        demo.runDemo();
    }

    private void runDemo() throws InterruptedException {
        System.out.println("=== ReadWriteLock ===\n");

        Thread[] readers = new Thread[READER_COUNT];
        for (int i = 0; i < READER_COUNT; i++) {
            readers[i] = new Thread(this::readLoop);
            readers[i].start();
        }

        Thread writer = new Thread(this::writeLoop);
        writer.start();
        writer.join();

        for (Thread t : readers) {
            t.join();
        }

        System.out.println("Son değer: " + getData());
    }

    private void readLoop() {
        for (int i = 0; i < READS_PER_READER; i++) {
            String value = getData();
            if (i % 50 == 0) {
                System.out.println("  Okuyucu gördü: " + value);
            }
        }
    }

    private String getData() {
        rwLock.readLock().lock();
        try {
            return data;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    private void writeLoop() {
        for (int i = 0; i < WRITES; i++) {
            rwLock.writeLock().lock();
            try {
                data = "güncel-" + i;
                System.out.println("  Yazıldı: " + data);
            } finally {
                rwLock.writeLock().unlock();
            }
            sleepQuietly(50);
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

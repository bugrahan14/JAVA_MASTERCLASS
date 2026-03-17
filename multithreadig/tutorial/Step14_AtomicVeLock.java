package tutorial;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Adım 14: Atomic ve Lock.
 * <p>
 * Bu adımda öğreneceksiniz: AtomicInteger — lock kullanmadan atomik artırma (incrementAndGet).
 * ReentrantLock — synchronized'a alternatif; tryLock, timeout, try-finally ile unlock.
 */
public final class Step14_AtomicVeLock {

    private static final int TEKRAR = 20_000;
    private static final int THREAD_SAYISI = 2;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== ADIM 14: Atomic ve Lock ==========\n");

        // Atomic: lock-free sayaç
        AtomicInteger atomikSayac = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < TEKRAR; i++) {
                atomikSayac.incrementAndGet();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < TEKRAR; i++) {
                atomikSayac.incrementAndGet();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("AtomicInteger sonuç: " + atomikSayac.get() + " (beklenen: " + (2 * TEKRAR) + ")");

        // ReentrantLock: lock/unlock, finally'de unlock
        Lock kilit = new ReentrantLock();
        int[] paylasilan = { 0 };
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < TEKRAR; i++) {
                kilit.lock();
                try {
                    paylasilan[0]++;
                } finally {
                    kilit.unlock();
                }
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < TEKRAR; i++) {
                kilit.lock();
                try {
                    paylasilan[0]++;
                } finally {
                    kilit.unlock();
                }
            }
        });
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("ReentrantLock sonuç: " + paylasilan[0]);

        System.out.println("\n• Atomic*: Tek değişken üzerinde atomik işlem; lock yok.");
        System.out.println("• ReentrantLock: lock()/unlock(); try-finally ile mutlaka unlock.\n");
    }
}

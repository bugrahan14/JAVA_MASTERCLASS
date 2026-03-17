package tutorial;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Adım 13: Concurrent collections.
 * <p>
 * Bu adımda öğreneceksiniz: Paylaşılan HashMap birden fazla thread'den yazılırsa
 * güvenli değildir. ConcurrentHashMap thread-safe'tir; atomic işlemler (put, computeIfAbsent)
 * sunar. BlockingQueue da producer-consumer için kullanılır.
 */
public final class Step13_ConcurrentCollections {

    private static final int THREAD_SAYISI = 3;
    private static final int ELEMAN_PER_THREAD = 20;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== ADIM 13: Concurrent Collections ==========\n");

        System.out.println("• HashMap birden fazla thread'den yazılırsa tutarsızlık/Exception riski.");
        System.out.println("• ConcurrentHashMap: thread-safe; okuma/yazma eşzamanlı.\n");

        ConcurrentHashMap<String, Integer> harita = new ConcurrentHashMap<>();
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_SAYISI);

        for (int t = 0; t < THREAD_SAYISI; t++) {
            final int threadNo = t;
            pool.submit(() -> {
                for (int i = 0; i < ELEMAN_PER_THREAD; i++) {
                    harita.put("t" + threadNo + "-" + i, threadNo * 100 + i);
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Toplam entry: " + harita.size());
        System.out.println("\n• BlockingQueue: put/take bloklar; producer-consumer için.");
        System.out.println("• CopyOnWriteArrayList: okuma ağırlıklı liste için thread-safe.\n");
    }
}

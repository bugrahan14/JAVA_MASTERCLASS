package tutorial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Adım 12: ExecutorService — thread pool.
 * <p>
 * Bu adımda öğreneceksiniz: Thread'i elle new Thread() ile oluşturmak yerine
 * bir "pool" kullanmak. Görevleri submit ederiz; pool thread'leri yönetir.
 * shutdown() ve awaitTermination() ile düzgün kapatma.
 */
public final class Step12_ExecutorService {

    private static final int POOL_BOYUTU = 2;
    private static final int GOREV_SAYISI = 4;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== ADIM 12: ExecutorService ==========\n");

        System.out.println("• Thread pool: Sabit sayıda thread; görevler kuyruğa girer, thread'ler alır.");
        System.out.println("• Avantaj: Thread oluşturma/yok etme maliyeti yok; kaynak sınırı.\n");

        ExecutorService pool = Executors.newFixedThreadPool(POOL_BOYUTU);

        for (int i = 0; i < GOREV_SAYISI; i++) {
            final int no = i + 1;
            pool.submit(() -> {
                System.out.println("  Görev " + no + " [" + Thread.currentThread().getName() + "]");
                sleep(100);
            });
        }

        pool.shutdown(); // yeni görev kabul etme
        boolean bitti = pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println(bitti ? "Tüm görevler bitti." : "Timeout.");

        System.out.println("\n• submit(Runnable) — görevi kuyruğa atar.");
        System.out.println("• shutdown() + awaitTermination() — düzgün kapatma.\n");
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

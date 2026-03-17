package tutorial;

/**
 * Adım 4: Runnable kullanımı ve neden tercih edilir.
 * <p>
 * Bu adımda öğreneceksiniz: Thread oluşturmanın iki yolu — Thread alt sınıfı veya
 * Runnable. Runnable tercih edilir: composition over inheritance, tek sorumluluk,
 * aynı görevi birden fazla thread'e verebilme veya ExecutorService ile kullanım.
 */
public final class Step04_RunnableKullanimi {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== ADIM 4: Runnable Kullanımı ==========\n");

        // Görevi bir kez tanımla; birden fazla thread bu görevi çalıştırabilir.
        Runnable gorev = () -> {
            String ad = Thread.currentThread().getName();
            System.out.println("  Çalışan: " + ad);
        };

        // Aynı Runnable'ı iki farklı thread'e veriyoruz.
        Thread t1 = new Thread(gorev, "Thread-A");
        Thread t2 = new Thread(gorev, "Thread-B");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("\n• Neden Runnable?");
        System.out.println("  - Thread sınıfını extend etmek yerine 'görevi' ayrı tutuyoruz (composition).");
        System.out.println("  - Aynı görev farklı thread'lerde veya ExecutorService'te kullanılabilir.");
        System.out.println("  - Tek sorumluluk: Runnable sadece 'ne yapılacak', Thread 'nasıl çalıştırılacak'.\n");
    }
}

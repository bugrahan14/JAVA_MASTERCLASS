package tutorial;

/**
 * Adım 10: synchronized(lock) blok.
 * <p>
 * Bu adımda öğreneceksiniz: Tüm metot yerine sadece kritik bölgeyi kilitlemek için
 * synchronized(lock) kullanırız. Lock nesnesi private final tutulur; dışarıdan
 * erişilmez (clean code). Böylece sadece gerekli kısım kilitlenir.
 */
public final class Step10_SynchronizedBlok {

    private static final int TEKRAR = 10_000;
    private static final int THREAD_SAYISI = 2;

    private int deger;
    private final Object kilit = new Object();

    public static void main(String[] args) throws InterruptedException {
        Step10_SynchronizedBlok adim = new Step10_SynchronizedBlok();
        adim.calistir();
    }

    private void calistir() throws InterruptedException {
        System.out.println("========== ADIM 10: synchronized Blok ==========\n");

        deger = 0;
        Thread t1 = new Thread(this::artirBlokla);
        Thread t2 = new Thread(this::artirBlokla);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Sonuç: " + deger + " (beklenen: " + (THREAD_SAYISI * TEKRAR) + ")");
        System.out.println("\n• synchronized(kilit) { ... } — sadece bu blok kilitlenir.");
        System.out.println("• kilit = private final Object; amacı sadece kilitleme, başka işe yaramaz.");
        System.out.println("• Metodun geri kalanı paralel çalışabilir; daha ince taneli kontrol.\n");
    }

    private void artirBlokla() {
        for (int i = 0; i < TEKRAR; i++) {
            synchronized (kilit) {
                deger++;
            }
        }
    }
}

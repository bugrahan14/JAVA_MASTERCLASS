package tutorial;

/**
 * Adım 8: Paylaşılan veri ve race condition.
 * <p>
 * Bu adımda öğreneceksiniz: İki thread aynı sayacı artırırsa sonuç neden yanlış
 * çıkabilir? Okuma-artır-yazma atomik değildir; araya başka thread girebilir (race condition).
 */
public final class Step08_PaylasilanVeriVeSorun {

    private static final int ARTTIRMA_SAYISI = 50_000;
    private static final int THREAD_SAYISI = 2;

    private int sayac; // paylaşılan; senkronizasyon YOK

    public static void main(String[] args) throws InterruptedException {
        Step08_PaylasilanVeriVeSorun adim = new Step08_PaylasilanVeriVeSorun();
        adim.calistir();
    }

    private void calistir() throws InterruptedException {
        System.out.println("========== ADIM 8: Paylaşılan Veri ve Sorun ==========\n");

        System.out.println("İki thread aynı sayacı " + ARTTIRMA_SAYISI + " kez artıracak.");
        System.out.println("Beklenen toplam: " + (THREAD_SAYISI * ARTTIRMA_SAYISI) + "\n");

        sayac = 0;
        Thread t1 = new Thread(this::artirCok);
        Thread t2 = new Thread(this::artirCok);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Gerçek sonuç: " + sayac);
        System.out.println("\n• Neden eksik? counter++ üç adım: oku → artır → yaz. Araya başka thread girebilir (race condition).");
        System.out.println("• Çözüm: Kritik bölgeyi senkronize etmek (sonraki adım).\n");
    }

    private void artirCok() {
        for (int i = 0; i < ARTTIRMA_SAYISI; i++) {
            sayac++; // atomik değil!
        }
    }
}

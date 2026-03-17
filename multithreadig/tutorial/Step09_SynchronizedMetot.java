package tutorial;

/**
 * Adım 9: synchronized metot ile düzeltme.
 * <p>
 * Bu adımda öğreneceksiniz: Aynı sayacı artırma işini synchronized metot içinde
 * yaparsak aynı anda sadece bir thread o metodu çalıştırır; race condition ortadan kalkar.
 */
public final class Step09_SynchronizedMetot {

    private static final int ARTTIRMA_SAYISI = 50_000;
    private static final int THREAD_SAYISI = 2;

    private int sayac;

    public static void main(String[] args) throws InterruptedException {
        Step09_SynchronizedMetot adim = new Step09_SynchronizedMetot();
        adim.calistir();
    }

    private void calistir() throws InterruptedException {
        System.out.println("========== ADIM 9: synchronized Metot ==========\n");

        System.out.println("Beklenen: " + (THREAD_SAYISI * ARTTIRMA_SAYISI));

        sayac = 0;
        Thread t1 = new Thread(this::artirCok);
        Thread t2 = new Thread(this::artirCok);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Gerçek sonuç: " + sayac);
        System.out.println("\n• synchronized: Aynı anda sadece bir thread bu metodu çalıştırabilir.");
        System.out.println("• Kilidi 'this' (bu nesne) üzerinden alır. Tutarlı sonuç garanti.\n");
    }

    private synchronized void artir() {
        sayac++;
    }

    private void artirCok() {
        for (int i = 0; i < ARTTIRMA_SAYISI; i++) {
            artir();
        }
    }
}

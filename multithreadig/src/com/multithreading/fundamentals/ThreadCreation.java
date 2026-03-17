package com.multithreading.fundamentals;

/**
 * Thread oluşturmanın iki yolu: Thread alt sınıfı vs Runnable implementasyonu.
 * <p>
 * Tercih: Runnable kullanmak (composition over inheritance). Görev ile thread ayrılır;
 * tek sorumluluk; aynı Runnable birden fazla thread'e verilebilir veya ExecutorService ile çalıştırılabilir.
 */
public final class ThreadCreation {

    private static final int SLEEP_MS = 100;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Oluşturma Yöntemleri ===\n");

        demonstrateSubclassApproach();
        demonstrateRunnableApproach();

        System.out.println("\nRunnable tercih sebebi: composition, tek sorumluluk, ExecutorService uyumu.");
    }

    /** Thread sınıfını extend eden iç sınıf — miras yolu (genelde tercih edilmez). */
    private static void demonstrateSubclassApproach() throws InterruptedException {
        System.out.println("1) Thread alt sınıfı (inheritance):");
        Thread subclassThread = new WorkerThread();
        subclassThread.start();
        subclassThread.join();
    }

    /** Runnable kullanımı — composition, daha esnek. */
    private static void demonstrateRunnableApproach() throws InterruptedException {
        System.out.println("2) Runnable implementasyonu (composition):");
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("  Runnable çalışıyor: " + name);
            sleepQuietly(SLEEP_MS);
        };
        Thread runnableThread = new Thread(task, "Runnable-Thread");
        runnableThread.start();
        runnableThread.join();
    }

    private static void sleepQuietly(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /** Örnek: Thread sınıfından türetme (sadece demo amaçlı). */
    private static final class WorkerThread extends Thread {
        @Override
        public void run() {
            System.out.println("  WorkerThread çalışıyor: " + getName());
            sleepQuietly(SLEEP_MS);
        }
    }
}

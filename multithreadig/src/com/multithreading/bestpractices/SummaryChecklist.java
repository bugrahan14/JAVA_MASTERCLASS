package com.multithreading.bestpractices;

/**
 * Kısa özet: Ne zaman synchronized, volatile, ExecutorService, concurrent collection?
 */
public final class SummaryChecklist {

    public static void main(String[] args) {
        printChecklist();
    }

    private static void printChecklist() {
        System.out.println("=== Ne Zaman Hangi Araç? ===\n");

        System.out.println("synchronized / ReentrantLock:");
        System.out.println("  - Birden fazla thread aynı veriyi okuyup yazıyorsa (kritik bölge).");
        System.out.println("  - Compound işlem (okuma-artır-yazma) atomik olmalı.\n");

        System.out.println("volatile:");
        System.out.println("  - Tek bir flag/boolean görünürlüğü (happens-before).");
        System.out.println("  - Sayaç artırma için YETERLİ DEĞİL (atomic değil).\n");

        System.out.println("ExecutorService:");
        System.out.println("  - Görev kuyruğu, thread sayısı sınırı, yaşam döngüsü yönetimi.");
        System.out.println("  - new Thread() yerine pool kullanın (kaynak kontrolü).\n");

        System.out.println("Concurrent collection (ConcurrentHashMap, BlockingQueue):");
        System.out.println("  - Paylaşılan map/kuyruk thread-safe olmalı.");
        System.out.println("  - Collections.synchronizedMap yerine ConcurrentHashMap tercih edin.\n");

        System.out.println("Atomic (AtomicInteger, AtomicReference):");
        System.out.println("  - Tek değişken üzerinde lock-free atomik işlem.");
        System.out.println("  - Sayaç, state geçişi için uygun.\n");

        System.out.println("CountDownLatch / CyclicBarrier / Semaphore:");
        System.out.println("  - N iş bitene kadar bekle: CountDownLatch");
        System.out.println("  - N thread aynı noktada buluşsun: CyclicBarrier");
        System.out.println("  - Sınırlı kaynak (N izin): Semaphore");
    }
}

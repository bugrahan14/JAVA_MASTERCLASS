package com.multithreading.bestpractices;

/**
 * Mümkünse paylaşımsız tasarım; paylaşım gerekirse doğru araç:
 * synchronized, concurrent collection, atomic. Immutability tercih edin.
 */
public final class AvoidingSharedMutableState {

    public static void main(String[] args) {
        printGuidelines();
    }

    private static void printGuidelines() {
        System.out.println("=== Paylaşılan Değişebilir Durumdan Kaçınma ===\n");

        System.out.println("1) PAYLAŞIMI AZALTIN:");
        System.out.println("   - Thread-local: ThreadLocal<SimpleDateFormat>");
        System.out.println("   - Her thread kendi verisiyle çalışsın, sonuçları birleştirin.\n");

        System.out.println("2) DEĞİŞMEZ (IMMUTABLE) VERİ:");
        System.out.println("   - Paylaşılan nesneleri immutable yapın; senkronizasyon gerekmez.");
        System.out.println("   - final alanlar, setter yok, referans paylaşımı güvenli.\n");

        System.out.println("3) PAYLAŞIM GEREKİYORSA DOĞRU ARAÇ:");
        System.out.println("   - Basit sayaç/flag: AtomicInteger, volatile");
        System.out.println("   - Koleksiyon: ConcurrentHashMap, BlockingQueue");
        System.out.println("   - Kritik bölge: synchronized veya ReentrantLock\n");

        System.out.println("4) KRİTİK BÖLGEYİ KÜÇÜK TUTUN:");
        System.out.println("   - Lock içinde minimum iş; uzun I/O veya hesaplama dışarıda.");
    }
}

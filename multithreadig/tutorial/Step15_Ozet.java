package tutorial;

/**
 * Adım 15: Özet — Multithreading 0'dan ne öğrendik?
 * <p>
 * Thread → Runnable → paylaşım → synchronized/volatile/atomic → ExecutorService →
 * concurrent collections. Maddeler halinde hatırlatma.
 */
public final class Step15_Ozet {

    public static void main(String[] args) {
        System.out.println("========== ADIM 15: Özet ==========\n");

        System.out.println("1. Process ve Thread");
        System.out.println("   - Process: bağımsız program örneği. Thread: process içinde yürütme birimi.");
        System.out.println("   - Aynı process'teki thread'ler heap paylaşır, stack ayrı.\n");

        System.out.println("2. Thread oluşturma");
        System.out.println("   - new Thread(Runnable).start(); run() değil start() çağrılmalı.");
        System.out.println("   - Runnable tercih edin (composition, ExecutorService uyumu).\n");

        System.out.println("3. Main ve Daemon");
        System.out.println("   - main() = main thread. Daemon = JVM çıkarken beklenmez.\n");

        System.out.println("4. Paylaşılan veri");
        System.out.println("   - İki thread aynı veriyi yazarsa race condition.");
        System.out.println("   - synchronized (metot veya blok) ile kritik bölge korunur.\n");

        System.out.println("5. Görünürlük");
        System.out.println("   - volatile: tek flag/değişken için yazma-okuma görünür.\n");

        System.out.println("6. ExecutorService");
        System.out.println("   - Thread pool; submit(), shutdown(), awaitTermination().\n");

        System.out.println("7. Concurrent collections ve Atomic");
        System.out.println("   - ConcurrentHashMap, BlockingQueue; AtomicInteger vb. lock-free seçenekler.\n");

        System.out.println("--- Tutorial tamamlandı. Diğer paketlerdeki demo sınıflarıyla pratik yapabilirsiniz. ---\n");
    }
}

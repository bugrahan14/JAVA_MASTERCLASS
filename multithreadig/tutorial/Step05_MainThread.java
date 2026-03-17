package tutorial;

/**
 * Adım 5: Main thread.
 * <p>
 * Bu adımda öğreneceksiniz: main() metodunun çalıştığı thread "main" thread'dir.
 * Thread.currentThread() ile hangi thread'de olduğumuzu öğreniriz; getName(), getId() vb.
 */
public final class Step05_MainThread {

    public static void main(String[] args) {
        System.out.println("========== ADIM 5: Main Thread ==========\n");

        Thread suAnki = Thread.currentThread();
        System.out.println("Şu an çalışan thread: " + suAnki.getName());
        System.out.println("  ID: " + suAnki.getId());
        System.out.println("  Öncelik: " + suAnki.getPriority());

        System.out.println("\n• main() her zaman 'main' adlı thread'de çalışır.");
        System.out.println("• Thread.currentThread() — hangi thread'deysek onu döner.");
        System.out.println("• Yeni thread'ler oluşturduğunuzda main thread ile birlikte çalışırlar.\n");
    }
}

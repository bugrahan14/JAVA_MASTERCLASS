package tutorial;

/**
 * Adım 3: İlk thread'inizi oluşturmak.
 * <p>
 * Bu adımda öğreneceksiniz: new Thread(...) ile thread oluşturma, start() ile
 * başlatma. ÖNEMLİ: run() doğrudan çağrılırsa yeni thread oluşmaz, mevcut thread'de
 * çalışır; start() çağrılmalı ki JVM yeni bir thread başlatsın.
 */
public final class Step03_IlkThread {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== ADIM 3: İlk Thread ==========\n");

        System.out.println("main thread: " + Thread.currentThread().getName());

        // Yeni thread: constructor'a bir Runnable veriyoruz (lambda ile).
        // Bu kod henüz ÇALIŞMIYOR — sadece thread nesnesi oluşturuldu.
        Thread yeniThread = new Thread(() -> {
            System.out.println("Yeni thread içinden: " + Thread.currentThread().getName());
        });

        System.out.println("start() öncesi — yeni thread henüz çalışmıyor.");

        // start() = JVM'e "bu thread'i başlat" der. JVM yeni bir yürütme akışı açar.
        yeniThread.start();

        // main thread burada da çalışmaya devam eder; iki akış aynı anda ilerler.
        // join() = "bu thread bitene kadar bekle" (sıralı sonuç görmek için).
        yeniThread.join();

        System.out.println("\n• start() vs run(): run()'ı doğrudan çağırsaydık, kod main thread'de çalışırdı.");
        System.out.println("  start() ile JVM yeni thread oluşturur ve run()'ı o thread'de çalıştırır.\n");
    }
}

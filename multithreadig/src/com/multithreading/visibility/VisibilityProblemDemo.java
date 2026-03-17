package com.multithreading.visibility;

/**
 * Görünürlük sorunu: Bir thread paylaşılan boolean'ı true yapar, diğer thread
 * (JVM optimizasyonu nedeniyle) değişikliği görmeyebilir ve sonsuz döngüde kalabilir.
 * volatile kullanılmadığında bu davranış teorik olarak mümkündür (bazı JVM'lerde nadir).
 */
public final class VisibilityProblemDemo {

    // volatile OLMADAN — diğer thread güncellemeyi görmeyebilir (memory visibility)
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Görünürlük Sorunu (volatile yok) ===\n");
        System.out.println("Arka plan thread'i stopRequested'i okuyor; main 1 sn sonra true yapıyor.");
        System.out.println("Bazı ortamlarda arka plan thread güncellemeyi görmeyebilir.\n");

        stopRequested = false;
        Thread background = new Thread(() -> {
            int count = 0;
            while (!stopRequested) {
                count++;
            }
            System.out.println("Arka plan thread durdu, count: " + count);
        });
        background.start();

        Thread.sleep(1000);
        stopRequested = true;
        background.join(2000);

        if (background.isAlive()) {
            System.out.println("UYARI: Arka plan hala çalışıyor — görünürlük sorunu yaşanıyor olabilir.");
        } else {
            System.out.println("Arka plan normal şekilde durdu.");
        }
    }
}

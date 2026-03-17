package com.multithreading.visibility;

/**
 * volatile ile görünürlük garantisi: Bir thread'deki yazma, diğer thread'lerdeki okumalarda
 * "happens-before" ilişkisiyle görünür. Sadece basit flag/state için uygundur;
 * sayacı artırma gibi compound işlemler için yeterli değildir (atomic değil).
 */
public final class VolatileFlagDemo {

    // volatile: yazma ve okumalar tüm thread'lerde görünür
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== volatile ile Görünürlük ===\n");

        stopRequested = false;
        Thread background = new Thread(() -> {
            long count = 0;
            while (!stopRequested) {
                count++;
            }
            System.out.println("Arka plan thread durdu, count: " + count);
        });
        background.start();

        Thread.sleep(500);
        stopRequested = true;
        background.join(2000);

        if (!background.isAlive()) {
            System.out.println("volatile sayesinde güncelleme her zaman görünür.");
        }
    }
}

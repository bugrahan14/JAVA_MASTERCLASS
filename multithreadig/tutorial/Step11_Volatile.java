package tutorial;

/**
 * Adım 11: volatile — görünürlük.
 * <p>
 * Bu adımda öğreneceksiniz: Bir thread'deki yazma, diğer thread'lerde "görünür" olmalı.
 * JVM bazen okumayı cache'den yapabilir; volatile bu değişikliğin hemen görünmesini
 * sağlar (happens-before). Sadece basit flag/tek değişken için; sayacı artırma atomik değildir.
 */
public final class Step11_Volatile {

    private static volatile boolean durdur; // volatile = görünürlük garantisi

    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== ADIM 11: volatile ==========\n");

        durdur = false;
        Thread arkaPlan = new Thread(() -> {
            long n = 0;
            while (!durdur) {
                n++;
            }
            System.out.println("Arka plan durdu, n: " + n);
        });
        arkaPlan.start();

        Thread.sleep(300);
        durdur = true; // volatile olmasaydı arka plan bunu görmeyebilirdi
        arkaPlan.join(2000);

        System.out.println("\n• volatile: Yazma ve okumalar tüm thread'lerde görünür.");
        System.out.println("• Sadece tek değişken (flag) için; counter++ gibi işlemler atomik DEĞİL.\n");
    }
}

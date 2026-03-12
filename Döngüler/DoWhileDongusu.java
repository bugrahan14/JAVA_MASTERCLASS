import java.util.Scanner;

/**
 * Do-while döngüsü örnekleri.
 * Önce gövde çalışır, sonra koşul kontrol edilir; en az bir kez çalışma garantisi vardır.
 * Menü, kullanıcı girdisi veya "en az bir kez işlem yap" senaryolarında uygundur.
 */
public class DoWhileDongusu {

    private static final int CIKIS_SECIMI = 0;
    private static final int MENU_SECENEK_SAYISI = 3;

    public static void main(String[] args) {
        whileIleFark();
        menuDongusu();
    }

    /**
     * While ile fark: Koşul başta false olsa bile do-while gövdesi en az bir kez çalışır.
     */
    private static void whileIleFark() {
        int sayac = 10;
        System.out.println("Do-while: kosul false olsa bile ilk iterasyon calisir.");
        do {
            System.out.println("sayac = " + sayac + " (bu satir bir kez yazilir)");
            sayac++;
        } while (sayac <= 5);
        System.out.println("--- while ile olsaydi bu blok hic calismazdi ---");
    }

    /**
     * Menü döngüsü: Kullanıcı seçim yapar, 0 girince çıkılır.
     * Do-while: En az bir kez menü gösterilir, sonra koşula bakılır.
     */
    private static void menuDongusu() {
        Scanner giris = new Scanner(System.in);
        int secim;
        do {
            secim = menuyuGosterVeSecimAl(giris);
            secimeGoreIslemYap(secim);
        } while (kullaniciCikisIstemedi(secim));
        System.out.println("Programdan cikildi.");
        giris.close();
    }

    private static int menuyuGosterVeSecimAl(Scanner giris) {
        System.out.println("--- Menu ---");
        System.out.println("1: Islem bir");
        System.out.println("2: Islem iki");
        System.out.println("3: Islem uc");
        System.out.println(CIKIS_SECIMI + ": Cikis");
        System.out.print("Seciminiz: ");
        return giris.nextInt();
    }

    private static void secimeGoreIslemYap(int secim) {
        if (secim >= 1 && secim <= MENU_SECENEK_SAYISI) {
            System.out.println("Islem " + secim + " yapildi.");
        } else if (secim != CIKIS_SECIMI) {
            System.out.println("Gecersiz secim.");
        }
    }

    private static boolean kullaniciCikisIstemedi(int secim) {
        return secim != CIKIS_SECIMI;
    }
}

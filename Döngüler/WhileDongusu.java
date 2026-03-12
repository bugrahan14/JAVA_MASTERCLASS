/**
 * While döngüsü örnekleri.
 * Koşul başta kontrol edilir; koşul true olduğu sürece gövde çalışır.
 * Kaç tekrar yapılacağı önceden net değilse veya koşul karmaşıksa while tercih edilir.
 */
public class WhileDongusu {

    private static final int HEDEF_DEGER = 5;
    private static final int MAX_ITERASYON = 10;

    public static void main(String[] args) {
        basitSayac();
        kosulYanlisIkenCalismaz();
        breakKullanimi();
        continueKullanimi();
        sonsuzDonguUyarisi();
    }

    /**
     * Temel while: 1'den HEDEF_DEGER'e kadar sayar.
     * Sözdizimi: while (koşul) { gövde }
     */
    private static void basitSayac() {
        int sayac = 1;
        while (sayac <= HEDEF_DEGER) {
            System.out.println("Sayac: " + sayac);
            sayac++;
        }
        System.out.println("--- basitSayac bitti ---");
    }

    /**
     * Koşul başta false ise gövde hiç çalışmaz.
     */
    private static void kosulYanlisIkenCalismaz() {
        int sayac = 10;
        while (sayac <= HEDEF_DEGER) {
            System.out.println("Bu satir hic yazilmayacak.");
            sayac++;
        }
        System.out.println("--- kosul baslangicta false, dongu atlandi ---");
    }

    /**
     * break: Koşulu beklemeden döngüden çıkar.
     */
    private static void breakKullanimi() {
        int sayac = 1;
        while (sayac <= MAX_ITERASYON) {
            if (sayac == 4) {
                System.out.println("sayac 4 oldu, break ile cikiliyor.");
                break;
            }
            System.out.println("sayac = " + sayac);
            sayac++;
        }
        System.out.println("--- breakKullanimi bitti ---");
    }

    /**
     * continue: Kalan gövdeyi atla, bir sonraki iterasyona geç.
     */
    private static void continueKullanimi() {
        int sayac = 0;
        while (sayac < 6) {
            sayac++;
            if (sayac % 2 == 0) {
                continue;
            }
            System.out.println("Tek sayi: " + sayac);
        }
        System.out.println("--- continueKullanimi bitti ---");
    }

    /**
     * Sonsuz döngü riski: Koşul hiç false olmazsa döngü bitmez.
     * Bu örnekte sayac artırılmazsa (yorum satırı gibi) sonsuz döngü oluşur.
     * Dikkat: Koşul içindeki değişkenin mutlaka güncellenmesi gerekir.
     */
    private static void sonsuzDonguUyarisi() {
        int sayac = 1;
        final int sinir = 3;
        while (sayac <= sinir) {
            System.out.println("Iterasyon: " + sayac);
            sayac++;
        }
        System.out.println("--- Dongu saglikli bitti (sayac guncellendi) ---");
    }
}

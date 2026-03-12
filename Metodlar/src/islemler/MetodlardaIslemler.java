package islemler;

/**
 * Metod içinde işlemler: lokal değişkenler, if/for/while, return kullanımı.
 */
public class MetodlardaIslemler {

    public static void main(String[] args) {
        System.out.println("Maksimum: " + maksimum(10, 20));
        System.out.println("Toplam 1..5: " + toplamDongu(5));
        listeyiYaz(3);
        System.out.println("Erken çıkış örneği: " + ilkCiftIndex(new int[] { 1, 3, 4, 5 }));
    }

    /** Karar yapısı: if-else, lokal değişken. */
    public static int maksimum(int a, int b) {
        int sonuc;
        if (a >= b) {
            sonuc = a;
        } else {
            sonuc = b;
        }
        return sonuc;
    }

    /** Döngü: for ile toplam. */
    public static int toplamDongu(int n) {
        int toplam = 0;
        for (int i = 1; i <= n; i++) {
            toplam += i;
        }
        return toplam;
    }

    /** while ile sayma. */
    public static void listeyiYaz(int adet) {
        int sayac = 0;
        while (sayac < adet) {
            System.out.println("  Eleman " + (sayac + 1));
            sayac++;
        }
    }

    /** Erken return: İlk çift sayının index'ini bul. */
    public static int ilkCiftIndex(int[] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] % 2 == 0) {
                return i;
            }
        }
        return -1;
    }
}

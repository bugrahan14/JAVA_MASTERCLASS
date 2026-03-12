import java.util.Arrays;
import java.util.List;

/**
 * For döngüsü örnekleri.
 * Başlangıç, koşul ve güncelleme tek satırda; tekrar sayısı belli veya aralık netse for tercih edilir.
 */
public class ForDongusu {

    private static final int BASLANGIC = 1;
    private static final int BITIS = 5;
    private static final int ARTIS_IKI = 2;
    private static final int ARTIS_BES = 5;
    private static final int CARPIM_TABLOSU_SINIRI = 5;

    public static void main(String[] args) {
        klasikForBirdenNe();
        geriyeSayim();
        ikiSerArtis();
        beserArtis();
        carpimTablosu();
        forEachDizi();
        forEachListe();
    }

    /**
     * Klasik for: başlangıç, koşul, güncelleme.
     * 1'den BITIS'e kadar yazdırır.
     */
    private static void klasikForBirdenNe() {
        for (int sayac = BASLANGIC; sayac <= BITIS; sayac++) {
            System.out.println("sayac = " + sayac);
        }
        System.out.println("--- klasikForBirdenNe bitti ---");
    }

    /**
     * N'den 1'e geriye sayım.
     */
    private static void geriyeSayim() {
        for (int sayac = BITIS; sayac >= BASLANGIC; sayac--) {
            System.out.println("geriye: " + sayac);
        }
        System.out.println("--- geriyeSayim bitti ---");
    }

    /**
     * 2'şer artış (çift sayılar).
     */
    private static void ikiSerArtis() {
        for (int deger = BASLANGIC; deger <= 10; deger += ARTIS_IKI) {
            System.out.println("2'ser: " + deger);
        }
        System.out.println("--- ikiSerArtis bitti ---");
    }

    /**
     * 5'er artış.
     */
    private static void beserArtis() {
        for (int deger = 0; deger <= 20; deger += ARTIS_BES) {
            System.out.println("5'er: " + deger);
        }
        System.out.println("--- beserArtis bitti ---");
    }

    /**
     * İç içe for: çarpım tablosu (tek sorumluluk için ayrı metot).
     */
    private static void carpimTablosu() {
        for (int satir = 1; satir <= CARPIM_TABLOSU_SINIRI; satir++) {
            for (int sutun = 1; sutun <= CARPIM_TABLOSU_SINIRI; sutun++) {
                System.out.print(satir * sutun + "\t");
            }
            System.out.println();
        }
        System.out.println("--- carpimTablosu bitti ---");
    }

    /**
     * For-each (enhanced for): dizi üzerinde gezinti, okunabilir.
     */
    private static void forEachDizi() {
        int[] dizi = { 10, 20, 30, 40, 50 };
        for (int eleman : dizi) {
            System.out.println("Eleman: " + eleman);
        }
        System.out.println("--- forEachDizi bitti ---");
    }

    /**
     * For-each: List üzerinde gezinti.
     */
    private static void forEachListe() {
        List<String> liste = Arrays.asList("Elma", "Armut", "Muz");
        for (String meyve : liste) {
            System.out.println("Meyve: " + meyve);
        }
        System.out.println("--- forEachListe bitti ---");
    }
}

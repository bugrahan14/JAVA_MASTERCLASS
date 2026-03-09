import java.util.Arrays;

/**
 * ARRAY - EN TEMEL VE KAPSAMLI ÖRNEKLER
 * --------------------------------------
 * Array: Sabit boyutlu, aynı tipte elemanları ardışık bellek (contiguous) alanında tutan yapı.
 * - Tip güvenliği: Derleme/çalışma zamanında tip kontrolü.
 * - Boyut bir kez verilir, sonradan değiştirilemez (bu yüzden Collection'lara geçiş motivasyonu).
 */
public class ArrayTemelVeOrnekler {

    public static void main(String[] args) {
        temelTanımlamaVeErisim();
        dongulerVeCokBoyutlu();
        yayginIslemler();
        sinirlamalarVeMotivasyon();
    }

    /** 1. Temel tanımlama ve erişim */
    public static void temelTanımlamaVeErisim() {
        System.out.println("\n=== 1. TEMEL TANIMLAMA VE ERİŞİM ===\n");

        // int[]: tamsayı dizisi; new int[5] ile 5 elemanlı, varsayılan 0 değerleri
        int[] sayilar = new int[5];
        sayilar[0] = 10;
        sayilar[1] = 20;
        sayilar[2] = 30;
        System.out.println("sayilar[0] = " + sayilar[0]);
        System.out.println("sayilar.length = " + sayilar.length);

        // Literal ile tanımlama: { değer1, değer2, ... }
        int[] literal = { 1, 2, 3, 4, 5 };
        System.out.println("Literal dizi: " + Arrays.toString(literal));

        // String dizisi
        String[] isimler = new String[3];
        isimler[0] = "Ali";
        isimler[1] = "Veli";
        isimler[2] = "Ayşe";
        System.out.println("İsimler: " + Arrays.toString(isimler));

        // Erişim: index 0..length-1. length alanı (metod değil!)
        // Geçersiz index -> ArrayIndexOutOfBoundsException
        System.out.println("Son eleman: " + sayilar[sayilar.length - 1]);
        System.out.println("Arrayin uzunlugu: " + literal.length);
    }

    /** 2. Döngüler ve çok boyutlu array (matris) */
    public static void dongulerVeCokBoyutlu() {
        System.out.println("\n=== 2. DÖNGÜLER VE ÇOK BOYUTLU ARRAY ===\n");

        int[] arr = { 10, 20, 30, 40, 50 };

        System.out.println("Klasik for:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("  arr[" + i + "] = " + arr[i]);
        }

        System.out.println("For-each (index gerekmez):");
        for (int deger : arr) {
            System.out.println("  " + deger);
        }

        // Çok boyutlu: matris [satır][sütun]
        int[][] matris = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Matris (3x3):");
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                System.out.print(matris[i][j] + " ");
            }
            System.out.println();
        }
    }

    /** 3. Yaygın işlemler: max, min, toplam, ortalama, kopyalama, sıralama, arama */
    public static void yayginIslemler() {
        System.out.println("\n=== 3. YAYGIN İŞLEMLER (Arrays yardımcıları) ===\n");

        int[] arr = { 64, 12, 88, 5, 42 };

        // Max / Min (manuel döngü)
        int max = arr[0], min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        System.out.println("Max: " + max + ", Min: " + min);

        // Toplam ve ortalama
        int toplam = 0;
        for (int x : arr) toplam += x;
        double ortalama = (double) toplam / arr.length;
        System.out.println("Toplam: " + toplam + ", Ortalama: " + ortalama);

        // Kopyalama: Arrays.copyOf (yeni dizi döner)
        int[] kopya = Arrays.copyOf(arr, arr.length);
        System.out.println("Kopya: " + Arrays.toString(kopya));

        // Sıralama: yerinde (in-place) sıralar
        int[] siralanacak = Arrays.copyOf(arr, arr.length);
        Arrays.sort(siralanacak);
        System.out.println("Sıralı: " + Arrays.toString(siralanacak));

        // İkili arama: sıralı dizi gerekir
        int aranan = 42;
        int idx = Arrays.binarySearch(siralanacak, aranan);
        System.out.println(aranan + " değeri indeks: " + idx);
    }

    /** 4. Sınırlamalar: boyut sabit, ekleme/silme zor; Collection'lara geçiş motivasyonu */
    public static void sinirlamalarVeMotivasyon() {
        System.out.println("\n=== 4. ARRAY SINIRLAMALARI ===\n");

        System.out.println("- Boyut sabittir; oluşturulduktan sonra artırılamaz/azaltılamaz.");
        System.out.println("- Ortaya veya başa eleman eklemek için kaydırma gerekir (O(n)).");
        System.out.println("- Silmek için de kaydırma veya yeni dizi oluşturup kopyalama gerekir.");
        System.out.println("- Bu yüzden dinamik boyut ve kolay ekleme/çıkarma için List (ArrayList/LinkedList) kullanılır.");
    }
}

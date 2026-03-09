/**
 * KARŞILAŞTIRMA VE BEST PRACTICES
 * --------------------------------
 * Array vs ArrayList vs LinkedList özet tablo ve "nasıl kullanmalı" kuralları.
 */
public class KarsilastirmaVeBestPractices {

    public static void main(String[] args) {
        ozetTabloyuYazdir();
        bestPracticesOzeti();
    }

    /** Özet tablo: Array vs ArrayList vs LinkedList — boyut, erişim, ekleme, bellek, senaryo */
    public static void ozetTabloyuYazdir() {
        System.out.println("\n=== ARRAY vs ARRAYLİST vs LİNKEDLİST ÖZET TABLO ===\n");

        System.out.println("+------------------+----------------+------------------+------------------+");
        System.out.println("| Özellik          | Array          | ArrayList        | LinkedList       |");
        System.out.println("+------------------+----------------+------------------+------------------+");
        System.out.println("| Boyut            | Sabit          | Dinamik          | Dinamik          |");
        System.out.println("| Erişim (index)   | O(1)           | O(1)             | O(n)             |");
        System.out.println("| Başa ekleme      | O(n)           | O(n)             | O(1)             |");
        System.out.println("| Sona ekleme      | -              | O(1)*            | O(1)             |");
        System.out.println("| Ortaya ekleme    | O(n)           | O(n)             | O(n)+O(1)        |");
        System.out.println("| Bellek overhead  | Düşük          | Orta (resize)    | Yüksek (node)    |");
        System.out.println("| Kullanım         | Sabit veri     | Genel liste      | Kuyruk/Deque     |");
        System.out.println("+------------------+----------------+------------------+------------------+");
        System.out.println("* Amortized O(1); resize olduğunda geçici O(n)");
    }

    /** Best practices özeti */
    public static void bestPracticesOzeti() {
        System.out.println("\n=== BEST PRACTICES ===\n");

        System.out.println("1. Değişken tipinde interface kullan: List<T> tercih et, ArrayList/LinkedList sadece sağ tarafta.");
        System.out.println("   Örnek: List<String> list = new ArrayList<>();");
        System.out.println();
        System.out.println("2. ArrayList başlangıç kapasitesi: Eleman sayısı tahmin edilebiliyorsa new ArrayList<>(n) ver.");
        System.out.println();
        System.out.println("3. Immutable listeler: List.of(...) (Java 9+); değiştirilmeyecek listelerde kullan. Arrays.asList sabit boyutlu, add/remove atar.");
        System.out.println();
        System.out.println("4. Boxing/Unboxing: Çok sayıda int için ArrayList<Integer> yerine int[] veya primitive odaklı kütüphaneler düşün.");
        System.out.println();
        System.out.println("5. Null ve duplicate: List.of null kabul etmez; ArrayList null ve duplicate kabul eder. İhtiyaca göre seç.");
        System.out.println();
        System.out.println("6. Concurrency: ArrayList ve LinkedList thread-safe değildir. Çok thread'de CopyOnWriteArrayList veya Collections.synchronizedList(list) kullan; senkronize erişim gerekir.");
    }
}

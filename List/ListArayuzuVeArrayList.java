import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LİST ARAYÜZÜ VE ARRAYLİST - KAPSAMLI ÖRNEKLER
 * ----------------------------------------------
 * List<E>: Sıralı, indeksli, tekrarlı (duplicate) elemana izin veren koleksiyon arayüzü.
 * ArrayList: List'in array tabanlı implementasyonu; dinamik boyut (dahili array resize).
 * Best practice: Değişken tipini List<E> yap; başlangıç kapasitesi tahmin edilebiliyorsa ver.
 */
public class ListArayuzuVeArrayList {

    public static void main(String[] args) {
        listArayuzuVeArrayListTemel();
        baslangicDegerleri();
        pratikOrnekler();
        bestPracticeOrnekleri();
    }

    /** List arayüzü ve ArrayList temel API: add, remove, get, set, size, contains, indexOf, clear */
    public static void listArayuzuVeArrayListTemel() {
        System.out.println("\n=== LİST ARAYÜZÜ VE ARRAYLİST TEMEL ===\n");

        // Best practice: Interface tipi (List<String>) kullan
        List<String> list = new ArrayList<>();
        list.add("Elma");
        list.add("Armut");
        list.add("Muz");
        list.add("Elma"); // duplicate serbest
        System.out.println("Liste: " + list);
        System.out.println("Boyut (size): " + list.size());

        System.out.println("get(1): " + list.get(1));
        list.set(1, "Kiraz"); // indeks 1'i değiştir
        System.out.println("set(1,\"Kiraz\") sonrası: " + list);

        System.out.println("contains(\"Muz\"): " + list.contains("Muz"));
        System.out.println("indexOf(\"Elma\"): " + list.indexOf("Elma"));

        list.remove(2); // indeks 2'deki elemanı sil (Muz)
        System.out.println("remove(2) sonrası: " + list);

        list.clear();
        System.out.println("clear() sonrası: " + list);
    }

    /** Başlangıç değerleri: Arrays.asList, List.of (Java 9+); sabit boyut dikkati */
    public static void baslangicDegerleri() {
        System.out.println("\n=== BAŞLANGIÇ DEĞERLERİ ===\n");

        // Arrays.asList: sabit boyutlu liste (add/remove desteklenmez!)
        List<String> asList = Arrays.asList("A", "B", "C");
        System.out.println("Arrays.asList: " + asList);
        // asList.add("D"); // UnsupportedOperationException

        // Değiştirilebilir liste istiyorsak: new ArrayList<>(Arrays.asList(...))
        List<String> degistirilebilir = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        degistirilebilir.add("W");
        System.out.println("new ArrayList<>(Arrays.asList(...)): " + degistirilebilir);

        // List.of (Java 9+): immutable, null'a izin vermez
        List<String> immutable = List.of("Bir", "İki", "Üç");
        System.out.println("List.of: " + immutable);
        // immutable.add("Dört"); // UnsupportedOperationException
    }

    /** Pratik örnekler: filtreleme, arama, alt liste, listeyi array'e çevirme */
    public static void pratikOrnekler() {
        System.out.println("\n=== PRATİK ÖRNEKLER ===\n");

        List<Integer> sayilar = new ArrayList<>(Arrays.asList(10, 25, 30, 45, 50, 60));

        // Filtreleme: 30'dan büyük olanlar
        List<Integer> filtrelenmis = new ArrayList<>();
        for (Integer n : sayilar) {
            if (n > 30) filtrelenmis.add(n);
        }
        System.out.println("30'dan büyük: " + filtrelenmis);

        // Arama: belirli bir değerin indeksi
        int aranan = 45;
        int idx = sayilar.indexOf(aranan);
        System.out.println(aranan + " indeksi: " + idx);

        // Alt liste: subList(baslangic, bitis) - bitis dahil değil
        List<Integer> altListe = sayilar.subList(1, 4);
        System.out.println("subList(1,4): " + altListe);

        // Listeyi array'e çevirme
        Integer[] dizi = sayilar.toArray(new Integer[0]);
        System.out.println("toArray: " + Arrays.toString(dizi));
    }

    /** Best practice: kapasite tahmini, List<T> tipi, immutable kullanımı */
    public static void bestPracticeOrnekleri() {
        System.out.println("\n=== BEST PRACTICE ÖRNEKLERİ ===\n");

        // Tahmin edilen eleman sayısı varsa başlangıç kapasitesi ver (reallocation azalır)
        int tahminiBoyut = 100;
        List<Integer> buyukListe = new ArrayList<>(tahminiBoyut);
        System.out.println("new ArrayList<>(100) ile kapasite tahmini");

        // Her zaman List<E> olarak tanımla, ArrayList'i sadece sağ tarafta kullan
        List<String> isimler = new ArrayList<>();
        isimler.add("Ali");
        isimler.add("Veli");
        System.out.println("List<String> isimler = new ArrayList<>(): " + isimler);

        // Değiştirilmeyecek listeler için List.of
        List<String> sabitListe = List.of("Pazartesi", "Salı", "Çarşamba");
        System.out.println("Immutable liste (List.of): " + sabitListe);
    }
}

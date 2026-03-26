package com.example.lambda;

import java.util.List;
import java.util.Objects;

/**
 * METOT REFERANSI (::)
 * <p>
 * Bazen lambda yalnızca mevcut bir metodu çağırıyorsa, daha kısa yazım mümkündür.
 * <p>
 * Dört ana biçim:
 * 1) Statik metot:           SınıfAdı::statikMetot
 * 2) Belirli nesnenin metodu: nesne::örnekMetot
 * 3) Belirsiz nesnenin metodu (örnek): SınıfAdı::örnekMetot  (ilk parametre "this" gibi akar)
 * 4) Kurucu referansı:       SınıfAdı::new
 * <p>
 * Clean code notu: Okuyucu için anlam aynıysa method reference tercih edilir;
 * davranışı gizleyecek kadar dolaylıysa lambda ile açık yazmak daha iyidir.
 */
public final class MethodReferenceDemo {

    private MethodReferenceDemo() {
    }

    public static void ornekleriCalistir() {
        List<String> satirlar = List.of("a", "b", "c");

        // Statik metot referansı: her eleman için Objects.requireNonNull
        satirlar.forEach(Objects::requireNonNull);

        // Örnek metot (belirsiz nesne): String üzerinde compareToIgnoreCase
        // İki parametreli Comparator için uygun: (a,b) -> a.compareToIgnoreCase(b)
        List<String> isimler = new java.util.ArrayList<>(List.of("ali", "Zeynep", "MEHMET"));
        isimler.sort(String::compareToIgnoreCase);
        System.out.println("sıralı: " + isimler);

        // Kurucu referansı: String::new gibi
        java.util.function.Function<String, String> fabrika = String::new;
        System.out.println("yeni string: '" + fabrika.apply("kopya") + "'");
    }
}

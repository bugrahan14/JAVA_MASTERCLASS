package com.example.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * LAMBDA İLE TEMİZ KOD — pratik ilkeler
 * <p>
 * 1) İsimlendirme: lambda çok uzunsa, özel bir metoda veya Predicate/Function değişkenine çıkar.
 * 2) Tek satır sihri: akıl yürütmeyi zorlaştırıyorsa süslü parantez ve ara değişken kullan.
 * 3) Yan etki: forEach içinde dış durumu şişirmek yerine collect/reduce ile sonuç üret.
 * 4) Okunurluk: method reference ile aynı anlam daha kısaysa onu seç.
 * 5) null güvenliği: Predicate'leri birleştirirken null kontrolünü açık tut.
 */
public final class TemizKodPrensipleri {

    private TemizKodPrensipleri() {
    }

    /**
     * Kötü örnek değil ama "gizli" mantık: uzun lambda okunması zorlaşır.
     * İyi örnek: anlamlı isimli yardımcı metot veya değişken.
     */
    private static boolean gecerliEmail(String email) {
        if (email == null) {
            return false;
        }
        String e = email.trim();
        return e.contains("@") && e.length() > 3;
    }

    public static void ornekleriCalistir() {
        // List.of null elemana izin vermez; null filtrelemeyi göstermek için ArrayList kullanıyoruz.
        List<String> adaylar = new ArrayList<>();
        adaylar.add("ali@test.com");
        adaylar.add("bozuk");
        adaylar.add(null);
        adaylar.add("  ");

        // Açık ve test edilebilir: karmaşık koşul metoda taşındı.
        Predicate<String> gecerli = TemizKodPrensipleri::gecerliEmail;

        List<String> temizListe = adaylar.stream()
                .filter(Objects::nonNull)
                .filter(gecerli)
                .toList();

        System.out.println("geçerli e-postalar: " + temizListe);
    }
}

package com.example.lambda;

import java.util.List;
import java.util.stream.Collectors;

/**
 * STREAM API + LAMBDA
 * <p>
 * Stream, veri üzerinde "bildirimsel" (ne yapılacağını söyle, nasıl yürütüleceğini değil)
 * işlem zinciri kurmayı sağlar. Lambda'lar burada filtre, dönüşüm, tüketim adımlarını doldurur.
 * <p>
 * Önemli fikirler:
 * - Ara işlemler (filter, map) "lazy" olabilir; son işlem (collect, forEach) tetikler.
 * - Yan etkileri stream içinde biriktirmek yerine, mümkünse saf dönüşümler tercih edilir (temiz kod).
 */
public final class LambdaVeStreams {

    private LambdaVeStreams() {
    }

    public static void ornekleriCalistir() {
        List<String> kelimeler = List.of(" Lambda ", "stream", "TEMİZ", "kod ");

        // map-trim-filter-collect: okunaklı bir pipeline
        List<String> sonuc = kelimeler.stream()
                .map(String::trim)                    // her elemanı normalize et
                .map(String::toLowerCase)             // karşılaştırma için küçük harf
                .filter(s -> s.length() >= 3)         // çok kısa gürültüyü at
                .distinct()                           // tekrarları kaldır
                .sorted()                             // doğal sıra
                .collect(Collectors.toList());

        System.out.println("pipeline sonucu: " + sonuc);
    }
}

package com.example.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * YERLEŞİK FONKSİYONEL ARAYÜZLER (java.util.function)
 * <p>
 * Kendi @FunctionalInterface tanımlamak yerine, çoğu ihtiyaç için JDK'nın hazır tiplerini kullanmak:
 * - Temiz kod: isimlendirilmiş, standart sözleşme
 * - Bakım: ekip herkes aynı tipleri bilir
 * <p>
 * En sık kullanılanlar (özet):
 * - Predicate&lt;T&gt;     : T -&gt; boolean  (test / filtre)
 * - Function&lt;T,R&gt;   : T -&gt; R       (dönüşüm / haritalama)
 * - Consumer&lt;T&gt;     : T -&gt; void    (yan etki: yazdırma, log, kayıt)
 * - Supplier&lt;T&gt;     : () -&gt; T      (üretim: fabrika, lazy değer)
 * <p>
 * Primitive uzantılar (boxing maliyetini azaltmak için):
 * IntPredicate, IntFunction, IntConsumer, IntSupplier vb.
 */
public final class YerlesikFonksiyonelTurler {

    private YerlesikFonksiyonelTurler() {
    }

    public static void ornekleriCalistir() {
        // Predicate: "bu öğe koşulu sağlıyor mu?"
        Predicate<Integer> ciftMi = n -> n % 2 == 0;
        System.out.println("ciftMi(4): " + ciftMi.test(4));

        // Function: "T'yi al, R üret"
        Function<String, Integer> uzunluk = String::length;
        System.out.println("uzunluk('lambda'): " + uzunluk.apply("lambda"));

        // Consumer: "T'yi al, bir şey yap (dönüş yok)"
        Consumer<String> yazdir = System.out::println;
        yazdir.accept("Consumer örneği");

        // Supplier: "parametre yok, T üret"
        Supplier<Double> rastgele = Math::random;
        System.out.println("random: " + rastgele.get());

        // Birleştirme: küçük parçaları okunur biçimde birleştirmek temiz koddur.
        Function<String, String> trimVeBuyuk = s -> s.trim().toUpperCase();
        System.out.println(trimVeBuyuk.apply("  merhaba  "));
    }
}

package com.example.lambda;

import java.util.Comparator;
import java.util.List;

/**
 * LAMBDA NEDİR? (En temel seviye)
 * <p>
 * Lambda, "anonim bir fonksiyon" gibi düşünülebilir: ismi olmayan, kısa bir kod bloğu.
 * Java'da lambda, aslında bir "fonksiyonel arayüzün" (tek soyut metodu olan arayüz) tek
 * metodunun gövdesini yazmanın kısayoludur.
 * <p>
 * Neden var?
 * - Daha az boilerplate (anonim sınıf yazmadan aynı işi yapmak)
 * - Okunabilirlik (küçük davranışları çağrı yerinde ifade etmek)
 * - Koleksiyonlar ve Stream API ile doğal biçimde çalışmak
 * <p>
 * Temel sözdizimi:
 * (parametreler) -> { gövde }
 * Tek satırlık ifade ise süslü parantez ve return genelde atlanabilir.
 */
public final class TemelLambda {

    private TemelLambda() {
    }

    /**
     * Fonksiyonel arayüz: tam olarak bir adet soyut metot içerir.
     * Bu sayede derleyici, lambda'nın hangi metodu uyguladığını bilir.
     */
    @FunctionalInterface
    interface Toplayici {
        int topla(int a, int b);
    }

    public static void ornekleriCalistir() {
        // --- 1) Klasik anonim sınıf (lambda öncesi) ---
        // Amaç: küçük bir "toplama davranışı" tanımlamak.
        Toplayici anonim = new Toplayici() {
            @Override
            public int topla(int a, int b) {
                return a + b;
            }
        };

        // --- 2) Aynı davranışın lambda ile yazımı ---
        // Okunuşu: "(a ve b) al, a+b döndür"
        Toplayici lambda = (a, b) -> a + b;

        // --- 3) Parametre tipleri (isteğe bağlı) ---
        // Derleyici çoğu zaman çıkarsar; gerekirse açık yazılır.
        Toplayici lambdaTipiAcik = (int a, int b) -> a + b;

        // --- 4) Tek parametre: parantez isteğe bağlı (stil tercihi) ---
        java.util.function.IntUnaryOperator ikiKat = x -> x * 2;

        // --- 5) Çok satırlı gövde: süslü parantez + return zorunlu ---
        Toplayici lambdaCokSatir = (a, b) -> {
            int araToplam = a + b;
            return araToplam;
        };

        System.out.println("anonim: " + anonim.topla(2, 3));
        System.out.println("lambda: " + lambda.topla(2, 3));
        System.out.println("ikiKat(5): " + ikiKat.applyAsInt(5));
        System.out.println("cokSatir: " + lambdaCokSatir.topla(2, 3));

        // --- 6) Gerçek hayat benzeri: sıralama ---
        // Comparator bir fonksiyonel arayüzdür (compare soyut metodu).
        // Lambda ile "sıralama kuralını" net ve yerel biçimde veriyoruz.
        List<String> isimler = new java.util.ArrayList<>(List.of("Zeynep", "Ali", "Mehmet"));
        isimler.sort(Comparator.comparing(String::length)); // method reference (başka derste)
        System.out.println("uzunluğa göre: " + isimler);

        isimler.sort(String::compareToIgnoreCase);
        System.out.println("alfabetik (ignore case): " + isimler);
    }
}

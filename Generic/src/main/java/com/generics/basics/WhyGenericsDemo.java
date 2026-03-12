package com.generics.basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Raw list vs List&lt;String&gt; karşılaştırması.
 * Generics ile tip güvenliği ve cast'siz kullanım.
 */
public class WhyGenericsDemo {
    public static void main(String[] args) {
        System.out.println("=== Generics İLE (önerilen) ===");
        List<String> safeList = new ArrayList<>();
        safeList.add("Merhaba");
        String value = safeList.get(0);
        System.out.println("Cast gerekmez: " + value);

        System.out.println("=== Raw type (kaçınılmalı) ===");
        @SuppressWarnings("rawtypes")
        List rawList = new ArrayList();
        rawList.add("test");
        rawList.add(42);
        String fromRaw = (String) rawList.get(0);
        System.out.println("Cast gerekir: " + fromRaw);
        // (String) rawList.get(1) -> ClassCastException
    }
}

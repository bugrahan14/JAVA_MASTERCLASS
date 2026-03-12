package com.generics.bestpractices;

import java.util.ArrayList;
import java.util.List;

/**
 * İyi ve kötü generic kullanım karşılaştırmaları.
 * Bkz. docs/06-clean-code.md
 */
public class GoodVsBadGenerics {

    /**
     * İyi: Tip güvenli, cast yok.
     */
    public static void goodListUsage() {
        List<String> list = new ArrayList<>();
        list.add("a");
        String s = list.get(0);
    }

    /**
     * Kötü: Raw type, cast gerekir, runtime riski.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void badListUsage() {
        List list = new ArrayList();
        list.add("a");
        list.add(42);
        String s = (String) list.get(1);
    }

    /**
     * İyi: Generic metot, dar kapsam.
     */
    public static <T> T getFirst(List<T> list) {
        return list == null || list.isEmpty() ? null : list.get(0);
    }

    public static void main(String[] args) {
        goodListUsage();
        System.out.println("İyi kullanım tamamlandı.");
    }
}

package com.collection.framework.set;

import java.util.*;

/**
 * SET ARAYÜZÜ - GENEL BAKIŞ
 * -------------------------
 * Set<E>: Tekrarsız (no duplicate) eleman koleksiyonu. equals() ile eşitlik kontrolü.
 * List'teki indeks erişimi (get(i)) yok; add, remove, contains, size, iterator.
 *
 * Implementasyonlar:
 * - HashSet: O(1) ortalama; sıra garantisi yok. hashCode + equals gerekli.
 * - LinkedHashSet: Ekleme sırasını korur; biraz daha fazla bellek.
 * - TreeSet: Sıralı (Comparable veya Comparator); O(log n).
 *
 * Clean code: Sadece "benzersizlik" istiyorsan Set; sıra önemliyse LinkedHashSet veya TreeSet.
 */
public class SetInterfaceOverview {

    public static void main(String[] args) {
        noDuplicates();
        setOperations();
        nullHandling();
    }

    private static void noDuplicates() {
        System.out.println("=== TEKRARSIZ ELEMANLAR ===\n");
        Set<String> set = new HashSet<>();
        set.add("Elma");
        set.add("Armut");
        set.add("Elma");
        set.add("Muz");
        System.out.println("Set (tekrar eklenen 'Elma' bir kez): " + set);
    }

    private static void setOperations() {
        System.out.println("\n=== KÜME İŞLEMLERİ ===\n");
        Set<Integer> a = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> b = new HashSet<>(Set.of(2, 3, 4));

        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("A ∪ B: " + union);

        Set<Integer> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        System.out.println("A ∩ B: " + intersect);

        Set<Integer> diff = new HashSet<>(a);
        diff.removeAll(b);
        System.out.println("A - B: " + diff);
    }

    private static void nullHandling() {
        System.out.println("\n=== NULL DAVRANIŞI ===\n");
        Set<String> hashSet = new HashSet<>();
        hashSet.add(null);
        System.out.println("HashSet null kabul eder: " + hashSet);

        // TreeSet: null eklenemez (sıralama yapılamaz)
        Set<String> treeSet = new TreeSet<>();
        // treeSet.add(null); // NullPointerException
        System.out.println("TreeSet null kabul etmez (sıralama gerekir).");
    }
}

package com.collection.framework.set;

import java.util.*;


/**
 * LİNKEDHASHSET & TREESET
 * -----------------------
 * LinkedHashSet: Ekleme sırasını (insertion order) korur. HashSet + çift yönlü bağlı liste.
 * TreeSet: Sıralı set. Red-Black tree; add/remove/contains O(log n). Comparable veya Comparator gerekir.
 *
 * Clean code: Sıra önemliyse LinkedHashSet; doğal sıralama veya özel sıra istiyorsan TreeSet.
 */
public class LinkedHashSetAndTreeSet {

    public static void main(String[] args) {
        linkedHashSetOrder();
        treeSetNaturalOrder();
        treeSetWithComparator();
    }

    private static void linkedHashSetOrder() {
        System.out.println("=== LİNKEDHASHSET - EKLEME SIRASI ===\n");
        Set<String> set = new LinkedHashSet<>();
        set.add("Üç");
        set.add("Bir");
        set.add("İki");
        set.add("Bir");
        System.out.println("Görünüm (ekleme sırası): " + set);
    }

    private static void treeSetNaturalOrder() {
        System.out.println("\n=== TREESET - DOĞAL SIRALAMA ===\n");
        Set<String> set = new TreeSet<>();
        set.add("Muz");
        set.add("Elma");
        set.add("Armut");
        System.out.println("Alfabetik: " + set);

        Set<Integer> numbers = new TreeSet<>(List.of(3, 1, 4, 1, 5)); // tekrarlar TreeSet'te bir kez
        System.out.println("Sayısal (tekrarsız sıralı): " + numbers);
    }

    private static void treeSetWithComparator() {
        System.out.println("\n=== TREESET - COMPARATOR ===\n");
        Comparator<String> reverse = Comparator.reverseOrder();
        Set<String> set = new TreeSet<>(reverse);
        set.add("A");
        set.add("C");
        set.add("B");
        System.out.println("Ters alfabetik: " + set);

        // Uzunluğa göre
        Set<String> byLength = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(s -> s));
        byLength.add("aa");
        byLength.add("b");
        byLength.add("ccc");
        System.out.println("Uzunluğa göre: " + byLength);
    }
}

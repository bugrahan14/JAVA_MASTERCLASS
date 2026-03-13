package com.collection.framework.utils;

import java.util.*;

/**
 * COLLECTIONS YARDIMCI SINIFI
 * ---------------------------
 * sort, reverse, shuffle, binarySearch, min, max, frequency, disjoint,
 * copy, fill, replaceAll, rotate, swap; synchronized/unmodifiable wrapper'lar.
 *
 * Clean code: List'i sıralamak için Collections.sort(list) veya list.sort(Comparator).
 * Immutable kopya: List.copyOf(list) (Java 10+) veya Collections.unmodifiableList(new ArrayList<>(list)).
 */
public class CollectionsUtility {

    public static void main(String[] args) {
        sortingAndSearching();
        minMaxFrequency();
        immutableAndSynchronizedWrappers();
        usefulMethods();
    }

    private static void sortingAndSearching() {
        System.out.println("=== SIRALAMA VE ARAMA ===\n");
        List<Integer> list = new ArrayList<>(List.of(3, 1, 4, 1, 5));
        Collections.sort(list);
        System.out.println("sort: " + list);
        int idx = Collections.binarySearch(list, 4);
        System.out.println("binarySearch(list, 4): " + idx);
        Collections.reverse(list);
        System.out.println("reverse: " + list);
        Collections.shuffle(list);
        System.out.println("shuffle: " + list);
    }

    private static void minMaxFrequency() {
        System.out.println("\n=== min, max, frequency ===\n");
        List<Integer> list = List.of(5, 2, 8, 2, 2);
        System.out.println("min: " + Collections.min(list));
        System.out.println("max: " + Collections.max(list));
        System.out.println("frequency(2): " + Collections.frequency(list, 2));
    }

    private static void immutableAndSynchronizedWrappers() {
        System.out.println("\n=== UNMODIFIABLE & SYNCHRONIZED ===\n");
        List<String> mutable = new ArrayList<>(List.of("a", "b"));
        List<String> unmod = Collections.unmodifiableList(mutable);
        System.out.println("unmodifiableList: " + unmod);
        // unmod.add("c"); // UnsupportedOperationException
        List<String> synced = Collections.synchronizedList(new ArrayList<>(List.of("x", "y")));
        System.out.println("synchronizedList kullanılabilir (thread-safe erişim).");
    }

    private static void usefulMethods() {
        System.out.println("\n=== DİĞER METODLAR ===\n");
        List<String> list = new ArrayList<>(List.of("A", "B", "C", "D"));
        Collections.rotate(list, 1);
        System.out.println("rotate(list, 1): " + list);
        Collections.swap(list, 0, 2);
        System.out.println("swap(0, 2): " + list);
        Collections.fill(list, "X");
        System.out.println("fill \"X\": " + list);
    }
}

package com.collection.framework.utils;

import java.util.*;

/**
 * ARRAYS YARDIMCI SINIFI (java.util.Arrays)
 * -----------------------------------------
 * Dizi işlemleri: sort, binarySearch, copyOf, copyOfRange, fill, equals, hashCode,
 * asList (dizi → sabit boyutlu List), stream (Java 8+).
 *
 * Clean code: List oluşturmak için Arrays.asList(...) veya List.of(...).
 * asList dönen liste sabit boyutludur; add/remove atar. Değiştirilebilir istiyorsan:
 * new ArrayList<>(Arrays.asList(...)).
 */
public class ArraysUtility {

    public static void main(String[] args) {
        sortAndSearch();
        copyAndFill();
        asListAndListOf();
    }

    private static void sortAndSearch() {
        System.out.println("=== SORT & BINARY SEARCH ===\n");
        int[] arr = {3, 1, 4, 1, 5};
        Arrays.sort(arr);
        System.out.println("sort: " + Arrays.toString(arr));
        int idx = Arrays.binarySearch(arr, 4);
        System.out.println("binarySearch(4): " + idx);
    }

    private static void copyAndFill() {
        System.out.println("\n=== COPY & FILL ===\n");
        int[] a = {1, 2, 3};
        int[] b = Arrays.copyOf(a, 5); // kalan 0
        System.out.println("copyOf(a, 5): " + Arrays.toString(b));
        int[] c = Arrays.copyOfRange(a, 1, 3);
        System.out.println("copyOfRange(a,1,3): " + Arrays.toString(c));
        Arrays.fill(b, 3, 5, -1);
        System.out.println("fill(b,3,5,-1): " + Arrays.toString(b));
    }

    private static void asListAndListOf() {
        System.out.println("\n=== asList & List.of ===\n");
        List<String> asList = Arrays.asList("X", "Y", "Z");
        System.out.println("Arrays.asList: " + asList + " (sabit boyut)");
        List<String> mutable = new ArrayList<>(Arrays.asList("A", "B"));
        mutable.add("C");
        System.out.println("new ArrayList<>(Arrays.asList(...)): " + mutable);
        List<String> immutable = List.of("1", "2", "3");
        System.out.println("List.of: " + immutable + " (immutable, null yok)");
    }
}

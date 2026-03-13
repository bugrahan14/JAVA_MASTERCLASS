package com.collection.framework.fundamentals;

import java.util.*;

/**
 * JAVA COLLECTION FRAMEWORK - TEMEL HİYERARŞİ
 * -------------------------------------------
 * Tüm koleksiyonların kökü: Iterable<T>
 *   └── Collection<E>
 *         ├── List<E>     → sıralı, indeksli, tekrara izin verir
 *         ├── Set<E>     → tekrarsız (unique)
 *         └── Queue<E>    → kuyruk (FIFO/LIFO/öncelik)
 *
 * Map<K,V> Collection'dan türemez; ayrı bir hiyerarşidedir (key-value).
 *
 * Clean code: Program to interface (List, Set, Map), not to implementation (ArrayList, HashSet).
 */
public class CollectionHierarchy {

    public static void main(String[] args) {
        showIterableBasics();
        showCollectionContract();
        showIteratorUsage();
    }

    /**
     * Iterable<T>: for-each ve iterator() sağlar.
     * Tüm Collection'lar Iterable olduğu için for-each kullanılabilir.
     */
    private static void showIterableBasics() {
        System.out.println("=== ITERABLE TEMEL ===\n");

        List<String> items = List.of("A", "B", "C");

        // for-each aslında Iterable + Iterator kullanır
        for (String s : items) {
            System.out.println("  " + s);
        }

        // Aynı davranış: iterator açık kullanım
        for (Iterator<String> it = items.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println("  (iterator) " + s);
        }
    }

    /**
     * Collection<E> arayüzünün ortak sözleşmesi:
     * add, remove, contains, size, isEmpty, clear, toArray...
     */
    private static void showCollectionContract() {
        System.out.println("\n=== COLLECTION SÖZLEŞMESİ ===\n");

        Collection<Integer> col = new ArrayList<>();
        col.add(10);
        col.add(20);
        col.add(10);

        System.out.println("size: " + col.size());
        System.out.println("contains(20): " + col.contains(20));
        System.out.println("isEmpty: " + col.isEmpty());

        col.remove(10); // ilk 10'u kaldırır
        System.out.println("remove(10) sonrası: " + col);

        Object[] arr = col.toArray();
        System.out.println("toArray(): " + Arrays.toString(arr));
    }

    /**
     * Iterator: hasNext(), next(), remove().
     * remove() sadece next() sonrası çağrılabilir; güvenli silme için kullanılır.
     */
    private static void showIteratorUsage() {
        System.out.println("\n=== ITERATOR KULLANIMI ===\n");

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int value = it.next();
            if (value % 2 == 0) {
                it.remove(); // güvenli silme
            }
        }
        System.out.println("Çiftler silindikten sonra: " + list);
    }
}

package com.collection.framework.map;

import java.util.*;

/**
 * HASHMAP, LİNKEDHASHMAP, TREEMAP
 * -------------------------------
 * HashMap: Sıra yok; ortalama O(1). Key'de null (tek); value'da null serbest (HashMap).
 * LinkedHashMap: Ekleme sırası (veya access-order) korunur.
 * TreeMap: Key'e göre sıralı; O(log n). Key'de null yok (Comparable gerekir).
 *
 * Clean code: Sadece eşleme istiyorsan HashMap; sıra istiyorsan LinkedHashMap veya TreeMap.
 */
public class HashMapLinkedHashMapTreeMap {

    public static void main(String[] args) {
        hashMapBasics();
        linkedHashMapOrder();
        treeMapSorted();
    }

    private static void hashMapBasics() {
        System.out.println("=== HASHMAP ===\n");
        Map<String, Integer> map = new HashMap<>();
        map.put("üç", 3);
        map.put("bir", 1);
        map.put("iki", 2);
        System.out.println("Sıra garanti değil: " + map);
        map.put(null, 0); // HashMap'te key null olabilir (tek)
        System.out.println("null key: " + map);
    }

    private static void linkedHashMapOrder() {
        System.out.println("\n=== LİNKEDHASHMAP - EKLEME SIRASI ===\n");
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("C", 3);
        map.put("A", 1);
        map.put("B", 2);
        System.out.println("Ekleme sırası: " + map);
    }

    private static void treeMapSorted() {
        System.out.println("\n=== TREEMAP - SIRALI ===\n");
        Map<String, Integer> map = new TreeMap<>();
        map.put("Muz", 1);
        map.put("Elma", 2);
        map.put("Armut", 3);
        System.out.println("Key'e göre sıralı: " + map);
        Map<String, Integer> reverse = new TreeMap<>(Comparator.reverseOrder());
        reverse.putAll(map);
        System.out.println("Ters sıra: " + reverse);
    }
}

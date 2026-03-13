package com.collection.framework.map;

import java.util.*;

/**
 * MAP ARAYÜZÜ - GENEL BAKIŞ
 * --------------------------
 * Map<K,V>: Key-value çiftleri. Key'ler tekrarsız; her key en fazla bir value'ya karşılık gelir.
 * Collection'dan türemez; kendi hiyerarşisi.
 *
 * Temel metodlar: put(k,v), get(k), remove(k), containsKey(k), containsValue(v),
 * keySet(), values(), entrySet(), getOrDefault(k, default), putIfAbsent(k,v).
 *
 * Implementasyonlar:
 * - HashMap: O(1) ortalama; sıra yok. Key için hashCode + equals.
 * - LinkedHashMap: Ekleme (veya erişim) sırasını korur.
 * - TreeMap: Key'e göre sıralı; O(log n). Comparable veya Comparator.
 * - Hashtable: Eski, thread-safe; HashMap + Collections.synchronizedMap tercih edilir.
 *
 * Clean code: Değişken tipi Map<K,V>; implementasyon constructor'da seçilir.
 */
public class MapInterfaceOverview {

    public static void main(String[] args) {
        basicOperations();
        viewsKeySetValuesEntrySet();
        getOrDefaultAndPutIfAbsent();
    }

    private static void basicOperations() {
        System.out.println("=== MAP TEMEL İŞLEMLER ===\n");
        Map<String, Integer> map = new HashMap<>();
        map.put("Ali", 25);
        map.put("Ayşe", 30);
        map.put("Ali", 26); // üzerine yazar
        System.out.println("map: " + map);
        System.out.println("get(\"Ali\"): " + map.get("Ali"));
        System.out.println("get(\"Veli\"): " + map.get("Veli"));
        map.remove("Ayşe");
        System.out.println("remove(\"Ayşe\") sonrası: " + map);
    }

    private static void viewsKeySetValuesEntrySet() {
        System.out.println("\n=== keySet, values, entrySet ===\n");
        Map<String, Integer> map = new HashMap<>(Map.of("A", 1, "B", 2, "C", 3));
        System.out.println("keySet: " + map.keySet());
        System.out.println("values: " + map.values());
        System.out.println("entrySet (döngü):");
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }
    }

    private static void getOrDefaultAndPutIfAbsent() {
        System.out.println("\n=== getOrDefault & putIfAbsent ===\n");
        Map<String, Integer> count = new HashMap<>();
        count.put("a", 1);
        System.out.println("getOrDefault(\"a\", 0): " + count.getOrDefault("a", 0));
        System.out.println("getOrDefault(\"b\", 0): " + count.getOrDefault("b", 0));
        count.putIfAbsent("b", 10);
        count.putIfAbsent("a", 99); // zaten var, yazılmaz
        System.out.println("putIfAbsent sonrası: " + count);
    }
}

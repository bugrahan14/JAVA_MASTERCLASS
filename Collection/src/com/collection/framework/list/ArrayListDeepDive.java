package com.collection.framework.list;

import java.util.*;

/**
 * ARRAYLİST - DETAYLI İNCELEME
 * -----------------------------
 * - Dinamik diz tabanlı; kapasite dolunca büyür (genelde 1.5x).
 * - get(i), set(i,e): O(1).
 * - add(e): amortized O(1); add(i,e) ve remove(i): O(n) (kaydırma).
 * - Random access için ideal. Başlangıç kapasitesi biliniyorsa constructor'da ver (trimToSize).
 *
 * Clean code: Başlangıç kapasitesi tahmin edilebiliyorsa new ArrayList<>(initialCapacity).
 */
public class ArrayListDeepDive {

    public static void main(String[] args) {
        capacityAndPerformance();
        initialCapacityBestPractice();
        usefulMethods();
    }

    private static void capacityAndPerformance() {
        System.out.println("=== KAPASİTE VE PERFORMANS ===\n");

        // Kapasite belirtmeden: varsayılan 10, büyüme maliyeti
        List<Integer> defaultList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            defaultList.add(i);
        }
        System.out.println("15 eleman eklendi (varsayılan kapasite): size=" + defaultList.size());

        // Kapasite belirterek: gereksiz resize azalır
        List<Integer> withCapacity = new ArrayList<>(100);
        for (int i = 0; i < 50; i++) {
            withCapacity.add(i);
        }
        System.out.println("50 eleman, initialCapacity=100: gereksiz büyüme yok");
    }

    private static void initialCapacityBestPractice() {
        System.out.println("\n=== BAŞLANGIÇ KAPASİTESİ (CLEAN CODE) ===\n");

        int expectedSize = 1000;
        List<String> list = new ArrayList<>(expectedSize);
        // ensureCapacity(int) ile de artırılabilir (internal)
        System.out.println("new ArrayList<>(expectedSize) ile tahmini boyut verildi.");
    }

    private static void usefulMethods() {
        System.out.println("\n=== YARDIMCI METODLAR ===\n");

        ArrayList<String> list = new ArrayList<>(List.of("C", "A", "B", "A"));
        list.trimToSize(); // kullanılmayan kapasiteyi bırak (opsiyonel)

        list.ensureCapacity(200); // en az 200 kapasite garanti
        list.sort(String::compareTo);
        System.out.println("sort sonrası: " + list);

        list.replaceAll(s -> s.toLowerCase());
        System.out.println("replaceAll toLowerCase: " + list);
    }
}

package com.collection.framework.utils;

import java.util.*;

/**
 * COLLECTION FRAMEWORK - KARŞILAŞTIRMA ÖZETİ
 * ------------------------------------------
 * Hangi yapıyı ne zaman kullanacağınızı seçmek için özet tablo (kod içi dokümantasyon).
 *
 * LIST:
 *   ArrayList  → Random access sık, ekleme/çıkarma çoğunlukla sonda. Varsayılan tercih.
 *   LinkedList → Başta/sonda sık ekleme-çıkarma, queue/stack, ListIterator çift yön.
 *   Vector     → Eski; thread-safe gerekirse synchronized wrapper tercih edilir.
 *
 * SET:
 *   HashSet       → Tekrarsız, sıra önemsiz. En hızlı.
 *   LinkedHashSet → Tekrarsız + ekleme sırası.
 *   TreeSet       → Tekrarsız + sıralı (Comparable/Comparator).
 *
 * QUEUE / DEQUE:
 *   ArrayDeque   → Stack ve FIFO kuyruk için önerilen (LinkedList'ten genelde daha iyi).
 *   LinkedList   → List + Deque ihtiyacı birlikte.
 *   PriorityQueue → Öncelik kuyruğu (min/max heap).
 *
 * MAP:
 *   HashMap       → Key-value, sıra yok. Varsayılan.
 *   LinkedHashMap → Ekleme (veya erişim) sırası.
 *   TreeMap       → Key'e göre sıralı.
 *
 * KARMAŞIKLIK (ortalama):
 *   ArrayList:  get/set O(1), add(e) O(1)*, add(i,e)/remove(i) O(n)
 *   LinkedList: get/set O(n), add/remove uç O(1)
 *   HashSet/Map: put/get/remove O(1)*
 *   TreeSet/Map: put/get/remove O(log n)
 *   PriorityQueue: offer/poll/peek O(log n)
 */
public class CollectionComparisonTable {

    public static void main(String[] args) {
        printSummary();
    }

    private static void printSummary() {
        System.out.println("=== COLLECTION KARŞILAŞTIRMA ÖZETİ ===\n");
        System.out.println("List    → Sıralı, indeksli, tekrara izin: ArrayList (varsayılan), LinkedList, Vector");
        System.out.println("Set     → Tekrarsız: HashSet, LinkedHashSet, TreeSet");
        System.out.println("Queue   → FIFO/LIFO/Öncelik: ArrayDeque, LinkedList, PriorityQueue");
        System.out.println("Map     → Key-Value: HashMap, LinkedHashMap, TreeMap");
        System.out.println("\nClean code: Tipi her zaman arayüz (List, Set, Map, Queue, Deque) tutun.");
    }
}

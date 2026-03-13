package com.collection.framework.queue;

import java.util.*;

/**
 * PRİORİTYQUEUE - ÖNCELİK KUYRUĞU
 * ---------------------------------
 * Heap tabanlı; en küçük (veya Comparator'a göre "en öncelikli") eleman her zaman başta.
 * offer/poll/peek: O(log n). Sıra garantisi sadece "öncelik"e göre, FIFO değil.
 *
 * Doğal sıralama: Elemanlar Comparable olmalı. Ya da Comparator verilir.
 * null kabul edilmez.
 *
 * Clean code: Öncelikli işlem (task scheduling, en küçük/k en büyük k eleman) için kullan.
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        naturalOrder();
        withComparator();
        topKExample();
    }

    private static void naturalOrder() {
        System.out.println("=== DOĞAL SIRALAMA (KÜÇÜKTEN BÜYÜĞE) ===\n");
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        System.out.println("peek (en küçük): " + pq.peek());
        System.out.println("Sırayla poll: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }

    private static void withComparator() {
        System.out.println("\n=== COMPARATOR (BÜYÜKTEN KÜÇÜĞE) ===\n");
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(5);
        pq.offer(1);
        pq.offer(9);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }

    private static void topKExample() {
        System.out.println("\n=== EN BÜYÜK K ELEMAN (min-heap ile) ===\n");
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        int k = 3;
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int value : arr) {
            minHeap.offer(value);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        System.out.println("En büyük " + k + " eleman: " + minHeap);
    }
}

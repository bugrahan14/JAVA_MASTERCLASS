package com.collection.framework.queue;

import java.util.*;

/**
 * QUEUE & DEQUE ARAYÜZLERİ
 * -------------------------
 * Queue<E>: Kuyruk — offer/add (ekleme), poll/remove (çıkarma), peek/element (bakma).
 * Başarısızda: offer=false, add=exception; poll=null, remove=exception; peek=null, element=exception.
 *
 * Deque<E>: Çift uçlu kuyruk (Double Ended Queue). Hem FIFO hem LIFO.
 * offerFirst/Last, pollFirst/Last, peekFirst/Last. Stack için: push=addFirst, pop=pollFirst.
 *
 * Implementasyonlar:
 * - ArrayDeque: Dinamik dizi; stack ve kuyruk için önerilen (LinkedList'ten genelde daha hızlı).
 * - LinkedList: List + Deque.
 * - PriorityQueue: Öncelik kuyruğu (heap); sıra önceliğe göre.
 *
 * Clean code: Stack için ArrayDeque; FIFO kuyruk için ArrayDeque veya LinkedList.
 */
public class QueueAndDequeOverview {

    public static void main(String[] args) {
        queueFifo();
        dequeAsStack();
        dequeBothEnds();
    }

    private static void queueFifo() {
        System.out.println("=== QUEUE - FIFO ===\n");
        Queue<String> q = new ArrayDeque<>();
        q.offer("bir");
        q.offer("iki");
        q.offer("üç");
        System.out.println("peek: " + q.peek());
        while (!q.isEmpty()) {
            System.out.println("  poll: " + q.poll());
        }
    }

    private static void dequeAsStack() {
        System.out.println("\n=== DEQUE - STACK (LIFO) ===\n");
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("pop: " + stack.pop());
        System.out.println("peek: " + stack.peek());
        System.out.println("kalan: " + stack);
    }

    private static void dequeBothEnds() {
        System.out.println("\n=== DEQUE - ÇİFT UÇ ===\n");
        Deque<String> d = new ArrayDeque<>();
        d.addFirst("sol");
        d.addLast("sag");
        d.addFirst("en-sol");
        System.out.println("deque: " + d);
        System.out.println("pollFirst: " + d.pollFirst());
        System.out.println("pollLast: " + d.pollLast());
    }
}

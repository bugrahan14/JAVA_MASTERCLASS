package com.collection.framework.list;

import java.util.*;

/**
 * LİNKEDLİST - DETAYLI İNCELEME
 * ------------------------------
 * Çift yönlü bağlı liste (doubly linked). Hem List hem Deque implementasyonu.
 *
 * Karmaşıklık:
 * - get(i), set(i,e): O(n) — indekse ulaşmak için traverse.
 * - add(e), addFirst(e), addLast(e): O(1) (referans biliniyorsa).
 * - add(i,e): O(n) (konuma gitmek); remove(i): O(n).
 * - remove(first/last): O(1) — kuyruk/stack gibi kullanılırsa.
 *
 * Ne zaman kullanılır: Sık başa/sona ekleme-çıkarma, listIterator ile çift yönlü gezinme,
 * queue/stack gibi kullanım. Random access çoksa ArrayList tercih edilir.
 *
 * Clean code: Tipi List veya Deque tut; implementasyon olarak LinkedList seç.
 */
public class LinkedListDeepDive {

    public static void main(String[] args) {
        asList();
        asDeque();
        whenToUseLinkedList();
    }

    private static void asList() {
        System.out.println("=== LİNKEDLİST LİST OLARAK ===\n");

        List<Integer> list = new LinkedList<>(List.of(1, 2, 3));
        list.add(1, 99);
        System.out.println("add(1, 99): " + list);
        System.out.println("get(2): " + list.get(2));
    }

    private static void asDeque() {
        System.out.println("\n=== LİNKEDLİST DEQUE (ÇİFT UÇLU KUYRUK) ===\n");

        Deque<String> deque = new LinkedList<>();
        deque.addFirst("ilk");
        deque.addLast("son");
        deque.addFirst("en-baş");
        System.out.println("deque: " + deque);
        System.out.println("peekFirst: " + deque.peekFirst());
        System.out.println("pollLast: " + deque.pollLast());
        System.out.println("kalan: " + deque);
    }

    private static void whenToUseLinkedList() {
        System.out.println("\n=== NE ZAMAN LİNKEDLİST? ===\n");
        System.out.println("+ Sık addFirst/addLast, removeFirst/removeLast");
        System.out.println("+ Queue veya Stack davranışı gerekince");
        System.out.println("+ ListIterator ile ileri-geri gezinme");
        System.out.println("- Random access (get(i)) çoksa ArrayList daha iyi");
    }
}

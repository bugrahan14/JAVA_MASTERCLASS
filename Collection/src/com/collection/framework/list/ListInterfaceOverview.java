package com.collection.framework.list;

import java.util.*;

/**
 * LİST ARAYÜZÜ - GENEL BAKIŞ
 * --------------------------
 * List<E>: Sıralı (insertion order), indeks erişimi (get/set), tekrara izin verir.
 * Ortak metodlar: add(e), add(index, e), get(i), set(i, e), remove(i), remove(Object),
 * indexOf, lastIndexOf, subList(from, to), listIterator().
 *
 * Clean code: Değişken tipini her zaman List<E> yap; implementasyonu (ArrayList/LinkedList)
 * sadece constructor'da seç.
 */
public class ListInterfaceOverview {

    public static void main(String[] args) {
        listBasicOperations();
        listIndexOperations();
        subListAndListIterator();
    }

    private static void listBasicOperations() {
        System.out.println("=== LİST TEMEL İŞLEMLER ===\n");

        List<String> list = new ArrayList<>();
        list.add("Bir");
        list.add("İki");
        list.add("Üç");
        list.add(1, "Ara"); // indeks 1'e ekle

        System.out.println("list: " + list);
        System.out.println("get(2): " + list.get(2));
        System.out.println("indexOf(\"Üç\"): " + list.indexOf("Üç"));
        System.out.println("lastIndexOf (tekrar ekleyip): ");
        list.add("Bir");
        System.out.println("lastIndexOf(\"Bir\"): " + list.lastIndexOf("Bir"));
    }

    private static void listIndexOperations() {
        System.out.println("\n=== İNDEKS İŞLEMLERİ ===\n");

        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        list.set(2, 99);
        System.out.println("set(2, 99): " + list);

        list.remove(2); // indeks 2'deki elemanı kaldır
        System.out.println("remove(2): " + list);

        list.remove(Integer.valueOf(40)); // değer 40'ı kaldır (obje olarak)
        System.out.println("remove(Integer.valueOf(40)): " + list);
    }

    private static void subListAndListIterator() {
        System.out.println("\n=== subList & ListIterator ===\n");

        List<String> list = new ArrayList<>(List.of("A", "B", "C", "D", "E"));
        List<String> sub = list.subList(1, 4); // [B, C, D] — backed by original!
        System.out.println("subList(1,4): " + sub);
        sub.set(0, "X"); // orijinal listeyi de etkiler
        System.out.println("sub.set(0,\"X\") sonrası orijinal: " + list);

        // ListIterator: ileri/geri, set/add
        ListIterator<String> li = list.listIterator(list.size());
        System.out.print("Tersten: ");
        while (li.hasPrevious()) {
            System.out.print(li.previous() + " ");
        }
        System.out.println();
    }
}
